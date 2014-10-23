package com.raze.admingol.controller;
import com.raze.admingol.domain.Alineacion;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Alineacion.class)
@Controller
@RequestMapping("/alineacions")
@RooWebScaffold(path = "alineacions", formBackingObject = Alineacion.class)
@RooWebFinder
public class AlineacionController {
}
