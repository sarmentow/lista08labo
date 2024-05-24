package ex01;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class FactorialView extends JFrame {
    private JTextField inputField;
    private JButton calculateButton;
    private JLabel resultLabel;

    private FactorialCalculator calculator;

    public FactorialView() {
        calculator = new FactorialCalculator();
        createView();

        setTitle("Calculadora de Fatorial");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
    }

    private void createView() {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        getContentPane().add(panel);

        inputField = new JTextField();
        panel.add(new JLabel("Digite um número:"));
        panel.add(inputField);

        calculateButton = new JButton("Calcular");
        panel.add(calculateButton);

        resultLabel = new JLabel("Resultado:");
        panel.add(resultLabel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCalculate();
            }
        });
    }

    private void onCalculate() {
        try {
            int number = Integer.parseInt(inputField.getText());
            BigDecimal result = calculator.calculateFactorial(number);
            resultLabel.setText("Resultado: " + result.toString());
        } catch (NumberFormatException ex) {
            resultLabel.setText("Por favor, insira um número válido.");
        } catch (IllegalArgumentException ex) {
            resultLabel.setText(ex.getMessage());
        } catch (Exception ex) {
            resultLabel.setText("Erro ao calcular fatorial.");
        }
    }

    // Métodos adicionais para acessar componentes da interface gráfica nos testes
    public JTextField getInputField() {
        return inputField;
    }

    public JButton getCalculateButton() {
        return calculateButton;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FactorialView().setVisible(true);
            }
        });
    }
}