package org.jointheleague.level7.MongooseSearch.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HomeController.class)
public class HomeControllerIntTest {
    @Autowired // instantiates the variable for us?
    private MockMvc mockMvc;

    @Test
    public void whenHome_thenReturnMovedPermanentlyAndRedirect() throws Exception {
        //try catch for important code that is needed to make code do stuff
        mockMvc.perform(get("/")) //makes the request --> request URI = "/"
        .andDo(print())
        .andExpect(status().isMovedPermanently())
        .andExpect(redirectedUrl("swagger-ui.html")); //
    }
}