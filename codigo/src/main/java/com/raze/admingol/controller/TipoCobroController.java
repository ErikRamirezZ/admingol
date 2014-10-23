package com.raze.admingol.controller;
import com.raze.admingol.catalog.TipoCobro;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = TipoCobro.class)
@Controller
@RequestMapping("/tipocobroes")
@RooWebScaffold(path = "tipocobroes", formBackingObject = TipoCobro.class)
public class TipoCobroController {
}
