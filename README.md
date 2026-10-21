# NEXUSMARKET

Proyecto de backend desarrollado con Java para modelar un sistema de comercio electrónico con usuarios, productos, pedidos, inventario, pagos, entregas y devoluciones.

## Descripción general

Este proyecto representa un dominio de negocio orientado a un marketplace. Su objetivo principal es estructurar las entidades y responsabilidades del negocio alrededor de procesos como:

- gestión de usuarios y roles
- compras y carrito
- productos y categorías
- inventario y bodegas
- pedidos y estados
- facturación
- entregas
- devoluciones y reembolsos

sigue una organización por paquetes de dominio, donde cada clase corresponde a una entidad o concepto del negocio.

## Estructura del proyecto

```text
bank2/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── application/
│   │   │       ├── Bank2Application.java
│   │   │       ├── domain/
│   │   │       │   ├── models/
│   │   │       │   │   ├── Address.java
│   │   │       │   │   ├── Administrator.java
│   │   │       │   │   ├── Bill.java
│   │   │       │   │   ├── Buyer.java
│   │   │       │   │   ├── Cart.java
│   │   │       │   │   ├── Delivery.java
│   │   │       │   │   ├── InCharge.java
│   │   │       │   │   ├── Inventory.java
│   │   │       │   │   ├── LogisticsP.java
│   │   │       │   │   ├── Merchants.java
│   │   │       │   │   ├── Order.java
│   │   │       │   │   ├── Producto.java
│   │   │       │   │   ├── Refund.java
│   │   │       │   │   ├── Return.java
│   │   │       │   │   ├── Store.java
│   │   │       │   │   ├── User.java
│   │   │       │   │   └── enums/
│   │   │       │   │       ├── DeliveryStatus.java
│   │   │       │   │       ├── InventoryStatus.java
│   │   │       │   │       ├── OrderStatus.java
│   │   │       │   │       ├── ProductType.java
│   │   │       │   │       ├── TradingStatus.java
│   │   │       │   │       └── UserStatus.java
│   │   │       │   ├── ports/
│   │   │       │   │   ├── CartPort.java
│   │   │       │   │   ├── CartProductPort.java
│   │   │       │   │   ├── DeliveryConfirmationPort.java
│   │   │       │   │   ├── DeliveryPort.java
│   │   │       │   │   ├── InventoryPort.java
│   │   │       │   │   ├── InventoryStockPort.java
│   │   │       │   │   ├── OrderPort.java
│   │   │       │   │   ├── ProductoPort.java
│   │   │       │   │   ├── RefundDecisionPort.java
│   │   │       │   │   ├── RefundPort.java
│   │   │       │   │   ├── UserPort.java
│   │   │       │   ├── valueObjects/
│   │   │       │   │   └── UserStatus.java
│   │   │       │   └── services/
│   │   │       │       ├── CartProductService.java
│   │   │       │       ├── CartService.java
│   │   │       │       ├── DeliveryConfirmationService.java
│   │   │       │       ├── DeliveryService.java
│   │   │       │       ├── InventoryService.java
│   │   │       │       ├── InventoryStockService.java
│   │   │       │       ├── OrderService.java
│   │   │       │       ├── ProductoService.java
│   │   │       │       ├── RefundDecisionService.java
│   │   │       │       ├── RefundService.java
│   │   │       │       └── UserService.java
│   │   │       └── infrastructure/
│   │   │           └── controllers/
│   │   │               └── HealthController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── application/
│               ├── Bank2ApplicationTests.java
│               └── domain/
│                   └── services/
│                       └── DomainCommandServicesTest.java
├── .gitignore
├── HELP.md
├── pom.xml
├── mvnw
├── mvnw.cmd
├── README.md
└── target/
```
-----------------------------------------------------

## Descripción de las clases principales

# User - Usuario

## Descripción
Representa a cualquier usuario registrado dentro del sistema de comercio. Esta clase centraliza la información común de identificación, contacto y estado que comparten los distintos tipos de usuarios del dominio.

## Atributos
- id: long — Identificador único del usuario.
- name: String — Nombre completo del usuario.
- email: String — Correo electrónico principal.
- password: String — Contraseña del usuario.
- phoneNumber: String — Número de contacto.
- userStatus: UserStatus — Estado actual del usuario dentro del sistema.

## Métodos
- updateStatus(): cambia el estado del usuario.
- viewProfile(): permite visualizar la información del perfil.

