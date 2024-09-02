export interface Alquiler {
    idAlquiler:        number;
    estadoAlquiler:    string;
    fechaEntrada:      Date;
    fechaSalida:       Date;
    personas:          number;
    precioCancelacion: number;
    precioNoche:       number;
    vivienda:          Vivienda;
    usuario:           Usuario;
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

export interface Vivienda {
    idVivienda:               number;
    fechaConstruccion:        Date;
    aseosHabitacion:          number;
    aseos:                    number;
    descripcion:              string;
    existenciaSubasta:        number;
    extension:                string;
    fechaAltaVivienda:        Date;
    fechaCancelacionVivienda: Date;
    garaje:                   number;
    golf:                     number;
    habitaciones:             number;
    jardin:                   number;
    piscina:                  number;
    plantas:                  number;
    spa:                      number;
    tipoVivienda:             string;
    ubicacion:                string;
    valoracion:               number;
    vista:                    string;
    usuario:                  Usuario;
    fotosVivienda:            FotosVivienda;
}

export interface FotosVivienda {
    foto1: string;
    foto2: string;
    foto3: string;
    foto4: string;
}

