# ApiGateway-ElectivaII
🏥 FarmaSync - API Gateway
🚀 Descripción
Este proyecto es el API Gateway del sistema de gestión 
farmacéutica FarmaSync. Actúa como punto de entrada único 
para todos los microservicios, manejando el routing, redirección y 
monitorio de las solicitudes.

🚀 API GATEWAY (Puerto 8012)
📨 /farmasync/usuarios/**
📨 /farmasync/pedidos/**
📨 /farmasync/ventas/**
📨 /farmasync/inventario/**

🏥 MICROSERVICIOS  
👥 Usuarios Service    (Puerto 8013)
📦 Pedidos Service     (Puerto 8014)
💰 Ventas Service      (Puerto 8015)
📊 Inventario Service  (Puerto 8016)

🔧 Tecnologías
Java 17
Spring Boot 3.3.4
Spring Cloud Gateway 2023.0.3
Spring WebFlux (Reactivo)
Spring Boot Actuator (Monitorio)
SpringDoc OpenAPI 2.6.0 (Documentación)

🔌 Rutas de Redirección
GET /farmasync/usuarios/** → Redirige al servicio de Usuarios (8013)
GET /farmasync/pedidos/** → Redirige al servicio de Pedidos (8014)
GET /farmasync/ventas/** → Redirige al servicio de Ventas (8015)
GET /farmasync/inventario/** → Redirige al servicio de Inventario (8016)

📊 Monitorio (Actuator)
GET /actuator/health - Estado de salud del gateway
GET /actuator/gateway/routes - Rutas configuradas
GET /actuator - Todos los endpoints disponibles

📚 Documentación
GET /swagger-ui.html - Interfaz Swagger UI
GET /v3/api-docs - Documentación OpenAPI JSON

ℹ️ Endpoints Técnicos (InfoController)
GET /gateway/status - Estado del servicio Gateway
GET /gateway/routes-info - Información de rutas configuradas
GET /gateway/health - Health check técnico
GET /gateway/tech-info - Tecnologías utilizadas

🛠️ Instalación y Ejecución
Prerrequisitos
Java 17 o superior
Maven 3.6+

Compilar y ejecutar
bash
# Compilar el proyecto
./mvnw clean compile

# Ejecutar la aplicación
./mvnw spring-boot:run

# O compilar y ejecutar el JAR
./mvnw clean package
java -jar target/api-gateway-0.0.1-SNAPSHOT.jar

Verificar que funciona
bash
# Health check
curl http://localhost:8012/actuator/health

# Listar rutas configuradas
curl http://localhost:8012/actuator/gateway/routes

# Probar endpoints técnicos
curl http://localhost:8012/gateway/status
curl http://localhost:8012/gateway/routes-info

# Probar redirección (requiere microservicios ejecutándose)
curl http://localhost:8012/farmasync/usuarios

🧪 Pruebas de simulación
Sin microservicios:
bash
# El gateway funcionará pero mostrará error de conexión
curl http://localhost:8012/farmasync/usuarios
# Response: Error de conexión (esperado)

📝 Características implementadas
✅ Funcionalidades principales
Routing automático a microservicios

Monitorio con Spring Boot Actuator

Documentación con Swagger/OpenAPI

Endpoints técnicos de monitorio

Configuración centralizada en properties

✅ Patrones de diseño
API Gateway Pattern: Punto de entrada único

Reverse Proxy: Redirección transparente
El API Gateway implementa redirección transparente, 
permitiendo que los clientes se comuniquen con los microservicios 
utilizando las mismas URLs que usarían para una conexión directa. 
El gateway maneja internamente el routing sin que clientes o microservicios 
necesiten awareness de su existencia.

🏥 FarmaSync - Sistema de Gestión Farmacéutica
*Gateway version 1.0.0 - Spring Cloud Gateway*