## Relaciones
- Un `User` puede especializarse en `Buyer`, `Merchants`, `Administrator`, `InCharge` o `LogisticsP`.
- `UserStatus` define el estado del usuario.

-----------------------------------------------------

# Buyer - Comprador

## Descripción
Representa al cliente comprador dentro del sistema. Extiende la información base del usuario para incluir datos de compra y comportamiento comercial.

## Atributos
- mainAddress: String — Dirección principal del comprador.
- tradingStatus: TradingStatus — Estado comercial del comprador.
- user: User — Referencia al usuario base asociado.

## Métodos
- Addaddress(): agrega una dirección.
- Placeanorder(): realiza un pedido.
- Vieworderhistory(): consulta el historial de pedidos.

## Relaciones
- Un `Buyer` es un tipo de `User`.
- Un `Buyer` puede tener uno o varios pedidos y un carrito asociado.
- `TradingStatus` indica el estado comercial del comprador.

-----------------------------------------------------

# Merchants - Comerciante

## Descripción
Representa a un comerciante o vendedor dentro del sistema. Es la entidad encargada de relacionar productos y bodegas con las operaciones comerciales.

## Atributos
- MainWarehause: String — Nombre o referencia a la bodega principal del comerciante.

## Métodos
- registerProduct(): registra un producto.
- ManegeInventory(): administra el inventario.

## Relaciones
- Un `Merchants` es un tipo de `User`.
- Un `Merchants` puede gestionar varios `Producto` y `Store`.

-----------------------------------------------------

# Administrator - Administrador

## Descripción
Representa al administrador del sistema, cuya responsabilidad es gestionar registros clave del negocio.

## Atributos
- Ninguno propios.

## Métodos
- registerSeller(): registra un vendedor.
- registerWarehause(): registra una bodega.

## Relaciones
- Un `Administrator` es un tipo de `User`.
- El administrador coordina operaciones sobre vendedores y almacenes.

-----------------------------------------------------

# InCharge - Encargado

## Descripción
Representa a un encargado o personal operativo que consulta información del sistema para apoyar la gestión.

## Atributos
- Ninguno propios.

## Métodos
- ConsulInformation(): consulta información relevante.

## Relaciones
- Un `InCharge` es un tipo de `User`.

-----------------------------------------------------

# LogisticsP - Personal de logística

## Descripción
Representa la parte logística del sistema. Se encarga de la preparación y seguimiento del envío de pedidos.

## Atributos
- Ninguno propios.

## Métodos
- processShipment(): procesa un envío.
- updateShippingStatus(): actualiza el estado del transporte.

## Relaciones
- Un `LogisticsP` es un tipo de `User`.
- Se relaciona con `Delivery` y `Order`.

-----------------------------------------------------

# Store - Bodega

## Descripción
Representa una bodega o almacén donde se almacenan y gestionan los productos del sistema.

## Atributos
- id: long — Identificador de la bodega.
- name: String — Nombre de la bodega.
- ubication: String — Ubicación de la bodega.

## Métodos
- record(): registra información de la bodega.
- consultCapaciti(): consulta la capacidad de almacenamiento.

## Relaciones
- Un `Store` pertenece a `Merchants`.
- Una tienda puede tener varios `Inventory`.

-----------------------------------------------------
# Producto - Producto

## Descripción
Representa un producto disponible para venta dentro del comercio.

## Atributos
- id: long — Identificador del producto.
- name: String — Nombre del producto.
- productType: ProductType — Tipo de producto.

## Métodos
- post(): publica el producto.
- suspend(): suspende el producto.

## Relaciones
- Un `Producto` pertenece a `Merchants`.
- `ProductType` define la categoría comercial del producto.

-----------------------------------------------------

# Inventory - Inventario

## Descripción
Representa el inventario asociado a una bodega o tienda, con el control del stock disponible.

## Atributos
- name: String — Nombre del inventario.
- quantity: int — Cantidad disponible.
- estado: InventoryStatus — Estado del inventario.

## Métodos
- updateInventory(): actualiza la cantidad o el estado.
- checkInventory(): revisa el inventario.
- enterInventory(): ingresa productos al stock.
- validateInventory(): valida datos del inventario.
- removeInventory(): elimina elementos del inventario.

## Relaciones
- `Inventory` pertenece a `Store`.
- `InventoryStatus` define si hay stock, poco stock o agotado.

