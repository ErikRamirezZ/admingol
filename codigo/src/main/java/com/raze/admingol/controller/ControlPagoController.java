package com.raze.admingol.controller;
import com.raze.admingol.domain.ControlPago;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = ControlPago.class)
@Controller
@RequestMapping("/controlpagoes")
@RooWebScaffold(path = "controlpagoes", formBackingObject = ControlPago.class)
public class ControlPagoController {
}
