package com.raze.admingol.controller;
import com.raze.admingol.catalog.DiasJuego;
import com.raze.admingol.catalog.TipoCobroTorneo;
import com.raze.admingol.domain.ConfiguracionTorneo;
import com.raze.admingol.service.domain.CanchaService;
import com.raze.admingol.service.domain.ConfiguracionTorneoService;
import com.raze.admingol.service.domain.TorneoService;
import com.raze.admingol.service.domain.UsuarioService;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

@RooWebJson(jsonObject = ConfiguracionTorneo.class)
@Controller
@RequestMapping("/configuraciontorneos")
@RooWebScaffold(path = "configuraciontorneos", formBackingObject = ConfiguracionTorneo.class)
public class ConfiguracionTorneoController {

	@Autowired
    TorneoService torneoService;

	@Autowired
    ConfiguracionTorneoService configuracionTorneoService;

	@Autowired
    CanchaService canchaService;

	@Autowired
    UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid ConfiguracionTorneo configuracionTorneo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, configuracionTorneo);
            return "configuraciontorneos/create";
        }
        uiModel.asMap().clear();
        configuracionTorneoService.saveConfiguracionTorneo(configuracionTorneo);
        return "redirect:/configuraciontorneos/" + encodeUrlPathSegment(configuracionTorneo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new ConfiguracionTorneo());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (torneoService.countAllTorneos() == 0) {
            dependencies.add(new String[] { "torneo", "torneos" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "configuraciontorneos/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("configuraciontorneo", configuracionTorneoService.findConfiguracionTorneo(id));
        uiModel.addAttribute("itemId", id);
        return "configuraciontorneos/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("configuraciontorneos", configuracionTorneoService.findConfiguracionTorneoEntries(firstResult, sizeNo));
            float nrOfPages = (float) configuracionTorneoService.countAllConfiguracionTorneos() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("configuraciontorneos", configuracionTorneoService.findAllConfiguracionTorneos());
        }
        addDateTimeFormatPatterns(uiModel);
        return "configuraciontorneos/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid ConfiguracionTorneo configuracionTorneo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, configuracionTorneo);
            return "configuraciontorneos/update";
        }
        uiModel.asMap().clear();
        configuracionTorneoService.updateConfiguracionTorneo(configuracionTorneo);
        return "redirect:/configuraciontorneos/" + encodeUrlPathSegment(configuracionTorneo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, configuracionTorneoService.findConfiguracionTorneo(id));
        return "configuraciontorneos/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ConfiguracionTorneo configuracionTorneo = configuracionTorneoService.findConfiguracionTorneo(id);
        configuracionTorneoService.deleteConfiguracionTorneo(configuracionTorneo);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/configuraciontorneos";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("configuracionTorneo_fechalimiteregistro_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("configuracionTorneo_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("configuracionTorneo_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, ConfiguracionTorneo configuracionTorneo) {
        uiModel.addAttribute("configuracionTorneo", configuracionTorneo);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("diasjuegoes", Arrays.asList(DiasJuego.values()));
        uiModel.addAttribute("tipocobrotorneos", Arrays.asList(TipoCobroTorneo.values()));
        uiModel.addAttribute("canchas", canchaService.findAllCanchas());
        uiModel.addAttribute("torneos", torneoService.findAllTorneos());
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public ResponseEntity<String> showJson(@PathVariable("id") Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json; charset=utf-8");
        try {
            ConfiguracionTorneo configuracionTorneo = configuracionTorneoService.findConfiguracionTorneo(id);
            if (configuracionTorneo == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(configuracionTorneo.toJson(), headers, HttpStatus.OK);
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
            List<ConfiguracionTorneo> result = configuracionTorneoService.findAllConfiguracionTorneos();
            return new ResponseEntity<String>(ConfiguracionTorneo.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            ConfiguracionTorneo configuracionTorneo = ConfiguracionTorneo.fromJsonToConfiguracionTorneo(json);
            configuracionTorneoService.saveConfiguracionTorneo(configuracionTorneo);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+configuracionTorneo.getId().toString()).build().toUriString());
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
            for (ConfiguracionTorneo configuracionTorneo: ConfiguracionTorneo.fromJsonArrayToConfiguracionTorneos(json)) {
                configuracionTorneoService.saveConfiguracionTorneo(configuracionTorneo);
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
            ConfiguracionTorneo configuracionTorneo = ConfiguracionTorneo.fromJsonToConfiguracionTorneo(json);
            configuracionTorneo.setId(id);
            if (configuracionTorneoService.updateConfiguracionTorneo(configuracionTorneo) == null) {
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
            ConfiguracionTorneo configuracionTorneo = configuracionTorneoService.findConfiguracionTorneo(id);
            if (configuracionTorneo == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            configuracionTorneoService.deleteConfiguracionTorneo(configuracionTorneo);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
