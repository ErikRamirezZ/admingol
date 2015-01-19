package com.raze.admingol.controller;

import com.raze.admingol.domain.Abono;
import com.raze.admingol.domain.Alineacion;
import com.raze.admingol.domain.Cancha;
import com.raze.admingol.domain.Cargo;
import com.raze.admingol.domain.CedulaPartido;
import com.raze.admingol.domain.ConfiguracionNotificaciones;
import com.raze.admingol.domain.ConfiguracionTorneo;
import com.raze.admingol.domain.ControlPagoServicio;
import com.raze.admingol.domain.Empresa;
import com.raze.admingol.domain.Equipo;
import com.raze.admingol.domain.Estadisticas;
import com.raze.admingol.domain.Horario;
import com.raze.admingol.domain.Jugador;
import com.raze.admingol.domain.PagoHechoServicio;
import com.raze.admingol.domain.Partido;
import com.raze.admingol.domain.Rol;
import com.raze.admingol.domain.Sucursal;
import com.raze.admingol.domain.Torneo;
import com.raze.admingol.domain.Usuario;
import com.raze.admingol.service.domain.AbonoService;
import com.raze.admingol.service.domain.AlineacionService;
import com.raze.admingol.service.domain.CanchaService;
import com.raze.admingol.service.domain.CargoService;
import com.raze.admingol.service.domain.CedulaPartidoService;
import com.raze.admingol.service.domain.ConfiguracionNotificacionesService;
import com.raze.admingol.service.domain.ConfiguracionTorneoService;
import com.raze.admingol.service.domain.ControlPagoServicioService;
import com.raze.admingol.service.domain.EmpresaService;
import com.raze.admingol.service.domain.EquipoService;
import com.raze.admingol.service.domain.EstadisticasService;
import com.raze.admingol.service.domain.HorarioService;
import com.raze.admingol.service.domain.JugadorService;
import com.raze.admingol.service.domain.PagoHechoServicioService;
import com.raze.admingol.service.domain.PartidoService;
import com.raze.admingol.service.domain.RolService;
import com.raze.admingol.service.domain.SucursalService;
import com.raze.admingol.service.domain.TorneoService;
import com.raze.admingol.service.domain.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

@Configurable
/**
 * A central place to register application converters and formatters. 
 */
public class ApplicationConversionServiceFactoryBean extends FormattingConversionServiceFactoryBean {

	@Override
	protected void installFormatters(FormatterRegistry registry) {
		super.installFormatters(registry);
		// Register application converters and formatters
	}

	@Autowired
    AbonoService abonoService;

	@Autowired
    AlineacionService alineacionService;

	@Autowired
    CanchaService canchaService;

	@Autowired
    CargoService cargoService;

	@Autowired
    CedulaPartidoService cedulaPartidoService;

	@Autowired
    ConfiguracionNotificacionesService configuracionNotificacionesService;

	@Autowired
    ConfiguracionTorneoService configuracionTorneoService;

	@Autowired
    ControlPagoServicioService controlPagoServicioService;

	@Autowired
    EmpresaService empresaService;

	@Autowired
    EquipoService equipoService;

	@Autowired
    EstadisticasService estadisticasService;

	@Autowired
    HorarioService horarioService;

	@Autowired
    JugadorService jugadorService;

	@Autowired
    PagoHechoServicioService pagoHechoServicioService;

	@Autowired
    PartidoService partidoService;

	@Autowired
    RolService rolService;

	@Autowired
    SucursalService sucursalService;

	@Autowired
    TorneoService torneoService;

	@Autowired
    UsuarioService usuarioService;

