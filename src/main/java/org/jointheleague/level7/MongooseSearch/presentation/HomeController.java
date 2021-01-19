package org.jointheleague.level7.MongooseSearch.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller // specialized ver of @component annotation that asks Spring to make the class for us
public class HomeController {
    @GetMapping("/")
    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
