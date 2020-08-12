import java.awt.event.KeyEvent;

public enum Temperature {
    FAHRENHEIT("Fahrenheit"),
    CELSIUS("Celsius"),
    KELVIN("Kelvin");

    private final String unit;

    Temperature(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }

    public static String[] units = {"Fahrenheit", "Celsius", "Kelvin"};

    public static double convertUnit(double firstNumber, String firstUnit, String secondUnit) {
        double secondNumber;

        if (firstUnit.equals(FAHRENHEIT.getUnit()) && secondUnit.equals(FAHRENHEIT.getUnit())) {
            secondNumber = firstNumber;
        } else if (firstUnit.equals(CELSIUS.getUnit()) && secondUnit.equals(CELSIUS.getUnit())) {
            secondNumber = firstNumber;
        } else if (firstUnit.equals(KELVIN.getUnit()) && secondUnit.equals(KELVIN.getUnit())) {
            secondNumber = firstNumber;
        } else if (firstUnit.equals(FAHRENHEIT.getUnit()) && secondUnit.equals(CELSIUS.getUnit())) {
            secondNumber = (firstNumber - 32) * 5 / 9;
        } else if (firstUnit.equals(FAHRENHEIT.getUnit()) && secondUnit.equals(KELVIN.getUnit())) {
            secondNumber = (firstNumber - 32) * 5 / 9 + 273.15;
        } else if (firstUnit.equals(CELSIUS.getUnit()) && secondUnit.equals(FAHRENHEIT.getUnit())) {
            secondNumber = (firstNumber * 9 / 5) + 32;
        } else if (firstUnit.equals(CELSIUS.getUnit()) && secondUnit.equals(KELVIN.getUnit())) {
            secondNumber = firstNumber + 273.15;
        } else if (firstUnit.equals(KELVIN.getUnit()) && secondUnit.equals(FAHRENHEIT.getUnit())) {
            secondNumber = (firstNumber - 273.15) * 9 / 5 + 32;
        } else {
            secondNumber = firstNumber - 273.15;
        }

        return secondNumber;
    }
}
