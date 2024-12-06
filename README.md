# Aplicación REST Gavi

Este proyecto es el backend de **Gavi**, un sistema de gestión administrativa para tiendas que permite manejar usuarios, productos y ventas. Está diseñado para ser consumido por el cliente desarrollado en Javascript, HTML y CSS, alojado en este repositorio: [Gavi Cliente](https://github.com/Sanrvallejo/gavi-cliente).

## Tecnologías utilizadas

- **Java 17**: Lenguaje de programación.
- **Spring Boot**: Framework para la creación del backend.
- **Spring Data JPA**: Gestión de la persistencia.
- **MySQL**: Base de datos relacional.
- **Maven**: Herramienta de construcción y gestión de dependencias.
- **Lombok**: Para reducir el código repetitivo.

## Características

- Arquitectura **RESTful** para acceso a los recursos.
- Implementación de patrones de diseño organizados en capas: **Controlador**, **Servicio** y **Repositorio**.
- Integración con MySQL para persistencia de datos.
- Configuración lista para desplegar en un entorno local.

## Instalación

### Prerrequisitos

- Tener instalado **Java 17** o superior.
- Tener instalado **Maven**.
- Contar con una instancia de **MySQL** en ejecución.
- Configurar el archivo `application.properties` o usar un archivo `.env` para las variables de entorno.

### Configuración del archivo `.env`

Si prefieres usar variables de entorno, crea un archivo `.env` en la raíz del proyecto y utiliza la siguiente plantilla:  

```properties
# Configuración de la base de datos
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/nombre_base_datos
SPRING_DATASOURCE_USERNAME=tu_usuario
SPRING_DATASOURCE_PASSWORD=tu_contraseña

# Configuración de JPA
SPRING_JPA_SHOW_SQL=true
SPRING_JPA_HIBERNATE_DDL_AUTO=update
SPRING_JPA_PROPERTIES_HIBERNATE_DIALECT=org.hibernate.dialect.MySQLDialect
SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true
```

1. Clona el repositorio:

   ```bash
   git clone https://github.com/Sanrvallejo/gavi-server


