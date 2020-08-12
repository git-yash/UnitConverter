public enum Temperature {
    FAHRENHEIT("Fahrenheit"),
    CELSIUS("Celsius"),
    KELVIN("Kelvin");

    private final String unit;
    public static String formula;

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
            formula = "(" + firstNumber + " - 32) * 5/9 = " + secondNumber;
        } else if (firstUnit.equals(FAHRENHEIT.getUnit()) && secondUnit.equals(KELVIN.getUnit())) {
            secondNumber = (firstNumber - 32) * 5 / 9 + 273.15;
            formula = "(" + firstNumber + " - 32) * 5/9 + 273.5 = " + secondNumber;
        } else if (firstUnit.equals(CELSIUS.getUnit()) && secondUnit.equals(FAHRENHEIT.getUnit())) {
            secondNumber = (firstNumber * 9 / 5) + 32;
            formula = "(" + firstNumber + " * 9/5) + 32 = " + secondNumber;
        } else if (firstUnit.equals(CELSIUS.getUnit()) && secondUnit.equals(KELVIN.getUnit())) {
            secondNumber = firstNumber + 273.15;
            formula = firstNumber + " + 273.15 = " + secondNumber;
        } else if (firstUnit.equals(KELVIN.getUnit()) && secondUnit.equals(FAHRENHEIT.getUnit())) {
            secondNumber = (firstNumber - 273.15) * 9 / 5 + 32;
            formula = "(" + firstNumber + " - 273.15) * 9/5 + 32 = " + secondNumber;
        } else {
            secondNumber = firstNumber - 273.15;
            formula = firstNumber + " - 273.15 = " + secondNumber;
        }
        if (secondNumber == firstNumber) {
            formula = "Multiply value by 1";
        }

        return secondNumber;
    }

    public static String getFormula() {
        return formula;
    }
}
