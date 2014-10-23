package com.raze.admingol.controller;
import com.raze.admingol.catalog.DiasJuego;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = DiasJuego.class)
@Controller
@RequestMapping("/diasjuegoes")
@RooWebScaffold(path = "diasjuegoes", formBackingObject = DiasJuego.class)
public class DiasJuegoController {
}
