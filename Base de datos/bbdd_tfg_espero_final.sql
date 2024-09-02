create database BBDD_TFG_BHJ;
use BBDD_TFG_BHJ;

create table usuarios
(
id_usuario int auto_increment not null unique,
username varchar(50) not null,
password varchar(50) not null,
nombre varchar(50) not null,
apellidos varchar(60) not null,
dni varchar(9) not null,
email varchar(50) not null,
numero_telefono varchar (25) not null,
fecha_nacimiento date not null,
fecha_alta date not null,
tipo_usuario varchar(50) not null,
PRIMARY KEY (id_usuario)
);

INSERT INTO usuarios VALUES 
(1,"tomas","tomasin","Tomas", "Escudero","0000000y","tomas@gmail.com","123456789",'1999-12-31','1999-12-31',"propietario"),
(2,"joni","joni","joni", "joni","0000000y","joni@joni.com","123456789",'1999-12-31','1999-12-31',"admin"),
(3,"samu","samu","samu", "samu","0000000y","samu@samu.com","123456789",'1999-12-31','1999-12-31',"basico");



create table roles
(
id_rol int auto_increment not null,
id_usuario int not null,
nombre_rol varchar(50) not null,
PRIMARY KEY(id_rol),
FOREIGN KEY(id_usuario)  references usuarios (id_usuario)
);

create table chatbox
(
id_chat int auto_increment not null,
id_usuario int not null,
usuario_receptor int not null,
consulta varchar(800) not null,
PRIMARY KEY (id_chat),
FOREIGN KEY (id_usuario) references usuarios (id_usuario),
FOREIGN KEY (usuario_receptor) references usuarios (id_usuario)
);


