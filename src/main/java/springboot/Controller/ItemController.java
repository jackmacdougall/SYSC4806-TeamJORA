package springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springboot.Model.*;

@Controller
public class ItemController {

    @GetMapping(value = "/itemPage")
    public String itemPage() {
        return "itemPage";
    }
}