-----------------------------------------------------

# Order - Pedido

## Descripción
Representa un pedido generado por un comprador del sistema.

## Atributos
- id: long — Identificador del pedido.
- date: LocalDateTime — Fecha en que se creó el pedido.
- total: String — Total del pedido.
- status: OrderStatus — Estado actual del pedido.

## Métodos
- changeStatus(): cambia el estado del pedido.
- cancelOrder(): cancela el pedido.
- finishOrder(): finaliza la compra.

## Relaciones
- Un `Order` pertenece a `Buyer`.
- Un pedido puede generar una `Bill`, una `Return` y una `Delivery`.
- `OrderStatus` describe el flujo del pedido.

-----------------------------------------------------

# Cart - Carrito de compras

## Descripción
Representa el carrito de compras del cliente antes de confirmarlo como pedido.

## Atributos
- id: long — Identificador del carrito.
- date: LocalDateTime — Fecha de creación o actualización.

## Métodos
- addProduct(): agrega un producto al carrito.
- removeProduct(): elimina un producto del carrito.

## Relaciones
- Un `Cart` pertenece a `Buyer`.

-----------------------------------------------------

# Address - Dirección

## Descripción
Representa la dirección asociada al comprador o a un lugar del dominio comercial.

## Atributos
- id: long — Identificador de la dirección.
- calle: String — Nombre de la calle.
- ciudad: String — Ciudad donde se ubica la dirección.

## Métodos
- validateAddress(): valida la dirección registrada.

## Relaciones
- `Address` está asociada a `Buyer`.

-----------------------------------------------------

# Bill - Factura

## Descripción
Representa la factura generada para un pedido específico.

## Atributos
- dateIssue: LocalDateTime — Fecha de emisión.
- taxes: float — Impuestos asociados.

## Métodos
- generateBill(): genera la factura.
- updateBill(): actualiza la factura.
- confirmBill(): confirma la factura.
- cancelBill(): cancela la factura.

## Relaciones
- `Bill` pertenece a `Order`.

-----------------------------------------------------

# Return - Devolución

## Descripción
Representa la solicitud de devolución vinculada a un pedido.

## Atributos
- reason: String — Motivo de la devolución.

## Métodos
- request(): solicita la devolución.
- approve(): aprueba la devolución.
- decline(): rechaza la devolución.

## Relaciones
- `Return` se especializa en `Order`.
- Puede derivar en un `Refund`.

-----------------------------------------------------

# Refund - Reembolso

## Descripción
Representa un reembolso asociado a una solicitud de devolución.

## Atributos
- id: long — Identificador del reembolso.
- reason: String — Motivo del reembolso.
- amount: float — Monto a reembolsar.

## Métodos
- confirm(): confirma el reembolso.

## Relaciones
- `Refund` hereda de `Return`.

-----------------------------------------------------

# Delivery - Entrega

## Descripción
Representa la entrega del pedido al cliente final.

## Atributos
- id: long — Identificador de la entrega.
- deliverydate: LocalDateTime — Fecha de entrega.
- deliveryStatus: DeliveryStatus — Estado de la entrega.

## Métodos
- delivery(): registra la entrega.
- update(): actualiza la información de entrega.
- confirmDelivery(): confirma la entrega.

## Relaciones
- `Delivery` pertenece a `Order`.
- `DeliveryStatus` define el progreso del envío.

-----------------------------------------------------

## Enums del dominio

### UserStatus - Estado del usuario
- Representa los estados posibles de una cuenta de usuario.
- Valores: ACTIVE, INACTIVE, BLOCKED

### TradingStatus - Estado comercial
- Indica la situación comercial de un comprador o vendedor.
- Valores: ACTIVE, PENDING_APPROVAL, SUSPENDED, BLOCKED

### ProductType - Tipo de producto
- Clasifica los productos por categoría comercial.
- Valores: ELECTRONICS, HOME, CLOTHING, FOOD, BEAUTY, SPORTS, OTHER

### InventoryStatus - Estado del inventario
- Describe la disponibilidad del stock.
- Valores: AVAILABLE, LOW_STOCK, OUT_OF_STOCK, RESERVED

### OrderStatus - Estado del pedido
- Indica la etapa actual del ciclo de vida de un pedido.
- Valores: PENDING, CONFIRMED, IN_PREPARATION, SHIPPED, DELIVERED, CANCELLED