create table viviendas
(
id_vivienda int auto_increment not null,
ubicacion varchar(50) not null,
vista varchar(40) not null,
id_usuario int not null,
extension varchar(300) not null,
habitaciones int not null,
aseos int not null,
aseos_habitacion int not null,
garaje boolean not null,
descripcion varchar(500) not null,
valoracion int ,
golf boolean not null,
spa boolean not null,
jardin boolean not null,
piscina boolean not null,
plantas int not null,
fecha_construccion date,
fecha_alta_vivienda date not null,
fecha_cancelacion_vivienda date,
existencia_subasta boolean not null,
tipo_vivienda varchar(50) not null,
fotos_vivienda JSON,
PRIMARY KEY (id_vivienda),
FOREIGN KEY (id_usuario) references usuarios(id_usuario)
);
INSERT INTO viviendas (
    ubicacion, vista, id_usuario, extension, habitaciones, aseos, aseos_habitacion, garaje, 
    descripcion, valoracion, golf, spa, jardin, piscina, plantas, fecha_construccion, 
    fecha_alta_vivienda, fecha_cancelacion_vivienda, existencia_subasta, tipo_vivienda, fotos_vivienda
) VALUES 
(
    'Madrid, España', 'Ciudad', 2, '100', 4, 2, 1, true,
    'Una casa espaciosa en el centro de Madrid con todas las comodidades modernas.', 5, true, false, true, true, 2, '2000-05-15',
    '2023-01-01', '2023-12-31', false, 'Casa unifamiliar', JSON_OBJECT('foto1', 'foto1-1.jpg', 'foto2', 'foto1-2.jpg', 'foto3', 'foto1-3.jpg', 'foto4', 'foto1-4.jpg')
),
(
    'Barcelona, España', 'Mar', 2, '180', 3, 2, 1, true,
    'Apartamento moderno con vista al mar, cerca de la playa y todas las atracciones turísticas.', 4, false, true, false, false, 1, '2015-06-20',
    '2023-02-01', '2023-11-30', false, 'Apartamento', JSON_OBJECT('foto1', 'foto2-1.jpg', 'foto2', 'foto2-2.jpg', 'foto3', 'foto2-3.jpg', 'foto4', 'foto2-4.jpg')
),
(
    'Valencia, España', 'Parque', 2, '320', 5, 3, 2, true,
    'Casa moderna con jardín privado y fácil acceso al parque central.', 4, true, true, true, true, 3, '2010-08-10',
    '2023-03-01', '2023-09-30', true, 'Casa adosada', JSON_OBJECT('foto1', 'foto3-1.jpg', 'foto2', 'foto3-2.jpg', 'foto3', 'foto3-3.jpg', 'foto4', 'foto3-4.jpg')
),
(
    'Sevilla, España', 'Montaña', 2, '72', 4, 2, 1, true,
    'Villa tranquila en las montañas, perfecta para una vida relajada.', 5, true, false, true, true, 1, '2005-11-05',
    '2023-04-01', '2023-10-31', false, 'Villa', JSON_OBJECT('foto1', 'foto4-1.jpg', 'foto2', 'foto4-2.jpg', 'foto3', 'foto4-3.jpg', 'foto4', 'foto4-4.jpg')
),
(
    'Bilbao, España', 'Rio', 1, '225', 3, 2, 1, false,
    'Apartamento acogedor con vistas al rio y cerca del centro cultural.', 3, false, false, false, true, 1, '2020-01-01',
    '2023-05-01', '2023-08-31', true, 'Duplex', JSON_OBJECT('foto1', 'foto5-1.jpg', 'foto2', 'foto5-2.jpg', 'foto3', 'foto5-3.jpg', 'foto4', 'foto5-4.jpg')
),
(
    'Barcelona, España', 'Playa', 2, '350', 4, 3, 2, true,
    'Ático luminoso con vistas al mar y cerca del puerto deportivo.', 4, true, true, false, false, 2, '2021-02-15',
    '2024-07-01', '2024-09-30', false, 'Penthouse', JSON_OBJECT('foto1', 'foto6-1.jpg', 'foto2', 'foto6-2.jpg', 'foto3', 'foto6-3.jpg', 'foto4', 'foto6-4.jpg')
),
(
    'Madrid, España', 'Centro', 2, '400', 5, 4, 3, true,
    'Piso moderno en pleno centro, cerca de todas las atracciones principales.', 5, true, false, true, false, 3, '2021-01-01',
    '2024-06-01', '2024-12-31', true, 'Loft', JSON_OBJECT('foto1', 'foto7-1.jpg', 'foto2', 'foto7-2.jpg', 'foto3', 'foto7-3.jpg', 'foto4', 'foto7-4.jpg')
),
(
    'Sevilla, España', 'Barrio Antiguo', 1, '275', 3, 2, 1, false,
    'Apartamento histórico con encanto, situado en un barrio lleno de vida.', 3, false, true, false, true, 1, '2020-03-01',
    '2023-07-01', '2023-11-30', false, 'Apartamento', JSON_OBJECT('foto1', 'foto8-1.jpg', 'foto2', 'foto8-2.jpg', 'foto3', 'foto8-3.jpg', 'foto4', 'foto8-4.jpg')
),
(
    'Valencia, España', 'Playa', 2, '300', 4, 3, 2, true,
    'Apartamento con vistas al mar y acceso directo a la playa.', 4, true, false, true, false, 2, '2020-06-15',
    '2023-08-01', '2023-12-31', true, 'Ático', JSON_OBJECT('foto1', 'foto9-1.jpg', 'foto2', 'foto9-2.jpg', 'foto3', 'foto9-3.jpg', 'foto4', 'foto9-4.jpg')
),
(
    'Granada, España', 'Centro Histórico', 2, '225', 2, 1, 1, false,
    'Apartamento acogedor en el centro histórico, cerca de la Alhambra.', 3, false, false, false, true, 1, '2019-05-01',
    '2022-05-01', '2022-08-31', true, 'Estudio', JSON_OBJECT('foto1', 'foto10-1.jpg', 'foto2', 'foto10-2.jpg', 'foto3', 'foto10-3.jpg', 'foto4', 'foto10-4.jpg')
),
(
    'Málaga, España', 'Paseo Marítimo', 2, '350', 4, 3, 2, true,
    'Piso con vistas al mar, cerca del paseo marítimo y de restaurantes.', 4, true, true, false, false, 2, '2021-04-01',
    '2024-09-01', '2024-12-31', true, 'Apartamento', JSON_OBJECT('foto1', 'foto11-1.jpg', 'foto2', 'foto11-2.jpg', 'foto3', 'foto11-3.jpg', 'foto4', 'foto11-4.jpg')
),
(
    'Córdoba, España', 'Casco Viejo', 2, '250', 3, 2, 1, false,
    'Apartamento en el casco viejo, lleno de encanto y cerca de la mezquita.', 3, false, false, false, true, 1, '2020-01-01',
    '2023-05-01', '2023-08-31', true, 'Dúplex', JSON_OBJECT('foto1', 'foto12-1.jpg', 'foto2', 'foto12-2.jpg', 'foto3', 'foto12-3.jpg', 'foto4', 'foto12-4.jpg')
),
(
    'Alicante, España', 'Playa', 1, '300', 4, 3, 2, true,
    'Piso en primera línea de playa con todas las comodidades modernas.', 4, true, false, true, false, 2, '2018-01-15',
    '2023-01-01', '2023-12-31', true, 'Apartamento', JSON_OBJECT('foto1', 'foto13-1.jpg', 'foto2', 'foto13-2.jpg', 'foto3', 'foto13-3.jpg', 'foto4', 'foto13-4.jpg')
),
(
    'Salamanca, España', 'Centro', 2, '150', 3, 1, 1, false,
    'Apartamento en el centro, cerca de la universidad y lugares históricos.', 3, false, false, false, true, 1, '2019-05-01',
    '2023-02-01', '2023-05-31', false, 'Estudio', JSON_OBJECT('foto1', 'foto14-1.jpg', 'foto2', 'foto14-2.jpg', 'foto3', 'foto14-3.jpg', 'foto4', 'foto14-4.jpg')
);

