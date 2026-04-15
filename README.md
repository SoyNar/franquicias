#  Franquicias - Guía para ejecutar el proyecto

Este proyecto está construido con **Spring Boot** y utiliza una arquitectura en capas, contenedores Docker y buenas prácticas de separación de responsabilidades.

---

## ⚙️ Requisitos previos

Para poder ejecutar el proyecto es necesario contar con:

- Docker instalado y en ejecución
- Java 21 (para construir el JAR)
- Maven instalado

---

## Cómo levantar el proyecto

Para ejecutar el sistema correctamente se deben seguir los siguientes pasos:

### 1. Construir el JAR del proyecto

Primero es necesario generar el archivo ejecutable del backend:

```bash
mvn clean package
```

Este comando generará el archivo `.jar` dentro de la carpeta `target/`.

---

### 2. Levantar los contenedores

Una vez generado el JAR, se debe iniciar la aplicación con Docker:

```bash
docker-compose up --build -d
```

Este proceso crea y ejecuta los siguientes contenedores:

-  Contenedor de base de datos (MySQL)
-  Contenedor de la aplicación (Spring Boot)

---

### 3. Ejecución en segundo plano

El sistema está configurado para ejecutarse en **modo detached**, lo que permite que los contenedores funcionen en segundo plano sin bloquear la terminal.

---

##  Arquitectura del proyecto

El proyecto sigue una **arquitectura por capas**, lo que permite una mejor organización, escalabilidad y mantenimiento del código.

###  Capas principales

- **Controller**
  - Expone los endpoints de la API
  - Maneja las solicitudes HTTP

- **Service**
  - Contiene la lógica de negocio
  - Separada en:
    - `interface Service`
    - `implementación ServiceImpl`

- **Repository**
  - Acceso a datos (base de datos)

---

##  Manejo de DTOs y Mappers

- Se utilizan **DTOs (Data Transfer Objects)** para transferir información entre capas.
- Se implementan **Mappers** para convertir entre entidades ↔ DTOs.

Esto permite desacoplar la base de datos de la lógica de negocio.

---

##  Manejo de errores

La aplicación implementa:

- `@ControllerAdvice`
- Manejo centralizado de excepciones

Esto permite capturar errores de forma global y devolver respuestas estructuradas al cliente.

---

##  Resumen

- Arquitectura por capas
- Uso de DTOs
- Uso de Mappers
- Service / ServiceImpl
- Manejo global de errores
- Ejecución con Docker (app + DB)
