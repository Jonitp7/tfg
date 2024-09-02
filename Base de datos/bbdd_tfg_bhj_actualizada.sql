create database BBDD_TFG_BHJ;
use BBDD_TFG_BHJ;

create table usuarios
(username varchar(50) not null,
contraseña varchar(50) not null,
nombre varchar(50) not null,
apellido varchar(50) not null,
dni varchar(9) not null,
archivo_foto varchar(50),
PRIMARY KEY (username)
);

insert into usuarios
values("tomas", "tomasin", "Tomas", "Escudero", "00000000A", "foto.png");
insert into usuarios
values("javi", "javi", "Javi", "Ruiz", "00000000A", "foto.png");

create table notificaciones
(
id_notificacion int not null auto_increment,
username varchar(50) not null,
texto_notificacion varchar(150) not null,
fecha date not null,
PRIMARY KEY(id_notificacion),
FOREIGN KEY (username) references usuarios(username)
);



create table compradores
(
id_comprador int auto_increment not null,
username varchar(50) not null,

PRIMARY KEY (id_comprador),
FOREIGN KEY (username) references usuarios (username)
);

create table propietarios
(
id_propietario int auto_increment not null,
tipo_propietario tinyint not null default 0, 
 -- 0 vendedor, 1 banco
username varchar(50) not null,
PRIMARY KEY (id_propietario),
FOREIGN KEY (username) references usuarios (username)
);



create table viviendas
(
id_vivienda int auto_increment not null,
ubicacion varchar(50) not null,
id_propietario int not null,
extension varchar(300) not null,
habitaciones int not null,
baños int not null,
garaje boolean not null,
descripcion varchar(500) not null,
estado enum('ALQUILADA','EN VENTA','EN SUABASTA', 'VENDIDA', 'PARA ALQUILAR') not null,
plantas int not null,
precio int not null, 
año_construccion date,
PRIMARY KEY (id_vivienda),
FOREIGN KEY (id_propietario) references propietarios (id_propietario)
);

create table favoritos
(
id_favorito int not null,
id_comprador int not null,
id_vivienda int not null,
PRIMARY KEY ( id_favorito),
FOREIGN KEY (id_comprador) references compradores (id_comprador),
FOREIGN KEY (id_vivienda) references viviendas (id_vivienda)
);
/*create table transacciones
(
id_transaccion int auto_increment not null,
tipo_transaccion enum('VENTA','SUABASTA', 'ALQUILER') not null,
id_vivienda int not null,
id_comprador int,
PRIMARY KEY (id_transaccion),
FOREIGN KEY (id_vivienda) references viviendas (id_vivienda),
FOREIGN KEY (id_comprador) references compradores (id_comprador)
);*/

create table ventas
(
id_venta int auto_increment not null,
id_vivienda int not null,
estado varchar(50) not null,
id_comprador int,
PRIMARY KEY (id_venta),
FOREIGN KEY (id_vivienda) references viviendas (id_vivienda),
FOREIGN KEY (id_comprador) references compradores (id_comprador)
);


create table alquileres
(
id_alquiler int not null,
id_vivienda int not null,
precio int not null,
estado varchar(50) not null,
id_arrendatario int,
fecha_inicio date, 
fecha_fin date,
PRIMARY KEY (id_alquiler),
FOREIGN KEY (id_vivienda) references viviendas (id_vivienda),
FOREIGN KEY (id_arrendatario) references compradores (id_comprador)
);



create table subastas
(
id_subasta int not null,
id_vivienda int not null,
estado varchar(50) not null,
precio_inicial int not null,
fecha_inicio date not null, 
fecha_fin date not null,
PRIMARY KEY (id_subasta),
FOREIGN KEY (id_vivienda) references viviendas (id_vivienda)
);

create table pujas
(
id_puja int auto_increment not null,
id_subasta int not null,
id_postor int,
cantidad int not null,
PRIMARY KEY (id_puja),
FOREIGN KEY (id_subasta) references subastas (id_subasta),
FOREIGN KEY (id_postor) references compradores (id_comprador)
);

create user uviviendas identified by 'uviviendas';
grant all privileges on BBDD_TFG_BHJ.* to uviviendas;