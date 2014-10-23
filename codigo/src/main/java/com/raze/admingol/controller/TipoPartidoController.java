package com.raze.admingol.controller;
import com.raze.admingol.catalog.TipoPartido;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = TipoPartido.class)
@Controller
@RequestMapping("/tipopartidoes")
@RooWebScaffold(path = "tipopartidoes", formBackingObject = TipoPartido.class)
public class TipoPartidoController {
}
