package com.raze.admingol.controller;
import com.raze.admingol.domain.Horario;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = Horario.class)
@Controller
@RequestMapping("/horarios")
@RooWebScaffold(path = "horarios", formBackingObject = Horario.class)
@RooWebFinder
public class HorarioController {
}
