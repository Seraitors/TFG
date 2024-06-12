package com.wanted.wanted.controladores;


import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.wanted.wanted.entidades.Usuario;
import com.wanted.wanted.entidades.Ventas;
import com.wanted.wanted.servicios.EmailService;
import com.wanted.wanted.servicios.FiguraServices;
import com.wanted.wanted.servicios.UsuarioServices;
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
    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private  EmailService emailService;
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

        int totalVentas = ventas.size();
        int index = 0;
        for (Map<String, Object> venta : ventas) {
            if (index !=  totalVentas - 1) {

                String id = (String) venta.get("id");
                figuraServices.restarStock(id);
            }


            index++;
        }

        Map<String, Object> infoUser = ventas.get(totalVentas - 1);
        String userName = (String) infoUser.get("userName");
        Usuario usuario = usuarioServices.obtenerUsuarioPoremail(userName);
        if (usuario != null){
            emailService.sendRegistrationEmail(usuario.getEmail(),
                    "Compra en Wanted",
                    "Gracias por tus Muertos");
        }

        //aqui hacer correo


    }



    @PostMapping("/postPayVenta")
    public void procesarVentaInsertar(@RequestBody Map<String, Object> venta) {


        Ventas venta_final = new Ventas();
        venta_final.setFechaCompra( (String) venta.get("fechaCompra"));
        venta_final.setNombre((String) venta.get("nombre"));
        venta_final.setFiguraComprada((String) venta.get("figuraComprada"));
        venta_final.setPrecioTotal((double)venta.get("precioTotal"));
        venta_final.setDatosVivienda((String) venta.get("datosVivienda"));
        ventasServices.insertarVenta(venta_final);

    }



}
