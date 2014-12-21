package com.raze.admingol.controller;
import com.raze.admingol.catalog.PerodoNotificacion;
import com.raze.admingol.catalog.ViaNotificacion;
import com.raze.admingol.domain.ConfiguracionNotificaciones;
import com.raze.admingol.service.domain.ConfiguracionNotificacionesService;
import com.raze.admingol.service.domain.UsuarioService;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = ConfiguracionNotificaciones.class)
@Controller
@RequestMapping("/configuracionnotificacioneses")
@RooWebScaffold(path = "configuracionnotificacioneses", formBackingObject = ConfiguracionNotificaciones.class)
public class ConfiguracionNotificacionesController {

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            ConfiguracionNotificaciones configuracionNotificaciones = configuracionNotificacionesService.findConfiguracionNotificaciones(id);
            if (configuracionNotificaciones == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(configuracionNotificaciones.toJson(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> listJson() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            List<ConfiguracionNotificaciones> result = configuracionNotificacionesService.findAllConfiguracionNotificacioneses();
            return new ResponseEntity<String>(ConfiguracionNotificaciones.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            ConfiguracionNotificaciones configuracionNotificaciones = ConfiguracionNotificaciones.fromJsonToConfiguracionNotificaciones(json);
            configuracionNotificacionesService.saveConfiguracionNotificaciones(configuracionNotificaciones);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+configuracionNotificaciones.getId().toString()).build().toUriString());
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJsonArray(@RequestBody String json) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            for (ConfiguracionNotificaciones configuracionNotificaciones: ConfiguracionNotificaciones.fromJsonArrayToConfiguracionNotificacioneses(json)) {
                configuracionNotificacionesService.saveConfiguracionNotificaciones(configuracionNotificaciones);
            }
            return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
    public ResponseEntity<String> updateFromJson(@RequestBody String json, @PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            ConfiguracionNotificaciones configuracionNotificaciones = ConfiguracionNotificaciones.fromJsonToConfiguracionNotificaciones(json);
            configuracionNotificaciones.setId(id);
            if (configuracionNotificacionesService.updateConfiguracionNotificaciones(configuracionNotificaciones) == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<String> deleteFromJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            ConfiguracionNotificaciones configuracionNotificaciones = configuracionNotificacionesService.findConfiguracionNotificaciones(id);
            if (configuracionNotificaciones == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            configuracionNotificacionesService.deleteConfiguracionNotificaciones(configuracionNotificaciones);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@Autowired
    ConfiguracionNotificacionesService configuracionNotificacionesService;

	@Autowired
    UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid ConfiguracionNotificaciones configuracionNotificaciones, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, configuracionNotificaciones);
            return "configuracionnotificacioneses/create";
        }
        uiModel.asMap().clear();
        configuracionNotificacionesService.saveConfiguracionNotificaciones(configuracionNotificaciones);
        return "redirect:/configuracionnotificacioneses/" + encodeUrlPathSegment(configuracionNotificaciones.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new ConfiguracionNotificaciones());
        return "configuracionnotificacioneses/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("configuracionnotificaciones", configuracionNotificacionesService.findConfiguracionNotificaciones(id));
        uiModel.addAttribute("itemId", id);
        return "configuracionnotificacioneses/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("configuracionnotificacioneses", configuracionNotificacionesService.findConfiguracionNotificacionesEntries(firstResult, sizeNo));
            float nrOfPages = (float) configuracionNotificacionesService.countAllConfiguracionNotificacioneses() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("configuracionnotificacioneses", configuracionNotificacionesService.findAllConfiguracionNotificacioneses());
        }
        addDateTimeFormatPatterns(uiModel);
        return "configuracionnotificacioneses/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid ConfiguracionNotificaciones configuracionNotificaciones, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, configuracionNotificaciones);
            return "configuracionnotificacioneses/update";
        }
        uiModel.asMap().clear();
        configuracionNotificacionesService.updateConfiguracionNotificaciones(configuracionNotificaciones);
        return "redirect:/configuracionnotificacioneses/" + encodeUrlPathSegment(configuracionNotificaciones.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, configuracionNotificacionesService.findConfiguracionNotificaciones(id));
        return "configuracionnotificacioneses/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ConfiguracionNotificaciones configuracionNotificaciones = configuracionNotificacionesService.findConfiguracionNotificaciones(id);
        configuracionNotificacionesService.deleteConfiguracionNotificaciones(configuracionNotificaciones);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/configuracionnotificacioneses";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("configuracionNotificaciones_fecha_hora_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("configuracionNotificaciones_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("configuracionNotificaciones_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, ConfiguracionNotificaciones configuracionNotificaciones) {
        uiModel.addAttribute("configuracionNotificaciones", configuracionNotificaciones);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("perodonotificacions", Arrays.asList(PerodoNotificacion.values()));
        uiModel.addAttribute("vianotificacions", Arrays.asList(ViaNotificacion.values()));
        uiModel.addAttribute("usuarios", usuarioService.findAllUsuarios());
    }

	String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}
