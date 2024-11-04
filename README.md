Aplicación REST Gavi 

Esta aplicación permite el registro de usuairos, tiendas, productos y ventas para la administración de una tienda.

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Data JPA 
- Base de datos: MySQL
- Maven
- Lombok

## Características

- Arquitectura RESTful para acceso a datos.
- Patrones de diseño organizados en capas (Controlador, Servicio, Repositorio).

## Instalación

### Prerrequisitos

- **Java 17**
- **Maven**
- Configurar el archivo `.env` o las variables de entorno (si es necesario). Aunque el application.properties muestra su configuración.
- Si deseas trabajar con variables de entorno, crea el .env y sigue esta plantilla:
    spring.application.name=nombreproyecto
    spring.jpa.show-sql:true
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.properties.hibernate.format_sql=true
    spring.thymeleaf.cache: false
    spring.config.import=optional:file:.env[.properties]
    spring.datasource.url=${SPRING_DATASOURCE_URL}
    spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
    spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}

### Instrucciones

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tu-usuario/tu-repositorio.git
