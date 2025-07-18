# Noticias UTEQ - Aplicación Móvil en Android Studio

## Descripción

Esta aplicación móvil permite mostrar las últimas noticias de la Universidad Técnica Estatal de Quevedo (UTEQ) utilizando un ListView. Los datos se obtienen de un servicio RESTful que devuelve las noticias más recientes en formato JSON. La aplicación hace uso de un token de autenticación para acceder al servicio y mostrar la información de manera dinámica.

## Funcionalidades

- **Pantalla principal**: Muestra un botón que al presionarlo consulta el API y muestra las últimas noticias en un `ListView`.
- **Listado de noticias**: Cada noticia incluye el título, fecha de publicación y un enlace a la página web de la noticia.
- **Autenticación**: Utiliza un token de acceso (Bearer token) para hacer las solicitudes al servicio RESTful.

  <img width="288" height="598" alt="noticias1" src="https://github.com/user-attachments/assets/cf66f9b2-aec2-41d9-9de6-914ef108395a" />
  
  ![Imagen de WhatsApp 2025-07-18 a las 16 20 52_69df5b06](https://github.com/user-attachments/assets/bbcf67df-5c35-4238-bcc1-52291e8ff057)

  
## Tecnologías Utilizadas

- **Lenguaje**: Java
- **IDE**: Android Studio
- **API**: RESTful
- **Vista**: ListView
- **Red**: Retrofit para las peticiones HTTP

## Configuración del Proyecto

1. **Autenticación**: El proyecto utiliza el siguiente token para hacer las solicitudes al servicio RESTful:

    ```plaintext
    eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJfeDF1c2VyZGV2IiwiaWF0IjoxNzUyODY4NjIwLCJleHAiOjE3NTI5NTUwMjB9.tZPdC3XwEOhgHZz_QFk5TQa2SrFXimlgVSFa6cwhiwY
    ```

    Este token se debe incluir en el encabezado de cada petición HTTP utilizando la palabra "Bearer".

2. **Servicio Web**: Para obtener las noticias, se hace una solicitud GET al siguiente endpoint:

    ```plaintext
    https://apiws.uteq.edu.ec/h6RPoSoRaah0Y4Bah28eew/functions/information/entity/1
    ```

    Este servicio devuelve las noticias en formato JSON.

3. **URLs**: Los campos `ntUrlNoticia` y `ntUrlPortada` de la respuesta deben ser completados con las rutas correspondientes para acceder a las noticias y sus imágenes:

    ```plaintext
    ntUrlNoticia: https://uteq.edu.ec/es/comunicacion/noticia/{id}
    ntUrlPortada: https://uteq.edu.ec/assets/images/news/pagina/{id}.jpg
    ```




