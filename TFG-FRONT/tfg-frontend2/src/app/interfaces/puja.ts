export interface Puja {
    idPuja:     number;
    estadoPuja: string;
    valorPuja:  number;
    subasta:    Subasta;
    usuario:    Usuario;
}

export interface Subasta {
    idSubasta:     number;
    estadoSubasta: string;
    fechaFin:      Date;
    fechaInicio:   Date;
    precioInicial: number;
    vivienda:      Vivienda;
    usuario:       Usuario;
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
    fechaConstruccion:        null;
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
