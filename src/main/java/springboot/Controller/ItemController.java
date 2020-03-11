package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import springboot.Model.*;
import springboot.Service.ItemService;

@Controller
public class ItemController {

    private final ItemService service;

    private ItemController(ItemService service){
        this.service = service;
    }

    @GetMapping(value = "/itemPage")
    public String itemPage() {
        return "itemPage";
    }

    @PostMapping(value = "/add")
    public String addGroup(@ModelAttribute Item item, Model model) {
        service.addItem(item);
        model.addAttribute("items", service.getAllItems());
        return "itemPage";
    }
}
