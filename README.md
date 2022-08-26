# Sistema de escritorio de gestion de ventas fullstack

- El sistema comprende las tecnologias Java, Open Jdk,Swing, Mysql Mysql Workbench, Xammp, Poo, en Apache Netbeans. 
- La misma posee 3 capas [Presentación] , [Negocio] , [Acceso a Datos].
- Implementación del patrón DAO -Data Acces Object- , Encapsulando toda la logica de acceso a datos del resto de la aplicación, facilitando cambios en la fuente de datos sin tener que refactorizar el código. 
- La capa Presentación se desarrolla mediante formularios MDI (Multiple Document Interface)
- Se desarrolla el concepto CRUD tanto en las tablas independientes, Tablas relacionales y Detalles.
- Se elabora un método de paginación de registros y gestión de accesos: Usuarios y Roles.
- Se implementan consultas y búsquedas.
- Reportes para exportar en pdf. -Próximamente-
- 100% funcional para ser desplegada en una pc o red lan.

<img src="https://github.com/RichardDB7/SistemaDeVentas/blob/main/Sistema.png" height="500">


----------Paquetes del sistema----------
- <a href="https://github.com/RichardDB7/SistemaDeVentas/tree/main/DER"> Diagrama Entidad Relacion </a> - <a href="https://github.com/RichardDB7/SistemaDeVentas/blob/main/DER/Sistema.db.png"> [Gráfico DER] </a>
- <a href="https://github.com/RichardDB7/SistemaDeVentas/tree/main/PaqueteDatabase"> Paquete de Conexión a datos </a> - <a href="https://github.com/RichardDB7/SistemaDeVentas/blob/main/PaqueteDatabase/Conexion.Java">[Conexión]</a> - <a href="https://github.com/RichardDB7/SistemaDeVentas/blob/main/PaqueteDatabase/PruebaConexi%C3%B3n.java">[Test Base De Datos]</a> 
- <a href="https://github.com/RichardDB7/SistemaDeVentas/tree/main/PaqueteDatos"> Paquete de Datos </a> - <a href="https://github.com/RichardDB7/SistemaDeVentas/tree/main/PaqueteDatos/Interfaces">[Interfaces]</a> - <a href="https://github.com/RichardDB7/SistemaDeVentas/blob/main/PaqueteDatos/CategoriaDAO.java">[CategoriaDAO]</a> 
- <a href="https://github.com/RichardDB7/SistemaDeVentas/tree/main/PaqueteEntidades"> Paquete De Entidades </a> - <a href="https://github.com/RichardDB7/SistemaDeVentas/blob/main/PaqueteEntidades/ClaseCategoria.java">[Clase Categoria]</a>
- <a href="https://github.com/RichardDB7/SistemaDeVentas/tree/main/PaqueteNegocio"> Paquete De Negocio </a> - <a href="https://github.com/RichardDB7/SistemaDeVentas/blob/main/PaqueteNegocio/ClaseCategoriaControl.java">[Clase Categoria Control]</a>
- <a href="https://github.com/RichardDB7/SistemaDeVentas/tree/main/PaquetePresentaci%C3%B3n"> Paquete Presentación </a> - <a href="https://github.com/RichardDB7/SistemaDeVentas/blob/main/PaquetePresentaci%C3%B3n/FrmPrincipal.java">[Formulario Principal]</a> - <a href="https://github.com/RichardDB7/SistemaDeVentas/blob/main/PaquetePresentaci%C3%B3n/FrmCategoria.java">[Formulario Categoría]</a>
