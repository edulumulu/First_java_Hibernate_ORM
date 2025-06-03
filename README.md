# Gestión de Incidencias con Hibernate y Swing

Este proyecto es una aplicación Java que permite la gestión de empleados y sus incidencias mediante una base de datos MySQL, utilizando **Hibernate** como ORM. Los usuarios pueden interactuar con la aplicación a través de una **interfaz gráfica (Swing)** e incialmente mediante la **consola**, que incluye un menú para crear datos de prueba.

## 🚀 Funcionalidades

✔ **Insertar un empleado nuevo en la base de datos**  
✔ **Validar el acceso de un empleado mediante usuario y contraseña**  
✔ **Modificar el perfil de un empleado existente**  
✔ **Cambiar la contraseña de un empleado**  
✔ **Eliminar empleados**  
✔ **Obtener una incidencia por ID**  
✔ **Listar todas las incidencias**  
✔ **Insertar nuevas incidencias (con origen y destino)**  
✔ **Consultar incidencias creadas por un empleado**  
✔ **Consultar incidencias dirigidas a un empleado**

## 🛠️ Tecnologías utilizadas

- **Java** (POJO, DAO, Swing)
- **Hibernate** (ORM)
- **MySQL** (a través de **XAMPP** o servidor propio)
- **MVC** (Modelo-Vista-Controlador para estructurar el código)

## 📁 Estructura del proyecto

- `POJO`: Clases `Empleado` e `Incidencia`  
- `GestionConsultas`: `EmpleadoDao`, `IncidenciaDao`  
- `Herramientas`: `HibernateUtil`  
- `Interfaz gráfica`: Ventanas Swing para gestión visual  
- `main`: `Main.java` con menú de consola para crear datos de prueba  
- `resources`: Archivos de configuración Hibernate (`.cfg.xml`, `.hbm.xml`, `reveng.xml`)

## 📌 Requisitos

1. Tener instalado **Java (JDK 8 o superior)**  
2. Instalar **XAMPP** u otro servidor MySQL  
3. Configurar la base de datos con las tablas necesarias (empleados, incidencias)  
4. Configurar los archivos de Hibernate (`hibernate.cfg.xml`, `*.hbm.xml`) con los datos de tu servidor MySQL

## ⚡ Ejecución

### Opción 1: Usar la Interfaz Gráfica  
Ejecutar la clase principal que lanza la ventana de inicio y seguir los menús visuales para realizar operaciones sobre empleados o incidencias.

### Opción 2: Usar la Consola  
Ejecutar `Main.java` para acceder al menú de consola, que permite:  
- Crear empleados de prueba  
- Validar inicio de sesión  
- Acceder a un segundo menú para la gestión de incidencias

## 🗄️ Configuración de la Base de Datos

1. Iniciar **XAMPP** y activar MySQL  
2. Crear la base de datos con dos tablas:
   - `empleados` (usuario, contraseña, nombre completo, teléfono, etc.)
   - `incidencias` (fecha/hora, detalle, tipo, empleado origen/destino, etc.)
3. Asegúrate de que las relaciones entre empleados e incidencias están bien definidas (claves foráneas)
4. Ajustar la configuración en `hibernate.cfg.xml` con:
   ```xml
   <property name="connection.url">jdbc:mysql://localhost:3306/tu_base_de_datos</property>
   <property name="connection.username">tu_usuario</property>
   <property name="connection.password">tu_contraseña</property>
