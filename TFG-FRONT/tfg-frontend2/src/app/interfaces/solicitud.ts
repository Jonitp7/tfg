export interface Solicitud {
    idSolicitud:     number;
    estadoSolicitud: string;
    fecha:           Date;
    datosVivienda:   DatosVivienda;
    usuario:         Usuario;
}

export interface DatosVivienda {
    id_vivienda:                number;
    fecha_construccion:         Date;
    aseos_habitacion:           number;
    aseos:                      number;
    descripcion:                string;
    existencia_subasta:         number;
    extension:                  string;
    fecha_alta_vivienda:        Date;
    fecha_cancelacion_vivienda: Date;
    garaje:                     number;
    golf:                       number;
    habitaciones:               number;
    jardin:                     number;
    piscina:                    number;
    plantas:                    number;
    spa:                        number;
    tipo_vivienda:              string;
    ubicacion:                  string;
    valoracion:                 number;
    vista:                      string;
    fotosVivienda:            string[];
}

export interface FotosVivienda {
    foto1: string;
    foto2: string;
    foto3: string;
    foto4: string;
}

export interface Usuario {
    idUsuario:       number;
    apellidos:       string;
    dni:             string;
    email:           string;
    fechaAlta:       Date;
    fechaNacimiento: Date;
    nombre:          string;
    numeroTelefono:  string;
    password:        string;
    tipoUsuario:     string;
    username:        string;
}
