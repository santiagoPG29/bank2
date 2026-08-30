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
│   │   │       └── domain/
│   │   │           └── models/
│   │   │               ├── Address.java
│   │   │               ├── Administrator.java
│   │   │               ├── Bill.java
│   │  │               ├── Buyer.java
│   │  │               ├── Cart.java
│   │  │               ├── Delivery.java
│   │  │               ├── InCharge.java
│   │  │               ├── Inventory.java
│   │  │               ├── LogisticsP.java
│   │  │               ├── Merchants.java
│   │  │               ├── Order.java
│   │  │               ├── Producto.java
│   │  │               ├── Refund.java
│   │  │               ├── Return.java
│   │  │               ├── Store.java
│   │  │               ├── User.java
│   │  │               └── enums/
│   │  │                   ├── DeliveryStatus.java
│   │  │                   ├── InventoryStatus.java
│   │  │                   ├── OrderStatus.java
│   │  │                   ├── ProductType.java
│   │  │                   ├── TradingStatus.java
│   │  │                   └── UserStatus.java
│   │  └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── application/
│               └── Bank2ApplicationTests.java
├── .gitignore
├── HELP.md
├── pom.xml
├── mvnw
├── mvnw.cmd
├── README.md
└── target/
```

## Descripción de las clases principales

# User (Resumen)

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

# Buyer (Resumen)

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

# Merchants (Resumen)

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

# Administrator (Resumen)

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

# InCharge (Resumen)

## Descripción
Representa a un encargado o personal operativo que consulta información del sistema para apoyar la gestión.

## Atributos
- Ninguno propios.

## Métodos
- ConsulInformation(): consulta información relevante.

## Relaciones
- Un `InCharge` es un tipo de `User`.

-----------------------------------------------------

# LogisticsP (Resumen)

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

# Store (Resumen)

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
# Producto (Resumen)

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

# Inventory (Resumen)

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

# Order (Resumen)

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

# Cart (Resumen)

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

# Address (Resumen)

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

# Bill (Resumen)

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

# Return (Resumen)

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

# Refund (Resumen)

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

# Delivery (Resumen)

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

# Enums del dominio

## UserStatus
Valores: ACTIVE, INACTIVE, BLOCKED

## TradingStatus
Valores: ACTIVE, PENDING_APPROVAL, SUSPENDED, BLOCKED

## ProductType
Valores: ELECTRONICS, HOME, CLOTHING, FOOD, BEAUTY, SPORTS, OTHER

## InventoryStatus
Valores: AVAILABLE, LOW_STOCK, OUT_OF_STOCK, RESERVED

## OrderStatus
Valores: PENDING, CONFIRMED, IN_PREPARATION, SHIPPED, DELIVERED, CANCELLED

## DeliveryStatus
Valores: PENDING, ASSIGNED, IN_TRANSIT, DELIVERED, FAILED

## Enums del dominio

### UserStatus
- Valores: ACTIVE, INACTIVE, BLOCKED

### TradingStatus
- Valores: ACTIVE, PENDING_APPROVAL, SUSPENDED, BLOCKED

### ProductType
- Valores: ELECTRONICS, HOME, CLOTHING, FOOD, BEAUTY, SPORTS, OTHER

### InventoryStatus
- Valores: AVAILABLE, LOW_STOCK, OUT_OF_STOCK, RESERVED

### OrderStatus
- Valores: PENDING, CONFIRMED, IN_PREPARATION, SHIPPED, DELIVERED, CANCELLED

### DeliveryStatus
- Valores: PENDING, ASSIGNED, IN_TRANSIT, DELIVERED, FAILED

-----------------------------------------------------
Proyecto de aprendizaje/desarrollo académico para la asignatura de construcción II.
