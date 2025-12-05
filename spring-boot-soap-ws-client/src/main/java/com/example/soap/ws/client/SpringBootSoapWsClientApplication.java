package com.example.soap.ws.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.soap.ws.client.stub.Acknowledgement;
import com.example.soap.ws.client.stub.CustomerRequest;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*") // Permet les requêtes depuis n'importe quelle origine (pour l'interface HTML)
public class SpringBootSoapWsClientApplication {
    
    @Autowired
    private SoapClient client;
    
    /**
     * Endpoint pour vérifier l'éligibilité au prêt
     */
    @PostMapping("/getLoanStatus")
    public ResponseEntity<?> invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest request) {
        try {
            Acknowledgement acknowledgement = client.getLoanStatus(request);
            return ResponseEntity.ok(acknowledgement);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Erreur lors de la communication avec le service SOAP");
            error.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
        }
    }
    
    /**
     * Endpoint de santé pour vérifier si le service est actif
     */
    @GetMapping("/health")
    public ResponseEntity<Map<String, String>> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "UP");
        response.put("service", "Client SOAP - Éligibilité Prêt");
        response.put("port", "8081");
        return ResponseEntity.ok(response);
    }
    
    /**
     * Endpoint pour obtenir des informations sur le service
     */
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("service", "Client SOAP pour évaluation d'éligibilité au prêt");
        info.put("version", "1.0.0");
        info.put("endpoints", Map.of(
            "POST /getLoanStatus", "Vérifier l'éligibilité d'un client",
            "GET /health", "Vérifier l'état du service",
            "GET /info", "Informations sur le service"
        ));
        info.put("criteria", Map.of(
            "age", "Entre 30 et 60 ans",
            "yearlyIncome", "Supérieur à 200 000 TND",
            "cibilScore", "Supérieur à 500"
        ));
        return ResponseEntity.ok(info);
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSoapWsClientApplication.class, args);
    }
}