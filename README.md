Coinport Java API
=============

This is a Java client library for the Coinport Payment Gateway


Getting Started
---------------

Log into your Coinport merchant account and generate an API key. Then all you need to do is instantiate a Coinport object, and pass in your API key and the default currency code.

```java
Coinport coinport = new Coinport("API_KEY", "cny");
```

####Create an invoice
```java
Invoice invoice = coinport.createInvoice(45.88);

String invoiceUrl = invoice.getURL();

String status = invoice.getStatus();
```

####Retreive an invoice
```java
invoice = coinport.getInvoice(invoice.getId());
```

####Advanced Invoices

You can add additional params to the invoice by passing an InvoiceParams object. You don't have to set all of the advanced parameters. It will only use the ones you do set.
```java
InvoiceParams params = new InvoiceParams();

params.setBuyerName("Tom");
params.setBuyerEmail("tom@gmail.com");
params.setFullNotifications(true);
params.setNotificationEmail("tom@gmail.com");
		
Invoice invoice = this.coinport.createInvoice(45.88, params);
```
