package com.raze.admingol.controller;
import com.raze.admingol.catalog.ConceptoCobro;
import com.raze.admingol.catalog.StatusCargoAbono;
import com.raze.admingol.domain.Cargo;
import com.raze.admingol.service.domain.AbonoService;
import com.raze.admingol.service.domain.CargoService;
import com.raze.admingol.service.domain.EquipoService;
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

@RooWebJson(jsonObject = Cargo.class)
@Controller
@RequestMapping("/cargoes")
@RooWebScaffold(path = "cargoes", formBackingObject = Cargo.class)
public class CargoController {

	@Autowired
    TorneoService torneoService;

	@Autowired
    EquipoService equipoService;

	@Autowired
    CargoService cargoService;

	@Autowired
    AbonoService abonoService;

	@Autowired
    UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid Cargo cargo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, cargo);
            return "cargoes/create";
        }
        uiModel.asMap().clear();
        cargoService.saveCargo(cargo);
        return "redirect:/cargoes/" + encodeUrlPathSegment(cargo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new Cargo());
        List<String[]> dependencies = new ArrayList<String[]>();
        if (torneoService.countAllTorneos() == 0) {
            dependencies.add(new String[] { "conceptoCobro", "torneos" });
        }
        if (equipoService.countAllEquipoes() == 0) {
            dependencies.add(new String[] { "torneo", "equipoes" });
        }
        uiModel.addAttribute("dependencies", dependencies);
        return "cargoes/create";
    }

	@RequestMapping(value = "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("cargo", cargoService.findCargo(id));
        uiModel.addAttribute("itemId", id);
        return "cargoes/show";
    }

	@RequestMapping(produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("cargoes", cargoService.findCargoEntries(firstResult, sizeNo));
            float nrOfPages = (float) cargoService.countAllCargoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("cargoes", cargoService.findAllCargoes());
        }
        addDateTimeFormatPatterns(uiModel);
        return "cargoes/list";
    }

	@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid Cargo cargo, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, cargo);
            return "cargoes/update";
        }
        uiModel.asMap().clear();
        cargoService.updateCargo(cargo);
        return "redirect:/cargoes/" + encodeUrlPathSegment(cargo.getId().toString(), httpServletRequest);
    }

	@RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, cargoService.findCargo(id));
        return "cargoes/update";
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Cargo cargo = cargoService.findCargo(id);
        cargoService.deleteCargo(cargo);
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/cargoes";
    }

	void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("cargo_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("cargo_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }

	void populateEditForm(Model uiModel, Cargo cargo) {
        uiModel.addAttribute("cargo", cargo);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("conceptocobroes", Arrays.asList(ConceptoCobro.values()));
        uiModel.addAttribute("statuscargoabonoes", Arrays.asList(StatusCargoAbono.values()));
        uiModel.addAttribute("abonoes", abonoService.findAllAbonoes());
        uiModel.addAttribute("equipoes", equipoService.findAllEquipoes());
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
            Cargo cargo = cargoService.findCargo(id);
            if (cargo == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<String>(cargo.toJson(), headers, HttpStatus.OK);
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
            List<Cargo> result = cargoService.findAllCargoes();
            return new ResponseEntity<String>(Cargo.toJsonArray(result), headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	@RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> createFromJson(@RequestBody String json, UriComponentsBuilder uriBuilder) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        try {
            Cargo cargo = Cargo.fromJsonToCargo(json);
            cargoService.saveCargo(cargo);
            RequestMapping a = (RequestMapping) getClass().getAnnotation(RequestMapping.class);
            headers.add("Location",uriBuilder.path(a.value()[0]+"/"+cargo.getId().toString()).build().toUriString());
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
            for (Cargo cargo: Cargo.fromJsonArrayToCargoes(json)) {
                cargoService.saveCargo(cargo);
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
            Cargo cargo = Cargo.fromJsonToCargo(json);
            cargo.setId(id);
            if (cargoService.updateCargo(cargo) == null) {
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
            Cargo cargo = cargoService.findCargo(id);
            if (cargo == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
            cargoService.deleteCargo(cargo);
            return new ResponseEntity<String>(headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("{\"ERROR\":"+e.getMessage()+"\"}", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
