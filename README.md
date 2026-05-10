Resumen del Proyecto: Crypto Monitor
Descripción:
Aplicación backend desarrollada con Spring Boot para el monitoreo automatizado de precios de criptomonedas en tiempo real, utilizando la API pública de Binance.

Especificaciones Técnicas
Lenguaje: Java 17+.

Framework: Spring Boot 3.x.

Componentes Clave: RestTemplate para peticiones HTTP, Spring Scheduling para tareas repetitivas y Jackson para el procesamiento de JSON.

Funcionalidades Principales
Monitoreo Programado: Consulta automática del par BTC/USDT cada 5 segundos.

Gestión de Historial: Almacenamiento en memoria de los últimos 10 registros de precio obtenidos.

API de Consulta: Endpoints para verificar el estado del servicio y obtener el precio actual bajo demanda.

Validación de Umbral: Lógica interna para comparar el precio actual frente a un valor límite definido.

Estructura de Endpoints
GET /api/v1/crypto/now: Retorna el precio y símbolo actual.

GET /api/v1/crypto/status: Confirma que el monitor está en ejecución.

Organización del Código
El proyecto sigue una arquitectura de capas estándar:

Client: Conexión con la API externa.

Service: Procesamiento de datos e historial.

Controller: Exposición de servicios vía HTTP.

Scheduler: Gestión de la tarea automática.

Domain: Definición del modelo de datos.

Configuración
La URL de la API y el símbolo de la criptomoneda son configurables a través del archivo application.properties mediante la propiedad crypto.api.url.
