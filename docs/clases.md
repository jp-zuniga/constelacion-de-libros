# 5. Diagrama de Clases

Este diagrama de clases describe la jerarquía de las clases del proyecto y las relaciones entre ellas. Puede encontrar una versión PNG para descargar [aquí](diagrama-de-clases.png).

## 5.1. Resumen

Todas las clases heredan de la clase `BaseEntity` para estandarizar el manejo de la llave primaria como UUIDs.

- Las entidades azules representan el modelado de los libros, sus atributos y los ejemplares que tiene la bibilioteca.
- Las entidades verdes representan el modelado de las ubicaciones de los ejemplares en la biblioteca con una estructura jerárquica. Esta estructura describe la ubicación de un ejemplar completamente al definir cada paso que se debe tomar para ubicar un libro.
  - `Sala` => `Estante` => `Fila` => `Columna` => `Ubicacion`
  - Con esta cadena, se define completamente y únicamente la ubicación de un libro.
- Las entidades moradas representan el modelado de catálogos que describen otras entidades.
  - Los `Ejemplar`es, las `Multa`s y las `Reserva`s tienen estados predefinidos.
  - Los movimientos de inventario tienen un tipo que se almacena como `TipoMovimiento`.
  - Los pagos se realizan por un método específico, que se almacena como un `MetodoPago`.
- Las entidades rojas representan las operaciones y transacciones del sistema: uso de ejemplares, inventario y cobros.
  - `Reserva` y `Prestamo` registran cómo los Clientes usan los Ejemplares (separarlos, retirarlos y devolverlos).
  - `Inventario` controla los movimientos de entrada y salida de Libros y Ejemplares.
  - `Multa` y `Deuda` registran las obligaciones pendientes de un Cliente.
  - `Pago`, `PagoDetalle` y `PagoAplicacion` registran cómo se cancelan esas deudas mediante distintos métodos (`MetodoPago`) y cómo se aplica cada pago a una deuda concreta.
- Las entidades amarillas son las que interactúan con el sistema.
  - Los `Empleado`s manejan los registros internos, y funcionan como los usuarios del sistema.
  - Los `Cliente`s realizan `Prestamo`s y `Reserva`s, y pueden ser vinculados a `Deuda`s y `Multa`s, si no cumplen con los pagos o las fechas de compromiso.

---

## 5.2. Diagrama

![Diagrama de clases.](diagramas/clases.svg)

---

[Regresar a índice global.](README.md)
