package com.raze.admingol.controller;
import com.raze.admingol.catalog.ConceptoCobro;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = ConceptoCobro.class)
@Controller
@RequestMapping("/conceptocobroes")
@RooWebScaffold(path = "conceptocobroes", formBackingObject = ConceptoCobro.class)
@RooWebFinder
public class ConceptoCobroController {
}
