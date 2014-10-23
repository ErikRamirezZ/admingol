// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.raze.admingol.controller;

import com.raze.admingol.catalog.DiasJuego;
import com.raze.admingol.controller.DiasJuegoController;
import com.raze.admingol.domain.Usuario;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect DiasJuegoController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String DiasJuegoController.create(@Valid DiasJuego diasJuego, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, diasJuego);
            return "diasjuegoes/create";
        }
        uiModel.asMap().clear();
        diasJuego.persist();
        return "redirect:/diasjuegoes/" + encodeUrlPathSegment(diasJuego.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String DiasJuegoController.createForm(Model uiModel) {
        populateEditForm(uiModel, new DiasJuego());
        return "diasjuegoes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String DiasJuegoController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("diasjuego", DiasJuego.findDiasJuego(id));
        uiModel.addAttribute("itemId", id);
        return "diasjuegoes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String DiasJuegoController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, @RequestParam(value = "sortFieldName", required = false) String sortFieldName, @RequestParam(value = "sortOrder", required = false) String sortOrder, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("diasjuegoes", DiasJuego.findDiasJuegoEntries(firstResult, sizeNo, sortFieldName, sortOrder));
            float nrOfPages = (float) DiasJuego.countDiasJuegoes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("diasjuegoes", DiasJuego.findAllDiasJuegoes(sortFieldName, sortOrder));
        }
        addDateTimeFormatPatterns(uiModel);
        return "diasjuegoes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String DiasJuegoController.update(@Valid DiasJuego diasJuego, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, diasJuego);
            return "diasjuegoes/update";
        }
        uiModel.asMap().clear();
        diasJuego.merge();
        return "redirect:/diasjuegoes/" + encodeUrlPathSegment(diasJuego.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String DiasJuegoController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, DiasJuego.findDiasJuego(id));
        return "diasjuegoes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String DiasJuegoController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        DiasJuego diasJuego = DiasJuego.findDiasJuego(id);
        diasJuego.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/diasjuegoes";
    }
    
    void DiasJuegoController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("diasJuego_fechacreacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("diasJuego_fechamodificacion_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    void DiasJuegoController.populateEditForm(Model uiModel, DiasJuego diasJuego) {
        uiModel.addAttribute("diasJuego", diasJuego);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("usuarios", Usuario.findAllUsuarios());
    }
    
    String DiasJuegoController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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