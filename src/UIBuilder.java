import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UIBuilder {
    public void createFrame() {
        JTextField firstUnit = createFirstTextField();
        JFrame frame = new JFrame("Unit Converter");

        panel.setLayout(new GridLayout(2, 2, 30, 0));
        panel.setBounds(15, 75, 350, 85);

        typeOfConversionComboBox.addActionListener(e -> {
            if (typeOfConversionComboBox.getSelectedItem() == "Length") {
                DefaultComboBoxModel<String> lengthModel = new DefaultComboBoxModel<>(Length.units);
                DefaultComboBoxModel<String> lengthModel2 = new DefaultComboBoxModel<>(Length.units);
                unit.setModel(lengthModel);
                unit2.setModel(lengthModel2);
                setSelectedTypeOfConversion("Length");
            } else if (typeOfConversionComboBox.getSelectedItem() == "Time") {
                DefaultComboBoxModel<String> timeModel = new DefaultComboBoxModel<>(Time.units);
                DefaultComboBoxModel<String> timeModel2 = new DefaultComboBoxModel<>(Time.units);
                unit.setModel(timeModel);
                unit2.setModel(timeModel2);
                setSelectedTypeOfConversion("Time");
            } else {
                DefaultComboBoxModel<String> temperatureModel = new DefaultComboBoxModel<>(Temperature.units);
                DefaultComboBoxModel<String> temperatureModel2 = new DefaultComboBoxModel<>(Temperature.units);
                unit.setModel(temperatureModel);
                unit2.setModel(temperatureModel2);
                setSelectedTypeOfConversion("Temperature");
            }
            calculateValue(firstUnit);
        });

        secondUnit.setEditable(false);
        secondUnit.setBackground(Color.white);

        frame.setVisible(true);
        frame.setLayout(new GridLayout(3, 1, 0, 15));
        frame.setResizable(false);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(typeOfConversionComboBox);
        frame.add(panel);
        formula.setText("Formula : Multiply value by 1");
        frame.add(formula);

        unit.addActionListener(e -> addUnitComboBoxActionListener(firstUnit, unit));
        unit2.addActionListener(e -> addUnitComboBoxActionListener(firstUnit, unit2));

        panel.add(firstUnit);
        panel.add(secondUnit);
        panel.add(unit);
        panel.add(unit2);

    }

    private final JPanel panel = new JPanel();
    private final JComboBox<String> unit = new JComboBox<>(Length.units);
    private final JComboBox<String> unit2 = new JComboBox<>(Length.units);
    private final String[] typeOfConversionList = {"Length", "Time", "Temperature"};
    private final JComboBox<String> typeOfConversionComboBox = new JComboBox<>(typeOfConversionList);
    JLabel formula = new JLabel();

    private String selectedTypeOfConversion = "Length";

    private final JTextField secondUnit = new JTextField();

    private String getFirstSelectedItem() {
        String firstSelectedItem = null;
        if (panel.isAncestorOf(unit)) {
            firstSelectedItem = String.valueOf(unit.getSelectedItem());
        }
        return firstSelectedItem;
    }

    private String getSecondSelectedItem() {
        String secondSelectedItem = null;
        if (panel.isAncestorOf(unit2)) {
            secondSelectedItem = String.valueOf(unit2.getSelectedItem());
        }
        return secondSelectedItem;
    }

    private JTextField createFirstTextField() {
        JTextField textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_PERIOD) && (c != KeyEvent.VK_MINUS)) {
                    e.consume();
                }
                calculateValue(textField);
            }
        });
        return textField;
    }

    private void setSelectedTypeOfConversion(String type) {
        selectedTypeOfConversion = type;
    }

    private void calculateValue(JTextField textField){
        String secondNumber;
        try {
            String strFormula;
            if (selectedTypeOfConversion.equals("Length")) {
                secondNumber = String.valueOf(Length.convertUnit(Double.parseDouble(textField.getText()), getFirstSelectedItem(), getSecondSelectedItem()));
                strFormula = Length.getFormula();
            } else if (selectedTypeOfConversion.equals("Time")) {
                secondNumber = String.valueOf(Time.convertUnit(Double.parseDouble(textField.getText()), getFirstSelectedItem(), getSecondSelectedItem()));
                strFormula = Time.getFormula();
            } else {
                secondNumber = String.valueOf(Temperature.convertUnit(Double.parseDouble(textField.getText()), getFirstSelectedItem(), getSecondSelectedItem()));
                strFormula = Temperature.getFormula();
            }
            if (secondNumber.endsWith(".0")) {
                secondNumber = secondNumber.substring(0, secondNumber.length() - 2);
            }
            secondUnit.setText(secondNumber);
            formula.setText("Formula : " + strFormula);
        } catch (NullPointerException | NumberFormatException nullPointerException) {
            secondUnit.setText("");
        }
    }

    private void addUnitComboBoxActionListener(JTextField firstTextField, JComboBox<String> unit){
        unit.addActionListener(e -> calculateValue(firstTextField));
    }
}