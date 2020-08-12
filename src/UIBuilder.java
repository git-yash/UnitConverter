import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UIBuilder {
    private final JPanel panel = new JPanel();
    JComboBox<String> unit = new JComboBox<>(Length.units);
    JComboBox<String> unit2 = new JComboBox<>(Length.units);
    String[] typeOfConversionList = {"Length", "Time", "Temperature"};
    JComboBox<String> typeOfConversionComboBox = new JComboBox<>(typeOfConversionList);
    String selectedTypeOfConversion = "Length";

    JTextField secondUnit = new JTextField();

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

    public void createFrame() {
        JTextField firstUnit = createFirstTextField();
        JFrame frame = new JFrame("Unit Converter");

        panel.setLayout(new GridLayout(2, 2, 30, 0));
        panel.setBounds(15, 75, 350, 85);

        typeOfConversionComboBox.addActionListener(e -> {
            firstUnit.setText("");
            secondUnit.setText("");
            if(typeOfConversionComboBox.getSelectedItem() == "Length"){
                DefaultComboBoxModel<String> lengthModel = new DefaultComboBoxModel<>(Length.units);
                DefaultComboBoxModel<String> lengthModel2 = new DefaultComboBoxModel<>(Length.units);
                unit.setModel(lengthModel);
                unit2.setModel(lengthModel2);
                setSelectedTypeOfConversion("Length");
            }
            else if(typeOfConversionComboBox.getSelectedItem() == "Time"){
                DefaultComboBoxModel<String> timeModel = new DefaultComboBoxModel<>(Time.units);
                DefaultComboBoxModel<String> timeModel2 = new DefaultComboBoxModel<>(Time.units);
                unit.setModel(timeModel);
                unit2.setModel(timeModel2);
                setSelectedTypeOfConversion("Time");
            }
            else{
                DefaultComboBoxModel<String> temperatureModel = new DefaultComboBoxModel<>(Temperature.units);
                DefaultComboBoxModel<String> temperatureModel2 = new DefaultComboBoxModel<>(Temperature.units);
                unit.setModel(temperatureModel);
                unit2.setModel(temperatureModel2);
                setSelectedTypeOfConversion("Temperature");
            }
        });


        JLabel formula = new JLabel();
        secondUnit.setEditable(false);
        secondUnit.setBackground(Color.white);

        frame.setVisible(true);
        frame.setLayout(new GridLayout(3, 1, 0, 15));
        frame.setResizable(false);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(typeOfConversionComboBox);
        frame.add(panel);
        frame.add(formula);

        panel.add(firstUnit);
        panel.add(secondUnit);
        panel.add(unit);
        panel.add(unit2);

    }

    private JTextField createFirstTextField() {
        JTextField textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                String secondNumber;
                char c = e.getKeyChar();
                if (((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_PERIOD) && (c != KeyEvent.VK_MINUS)) {
                    e.consume();
                }
                try {
                    if(selectedTypeOfConversion.equals("Length")) {
                        secondNumber = String.valueOf(Length.convertUnit(Double.parseDouble(textField.getText()), getFirstSelectedItem(), getSecondSelectedItem()));
                    }
                    else if(selectedTypeOfConversion.equals("Time")) {
                        secondNumber = String.valueOf(Time.convertUnit(Double.parseDouble(textField.getText()), getFirstSelectedItem(), getSecondSelectedItem()));
                    }
                    else{
                        secondNumber = String.valueOf(Temperature.convertUnit(Double.parseDouble(textField.getText()), getFirstSelectedItem(), getSecondSelectedItem()));
                    }
                    if (secondNumber.endsWith(".0")) {
                        secondNumber = secondNumber.substring(0, secondNumber.length() - 2);
                    }
                    secondUnit.setText(secondNumber);
                } catch (NullPointerException | NumberFormatException nullPointerException) {
                    secondUnit.setText("");
                }
            }
        });
        return textField;
    }

//    private String getSelectedTypeOfConversion(){
//        String selectedTypeOfConversion;
//        if(typeOfConversionComboBox.getSelectedItem() == "Length"){selectedTypeOfConversion = "Length";}
//        else if(typeOfConversionComboBox.getSelectedItem() == "Time"){selectedTypeOfConversion = "Time";}
//        else{selectedTypeOfConversion = "Temperature";}
//        return selectedTypeOfConversion;
//    }
    private void setSelectedTypeOfConversion(String type){
        selectedTypeOfConversion = type;
    }

}