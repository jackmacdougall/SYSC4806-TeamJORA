package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = "/jorahome")
    public String jorahome() {
        return "jorahome";
    }
}
