//package com.wanted.wanted.controladores;
//
//
//import com.sendinblue.*;
//import com.sendinblue.auth.*;
//import sibApi.TransactionalEmailsApi;
//import sibModel.*;
//
//public class Sendinblue {
//
//    public static void main(String[] args) {
//        ApiClient defaultClient = Configuration.getDefaultApiClient();
//        ApiKeyAuth apiKey = (ApiKeyAuth) defaultClient.getAuthentication("api-key");
//        apiKey.setApiKey("YOUR_API_KEY");
//
//        TransactionalEmailsApi apiInstance = new TransactionalEmailsApi();
//        SendSmtpEmail sendSmtpEmail = new SendSmtpEmail();
//
//        sendSmtpEmail.setTo(Arrays.asList(new SendSmtpEmailTo().email("recipient@example.com").name("Recipient Name")));
//        sendSmtpEmail.setSender(new SendSmtpEmailSender().email("sender@example.com").name("Sender Name"));
//        sendSmtpEmail.setSubject("Test Email");
//        sendSmtpEmail.setHtmlContent("<html><body><h1>This is a test email</h1></body></html>");
//
//        try {
//            CreateSmtpEmail response = apiInstance.sendTransacEmail(sendSmtpEmail);
//            System.out.println(response);
//        } catch (ApiException e) {
//            System.err.println("Exception when calling TransactionalEmailsApi#sendTransacEmail");
//            e.printStackTrace();
//        }
//    }
//}
//
//
//
