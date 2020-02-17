-- Generado por Oracle SQL Developer Data Modeler 19.4.0.350.1424
--   en:        2020-02-17 14:03:20 CLST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



CREATE TABLE categorias (
    id           INTEGER NOT NULL,
    nombre       VARCHAR2(50),
    descripcion  VARCHAR2(150)
);

ALTER TABLE categorias ADD CONSTRAINT categorias_pk PRIMARY KEY ( id );

CREATE TABLE clientes (
    id         INTEGER NOT NULL,
    nombre     VARCHAR2(50),
    rut        VARCHAR2(15),
    direccion  VARCHAR2(100)
);

ALTER TABLE clientes ADD CONSTRAINT clientes_pk PRIMARY KEY ( id );

CREATE TABLE facturas (
    numerofactura  INTEGER NOT NULL,
    fecha          DATE,
    subtotal       FLOAT,
    iva            FLOAT,
    preciototal    FLOAT,
    clientes_id    INTEGER NOT NULL
);

ALTER TABLE facturas ADD CONSTRAINT facturas_pk PRIMARY KEY ( numerofactura );

CREATE TABLE listado (
    id                      INTEGER NOT NULL,
    cantidad                INTEGER,
    valortotal              FLOAT,
    productos_id            INTEGER NOT NULL,
    facturas_numerofactura  INTEGER NOT NULL
);

ALTER TABLE listado ADD CONSTRAINT listado_pk PRIMARY KEY ( id );

CREATE TABLE productos (
    id             INTEGER NOT NULL,
    nombre         VARCHAR2(50),
    descripcion    VARCHAR2(2000),
    valorunitario  FLOAT,
    categorias_id  INTEGER NOT NULL
);

ALTER TABLE productos ADD CONSTRAINT productos_pk PRIMARY KEY ( id );

ALTER TABLE productos
    ADD CONSTRAINT fk_categoria FOREIGN KEY ( categorias_id )
        REFERENCES categorias ( id );

ALTER TABLE facturas
    ADD CONSTRAINT fk_cliente FOREIGN KEY ( clientes_id )
        REFERENCES clientes ( id );

ALTER TABLE listado
    ADD CONSTRAINT fk_factura FOREIGN KEY ( facturas_numerofactura )
        REFERENCES facturas ( numerofactura );

ALTER TABLE listado
    ADD CONSTRAINT fk_producto FOREIGN KEY ( productos_id )
        REFERENCES productos ( id );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                              9
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
