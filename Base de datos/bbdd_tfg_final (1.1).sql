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
(1,"tomas","tomasin","Tomas", "Escudero","12222222M","tomas@gmail.com","622222222",'1999-12-31','2023-12-31',"propietario"),
(2,"joni","joni","joni", "Tanassa","11111111M","joni@joni.com","657893234",'1999-12-31','2022-03-04',"admin"),
(3,"samu","samu","samu", "Rodriguez","13333333J","samu@samu.com","666666666",'1989-05-12','2023-12-31',"basico"),
(4,"monica","monica","monica", "Andreani","14444444M","monica@monica.com","655555555",'1973-01-27','2023-10-20',"basico"),
(5,"lidia","lidia","lidia", "Salazar","15555555G","lidia@lidia.com","677777777",'2000-11-23','2024-01-31',"basico"),
(6,"javi","javi","javi", "Gutierrez","16666666F","javi@javi.com","654654654",'1960-12-31','2023-12-31',"basico"),
(7,"pablo","pablo","pablo", "Cepeda","17777777M","pablo@pablo.com","678678678",'2002-08-11','2024-06-06',"basico"),
(8,"paula","paula","paula", "Ramos","18888888H","paula@paula.com","670670670",'1995-04-03','2023-04-03',"basico"),
(9,"simon","simon","simon", "Sánchez","19999999K","simon@simon.com","658658685",'1970-01-16','2023-01-20',"basico"),
(10,"carol","carol","carol", "Martinez","12345678F","carol@carol.com","623623623",'1980-07-22','2024-02-18',"basico"),
(11,"blanca","blanca","blanca", "Vera","22222222M","blanca@blanca.com","626534879",'1999-12-31','2022-03-04',"admin"),
(12,"luis","luis","luis", "Garcia","13213233M","luis@gmail.com","6546987321",'1999-12-31','2023-12-31',"propietario");


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
INSERT INTO chatbox values(1,3,1,'Buenos días, quería consultar si ya se ha aceptado la solicitud de mi última vivienda. Gracias'),
(2,1,3,'Buenos días, perdone la tardanza, efectivamente su vivienda se ha aceptado. Si tiene alguna duda más no dude en preguntarnos. un saludo!'),
(3,12,11,'Hola! Soy Luis, estoy interesado en poner una casa en alquiler, me podrían dar información de como funcionais? Muchas gracias');

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
fecha_cancelacion_vivienda date not null,
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
    '2023-01-01', '2023-12-31', false, 'Casa unifamiliar',JSON_OBJECT('foto1', 'foto1-1.jpg', 'foto2', 'foto1-2.jpg', 'foto3', 'foto1-3.jpg', 'foto4', 'foto1-4.jpg')
),
(
    'Barcelona, España', 'Mar', 2, '180', 3, 2, 1, true,
    'Apartamento moderno con vista al mar, cerca de la playa y todas las atracciones turísticas.', 4, false, true, false, false, 1, '2015-06-20',
    '2023-02-01', '2023-11-30', false, 'Apartamento',JSON_OBJECT('foto1', 'foto2-1.jpg', 'foto2', 'foto2-2.jpg', 'foto3', 'foto2-3.jpg', 'foto4', 'foto2-4.jpg')
),
(
    'Valencia, España', 'Parque', 2, '320', 5, 3, 2, true,
    'Casa moderna con jardín privado y fácil acceso al parque central.', 4, true, true, true, true, 3, '2010-08-10',
    '2023-03-01', '2023-09-30', true, 'Casa adosada',JSON_OBJECT('foto1', 'foto3-1.jpg', 'foto2', 'foto3-2.jpg', 'foto3', 'foto3-3.jpg', 'foto4', 'foto3-4.jpg')
),
(
    'Sevilla, España', 'Montaña', 2, '72', 4, 2, 1, true,
    'Villa tranquila en las montañas, perfecta para una vida relajada.', 5, true, false, true, true, 1, '2005-11-05',
    '2023-04-01', '2023-10-31', false, 'Villa',JSON_OBJECT('foto1', 'foto4-1.jpg', 'foto2', 'foto4-2.jpg', 'foto3', 'foto4-3.jpg', 'foto4', 'foto4-4.jpg')
),
(
    'Bilbao, España', 'Río', 1, '225', 3, 2, 1, false,
    'Apartamento acogedor con vistas al río y cerca del centro cultural.', 3, false, false, false, true, 1, '2020-01-01',
    '2023-05-01', '2023-08-31', true, 'Dúplex',JSON_OBJECT('foto1', 'foto5-1.jpg', 'foto2', 'foto5-2.jpg', 'foto3', 'foto5-3.jpg', 'foto4', 'foto5-4.jpg')
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
    'Bilbao, España', 'Ría', 1, '225', 3, 2, 1, false,
    'Apartamento acogedor con vistas a la ría y cerca del centro cultural.', 3, false, false, false, true, 1, '2020-01-01',
    '2023-05-01', '2023-08-31', true, 'Dúplex', JSON_OBJECT('foto1', 'foto13-1.jpg', 'foto2', 'foto13-2.jpg', 'foto3', 'foto13-3.jpg', 'foto4', 'foto13-4.jpg')
),
(
    'San Sebastián, España', 'La Concha', 3, '450', 5, 4, 3, true,
    'Ático de lujo con vistas a la playa de La Concha.', 5, true, true, false, false, 3, '2021-05-01',
    '2024-10-01', '2024-12-31', true, 'Penthouse', JSON_OBJECT('foto1', 'foto14-1.jpg', 'foto2', 'foto14-2.jpg', 'foto3', 'foto14-3.jpg', 'foto4', 'foto14-4.jpg')
),
(
    'Pamplona, España', 'Centro', 2, '275', 3, 2, 1, false,
    'Piso céntrico ideal para disfrutar de los Sanfermines.', 3, false, true, false, true, 1, '2020-07-01',
    '2023-09-01', '2023-12-31', false, 'Apartamento', JSON_OBJECT('foto1', 'foto15-1.jpg', 'foto2', 'foto15-2.jpg', 'foto3', 'foto15-3.jpg', 'foto4', 'foto15-4.jpg')
),
(
    'Zaragoza, España', 'Centro', 1, '250', 3, 2, 1, false,
    'Apartamento moderno en el centro, cerca de la basílica del Pilar.', 3, false, false, false, true, 1, '2019-12-01',
    '2022-12-01', '2023-03-31', true, 'Estudio', JSON_OBJECT('foto1', 'foto16-1.jpg', 'foto2', 'foto16-2.jpg', 'foto3', 'foto16-3.jpg', 'foto4', 'foto16-4.jpg')
),
(
    'Alicante, España', 'Playa', 3, '375', 4, 3, 2, true,
    'Apartamento frente a la playa con piscina comunitaria.', 4, true, false, true, false, 2, '2021-03-01',
    '2024-07-01', '2024-12-31', true, 'Ático', JSON_OBJECT('foto1', 'foto17-1.jpg', 'foto2', 'foto17-2.jpg', 'foto3', 'foto17-3.jpg', 'foto4', 'foto17-4.jpg')
),
(
    'Ibiza, España', 'Centro', 2, '450', 5, 4, 3, true,
    'Ático de lujo en el centro de Ibiza, con terraza privada.', 5, true, true, false, false, 3, '2021-06-01',
    '2024-10-01', '2024-12-31', true, 'Penthouse', JSON_OBJECT('foto1', 'foto18-1.jpg', 'foto2', 'foto18-2.jpg', 'foto3', 'foto18-3.jpg', 'foto4', 'foto18-4.jpg')
),
(
    'Tenerife, España', 'Costa', 3, '350', 4, 3, 2, true,
    'Piso con vistas al mar y cerca de playas y restaurantes.', 4, true, true, false, false, 2, '2021-02-01',
    '2024-05-01', '2024-09-30', true, 'Apartamento', JSON_OBJECT('foto1', 'foto19-1.jpg', 'foto2', 'foto19-2.jpg', 'foto3', 'foto19-3.jpg', 'foto4', 'foto19-4.jpg')
),
(
    'Mallorca, España', 'Playa', 2, '400', 5, 4, 3, true,
    'Ático con impresionantes vistas al mar y piscina privada.', 5, true, false, true, false, 3, '2021-07-01',
    '2024-09-01', '2024-12-31', true, 'Penthouse', JSON_OBJECT('foto1', 'foto20-1.jpg', 'foto2', 'foto20-2.jpg', 'foto3', 'foto20-3.jpg', 'foto4', 'foto20-4.jpg')
),
(
    'Menorca, España', 'Costa', 3, '325', 4, 3, 2, true,
    'Apartamento con vistas al mar y acceso directo a la playa.', 4, true, true, false, false, 2, '2021-05-01',
    '2024-07-01', '2024-12-31', true, 'Ático', JSON_OBJECT('foto1', 'foto21-1.jpg','foto2', 'foto21-2.jpg', 'foto3', 'foto21-3.jpg', 'foto4', 'foto21-4.jpg'
    )),
    (
    'Oviedo, España', 'Centro', 1, '200', 2, 1, 1, false,
    'Apartamento en el centro, cerca de la catedral y del casco histórico.', 3, false, false, false, true, 1, '2019-04-01',
    '2022-04-01', '2022-08-31', true, 'Estudio', JSON_OBJECT('foto1', 'foto22-1.jpg', 'foto2', 'foto22-2.jpg', 'foto3', 'foto22-3.jpg', 'foto4', 'foto22-4.jpg')
),
(
    'Santander, España', 'Centro', 2, '275', 3, 2, 1, false,
    'Piso céntrico con vistas a la bahía, cerca de tiendas y restaurantes.', 3, false, true, false, true, 1, '2020-05-01',
    '2023-08-01', '2023-12-31', false, 'Apartamento', JSON_OBJECT('foto1', 'foto23-1.jpg', 'foto2', 'foto23-2.jpg', 'foto3', 'foto23-3.jpg', 'foto4', 'foto23-4.jpg')
),
(
    'Valladolid, España', 'Centro', 3, '300', 4, 3, 2, true,
    'Piso moderno en el centro, cerca de la plaza mayor.', 4, true, false, true, false, 2, '2021-03-01',
    '2024-05-01', '2024-09-30', true, 'Ático', JSON_OBJECT('foto1', 'foto24-1.jpg', 'foto2', 'foto24-2.jpg', 'foto3', 'foto24-3.jpg', 'foto4', 'foto24-4.jpg')
),
(
    'León, España', 'Centro Histórico', 1, '225', 3, 2, 1, false,
    'Apartamento acogedor en el centro histórico, cerca de la catedral.', 3, false, false, false, true, 1, '2019-05-01',
    '2022-05-01', '2022-08-31', true, 'Estudio', JSON_OBJECT('foto1', 'foto25-1.jpg', 'foto2', 'foto25-2.jpg', 'foto3', 'foto25-3.jpg', 'foto4', 'foto25-4.jpg')
),
(
    'Gijón, España', 'Playa', 2, '325', 4, 3, 2, true,
    'Apartamento con vistas al mar, cerca de la playa de San Lorenzo.', 4, true, true, false, false, 2, '2021-04-01',
    '2024-09-01', '2024-12-31', true, 'Ático', JSON_OBJECT('foto1', 'foto26-1.jpg', 'foto2', 'foto26-2.jpg', 'foto3', 'foto26-3.jpg', 'foto4', 'foto26-4.jpg')
),
(
    'Logroño, España', 'Centro', 1, '250', 3, 2, 1, false,
    'Apartamento moderno en el centro, cerca de la calle Laurel.', 3, false, false, false, true, 1, '2019-12-01',
    '2022-12-01', '2023-03-31', true, 'Estudio', JSON_OBJECT('foto1', 'foto27-1.jpg', 'foto2', 'foto27-2.jpg', 'foto3', 'foto27-3.jpg', 'foto4', 'foto27-4.jpg')
),
(
    'Salamanca, España', 'Centro', 2, '275', 3, 2, 1, false,
    'Piso céntrico con vistas a la plaza mayor, cerca de la universidad.', 3, false, true, false, true, 1, '2020-07-01',
    '2023-09-01', '2023-12-31', false, 'Apartamento', JSON_OBJECT('foto1', 'foto28-1.jpg', 'foto2', 'foto28-2.jpg', 'foto3', 'foto28-3.jpg', 'foto4', 'foto28-4.jpg')
),
(
    'Burgos, España', 'Centro Histórico', 3, '300', 4, 3, 2, true,
    'Piso moderno en el centro histórico, cerca de la catedral.', 4, true, false, true, false, 2, '2021-03-01',
    '2024-05-01', '2024-09-30', true, 'Ático', JSON_OBJECT('foto1', 'foto29-1.jpg', 'foto2', 'foto29-2.jpg', 'foto3', 'foto29-3.jpg', 'foto4', 'foto29-4.jpg')
),
(
    'Vitoria, España', 'Centro', 2, '275', 3, 2, 1, false,
    'Apartamento céntrico, cerca del parque de la Florida.', 3, false, true, false, true, 1, '2020-05-01',
    '2023-08-01', '2023-12-31', false, 'Apartamento', JSON_OBJECT('foto1', 'foto30-1.jpg', 'foto2', 'foto30-2.jpg', 'foto3', 'foto30-3.jpg', 'foto4', 'foto30-4.jpg')
),
(
    'A Coruña, España', 'Orzán', 3, '325', 4, 3, 2, true,
    'Apartamento con vistas al mar, cerca de la playa del Orzán.', 4, true, true, false, false, 2, '2021-05-01',
    '2024-09-01', '2024-12-31', true, 'Ático', JSON_OBJECT('foto1', 'foto31-1.jpg', 'foto2', 'foto31-2.jpg', 'foto3', 'foto31-3.jpg', 'foto4', 'foto31-4.jpg')
),
(
    'Santiago de Compostela, España', 'Centro', 1, '250', 3, 2, 1, false,
    'Apartamento moderno en el centro, cerca de la catedral.', 3, false, false, false, true, 1, '2019-12-01',
    '2022-12-01', '2023-03-31', true, 'Estudio', JSON_OBJECT('foto1', 'foto32-1.jpg', 'foto2', 'foto32-2.jpg', 'foto3', 'foto32-3.jpg', 'foto4', 'foto32-4.jpg')
),
(
    'Toledo, España', 'Casco Histórico', 2, '275', 3, 2, 1, false,
    'Piso en el casco histórico, cerca de la catedral y del alcázar.', 3, false, true, false, true, 1, '2020-05-01',
    '2023-08-01', '2023-12-31', false, 'Apartamento', JSON_OBJECT('foto1', 'foto33-1.jpg', 'foto2', 'foto33-2.jpg', 'foto3', 'foto33-3.jpg', 'foto4', 'foto33-4.jpg')
),
(
    'Segovia, España', 'Centro Histórico', 3, '300', 4, 3, 2, true,
    'Piso moderno en el centro histórico, cerca del acueducto.', 4, true, false, true, false, 2, '2021-03-01',
    '2024-05-01', '2024-09-30', true, 'Ático', JSON_OBJECT('foto1', 'foto34-1.jpg', 'foto2', 'foto34-2.jpg', 'foto3', 'foto34-3.jpg', 'foto4', 'foto34-4.jpg')
),
(
    'Murcia, España', 'Centro', 2, '275', 3, 2, 1, false,
    'Apartamento céntrico, cerca de la catedral y del casino.', 3, false, true, false, true, 1, '2020-07-01',
    '2023-09-01', '2023-12-31', false, 'Apartamento', JSON_OBJECT('foto1', 'foto35-1.jpg', 'foto2', 'foto35-2.jpg', 'foto3', 'foto35-3.jpg', 'foto4', 'foto35-4.jpg')
),
(
    'Cáceres, España', 'Casco Viejo', 1, '225', 3, 2, 1, false,
    'Apartamento en el casco viejo, cerca de la plaza mayor.', 3, false, false, false, true, 1, '2019-05-01',
    '2022-05-01', '2022-08-31', true, 'Estudio', JSON_OBJECT('foto1', 'foto36-1.jpg', 'foto2', 'foto36-2.jpg', 'foto3', 'foto36-3.jpg', 'foto4', 'foto36-4.jpg'
	));

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
(1, 'Aceptada', '2023-01-15', 
JSON_OBJECT(
'ubicacion', 'Calle Almirante 123', 
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
'fotosVivienda', JSON_ARRAY('foto2-1.jpg', 'foto2-2.jpg', 'foto2-3.jpg', 'foto2-4.jpg'))),
(1, 'En espera', '2024-06-03',
JSON_OBJECT(
    'ubicacion', 'Avenida Sol 456',
    'vista', 'Montaña',
    'extension', '250',
    'habitaciones' ,3,
    'aseos' ,2,
    'aseos_habitacion', 1,
    'garaje', true,
    'descripcion', 'Casa espaciosa con vista a la montaña',
    'valoracion', 9,
    'golf', false,
    'spa', true,
    'jardin', true,
    'piscina', false,
    'plantas', 2,
    'fecha_construccion', '2010-07-15',
    'fecha_alta_vivienda', '2023-03-10',
    'fecha_cancelacion_vivienda', '2023-03-25',
    'existencia_subasta', true,
    'tipo_vivienda', 'Casa',
    'fotosVivienda', JSON_ARRAY('foto3-1.jpg','foto3-2.jpg', 'foto3-3.jpg', 'foto3-4.jpg'))),
    (3, 'En espera', '2024-06-10',
JSON_OBJECT(
    'ubicacion', 'Calle Mayor 26',
    'vista', 'Mar',
    'extension', '300',
    'habitaciones' ,6,
    'aseos' ,5,
    'aseos_habitacion', 2,
    'garaje', true,
    'descripcion','Ático de lujo vista al mar',
    'valoracion', 10,
    'golf', false,
    'spa', false,
    'jardin', false,
    'piscina', true,
    'plantas', 2,
    'fecha_construccion', '2018-07-15',
    'fecha_alta_vivienda', '2023-03-10',
    'fecha_cancelacion_vivienda', '2023-03-25',
    'existencia_subasta', true,
    'tipo_vivienda', 'Ático',
    'fotosVivienda', JSON_ARRAY('foto4-1.jpg','foto4-2.jpg', 'foto4-3.jpg', 'foto4-4.jpg'))),
    (3, 'En espera', '2024-06-05',
JSON_OBJECT(
    'ubicacion', 'Calle Iglesias 6',
    'vista', 'Montaña',
    'extension', '450',
    'habitaciones' ,10,
    'aseos' ,8,
    'aseos_habitacion', 5,
    'garaje', true,
    'descripcion', 'Casa con vistas a la montaña y espacioso jardín',
    'valoracion', 10,
    'golf', true,
    'spa', true,
    'jardin', true,
    'piscina', true,
    'plantas', 2,
    'fecha_construccion', '2000-07-15',
    'fecha_alta_vivienda', '2022-03-10',
    'fecha_cancelacion_vivienda', '2023-03-13',
    'existencia_subasta', false,
    'tipo_vivienda', 'Casa',
    'fotosVivienda', JSON_ARRAY('foto5-1.jpg','foto5-2.jpg', 'foto5-3.jpg', 'foto5-4.jpg'))),
    (3, 'En espera', '2024-05-31',
JSON_OBJECT(
    'ubicacion', 'Gran Vía 19',
    'vista', 'Ciudad',
    'extension', '250',
    'habitaciones' ,3,
    'aseos' ,2,
    'aseos_habitacion', 1,
    'garaje', true,
    'descripcion', 'Piso reformado en una de las mejores ubicaciones de Madrid',
    'valoracion', 9,
    'golf', false,
    'spa', false,
    'jardin', false,
    'piscina', true,
    'plantas', 1,
    'fecha_construccion', '1999-07-15',
    'fecha_alta_vivienda', '2023-03-10',
    'fecha_cancelacion_vivienda', '2023-03-15',
    'existencia_subasta', true,
    'tipo_vivienda', 'Piso',
    'fotosVivienda', JSON_ARRAY('foto6-1.jpg','foto6-2.jpg', 'foto6-3.jpg', 'foto6-4.jpg')));




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

