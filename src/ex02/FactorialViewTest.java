package ex02;
import ex01.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialViewTest {
    private FactorialView frame;

    @BeforeEach
    public void setUp() {
        frame = new FactorialView();
        frame.setVisible(true);
    }

    @AfterEach
    public void tearDown() {
        frame.dispose();
    }

    @Test
    public void testFactorialCalculationValidInput() {
        // Simula a entrada de um número válido
        frame.getInputField().setText("5");
        frame.getCalculateButton().doClick();

        // Verifica o resultado esperado
        assertEquals("Resultado: 120", frame.getResultLabel().getText());
    }

    @Test
    public void testFactorialCalculationInvalidInput() {
        // Simula a entrada de um texto inválido
        frame.getInputField().setText("abc");
        frame.getCalculateButton().doClick();

        // Verifica a mensagem de erro esperada
        assertEquals("Por favor, insira um número válido.", frame.getResultLabel().getText());
    }

    @Test
    public void testFactorialCalculationNegativeInput() {
        // Simula a entrada de um número negativo
        frame.getInputField().setText("-5");
        frame.getCalculateButton().doClick();

        // Verifica a mensagem de erro esperada
        assertEquals("O número deve ser não negativo.", frame.getResultLabel().getText());
    }
}