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
2. **`Conexion`**: Clase encargada de realizar la conexión con la API y procesar la respuesta.
   - Esta clase se encarga de construir la URL para realizar la solicitud a la API de tipo de cambio. Recibe los parámetros de la moneda de inicio, la moneda de fin y el monto a convertir.
   - Realiza la conexión a la API utilizando `HttpClient`, procesa la respuesta JSON con `Gson`, y devuelve el resultado de la conversión formateado para que sea legible para el usuario.
   
3. **`Main`**: Clase principal que gestiona la interacción con el usuario.
   - En esta clase se define el flujo de la aplicación, desde la presentación de las opciones de conversión hasta la entrada del monto que el usuario desea convertir.
   - El usuario selecciona la opción de conversión y la aplicación hace uso de la clase `Conexion` para obtener el valor convertido desde la API.

## Cómo usar el proyecto

1. **Ejecutar el proyecto**: Puedes ejecutar la clase `Main` desde tu entorno de desarrollo o línea de comandos.
2. **Seleccionar la conversión**: Al iniciar el programa, el usuario verá un menú con las opciones de conversión disponibles.
3. **Ingresar el monto**: Después de seleccionar la opción deseada, el usuario deberá ingresar el monto que desea convertir.
4. **Ver el resultado**: La aplicación mostrará el resultado de la conversión en la consola, con el valor convertido y las monedas correspondientes.

## Requisitos

- **Java 11** o superior.
- **Dependencias**: 
  - `Gson` para la deserialización del JSON (puedes agregarlo a tu proyecto mediante Maven o Gradle).
  - **Acceso a Internet** para consultar la API.

## Contribuciones

Si deseas contribuir al proyecto, por favor sigue estos pasos:
1. Haz un fork de este repositorio.
2. Crea una rama con tu cambio: `git checkout -b nombre-de-tu-rama`.
3. Realiza tus cambios y haz commit: `git commit -am 'Descripción de tu cambio'`.
4. Haz push a la rama: `git push origin nombre-de-tu-rama`.
5. Crea un pull request detallando los cambios realizados.

## API Utilizada
Este proyecto utiliza la API de [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener los datos de conversión. La URL base utilizada es:
  ```Modelo de como funciona el endpoint
  https://v6.exchangerate-api.com/v6/<API_KEY>/pair/<moneda_origen>/<moneda_destino>/<monto>

Nota: La clave de la API `(API_KEY)` está incluida en el código como un ejemplo. Para producción, se recomienda ocultar esta clave y utilizar variables de entorno.
