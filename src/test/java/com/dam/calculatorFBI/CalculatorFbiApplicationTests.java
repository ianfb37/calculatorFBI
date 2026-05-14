package com.dam.calculatorFBI;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorFbiApplicationTests {
    private Calculator calculator = new Calculator();

    @Test
    void contextLoads() {
    }

    @Test
    public void testSum() {
        assertEquals(5, calculator.sum(3, 2));
    }

    @Autowired
    private org.springframework.test.web.servlet.MockMvc mockMvc;

    @Test
    public void testSumEndpoint() throws Exception {
        mockMvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/sum")
                .param("a", "3")
                .param("b", "2"))
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.status().isOk())
                .andExpect(org.springframework.test.web.servlet.result.MockMvcResultMatchers.content().string("5"));
    }
}
