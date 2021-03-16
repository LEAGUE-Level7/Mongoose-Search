package org.jointheleague.level7.MongooseSearch.presentation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)
public class HomeControllerIntTest {
    @Autowired
    private MockMvc mockMcv;

    @Test
    public void whenHome_thenReturnMovedPermanentlyAndRedirect(){

    }
}