create table solicitudes 
( 
id_solicitud int auto_increment not null,
id_usuario int not null,
estado_solicitud varchar (50) not null,
fecha date not null,
datos_vivienda JSON not null,
PRIMARY KEY(id_solicitud),
FOREIGN KEY (id_usuario) references usuarios (id_usuario)
);

INSERT INTO solicitudes (id_usuario, estado_solicitud, fecha, datos_vivienda) VALUES 
(1, 'En espera', '2023-01-15', 
JSON_OBJECT(
'ubicacion', 'Calle Falsa 123', 
'vista', 'Parque', 
'extension', '85', 
'habitaciones', 3, 
'aseos', 1, 
'aseos_habitacion', 1, 
'garaje', false, 
'descripcion', 'Departamento acogedor con vista al parque', 
'valoracion', 8, 
'golf', false, 
'spa', true, 
'jardin', true, 
'piscina', false, 
'plantas', 1, 
'fecha_construccion', '2015-04-23', 
'fecha_alta_vivienda', '2023-01-10', 
'fecha_cancelacion_vivienda', '2023-01-20', 
'existencia_subasta', false, 
'tipo_vivienda', 'Departamento',
'fotosVivienda', JSON_ARRAY('foto1-1.jpg', 'foto1-2.jpg', 'foto1-3.jpg', 'foto1-4.jpg'))),
(1, 'En espera', '2023-01-15', 
JSON_OBJECT(
'ubicacion', 'Calle Pez 123', 
'vista', 'Ciudad', 
'extension', '185', 
'habitaciones', 2, 
'aseos', 3, 
'aseos_habitacion', 1, 
'garaje', false, 
'descripcion', 'Departamento acogedor con vista a la ciudad', 
'valoracion', 8, 
'golf', true, 
'spa', false, 
'jardin', true, 
'piscina', true, 
'plantas', 1, 
'fecha_construccion', '2015-04-23', 
'fecha_alta_vivienda', '2023-01-10', 
'fecha_cancelacion_vivienda', '2023-01-20', 
'existencia_subasta', false, 
'tipo_vivienda', 'Departamento',
'fotosVivienda', JSON_ARRAY('foto2-1.jpg', 'foto2-2.jpg', 'foto2-3.jpg', 'foto2-4.jpg')));


create table chats_prop
(
id_chat_prop int auto_increment not null,
id_usuario int  not null,
usuario_receptor int not null,
mensaje varchar (800),
fecha date not null,
leido boolean not null,
PRIMARY KEY(id_chat_prop),
FOREIGN KEY (id_usuario) references usuarios (id_usuario),
FOREIGN KEY(usuario_receptor) references usuarios(id_usuario)
);