	public Converter<Abono, String> getAbonoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Abono, java.lang.String>() {
            public String convert(Abono abono) {
                return new StringBuilder().append(abono.getObservaciones()).append(' ').append(abono.getFechaCreacion()).append(' ').append(abono.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Abono> getIdToAbonoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Abono>() {
            public com.raze.admingol.domain.Abono convert(java.lang.Long id) {
                return abonoService.findAbono(id);
            }
        };
    }

	public Converter<String, Abono> getStringToAbonoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Abono>() {
            public com.raze.admingol.domain.Abono convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Abono.class);
            }
        };
    }

	public Converter<Alineacion, String> getAlineacionToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Alineacion, java.lang.String>() {
            public String convert(Alineacion alineacion) {
                return new StringBuilder().append(alineacion.getFechaCreacion()).append(' ').append(alineacion.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Alineacion> getIdToAlineacionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Alineacion>() {
            public com.raze.admingol.domain.Alineacion convert(java.lang.Long id) {
                return alineacionService.findAlineacion(id);
            }
        };
    }

	public Converter<String, Alineacion> getStringToAlineacionConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Alineacion>() {
            public com.raze.admingol.domain.Alineacion convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Alineacion.class);
            }
        };
    }

	public Converter<Cancha, String> getCanchaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Cancha, java.lang.String>() {
            public String convert(Cancha cancha) {
                return new StringBuilder().append(cancha.getNombre()).append(' ').append(cancha.getDescripcion()).append(' ').append(cancha.getFechaCreacion()).append(' ').append(cancha.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Cancha> getIdToCanchaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Cancha>() {
            public com.raze.admingol.domain.Cancha convert(java.lang.Long id) {
                return canchaService.findCancha(id);
            }
        };
    }

	public Converter<String, Cancha> getStringToCanchaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Cancha>() {
            public com.raze.admingol.domain.Cancha convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Cancha.class);
            }
        };
    }

	public Converter<Cargo, String> getCargoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Cargo, java.lang.String>() {
            public String convert(Cargo cargo) {
                return new StringBuilder().append(cargo.getMonto()).append(' ').append(cargo.getObservaciones()).append(' ').append(cargo.getFechaCreacion()).append(' ').append(cargo.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Cargo> getIdToCargoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Cargo>() {
            public com.raze.admingol.domain.Cargo convert(java.lang.Long id) {
                return cargoService.findCargo(id);
            }
        };
    }

	public Converter<String, Cargo> getStringToCargoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Cargo>() {
            public com.raze.admingol.domain.Cargo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Cargo.class);
            }
        };
    }

	public Converter<CedulaPartido, String> getCedulaPartidoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.CedulaPartido, java.lang.String>() {
            public String convert(CedulaPartido cedulaPartido) {
                return new StringBuilder().append(cedulaPartido.getHoraInicioReal()).append(' ').append(cedulaPartido.getMarcadorEquipoLocal()).append(' ').append(cedulaPartido.getMarcadorEquipoVisitante()).append(' ').append(cedulaPartido.getObservaciones()).toString();
            }
        };
    }

	public Converter<Long, CedulaPartido> getIdToCedulaPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.CedulaPartido>() {
            public com.raze.admingol.domain.CedulaPartido convert(java.lang.Long id) {
                return cedulaPartidoService.findCedulaPartido(id);
            }
        };
    }

	public Converter<String, CedulaPartido> getStringToCedulaPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.CedulaPartido>() {
            public com.raze.admingol.domain.CedulaPartido convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), CedulaPartido.class);
            }
        };
    }

	public Converter<ConfiguracionNotificaciones, String> getConfiguracionNotificacionesToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.ConfiguracionNotificaciones, java.lang.String>() {
            public String convert(ConfiguracionNotificaciones configuracionNotificaciones) {
                return new StringBuilder().append(configuracionNotificaciones.getMensaje()).append(' ').append(configuracionNotificaciones.getFecha_hora()).append(' ').append(configuracionNotificaciones.getFechaCreacion()).append(' ').append(configuracionNotificaciones.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, ConfiguracionNotificaciones> getIdToConfiguracionNotificacionesConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.ConfiguracionNotificaciones>() {
            public com.raze.admingol.domain.ConfiguracionNotificaciones convert(java.lang.Long id) {
                return configuracionNotificacionesService.findConfiguracionNotificaciones(id);
            }
        };
    }

	public Converter<String, ConfiguracionNotificaciones> getStringToConfiguracionNotificacionesConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.ConfiguracionNotificaciones>() {
            public com.raze.admingol.domain.ConfiguracionNotificaciones convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ConfiguracionNotificaciones.class);
            }
        };
    }

	public Converter<ConfiguracionTorneo, String> getConfiguracionTorneoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.ConfiguracionTorneo, java.lang.String>() {
            public String convert(ConfiguracionTorneo configuracionTorneo) {
                return new StringBuilder().append(configuracionTorneo.getCostoInscripcion()).append(' ').append(configuracionTorneo.getNumeroParcialidadesInscripcion()).append(' ').append(configuracionTorneo.getCosto()).append(' ').append(configuracionTorneo.getNumeroParcialidadesTorneo()).toString();
            }
        };
    }

	public Converter<Long, ConfiguracionTorneo> getIdToConfiguracionTorneoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.ConfiguracionTorneo>() {
            public com.raze.admingol.domain.ConfiguracionTorneo convert(java.lang.Long id) {
                return configuracionTorneoService.findConfiguracionTorneo(id);
            }
        };
    }

	public Converter<String, ConfiguracionTorneo> getStringToConfiguracionTorneoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.ConfiguracionTorneo>() {
            public com.raze.admingol.domain.ConfiguracionTorneo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ConfiguracionTorneo.class);
            }
        };
    }

	public Converter<ControlPagoServicio, String> getControlPagoServicioToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.ControlPagoServicio, java.lang.String>() {
            public String convert(ControlPagoServicio controlPagoServicio) {
                return new StringBuilder().append(controlPagoServicio.getTarfa()).append(' ').append(controlPagoServicio.getCuenta()).append(' ').append(controlPagoServicio.getNoReferencia()).append(' ').append(controlPagoServicio.getNoTC()).toString();
            }
        };
    }

	public Converter<Long, ControlPagoServicio> getIdToControlPagoServicioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.ControlPagoServicio>() {
            public com.raze.admingol.domain.ControlPagoServicio convert(java.lang.Long id) {
                return controlPagoServicioService.findControlPagoServicio(id);
            }
        };
    }

	public Converter<String, ControlPagoServicio> getStringToControlPagoServicioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.ControlPagoServicio>() {
            public com.raze.admingol.domain.ControlPagoServicio convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), ControlPagoServicio.class);
            }
        };
    }

	public Converter<Empresa, String> getEmpresaToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Empresa, java.lang.String>() {
            public String convert(Empresa empresa) {
                return new StringBuilder().append(empresa.getNombre()).append(' ').append(empresa.getNombreComercial()).append(' ').append(empresa.getDomicilio()).append(' ').append(empresa.getTelefono()).toString();
            }
        };
    }

	public Converter<Long, Empresa> getIdToEmpresaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Empresa>() {
            public com.raze.admingol.domain.Empresa convert(java.lang.Long id) {
                return empresaService.findEmpresa(id);
            }
        };
    }

	public Converter<String, Empresa> getStringToEmpresaConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Empresa>() {
            public com.raze.admingol.domain.Empresa convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Empresa.class);
            }
        };
    }

	public Converter<Equipo, String> getEquipoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Equipo, java.lang.String>() {
            public String convert(Equipo equipo) {
                return new StringBuilder().append(equipo.getNombre()).append(' ').append(equipo.getNombreCorto()).append(' ').append(equipo.getFechaCreacion()).append(' ').append(equipo.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Equipo> getIdToEquipoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Equipo>() {
            public com.raze.admingol.domain.Equipo convert(java.lang.Long id) {
                return equipoService.findEquipo(id);
            }
        };
    }

	public Converter<String, Equipo> getStringToEquipoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Equipo>() {
            public com.raze.admingol.domain.Equipo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Equipo.class);
            }
        };
    }

	public Converter<Estadisticas, String> getEstadisticasToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Estadisticas, java.lang.String>() {
            public String convert(Estadisticas estadisticas) {
                return new StringBuilder().append(estadisticas.getMinuto()).append(' ').append(estadisticas.getObservaciones()).append(' ').append(estadisticas.getFechaCreacion()).append(' ').append(estadisticas.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Estadisticas> getIdToEstadisticasConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Estadisticas>() {
            public com.raze.admingol.domain.Estadisticas convert(java.lang.Long id) {
                return estadisticasService.findEstadisticas(id);
            }
        };
    }

	public Converter<String, Estadisticas> getStringToEstadisticasConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Estadisticas>() {
            public com.raze.admingol.domain.Estadisticas convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Estadisticas.class);
            }
        };
    }

	public Converter<Horario, String> getHorarioToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Horario, java.lang.String>() {
            public String convert(Horario horario) {
                return new StringBuilder().append(horario.getHoraInicio()).append(' ').append(horario.getDuracion()).append(' ').append(horario.getFechaCreacion()).append(' ').append(horario.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Horario> getIdToHorarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Horario>() {
            public com.raze.admingol.domain.Horario convert(java.lang.Long id) {
                return horarioService.findHorario(id);
            }
        };
    }

	public Converter<String, Horario> getStringToHorarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Horario>() {
            public com.raze.admingol.domain.Horario convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Horario.class);
            }
        };
    }

	public Converter<Jugador, String> getJugadorToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Jugador, java.lang.String>() {
            public String convert(Jugador jugador) {
                return new StringBuilder().append(jugador.getNombre()).append(' ').append(jugador.getApellidoPaterno()).append(' ').append(jugador.getApellidoMaterno()).append(' ').append(jugador.getFechaNacimiento()).toString();
            }
        };
    }

	public Converter<Long, Jugador> getIdToJugadorConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Jugador>() {
            public com.raze.admingol.domain.Jugador convert(java.lang.Long id) {
                return jugadorService.findJugador(id);
            }
        };
    }

	public Converter<String, Jugador> getStringToJugadorConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Jugador>() {
            public com.raze.admingol.domain.Jugador convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Jugador.class);
            }
        };
    }

	public Converter<PagoHechoServicio, String> getPagoHechoServicioToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.PagoHechoServicio, java.lang.String>() {
            public String convert(PagoHechoServicio pagoHechoServicio) {
                return new StringBuilder().append(pagoHechoServicio.getMonto()).append(' ').append(pagoHechoServicio.getDescuento()).append(' ').append(pagoHechoServicio.getFechaPago()).append(' ').append(pagoHechoServicio.getFechaVencimiento()).toString();
            }
        };
    }

	public Converter<Long, PagoHechoServicio> getIdToPagoHechoServicioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.PagoHechoServicio>() {
            public com.raze.admingol.domain.PagoHechoServicio convert(java.lang.Long id) {
                return pagoHechoServicioService.findPagoHechoServicio(id);
            }
        };
    }

	public Converter<String, PagoHechoServicio> getStringToPagoHechoServicioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.PagoHechoServicio>() {
            public com.raze.admingol.domain.PagoHechoServicio convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), PagoHechoServicio.class);
            }
        };
    }

	public Converter<Partido, String> getPartidoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Partido, java.lang.String>() {
            public String convert(Partido partido) {
                return new StringBuilder().append(partido.getFechaJuego()).append(' ').append(partido.getFechaCreacion()).append(' ').append(partido.getFechaModificacion()).toString();
            }
        };
    }

	public Converter<Long, Partido> getIdToPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Partido>() {
            public com.raze.admingol.domain.Partido convert(java.lang.Long id) {
                return partidoService.findPartido(id);
            }
        };
    }

	public Converter<String, Partido> getStringToPartidoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Partido>() {
            public com.raze.admingol.domain.Partido convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Partido.class);
            }
        };
    }

	public Converter<Rol, String> getRolToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Rol, java.lang.String>() {
            public String convert(Rol rol) {
                return "(no displayable fields)";
            }
        };
    }

	public Converter<Long, Rol> getIdToRolConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Rol>() {
            public com.raze.admingol.domain.Rol convert(java.lang.Long id) {
                return rolService.findRol(id);
            }
        };
    }

	public Converter<String, Rol> getStringToRolConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Rol>() {
            public com.raze.admingol.domain.Rol convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Rol.class);
            }
        };
    }

	public Converter<Sucursal, String> getSucursalToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Sucursal, java.lang.String>() {
            public String convert(Sucursal sucursal) {
                return new StringBuilder().append(sucursal.getNombre()).append(' ').append(sucursal.getDomicilio()).append(' ').append(sucursal.getTelefono()).append(' ').append(sucursal.getCorreoE()).toString();
            }
        };
    }

	public Converter<Long, Sucursal> getIdToSucursalConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Sucursal>() {
            public com.raze.admingol.domain.Sucursal convert(java.lang.Long id) {
                return sucursalService.findSucursal(id);
            }
        };
    }

	public Converter<String, Sucursal> getStringToSucursalConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Sucursal>() {
            public com.raze.admingol.domain.Sucursal convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Sucursal.class);
            }
        };
    }

	public Converter<Torneo, String> getTorneoToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Torneo, java.lang.String>() {
            public String convert(Torneo torneo) {
                return new StringBuilder().append(torneo.getNombre()).append(' ').append(torneo.getDescripcion()).append(' ').append(torneo.getFechaInicio()).append(' ').append(torneo.getFechaFin()).toString();
            }
        };
    }

	public Converter<Long, Torneo> getIdToTorneoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Torneo>() {
            public com.raze.admingol.domain.Torneo convert(java.lang.Long id) {
                return torneoService.findTorneo(id);
            }
        };
    }

	public Converter<String, Torneo> getStringToTorneoConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Torneo>() {
            public com.raze.admingol.domain.Torneo convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Torneo.class);
            }
        };
    }

	public Converter<Usuario, String> getUsuarioToStringConverter() {
        return new org.springframework.core.convert.converter.Converter<com.raze.admingol.domain.Usuario, java.lang.String>() {
            public String convert(Usuario usuario) {
                return new StringBuilder().append(usuario.getNombre()).append(' ').append(usuario.getApellidoPaterno()).append(' ').append(usuario.getApellidoMaterno()).append(' ').append(usuario.getFechaNacimiento()).toString();
            }
        };
    }

	public Converter<Long, Usuario> getIdToUsuarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.Long, com.raze.admingol.domain.Usuario>() {
            public com.raze.admingol.domain.Usuario convert(java.lang.Long id) {
                return usuarioService.findUsuario(id);
            }
        };
    }

	public Converter<String, Usuario> getStringToUsuarioConverter() {
        return new org.springframework.core.convert.converter.Converter<java.lang.String, com.raze.admingol.domain.Usuario>() {
            public com.raze.admingol.domain.Usuario convert(String id) {
                return getObject().convert(getObject().convert(id, Long.class), Usuario.class);
            }
        };
    }

	public void installLabelConverters(FormatterRegistry registry) {
        registry.addConverter(getAbonoToStringConverter());
        registry.addConverter(getIdToAbonoConverter());
        registry.addConverter(getStringToAbonoConverter());
        registry.addConverter(getAlineacionToStringConverter());
        registry.addConverter(getIdToAlineacionConverter());
        registry.addConverter(getStringToAlineacionConverter());
        registry.addConverter(getCanchaToStringConverter());
        registry.addConverter(getIdToCanchaConverter());
        registry.addConverter(getStringToCanchaConverter());
        registry.addConverter(getCargoToStringConverter());
        registry.addConverter(getIdToCargoConverter());
        registry.addConverter(getStringToCargoConverter());
        registry.addConverter(getCedulaPartidoToStringConverter());
        registry.addConverter(getIdToCedulaPartidoConverter());
        registry.addConverter(getStringToCedulaPartidoConverter());
        registry.addConverter(getConfiguracionNotificacionesToStringConverter());
        registry.addConverter(getIdToConfiguracionNotificacionesConverter());
        registry.addConverter(getStringToConfiguracionNotificacionesConverter());
        registry.addConverter(getConfiguracionTorneoToStringConverter());
        registry.addConverter(getIdToConfiguracionTorneoConverter());
        registry.addConverter(getStringToConfiguracionTorneoConverter());
        registry.addConverter(getControlPagoServicioToStringConverter());
        registry.addConverter(getIdToControlPagoServicioConverter());
        registry.addConverter(getStringToControlPagoServicioConverter());
        registry.addConverter(getEmpresaToStringConverter());
        registry.addConverter(getIdToEmpresaConverter());
        registry.addConverter(getStringToEmpresaConverter());
        registry.addConverter(getEquipoToStringConverter());
        registry.addConverter(getIdToEquipoConverter());
        registry.addConverter(getStringToEquipoConverter());
        registry.addConverter(getEstadisticasToStringConverter());
        registry.addConverter(getIdToEstadisticasConverter());
        registry.addConverter(getStringToEstadisticasConverter());
        registry.addConverter(getHorarioToStringConverter());
        registry.addConverter(getIdToHorarioConverter());
        registry.addConverter(getStringToHorarioConverter());
        registry.addConverter(getJugadorToStringConverter());
        registry.addConverter(getIdToJugadorConverter());
        registry.addConverter(getStringToJugadorConverter());
        registry.addConverter(getPagoHechoServicioToStringConverter());
        registry.addConverter(getIdToPagoHechoServicioConverter());
        registry.addConverter(getStringToPagoHechoServicioConverter());
        registry.addConverter(getPartidoToStringConverter());
        registry.addConverter(getIdToPartidoConverter());
        registry.addConverter(getStringToPartidoConverter());
        registry.addConverter(getRolToStringConverter());
        registry.addConverter(getIdToRolConverter());
        registry.addConverter(getStringToRolConverter());
        registry.addConverter(getSucursalToStringConverter());
        registry.addConverter(getIdToSucursalConverter());
        registry.addConverter(getStringToSucursalConverter());
        registry.addConverter(getTorneoToStringConverter());
        registry.addConverter(getIdToTorneoConverter());
        registry.addConverter(getStringToTorneoConverter());
        registry.addConverter(getUsuarioToStringConverter());
        registry.addConverter(getIdToUsuarioConverter());
        registry.addConverter(getStringToUsuarioConverter());
    }

	public void afterPropertiesSet() {
        super.afterPropertiesSet();
        installLabelConverters(getObject());
    }
}
