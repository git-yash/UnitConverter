public enum Time {
    MINUTE("Minute"),
    HOUR("Hour"),
    DAY("Day");

    private final String unit;

    Time(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }

    public static String[] units = {"Minute", "Hour", "Day"};

    public static double convertUnit(double firstNumber, String firstUnit, String secondUnit) {
        double secondNumber;

        if (firstUnit.equals(MINUTE.getUnit()) && secondUnit.equals(MINUTE.getUnit())) {
            secondNumber = firstNumber;
        } else if (firstUnit.equals(HOUR.getUnit()) && secondUnit.equals(HOUR.getUnit())) {
            secondNumber = firstNumber;
        } else if (firstUnit.equals(DAY.getUnit()) && secondUnit.equals(DAY.getUnit())) {
            secondNumber = firstNumber;
        } else if (firstUnit.equals(MINUTE.getUnit()) && secondUnit.equals(HOUR.getUnit())) {
            secondNumber = firstNumber / 60;
        } else if (firstUnit.equals(MINUTE.getUnit()) && secondUnit.equals(DAY.getUnit())) {
            secondNumber = firstNumber / 1440;
        } else if (firstUnit.equals(HOUR.getUnit()) && secondUnit.equals(MINUTE.getUnit())) {
            secondNumber = firstNumber * 60;
        } else if (firstUnit.equals(HOUR.getUnit()) && secondUnit.equals(DAY.getUnit())) {
            secondNumber = firstNumber / 24;
        } else if (firstUnit.equals(DAY.getUnit()) && secondUnit.equals(MINUTE.getUnit())) {
            secondNumber = firstNumber * 1440;
        } else {
            secondNumber = firstNumber * 24;
        }

        return secondNumber;
    }
}