INSERT INTO chats_prop values(1,6,1,'Buenos días, estoy interesado en la vivienda con vistas al mar, podría hacer un tour por la casa? Gracias.','2024-06-01',true),
(2,1,6,'Buenos días, en seguida se lo envío. Le comento que hace poco le hicimos una reforma y ha quedado maravillosa. Espero que le guste.','2024-06-12',false),
(3,5,12,'Holaa, sería posible que en el estudio puedan estar 3 personas? Nos gustaría viajar con nuestra hija pequeña','2024-06-12',true),
(4,12,5,'Buenos días, por cuestión de espacio no es recomendable, pero el sofá es sofá es cama y se podría hacer alguna excepción. Cuando tienen la fecha de entrada?','2024-06-12',false),
(5,8,12,'Buenos días, nos gustaría preguntar si cerca de la casa de playa que queremos alquilar hay alguna del estilo de la nuestra cerca porque nos gustaría hacer un viaje con más familia. ¿Podría pasarme información? Muchas gracias.','2024-06-12',false);

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

INSERT INTO opiniones values(1,6,4,34, 'Íncreible la experiencia en la vivienda. Muy recomendable.', '2024-06-12'),
(2,7,3,33, 'Esta casa es ideal para quienes buscan espacio y una conexión cercana con la historia. La ausencia de piscina podría ser un pequeño inconveniente para verano. Recomendable.', '2023-06-12'),
(3,8,5,34, 'Es una excelente opción para quienes buscan un espacio moderno con vistas verdes. me encantó vivir aquí un espacio de tiempo.', '2024-01-20'),
(4,9,3,35, 'Esperaba un estudio más grande, pero tiene una gran reforma y es precioso por dentro. Super recomendable para una bonita escapada.', '2024-03-12'),
(5,10,5,32, 'Los propietarios de esta casa disfrutarán de un ambiente relajante con vistas, ideal para desconectar del estrés diario. El jardín y el garaje son grandes ventajas, proporcionando espacio adicional y conveniencia.', '2024-06-12'),
(10,6,3,28, 'Los habitantes de este departamento apreciarán el diseño moderno y las vistas al parque. El jardín y la piscina son excelentes para actividades al aire libre y proporcionan un espacio adicional para el ocio. La falta de un garaje podría ser un inconveniente', '2023-05-18'),
(7,6,4,13, 'El propietario de esta villa disfrutará de una vida de lujo y comodidad. La vista al mar será un placer diario, mientras que las instalaciones de golf y spa ofrecerán opciones recreativas y de bienestar excepcionales. ', '2024-06-12'),
(8,6,5,4, 'Esta vivienda es ideal para una familia grande que valora el espacio y la tranquilidad. Es probable que los usuarios sean amantes de la naturaleza', '2023-09-12'),
(9,6,3,30, 'Los habitantes de este departamento disfrutarán de un entorno urbano vibrante con todas las comodidades modernas. La vista a la ciudad es un punto destacable, proporcionando una sensación de conexión con el entorno urbano', '2024-06-12'),
(6,6,4,23, 'Este departamento es ideal para profesionales jóvenes o parejas sin hijos que buscan un lugar cómodo y bien ubicado en la ciudad.', '2022-02-12');


