package com.raze.admingol.controller;
import com.raze.admingol.catalog.FechaVencimientoTC;
import com.raze.admingol.catalog.TipoTarjeta;
import com.raze.admingol.domain.ControlPagoServicio;
import com.raze.admingol.service.domain.ControlPagoServicioService;
import com.raze.admingol.service.domain.EmpresaService;
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

@RooWebJson(jsonObject = ControlPagoServicio.class)
@Controller
@RequestMapping("/controlpagoservicios")
@RooWebScaffold(path = "controlpagoservicios", formBackingObject = ControlPagoServicio.class)
public class ControlPagoServicioController {

	@Autowired
    EmpresaService empresaService;

	@Autowired
    ControlPagoServicioService controlPagoServicioService;

	@Autowired
    UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid ControlPagoServicio controlPagoServicio, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, controlPagoServicio);
            return "controlpagoservicios/create";
        }
        uiModel.asMap().clear();
        controlPagoServicioService.saveControlPagoServicio(controlPagoServicio);
        return "redirect:/controlpagoservicios/" + encodeUrlPathSegment(controlPagoServicio.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new ControlPagoServicio());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (empresaService.countAllEmpresas() == 0) {
            dependencies.add(new String[] { "empresa", "empresas" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "controlpagoservicios/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("controlpagoservicio", controlPagoServicioService.findControlPagoServicio(id));
        uiModel.addAttribute("itemId", id);
        return "controlpagoservicios/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("controlpagoservicios", controlPagoServicioService.findControlPagoServicioEntries(firstResult, sizeNo));
            float nrOfPages = (float) controlPagoServicioService.countAllControlPagoServicios() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("controlpagoservicios", controlPagoServicioService.findAllControlPagoServicios());
        }
        addDateTimeFormatPatterns(uiModel);
        return "controlpagoservicios/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid ControlPagoServicio controlPagoServicio, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, controlPagoServicio);
            return "controlpagoservicios/update";
        }
        uiModel.asMap().clear();
        controlPagoServicioService.updateControlPagoServicio(controlPagoServicio);
        return "redirect:/controlpagoservicios/" + encodeUrlPathSegment(controlPagoServicio.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, controlPagoServicioService.findControlPagoServicio(id));
        return "controlpagoservicios/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        ControlPagoServicio controlPagoServicio = controlPagoServicioService.findControlPagoServicio(id);
        controlPagoServicioService.deleteControlPagoServicio(controlPagoServicio);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/controlpagoservicios";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("controlPagoServicio_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("controlPagoServicio_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, ControlPagoServicio controlPagoServicio) {
        uiModel.addAttribute("controlPagoServicio", controlPagoServicio);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("fechavencimientotcs", Arrays.asList(FechaVencimientoTC.values()));
        uiModel.addAttribute("tipotarjetas", Arrays.asList(TipoTarjeta.values()));
        uiModel.addAttribute("empresas", empresaService.findAllEmpresas());
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
            ControlPagoServicio controlPagoServicio = controlPagoServicioService.findControlPagoServicio(id);
            if (controlPagoServicio == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(controlPagoServicio.toJson(), headers, HttpStatus.OK);
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
            List<ControlPagoServicio> result = controlPagoServicioService.findAllControlPagoServicios();
            return new ResponseEntity<String>(ControlPagoServicio.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            ControlPagoServicio controlPagoServicio = ControlPagoServicio.fromJsonToControlPagoServicio(json);
            controlPagoServicioService.saveControlPagoServicio(controlPagoServicio);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+controlPagoServicio.getId().toString()).build().toUriString());
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
            for (ControlPagoServicio controlPagoServicio: ControlPagoServicio.fromJsonArrayToControlPagoServicios(json)) {
                controlPagoServicioService.saveControlPagoServicio(controlPagoServicio);
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
            ControlPagoServicio controlPagoServicio = ControlPagoServicio.fromJsonToControlPagoServicio(json);
            controlPagoServicio.setId(id);
            if (controlPagoServicioService.updateControlPagoServicio(controlPagoServicio) == null) {
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
            ControlPagoServicio controlPagoServicio = controlPagoServicioService.findControlPagoServicio(id);
            if (controlPagoServicio == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            controlPagoServicioService.deleteControlPagoServicio(controlPagoServicio);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
