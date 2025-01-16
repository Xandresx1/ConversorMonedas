# Conversor de Moneda

Este proyecto es una aplicación en Java que permite convertir montos entre diferentes monedas utilizando una API de tipo de cambio. La aplicación interactúa con el usuario a través de la consola y realiza solicitudes HTTP para obtener los datos de conversión.

## Características

- Conversión entre diferentes monedas:
  - Dólar (USD) ↔ Peso Argentino (ARS)
  - Dólar (USD) ↔ Real Brasileño (BRL)
  - Dólar (USD) ↔ Peso Colombiano (COP)
- Conexión con una API de tipo de cambio para obtener datos actualizados.
- Formateo de resultados en un formato legible para el usuario.

## Tecnologías utilizadas

- **Java**: Lenguaje principal del proyecto.
- **Gson**: Librería para deserializar el JSON recibido desde la API.
- **HttpClient**: Cliente HTTP para realizar solicitudes a la API.

## Estructura del proyecto

El proyecto está compuesto por las siguientes clases:

1. **`ResponseApi`**: Clase `record` que modela la respuesta JSON de la API.
   ```java
   public record ResponseApi(double conversion_result, String base_code, String target_code) {
   }