create table favoritos
(
id_favorito int not null auto_increment,
id_usuario int not null,
id_vivienda int not null,
PRIMARY KEY ( id_favorito),
FOREIGN KEY (id_usuario) references usuarios (id_usuario),
FOREIGN KEY (id_vivienda) references viviendas (id_vivienda)
);

INSERT INTO favoritos values(1,6,24),(2,6,25),(3,6,23),
(4,7,24),(5,7,33),(6,7,22),
(7,8,12),(8,8,13),(9,8,14),
(10,9,20),(11,9,21),(12,9,26),
(13,10,34),(14,10,32),(15,10,16),
(16,3,11),(17,3,10),(18,3,3),
(19,4,19),(20,4,36),(21,4,2),
(22,5,18),(23,5,28),(24,5,8);

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
(2, 120, 60, 3, 'Confirmado', '2024-07-01', '2024-07-05', 3),
(3, 80, 40, 2, 'Cancelado', '2024-06-15', '2024-06-20', 4),
(4, 150, 75, 5, 'Confirmado', '2024-08-01', '2024-08-10', 5),
(5, 90, 45, 3, 'Reservado', '2024-06-25', '2024-07-01', 6),
(6, 90, 45, 4, 'Reservado', '2024-07-20', '2024-07-30', 7),
(30, 90, 45, 2, 'Reservado', '2024-08-10', '2024-08-21', 8),
(28, 90, 45, 1, 'Reservado', '2024-09-15', '2024-09-18', 10),
(13, 360, 100, 6, 'Reservado', '2024-06-25', '2024-07-01', 9),
(4, 200, 90, 7, 'Reservado', '2024-06-20', '2024-06-25', 4);


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

