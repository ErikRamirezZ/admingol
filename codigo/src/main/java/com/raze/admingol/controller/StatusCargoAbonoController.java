package com.raze.admingol.controller;
import com.raze.admingol.catalog.StatusCargoAbono;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.roo.addon.web.mvc.controller.finder.RooWebFinder;

@RooWebJson(jsonObject = StatusCargoAbono.class)
@Controller
@RequestMapping("/statuscargoabonoes")
@RooWebScaffold(path = "statuscargoabonoes", formBackingObject = StatusCargoAbono.class)
@RooWebFinder
public class StatusCargoAbonoController {
}
