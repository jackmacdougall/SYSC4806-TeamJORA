package springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springboot.Model.*;
import springboot.Service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {

    private final ItemService service;

    private ItemController(ItemService service){
        this.service = service;
    }

    @GetMapping(value = "/itemPage")
    public String itemPage(Model model) {
        model.addAttribute("item", service.getAllItems());
        return "itemPage";
    }

    @PostMapping(value = "/add")
    public String addItem(@ModelAttribute Item item, Model model) {
        service.addItem(item);
        model.addAttribute("item", service.getAllItems());
        return "itemPage";
    }
}
