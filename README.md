# Vendors Manager API 🏢📦

API REST desarrollada con **JAVA/Spring** para la gestión de **proveedores**, **sucursales**, **direcciones** y **colaboradores**. 
Este proyecto forma parte del curso de JAVA en CoderHouse.

## 🚀 Tecnologías

- Java 17
- Spring Boot
- Spring Data JPA
- Lombok
- Hibernate Validator
- Swagger (OpenAPI 3)
- H2 Database 
- Maven

## 🔧 Funcionalidades

- Crear, listar, buscar, actualizar y eliminar **proveedores** (CRUD)
- Gestión de **sucursales, domicilios y colaboradores** asociadas a un proveedor
- Manejo de relaciones uno-a-uno y uno-a-muchos
- Validaciones automáticas con anotaciones (`@NotNull`, `@Email`, etc.)
- Uso de Lombok para reducir código repetitivo
- Base de datos embebida H2 para desarrollo
- Documentación completa con Swagger UI
- Manejo global de errores con `@RestControllerAdvice`

## 📓 Documentación de la API disponible en: 

- [Swagger UI](http://localhost:8080/swagger-ui/index.html)

## 📬 Colección Postman

-Podés probar esta API importando la siguiente colección en Postman:

🔗 [`Curso Java - Coderhouse.postman_collection.json`](./postman/Curso%20Java%20-%20Coderhouse.postman_collection.json)

## 📂 Estructura del proyecto

```plaintext
src
└── main
    ├── java
    │   └── com.CursoJavaCoderhouse.EntregaProyectoFinalHidalgo
    │       ├── config                      # Configuraciones adicionales del proyecto
    │       │   └── GlobalExceptionHandler.java
    │       │   └── OpenApiConfig.java
    │       ├── controller                  # Controladores REST de cada entidad    
    │       │   ├── AddressController.java
    │       │   ├── BranchController.java
    │       │   ├── CollaboratorController.java
    │       │   └── VendorController.java
    │       ├── dto                         # Data Transfer Objects
    │       │   │   ├── AddressCreateDTO.java
    │       │   │   └── AddressResponseDTO.java
    │       │   │   ├── BranchCreateDTO.java
    │       │   │   └── BranchResponseDTO.java
    │       │   │   ├── CollaboratorCreateDTO.java
    │       │   │   └── CollaboratorResponseDTO.java
    │       │   │   ├── VendorCreateDTO.java
    │       │   │   └── VendorResponseDTO.java
    │       │   │   └── VendorUpdateDTO.java
    │       ├── mapper                     # Mapeadores para convertir entre entidades y DTOs
    │       │   ├── AddressMapper.java
    │       │   ├── BranchMapper.java
    │       │   ├── CollaboratorMapper.java
    │       │   └── VendorMapper.java
    │       ├── model                      # Entidades del modelo de datos
    │       │   ├── Address.java
    │       │   ├── Branch.java
    │       │   ├── Collaborator.java
    │       │   └── Vendor.java
    │       ├── repository                 # Repositorios JPA para acceso a datos
    │       │   ├── AddressRepository.java
    │       │   ├── BranchRepository.java
    │       │   ├── CollaboratorRepository.java
    │       │   └── VendorRepository.java
    │       ├── service                    # Lógica de negocio 
    │       │   ├── AddressService.java
    │       │   ├── BranchService.java
    │       │   ├── CollaboratorService.java
    │       │   └── VendorService.java
    │       ├── startup                    # Clase auxiliar para inicialización de datos y pruebas
    │       │   └── AppRunner.java
    │       └── Application.java           # Clase principal de arranque del proyecto Spring Boot
    └── resources
        └── application.properties         # Configuración general del proyecto(puerto, DB, etc.)
```



## 👨🏻‍💻 Developer
- **Sebastián Matías Hidalgo**

- 🔗 [GitHub](https://github.com/sebasshidalgo/cursoJavaCoderhouse)