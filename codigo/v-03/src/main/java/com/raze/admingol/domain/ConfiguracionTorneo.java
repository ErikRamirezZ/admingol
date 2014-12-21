package com.raze.admingol.domain;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.DecimalMax;
import com.raze.admingol.catalog.TipoCobroTorneo;
import javax.persistence.Enumerated;
import com.raze.admingol.catalog.DiasJuego;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Version;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.json.RooJson;

@Entity
@RooJavaBean
@RooToString
@RooJpaEntity
@RooJson(deepSerialize = true)
public class ConfiguracionTorneo {

    /**
     */
    @NotNull
    @ManyToOne
    private Torneo torneo;

    /**
     */
    private Boolean inscripcion;

    /**
     */
    @DecimalMax("2")
    private double costoInscripcion;

    /**
     */
    private int numeroParcialidadesInscripcion;

    /**
     */
    @Enumerated
    private TipoCobroTorneo tipoCobroTorneo;

    /**
     */
    @DecimalMax("2")
    private double costo;

    /**
     */
    private int numeroParcialidadesTorneo;

    /**
     */
    private int numeroJugadoresXEquipo;

    /**
     */
    @ElementCollection
    private List<DiasJuego> diasJuego = new ArrayList<DiasJuego>();

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Cancha> canchasJuego = new ArrayList<Cancha>();

    /**
     */
    private int tiempoDuracionPartido;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaLimiteRegistro;

    /**
     */
    private double costoArbitroPrincipal;

    /**
     */
    private double costoArbitroAuxiliar;

    /**
     */
    private Boolean activo;

    /**
     */
    @ManyToOne
    private Usuario usuario;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaCreacion;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date fechaModificacion;

	public Torneo getTorneo() {
        return this.torneo;
    }

	public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

	public Boolean getInscripcion() {
        return this.inscripcion;
    }

	public void setInscripcion(Boolean inscripcion) {
        this.inscripcion = inscripcion;
    }

	public double getCostoInscripcion() {
        return this.costoInscripcion;
    }

	public void setCostoInscripcion(double costoInscripcion) {
        this.costoInscripcion = costoInscripcion;
    }

	public int getNumeroParcialidadesInscripcion() {
        return this.numeroParcialidadesInscripcion;
    }

	public void setNumeroParcialidadesInscripcion(int numeroParcialidadesInscripcion) {
        this.numeroParcialidadesInscripcion = numeroParcialidadesInscripcion;
    }

	public TipoCobroTorneo getTipoCobroTorneo() {
        return this.tipoCobroTorneo;
    }

	public void setTipoCobroTorneo(TipoCobroTorneo tipoCobroTorneo) {
        this.tipoCobroTorneo = tipoCobroTorneo;
    }

	public double getCosto() {
        return this.costo;
    }

	public void setCosto(double costo) {
        this.costo = costo;
    }

	public int getNumeroParcialidadesTorneo() {
        return this.numeroParcialidadesTorneo;
    }

	public void setNumeroParcialidadesTorneo(int numeroParcialidadesTorneo) {
        this.numeroParcialidadesTorneo = numeroParcialidadesTorneo;
    }

	public int getNumeroJugadoresXEquipo() {
        return this.numeroJugadoresXEquipo;
    }

	public void setNumeroJugadoresXEquipo(int numeroJugadoresXEquipo) {
        this.numeroJugadoresXEquipo = numeroJugadoresXEquipo;
    }

	public List<DiasJuego> getDiasJuego() {
        return this.diasJuego;
    }

	public void setDiasJuego(List<DiasJuego> diasJuego) {
        this.diasJuego = diasJuego;
    }

	public List<Cancha> getCanchasJuego() {
        return this.canchasJuego;
    }

	public void setCanchasJuego(List<Cancha> canchasJuego) {
        this.canchasJuego = canchasJuego;
    }

	public int getTiempoDuracionPartido() {
        return this.tiempoDuracionPartido;
    }

	public void setTiempoDuracionPartido(int tiempoDuracionPartido) {
        this.tiempoDuracionPartido = tiempoDuracionPartido;
    }

	public Date getFechaLimiteRegistro() {
        return this.fechaLimiteRegistro;
    }

	public void setFechaLimiteRegistro(Date fechaLimiteRegistro) {
        this.fechaLimiteRegistro = fechaLimiteRegistro;
    }

	public double getCostoArbitroPrincipal() {
        return this.costoArbitroPrincipal;
    }

	public void setCostoArbitroPrincipal(double costoArbitroPrincipal) {
        this.costoArbitroPrincipal = costoArbitroPrincipal;
    }

	public double getCostoArbitroAuxiliar() {
        return this.costoArbitroAuxiliar;
    }

	public void setCostoArbitroAuxiliar(double costoArbitroAuxiliar) {
        this.costoArbitroAuxiliar = costoArbitroAuxiliar;
    }

	public Boolean getActivo() {
        return this.activo;
    }

	public void setActivo(Boolean activo) {
        this.activo = activo;
    }

	public Usuario getUsuario() {
        return this.usuario;
    }

	public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	public Date getFechaCreacion() {
        return this.fechaCreacion;
    }

	public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

	public Date getFechaModificacion() {
        return this.fechaModificacion;
    }

	public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

	public String toJson() {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(this);
    }

	public String toJson(String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(this);
    }

	public static ConfiguracionTorneo fromJsonToConfiguracionTorneo(String json) {
        return new JSONDeserializer<ConfiguracionTorneo>()
        .use(null, ConfiguracionTorneo.class).deserialize(json);
    }

	public static String toJsonArray(Collection<ConfiguracionTorneo> collection) {
        return new JSONSerializer()
        .exclude("*.class").deepSerialize(collection);
    }

	public static String toJsonArray(Collection<ConfiguracionTorneo> collection, String[] fields) {
        return new JSONSerializer()
        .include(fields).exclude("*.class").deepSerialize(collection);
    }

	public static Collection<ConfiguracionTorneo> fromJsonArrayToConfiguracionTorneos(String json) {
        return new JSONDeserializer<List<ConfiguracionTorneo>>()
        .use("values", ConfiguracionTorneo.class).deserialize(json);
    }

	public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

	@Version
    @Column(name = "version")
    private Integer version;

	public Long getId() {
        return this.id;
    }

	public void setId(Long id) {
        this.id = id;
    }

	public Integer getVersion() {
        return this.version;
    }

	public void setVersion(Integer version) {
        this.version = version;
    }
}
