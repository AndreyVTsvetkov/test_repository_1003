package ru.sber.calculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorPanel extends JPanel {
    public CalculatorPanel() {
        setLayout(new BorderLayout());

        result = "";
        lastCommand = "=";
        start = true;

        display = new JButton("0");
        display.setEnabled(false);
        add(display, BorderLayout.NORTH);

        ActionListener insert = new InsertAction();
        ActionListener command = new CommandAction();

        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        addButton("7", insert);
        addButton("8", insert);
        addButton("9", insert);
        addButton("/", command);

        addButton("4", insert);
        addButton("5", insert);
        addButton("6", insert);
        addButton("*", command);

        addButton("1", insert);
        addButton("2", insert);
        addButton("3", insert);
        addButton("-", command);

        addButton("0", insert);
        addButton(".", insert);
        addButton("=", command);
        addButton("+", command);

        add(panel, BorderLayout.CENTER);
    }

    private void addButton(String label, ActionListener listener) {
        JButton button = new JButton(label);
        button.addActionListener(listener);
        panel.add(button);
    }

    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String input = event.getActionCommand();
            if (start) {
                display.setText("");
                start = false;
            }
            display.setText(display.getText() + input);
        }
    }

    private class CommandAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String command = event.getActionCommand();
            if (start) {
                if (command.equals("-")) {
                    display.setText(command);
                    start = false;
                } else lastCommand = command;
            } else {
                calculate(display.getText());
                lastCommand = command;
                start = true;
            }
        }
    }

    public void calculate(String x) {
        CalculatorProc calculatorproc = new CalculatorProc();

        calculatorproc.setVal1(result);
        calculatorproc.setVal2(x);

        if (lastCommand.equals("+")) result = calculatorproc.sumValues();
        else if (lastCommand.equals("-")) result = calculatorproc.subtractionValues();
        else if (lastCommand.equals("*")) result = calculatorproc.multiplicationValues();
        else if (lastCommand.equals("/")) result = calculatorproc.divisionValues();
        else if (lastCommand.equals("=")) result = x;
        display.setText("" + result);
    }

    private JButton display;
    private JPanel panel;
    private String result;
    private String lastCommand;
    private boolean start;
}
