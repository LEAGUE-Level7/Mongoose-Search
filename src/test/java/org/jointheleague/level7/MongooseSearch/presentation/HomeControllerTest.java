package org.jointheleague.level7.MongooseSearch.presentation;

import org.jointheleague.level7.MongooseSearch.presentation.HomeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeControllerTest {
    private HomeController homeController;

    @BeforeEach
    void setUp() {
        homeController = new HomeController();
    }

    @Test
    void givenHome_thenReturnRedirect() {
        // given
        String expected = "redirect:swagger-ui.html";

        // when
        String actual = homeController.home();

        // then
        assertEquals(expected, actual);
    }
}