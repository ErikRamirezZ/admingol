package com.raze.admingol.controller;
import com.raze.admingol.domain.Torneo;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Torneo.class)
@Controller
@RequestMapping("/torneos")
@RooWebScaffold(path = "torneos", formBackingObject = Torneo.class)
public class TorneoController {
}
