package viviendas.modelo.entities;

import java.util.List; 
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class DatosVivienda {



    @JsonProperty("fecha_construccion")
    private String fechaConstruccion;

    @JsonProperty("aseos_habitacion")
    private int aseosHabitacion;

    @JsonProperty("aseos")
    private int aseos;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("existencia_subasta")
    private boolean existenciaSubasta;

    @JsonProperty("extension")
    private String extension;

    @JsonProperty("fecha_alta_vivienda")
    private String fechaAltaVivienda;

    @JsonProperty("fecha_cancelacion_vivienda")
    private String fechaCancelacionVivienda;

    @JsonProperty("garaje")
    private boolean garaje;

    @JsonProperty("golf")
    private boolean golf;

    @JsonProperty("habitaciones")
    private int habitaciones;

    @JsonProperty("jardin")
    private boolean jardin;

    @JsonProperty("piscina")
    private boolean piscina;

    @JsonProperty("plantas")
    private int plantas;

    @JsonProperty("spa")
    private boolean spa;

    @JsonProperty("tipo_vivienda")
    private String tipoVivienda;

    @JsonProperty("ubicacion")
    private String ubicacion;

    @JsonProperty("valoracion")
    private int valoracion;

    @JsonProperty("vista")
    private String vista;
    
    @JsonProperty("fotosVivienda")
    private List<String> fotosVivienda;

     
}

 

