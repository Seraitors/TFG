package com.wanted.wanted.controladores;
//
//import com.stripe.model.PaymentIntent;
//import com.stripe.param.PaymentIntentCreateParams;
//import lombok.extern.slf4j.Slf4j;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.Map;
//import com.google.gson.Gson;
//import com.stripe.Stripe;
//import com.stripe.model.checkout.Session;
//import com.stripe.param.checkout.SessionCreateParams;
//
//import com.stripe.Stripe;
//import com.stripe.exception.StripeException;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@RestController
//@CrossOrigin(origins = "http://localhost:7071")
//@RequestMapping("/api")
//public class PaymentController {
//
//    static {
//
//        Stripe.apiKey ="sk_test_51PMaMmEU6FtnP23OHX1jwNGRqHGjL7hXH6C8V0CT3x2mlUBoVsLUr0lLRSPWliTJRaHkBcWHKswzr4sfTzELp3hZ009qcZ8bUt";
//    }
//
//    @GetMapping("/text")
//    public String test(){
//        log.info("Este es un mensaje de información");
//        return "hola";
//    }
//
//
//    @PostMapping("/create-checkout-session")
//    public ResponseEntity<?> createCheckoutSession() {
//        try {
//            double total = 45 * 100; // En céntimos
//
//
//            SessionCreateParams params =
//                    SessionCreateParams.builder()
//                            .setMode(SessionCreateParams.Mode.PAYMENT)
//                            .setUiMode(SessionCreateParams.UiMode.EMBEDDED)
//                            .setReturnUrl("https://example.com/return?session_id={CHECKOUT_SESSION_ID}")
//                            .addLineItem(
//                                    SessionCreateParams.LineItem.builder()
//                                            .setQuantity(1L)
//                                            .setPriceData(
//                                                    SessionCreateParams.LineItem.PriceData.builder()
//                                                            .setCurrency("usd")
//                                                            .setUnitAmount(2000L)
//                                                            .setProductData(
//                                                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
//                                                                            .setName("T-shirt")
//                                                                            .build())
//                                                            .build())
//                                            .build())
//                            .build();
//
//            Session session = Session.create(params);
//
//            Map<String, Object> responseData = new HashMap<>();
//            responseData.put("sessionId", session.getId());
//
//            return ResponseEntity.ok(responseData);
//        } catch (StripeException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }
//
//
//
//}
//
//



import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.wanted.wanted.entidades.Ventas;
import com.wanted.wanted.servicios.FiguraServices;
import com.wanted.wanted.servicios.VentasServices;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")

public class PaymentController {

    @Autowired
    private FiguraServices figuraServices;

    @Autowired
    private VentasServices ventasServices;
    private String stripeApiKey="sk_test_51PMaMmEU6FtnP23OHX1jwNGRqHGjL7hXH6C8V0CT3x2mlUBoVsLUr0lLRSPWliTJRaHkBcWHKswzr4sfTzELp3hZ009qcZ8bUt";

    @PostConstruct
    public void init() {
        Stripe.apiKey = stripeApiKey;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hola";
    }

    @PostMapping("/create-payment-intent")
    public Map<String, Object> createPaymentIntent(@RequestBody Map<String, Object> data) {
        Map<String, Object> response = new HashMap<>();
        try {
            long amount = ((Number) data.get("amount")).longValue();

            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(amount)
                    .setCurrency("usd")
                    .addPaymentMethodType("card")
                    .build();

            PaymentIntent paymentIntent = PaymentIntent.create(params);

            response.put("clientSecret", paymentIntent.getClientSecret());
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }




    @PostMapping("/postPay")
    public void procesarVentas(@RequestBody List<Map<String, Object>> ventas) {
        for (Map<String, Object> venta : ventas) {

            String id = (String) venta.get("id");
            figuraServices.restarStock(id);


        }


        //aqui hacer correo
    }



    @PostMapping("/postPayVenta")
    public void procesarVentaInsertar(@RequestBody Map<String, Object> venta) {


        Ventas venta_final = new Ventas();
        venta_final.setFechaCompra( (String) venta.get("fechaCompra"));
        venta_final.setNombre((String) venta.get("nombre"));
        venta_final.setFiguraComprada((String) venta.get("figuraComprada"));
        venta_final.setPrecioTotal((int)venta.get("precioTotal"));
        venta_final.setDatosVivienda((String) venta.get("datosVivienda"));
        ventasServices.insertarVenta(venta_final);

    }



}
