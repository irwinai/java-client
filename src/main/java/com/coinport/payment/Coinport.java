package com.coinport.payment;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class Coinport {
    private static final String BASE_URL = "https://pay.coinport.com/api/v1/";
    private String apiToken = "";
    private String currency;

    public Coinport(String apiToken, String currency) {
        this.apiToken = apiToken;
        this.currency = currency;
    }

    public Coinport setApiToken(String apiToken) {
        this.apiToken = apiToken;
        return this;
    }

    public Coinport setCurrency(String currency) {
        if (currency.length() > 3) {
            throw new IllegalArgumentException("Must be a valid currency code");
        }
        this.currency = currency;
        return this;
    }

    public Invoice createInvoice(Map<String, String> paramsMap) {
        String url = BASE_URL + "invoice";

        // call API
        String auth = apiToken + ": ";
        String json = post(url, auth, paramsMap);

        // parse invoice
        Invoice invoice = null;
        try {
            invoice = parseInvoice(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return invoice;
    }

    public Invoice createInvoice(double price, InvoiceParams params) {
        Map<String, String> map = params.getParams();
        map.putAll(getParams(price, this.currency));

        return createInvoice(map);
    }

    public Invoice createInvoice(double price) {
        Map<String, String> map = getParams(price, this.currency);

        return createInvoice(map);
    }

    public Invoice getInvoice(String invoiceId) {
        String url = BASE_URL + "invoice/" + invoiceId + "?f=json";

        // call API
        String json = get(url);

        // parse invoice
        Invoice invoice = null;
        try {
            invoice = parseInvoice(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return invoice;
    }

    private static String post(String url, String authen, Map<String, String> params) {
        java.io.DataOutputStream out = null;
        BufferedReader in = null;
        String result = "";
        if (params.isEmpty()) {
            System.out.println("参数不能为空");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            sb.append(param.getKey());
            sb.append("=");
            sb.append(param.getValue());
            sb.append("&");
        }
        sb.deleteCharAt(sb.length() - 1);
        String paramsEncoded = sb.toString();

        try {
            URL urlObject = new URL(url);

            URLConnection conn = urlObject.openConnection();

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            byte[] authEncBytes = Base64.encodeBase64(authen.getBytes());
            conn.setRequestProperty("Authorization", "Basic " + new String(authEncBytes));

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Length", "" + Integer.toString(paramsEncoded.getBytes("UTF-8").length));

            out = new java.io.DataOutputStream(conn.getOutputStream());

            out.writeBytes(paramsEncoded);

            out.flush();

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += "\n" + line;
            }
        } catch (Exception e) {
            System.out.println("发送POST请求异常:" + e);
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public String get(String url) {
        StringBuilder sb = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection urlConnection = urlObject.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    urlConnection.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (Exception e) {
            System.out.println("连接到URL异常:" + e);
            e.printStackTrace();
        }

        return sb.toString();
    }

    private Map<String, String> getParams(double price,
                                          String currency) {
        Map<String, String> params = new HashMap<String, String>();
        params.put("price", price + "");
        params.put("currency", currency);
        return params;
    }

    private Map<String, String> getParams(double price,
                                          String currency,
                                          InvoiceParams optionalParams) {
        Map<String, String> params = new HashMap<String, String>();
        params.putAll(optionalParams.getParams());
        params.put("price", price + "");
        params.put("currency", currency);
        return params;
    }

    private static Invoice parseInvoice(String json) throws IOException {
        if (json == null || json.isEmpty())
            return null;

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json.getBytes(), Invoice.class);
    }

    public static void main(String[] args) throws IOException {
        Coinport coinport = new Coinport("coinport1", "cny");
        // 新建收款请求
        Invoice invoice = coinport.createInvoice(45.88);
        System.out.println("create invoice: " + invoice.toString());

        // 查询已有的收款请求
        Invoice invoice2 = coinport.getInvoice(invoice.getId());
        System.out.println("get invoice: " + invoice2.toString());

        InvoiceParams params = new InvoiceParams();

        params.setBuyerName("Tom");
        params.setBuyerEmail("tom@gmail.com");
        params.setFullNotifications(true);
        params.setNotificationEmail("tom@gmail.com");

        Invoice invoice3 = coinport.createInvoice(45.88, params);
        System.out.println("create invoice with params: " + invoice3.toString());
    }
}