### DeliveryStatus - Estado de la entrega
- Indica el avance o resultado de una entrega.
- Valores: PENDING, ASSIGNED, IN_TRANSIT, DELIVERED, FAILED

-----------------------------------------------------


## Arquitectura actual

El proyecto utiliza una separación sencilla por capas dentro del paquete `application`:

- `domain/models`: clases que representan los conceptos del marketplace. Varias son abstractas y usan Lombok (`@Getter`, `@Setter` y `@NoArgsConstructor`) para generar acceso a sus atributos.
- `Bank2Application` (Aplicación principal): inicia el contexto de Spring Boot y pone en marcha el backend.
- `domain/ports`: interfaces que definen las operaciones CRUD y las acciones de dominio disponibles para cada agregado.
- `domain/services`: servicios Spring que implementan esos puertos. Los servicios CRUD almacenan objetos en listas en memoria y generan identificadores consecutivos; los servicios de comandos ejecutan acciones de dominio mediante los puertos CRUD correspondientes.
- `infrastructure/controllers`: contiene `HealthController` (Controlador de estado), que expone el endpoint para comprobar la salud del backend.
- `domain/models/enums`: estados y categorías usados por el modelo.
- `domain/valueObjects`: contiene `UserStatus` (Estado del usuario), una enumeración duplicada respecto a `domain/models/enums/UserStatus`.

-----------------------------------------------------

### Puertos

Los puertos son interfaces del dominio que definen las operaciones disponibles para cada tipo de objeto. No contienen la implementación ni almacenan datos.

1. **`UserPort` (Puerto de usuarios)**: define las operaciones para registrar, consultar, actualizar y eliminar usuarios.
2. **`CartPort` (Puerto de carritos)**: define las operaciones para registrar, consultar, actualizar y eliminar carritos.
3. **`DeliveryPort` (Puerto de entregas)**: define las operaciones para registrar, consultar, actualizar y eliminar entregas.
4. **`InventoryPort` (Puerto de inventarios)**: define las operaciones para registrar, consultar, actualizar y eliminar inventarios.
5. **`OrderPort` (Puerto de pedidos)**: define las operaciones para registrar, consultar, actualizar y eliminar pedidos.
6. **`ProductoPort` (Puerto de productos)**: define las operaciones para registrar, consultar, actualizar y eliminar productos.
7. **`RefundPort` (Puerto de reembolsos)**: define las operaciones para registrar, consultar, actualizar y eliminar reembolsos.
8. **`CartProductPort` (Puerto de productos del carrito)**: define las acciones para agregar, quitar o vaciar productos del carrito.
9. **`DeliveryConfirmationPort` (Puerto de confirmación de entrega)**: define la acción que confirma que una entrega se completó.
10. **`InventoryStockPort` (Puerto de existencias)**: define las acciones para aumentar, disminuir y consultar el stock.
11. **`RefundDecisionPort` (Puerto de decisión de reembolso)**: define las acciones para aprobar o rechazar un reembolso.

-----------------------------------------------------

### Servicios

Los servicios están registrados como componentes Spring mediante `@Service`. Los servicios CRUD implementan los puertos de persistencia y usan una `List` independiente, por lo que funcionan como almacenamiento temporal en memoria. Los servicios de comandos implementan puertos específicos para acciones de dominio y consultan los servicios CRUD correspondientes.

1. **`UserService` (Servicio de usuarios)**: implementa `UserPort` y administra los registros de usuarios.
2. **`CartService` (Servicio de carritos)**: implementa `CartPort` y administra los registros de carritos.
3. **`DeliveryService` (Servicio de entregas)**: implementa `DeliveryPort` y administra los registros de entregas.
4. **`InventoryService` (Servicio de inventarios)**: implementa `InventoryPort` y administra los registros de inventario.
5. **`OrderService` (Servicio de pedidos)**: implementa `OrderPort` y administra los registros de pedidos.
6. **`ProductoService` (Servicio de productos)**: implementa `ProductoPort` y administra los registros de productos.
7. **`RefundService` (Servicio de reembolsos)**: implementa `RefundPort` y administra los registros de reembolsos.
8. **`CartProductService` (Servicio de productos del carrito)**: implementa `CartProductPort` y agrega, elimina o quita todos los productos de un carrito. Usa `CartPort` para localizarlo y rechaza productos nulos o carritos inexistentes.
9. **`DeliveryConfirmationService` (Servicio de confirmación de entrega)**: implementa `DeliveryConfirmationPort` y cambia el estado de una entrega existente a `DELIVERED`.
10. **`InventoryStockService` (Servicio de existencias)**: implementa `InventoryStockPort` y aumenta, disminuye o consulta el stock. Rechaza cantidades no positivas y evita disminuir por debajo del stock disponible.
11. **`RefundDecisionService` (Servicio de decisión de reembolso)**: implementa `RefundDecisionPort` y aprueba o rechaza reembolsos. Al aprobar, marca como cancelado el pedido asociado y actualiza el motivo de la decisión.