create table opiniones
(
id_opinion  int auto_increment not null,
id_usuario int  not null,
valoracion int ,
id_vivienda int not null,
comentario varchar(800),
fecha_opinion date not null,
PRIMARY KEY (id_opinion),
FOREIGN KEY (id_usuario) references usuarios (id_usuario),
FOREIGN KEY (id_vivienda) references viviendas (id_vivienda)
);


create table favoritos
(
id_favorito int not null auto_increment,
id_usuario int not null,
id_vivienda int not null,
PRIMARY KEY ( id_favorito),
FOREIGN KEY (id_usuario) references usuarios (id_usuario),
FOREIGN KEY (id_vivienda) references viviendas (id_vivienda)
);



create table alquileres
(
id_alquiler int not null auto_increment,
id_vivienda int not null,
precio_noche int not null,
precio_cancelacion int not null,
personas int not null,
estado_alquiler varchar(50) not null,
fecha_entrada date not null, 
fecha_salida date not null,
id_usuario int not null,
PRIMARY KEY (id_alquiler),
FOREIGN KEY (id_vivienda) references viviendas (id_vivienda),
FOREIGN KEY (id_usuario) references usuarios (id_usuario)
);
INSERT INTO alquileres (id_vivienda, precio_noche, precio_cancelacion, personas, estado_alquiler, fecha_entrada, fecha_salida, id_usuario)
VALUES
(1, 100, 50, 4, 'Reservado', '2024-06-01', '2024-06-07', 1),
(2, 120, 60, 3, 'Confirmado', '2024-07-01', '2024-07-05', 2),
(3, 80, 40, 2, 'Cancelado', '2024-06-15', '2024-06-20', 1),
(4, 150, 75, 5, 'Confirmado', '2024-08-01', '2024-08-10', 2),
(5, 90, 45, 3, 'Reservado', '2024-06-25', '2024-07-01', 1);


create table historico_alquileres
(
id_historico_alquiler int auto_increment not null,
fecha_entrada_alquiler date not null,
fecha_salida_alquiler date not null,
fecha_cancelacion_alquiler date not null,
id_usuario int not null,
id_vivienda int not null,
id_alquiler int not null,
PRIMARY KEY (id_historico_alquiler),
FOREIGN KEY (id_usuario) references usuarios(id_usuario),
FOREIGN KEY (id_vivienda) references viviendas(id_vivienda),
FOREIGN KEY (id_alquiler) references alquileres(id_alquiler)
);

create table subastas
(
id_subasta int auto_increment not null,
id_vivienda int not null,
estado_subasta varchar(50) not null,
precio_inicial int not null,
fecha_inicio date not null, 
fecha_fin date not null,
id_usuario int not null,
PRIMARY KEY (id_subasta),
FOREIGN KEY (id_vivienda) references viviendas(id_vivienda),
FOREIGN KEY(id_usuario) references usuarios(id_usuario)
);

create table historico_subastas
(
id_historico_subastas int auto_increment not null,
id_vivienda int not null,
id_subasta int not null,
fecha_inicio_subasta date not null,
fecha_fin_subasta date not null,
fecha_cancelacion_subasta date not null,
precio_venta int not null,
id_usuario int not null,
PRIMARY KEY (id_historico_subastas),
FOREIGN KEY (id_usuario) references usuarios(id_usuario),
FOREIGN KEY (id_vivienda) references viviendas(id_vivienda),
FOREIGN KEY (id_subasta) references subastas(id_subasta)
);

create table pujas
(
id_puja int auto_increment not null,
id_subasta int not null,
id_usuario int not null,
estado_puja varchar(50) not null,
valor_puja int not null,
PRIMARY KEY (id_puja),
FOREIGN KEY (id_subasta) references subastas (id_subasta),
FOREIGN KEY (id_usuario) references usuarios (id_usuario)
);



create user uviviendas identified by 'uviviendas';
grant all privileges on BBDD_TFG_BHJ.* to uviviendas;