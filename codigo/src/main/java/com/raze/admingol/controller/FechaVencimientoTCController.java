package com.raze.admingol.controller;
import com.raze.admingol.catalog.FechaVencimientoTC;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = FechaVencimientoTC.class)
@Controller
@RequestMapping("/fechavencimientotcs")
@RooWebScaffold(path = "fechavencimientotcs", formBackingObject = FechaVencimientoTC.class)
@RooWebFinder
public class FechaVencimientoTCController {
}