-----------------------------------------------------

#### Comportamiento común de los servicios

- `save` rechaza valores `null` con `IllegalArgumentException`.
- Si el objeto tiene `id == 0`, `save` asigna un identificador consecutivo.
- Si ya existe un objeto con el mismo identificador, `save` lo reemplaza.
- `findById` devuelve un `Optional`.
- `findAll` devuelve una copia de la lista interna.
- `update` reutiliza la lógica de `save` en los servicios CRUD que la implementan.
- `deleteById` elimina por identificador y no falla si el identificador no existe.
- Los datos se pierden al reiniciar la aplicación porque todavía no se utilizan repositorios de base de datos.

Los servicios de comandos no administran listas ni identificadores: reciben el puerto CRUD correspondiente por inyección de dependencias y aplican una acción de dominio sobre el objeto encontrado.

En los servicios, `save` rechaza valores `null`, asigna un identificador cuando el objeto tiene `id == 0` y reemplaza otro objeto que tenga el mismo identificador. `findById` devuelve un `Optional`, `findAll` devuelve una copia de la lista y `deleteById` no falla si el identificador no existe. Esta persistencia se pierde al reiniciar la aplicación.

-----------------------------------------------------

### Aplicación, controlador y pruebas

- **`Bank2Application` (Aplicación principal)**: inicia la aplicación Spring Boot.
- **`HealthController` (Controlador de estado)**: responde a las solicitudes de comprobación de salud en `/api/health`.
- **`Bank2ApplicationTests` (Prueba de inicio de la aplicación)**: comprueba que el contexto de Spring Boot cargue correctamente.
- **`DomainCommandServicesTest` (Prueba de servicios de comandos)**: comprueba las operaciones de productos del carrito, confirmación de entrega, stock y decisiones de reembolso.

## API disponible

La aplicación solo tiene actualmente un endpoint HTTP:

```http
GET http://localhost:8081/api/health
```

Respuesta esperada:

```json
{
	"status": "UP",
	"service": "bank2",
	"port": "8081"
}
```

No existen todavía controladores REST para usuarios, productos, carritos, pedidos, inventarios, entregas o reembolsos. Los servicios pueden ser inyectados por Spring, pero no están expuestos como API pública.

-----------------------------------------------------

## Configuración y dependencias

- Java 17.
- Spring Boot `4.1.1`.
- Spring Web para el endpoint de salud.
- Spring Data JPA, MySQL y H2 configurados como soporte de persistencia.
- Spring Data MongoDB incluido como dependencia.
- Spring Security incluido como dependencia, sin configuración de autenticación propia documentada en el código actual.
- Lombok para reducir código repetitivo en los modelos.

En `src/main/resources/application.properties`, la aplicación se llama `bank2`, escucha en el puerto `8081` y configura una base H2 en memoria llamada `bank2db`. Aunque H2/JPA están configurados, los servicios actuales no utilizan repositorios JPA ni MongoDB; trabajan exclusivamente con listas en memoria.

-----------------------------------------------------

## Ejecución

En Windows:

```bash
./mvnw.cmd spring-boot:run
```

En Linux o macOS:

```bash
./mvnw spring-boot:run
```

La aplicación quedará disponible en `http://localhost:8081`. Para comprobar el estado:

```bash
curl http://localhost:8081/api/health
```

-----------------------------------------------------

## Pruebas

El proyecto incluye `Bank2ApplicationTests` (Prueba de inicio de la aplicación), que comprueba que el contexto de Spring Boot cargue correctamente, y `DomainCommandServicesTest` (Prueba de servicios de comandos), que comprueba las operaciones de carrito, entrega, inventario y reembolso. No hay pruebas unitarias para los servicios CRUD ni pruebas de integración para el endpoint `/api/health`.

Para ejecutar las pruebas:

```bash
./mvnw.cmd test
```
