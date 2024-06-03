//package com.wanted.wanted.controladores;
//
//import java.nio.file.Paths;
//import java.util.Map;
//import java.util.HashMap;
//
//import static spark.Spark.post;
//import static spark.Spark.get;
//import static spark.Spark.port;
//import static spark.Spark.staticFiles;
//import com.google.gson.Gson;
//
//import com.stripe.Stripe;
//import com.stripe.model.checkout.Session;
//import com.stripe.param.checkout.SessionCreateParams;
//public class Stripe {
//
// public static void main(String[] args) {
//            port(4242);
//
//            // This is a public sample test API key.
//            // Don’t submit any personally identifiable information in requests made with this key.
//            // Sign in to see your own test API key embedded in code samples.
//            Stripe.apiKey = "sk_test_CGGvfNiIPwLXiDwaOfZ3oX6Y";
//
//            staticFiles.externalLocation(
//                    Paths.get("public").toAbsolutePath().toString());
//
//            Gson gson = new Gson();
//
//            post("/create-checkout-session", (request, response) -> {
//                String YOUR_DOMAIN = "http://localhost:4242";
//                SessionCreateParams params =
//                        SessionCreateParams.builder()
//                                .setUiMode(SessionCreateParams.UiMode.EMBEDDED)
//                                .setMode(SessionCreateParams.Mode.PAYMENT)
//                                .setReturnUrl(YOUR_DOMAIN + "/return.html?session_id={CHECKOUT_SESSION_ID}")
//                                .addLineItem(
//                                        SessionCreateParams.LineItem.builder()
//                                                .setQuantity(1L)
//                                                // Provide the exact Price ID (for example, pr_1234) of the product you want to sell
//                                                .setPrice("{{PRICE_ID}}")
//                                                .build())
//                                .build();
//
//                Session session = Session.create(params);
//
//                Map<String, String> map = new HashMap();
//                map.put("clientSecret", session.getRawJsonObject().getAsJsonPrimitive("client_secret").getAsString());
//
//
//                return map;
//            }, gson::toJson);
//
//            get("/session-status", (request, response) -> {
//                Session session = Session.retrieve(request.queryParams("session_id"));
//
//                Map<String, String> map = new HashMap();
//                map.put("status", session.getRawJsonObject().getAsJsonPrimitive("status").getAsString());
//                map.put("customer_email", session.getRawJsonObject().getAsJsonObject("customer_details").getAsJsonPrimitive("email").getAsString());
//
//                return map;
//            }, gson::toJson);
//        }
//    }
//
