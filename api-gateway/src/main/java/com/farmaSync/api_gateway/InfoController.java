package com.farmaSync.api_gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class InfoController {

    // Estado del Gateway
    @GetMapping("/gateway/status")
    public Map<String, Object> gatewayStatus() {
        Map<String, Object> status = new LinkedHashMap<>();
        status.put("service", "FarmaSync API Gateway");
        status.put("status", "ACTIVE");
        status.put("port", 8012);
        status.put("timestamp", LocalDateTime.now());
        status.put("version", "1.0.0");
        return status;
    }

    // Información de rutas configuradas
    @GetMapping("/gateway/routes-info")
    public Map<String, Object> routesInfo() {
        Map<String, Object> routes = new LinkedHashMap<>();

        Map<String, String> services = new LinkedHashMap<>();
        services.put("usuarios", "http://localhost:8013/farmasync/usuarios/**");
        services.put("pedidos", "http://localhost:8014/farmasync/pedidos/**");
        services.put("ventas", "http://localhost:8015/farmasync/ventas/**");
        services.put("inventario", "http://localhost:8016/farmasync/inventario/**");

        routes.put("totalRoutes", 4);
        routes.put("services", services);
        routes.put("configSource", "application.properties");
        routes.put("gatewayType", "Spring Cloud Gateway");

        return routes;
    }

    //  Health Check técnico
    @GetMapping("/gateway/health")
    public Map<String, Object> healthCheck() {
        Map<String, Object> health = new LinkedHashMap<>();
        health.put("status", "UP");
        health.put("component", "API Gateway");
        health.put("timestamp", LocalDateTime.now());
        health.put("javaVersion", System.getProperty("java.version"));
        return health;
    }

    //  Información de las tecnologías usadas
    @GetMapping("/gateway/tech-info")
    public Map<String, Object> techInfo() {
        Map<String, Object> tech = new LinkedHashMap<>();
        tech.put("framework", "Spring Boot 3.3.4");
        tech.put("gateway", "Spring Cloud Gateway 2023.0.3");
        tech.put("architecture", "Microservices API Gateway");
        tech.put("communication", "HTTP/REST");
        tech.put("documentation", "SpringDoc OpenAPI 2.6.0");
        return tech;
    }

}