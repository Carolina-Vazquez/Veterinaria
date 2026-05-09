# Clinica Veterinaria - Practica UT8 JPA

Aplicacion web completa desarrollada con Spring Boot, JPA/Hibernate, Thymeleaf y MySQL
que permite gestionar una clinica veterinaria. Permite registrar propietarios y sus mascotas,
visualizar listados completos y dar de alta nuevos registros desde formularios web.

---

## URL en Railway (Produccion)
https://veterinaria-production-bc32.up.railway.app/inicio

---

## Descripcion del proyecto

Este proyecto es una aplicacion web MVC que gestiona dos entidades principales:
- Propietarios: personas que llevan sus mascotas a la clinica
- Mascotas: animales registrados con su especie, raza, fecha de nacimiento y peso

La aplicacion permite:
- Ver el listado completo de propietarios y mascotas
- Dar de alta nuevos propietarios y mascotas mediante formularios
- Relacionar cada mascota con su propietario
- Cargar datos iniciales automaticamente al arrancar

---

## Tecnologias utilizadas

| Tecnologia | Version |
|---|---|
| Java | 17 |
| Spring Boot | 3.5.14 |
| Spring Data JPA | 6.x |
| Hibernate | 6.6.x |
| Thymeleaf | 3.x |
| Bootstrap | 5.3.0 |
| MySQL / MariaDB | 8.x |
| Maven | 3.x |

---

## Requisitos previos

Antes de ejecutar el proyecto asegurate de tener instalado:
- Java 17 JDK
- MySQL o MariaDB en ejecucion en el puerto 3306
- Maven 3.x
- Git
- Un IDE como Eclipse, STS o IntelliJ (opcional)

---

## Pasos para ejecutarlo localmente

### 1. Clonar el repositorio
git clone https://github.com/Carolina-Vazquez/Veterinaria.git
cd Veterinaria

### 2. Crear la base de datos
Abre tu cliente MySQL (HeidiSQL, MySQL Workbench, etc.) y ejecuta
el archivo schema.sql que se encuentra en la raiz del proyecto.
Este archivo crea la base de datos clinica_veterinaria y las tablas
propietario y mascota.

### 3. Configurar la conexion a la base de datos
Abre el archivo src/main/resources/application.properties y ajusta:

spring.datasource.url=jdbc:mysql://localhost:3306/clinica_veterinaria?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_CONTRASENA

### 4. Ejecutar la aplicacion
mvn spring-boot:run

O desde tu IDE: clic derecho en VeterinariaApplication.java -> Run As -> Spring Boot App

### 5. Abrir en el navegador
http://localhost:8080/inicio

Al arrancar, se insertaran automaticamente 10 propietarios y 10 mascotas
si la base de datos esta vacia.

---

## Estructura del proyecto

src/
├── main/
│   ├── java/com/clinica/veterinaria/
│   │   ├── VeterinariaApplication.java  - Clase principal
│   │   ├── model/
│   │   │   ├── Propietario.java         - Entidad JPA Propietario
│   │   │   └── Mascota.java             - Entidad JPA Mascota
│   │   ├── repository/
│   │   │   ├── PropietarioRepository.java
│   │   │   └── MascotaRepository.java
│   │   ├── controller/
│   │   │   └── VeterinariaController.java
│   │   └── runner/
│   │       └── DataLoader.java          - Datos iniciales
│   └── resources/
│       ├── templates/                   - Vistas Thymeleaf
│       │   ├── inicio.html
│       │   ├── listadoPropietario.html
│       │   ├── listadoMascota.html
│       │   ├── altaPropietario.html
│       │   ├── altaMascota.html
│       │   └── error.html
│       ├── static/img/                  - Imagenes
│       ├── application.properties
│       └── schema.sql
└── pom.xml

---

## Endpoints disponibles

| Metodo | URL | Descripcion |
|---|---|---|
| GET | /inicio | Pagina principal con foto y nombre |
| GET | /listadoPropietario | Tabla con todos los propietarios |
| GET | /listadoMascota | Tabla con todas las mascotas |
| GET | /altaPropietario | Formulario de alta de propietario |
| POST | /altaPropietario | Guarda nuevo propietario en BD |
| GET | /altaMascota | Formulario de alta de mascota |
| POST | /altaMascota | Guarda nueva mascota en BD |

---

## Entidades de la base de datos

### Propietario
| Campo | Tipo | Descripcion |
|---|---|---|
| id | BIGINT | Clave primaria autoincremental |
| nombre | VARCHAR(100) | Nombre del propietario |
| apellidos | VARCHAR(150) | Apellidos del propietario |
| telefono | VARCHAR(15) | Telefono de contacto |
| email | VARCHAR(100) | Correo electronico |
| direccion | VARCHAR(200) | Direccion postal |

### Mascota
| Campo | Tipo | Descripcion |
|---|---|---|
| id | BIGINT | Clave primaria autoincremental |
| nombre | VARCHAR(100) | Nombre de la mascota |
| especie | VARCHAR(50) | Especie (Perro, Gato, etc.) |
| raza | VARCHAR(100) | Raza de la mascota |
| fecha_nacimiento | DATE | Fecha de nacimiento |
| peso | DOUBLE | Peso en kilogramos |
| propietario_id | BIGINT | Clave foranea a Propietario |

---

## Datos iniciales

Al arrancar la aplicacion por primera vez el CommandLineRunner inserta
automaticamente 10 propietarios y 10 mascotas de ejemplo si la base
de datos esta vacia.

---

## Pagina de error personalizada

La aplicacion incluye una pagina error.html personalizada que se muestra
cuando ocurre cualquier error inesperado, con un enlace para volver al inicio.

---

## Autor
Carolina Vazquez - C.F.G.S DAW