INSERT INTO subastas(id_vivienda,estado_subasta, precio_inicial, fecha_inicio, fecha_fin, id_usuario)
VALUES
(1,'EN PROCESO', 600000, '2024-06-01','2024-06-08', 2),
(6,'FINALIZADO', 3000000, '2024-02-10','2024-03-04', 2),
(9,'EN PROCESO', 2000000, '2024-05-30','2024-06-14', 2),
(10,'FINALIZADO', 890000, '2023-06-01','2023-06-08', 2),
(4,'EN PROCESO', 760000, '2024-06-03','2024-06-20', 2),
(5,'FINALIZADO', 1000000, '2022-06-01','2022-06-08', 2),
(7,'EN PROCESO', 400000, '2024-06-02','2024-06-22', 2),
(4,'FINALIZADO', 900500, '2024-01-01','2024-02-02', 2),
(2,'EN PROCESO', 570000, '2024-06-06','2024-06-09', 2),
(3,'FINALIZADO', 2000000, '2020-06-01','2020-06-08', 2),
(8,'EN PROCESO', 3000000, '2024-06-01','2024-06-08', 2);

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

INSERT INTO pujas values (1, 1, 3,'EN PROCESO', 30000),
(2, 6, 1,'FINALIZADA', 45000),
(3, 9, 4,'EN PROCESO', 400000),
(4, 4, 5,'EN PROCESO', 26000),
(5, 7, 6,'EN PROCESO', 50000),
(6, 2, 7,'EN PROCESO', 56000),
(7, 8, 8,'EN PROCESO', 300000),
(8, 3, 9,'FINALIZADA', 200000),
(9, 5, 10,'FINALIZADA', 80000),
(10, 10, 3,'FINALIZADA', 91000);


create user uviviendas identified by 'uviviendas';
grant all privileges on BBDD_TFG_BHJ.* to uviviendas;