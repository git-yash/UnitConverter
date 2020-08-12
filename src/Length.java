public enum Length {
    INCH("Inch"),
    FOOT("Foot"),
    MILE("Mile");

    private final String unit;

    Length(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return this.unit;
    }

    public static String[] units = {"Inch", "Foot", "Mile"};

    public static double convertUnit(double firstNumber, String firstUnit, String secondUnit) {
        double secondNumber;
        if (firstUnit.equals(INCH.getUnit()) && secondUnit.equals(INCH.getUnit())) {
            secondNumber = firstNumber;
        } else if (firstUnit.equals(FOOT.getUnit()) && secondUnit.equals(FOOT.getUnit())) {
            secondNumber = firstNumber;
        } else if (firstUnit.equals(MILE.getUnit()) && secondUnit.equals(MILE.getUnit())) {
            secondNumber = firstNumber;
        } else if (firstUnit.equals(INCH.getUnit()) && secondUnit.equals(FOOT.getUnit())) {
            secondNumber = firstNumber / 12;
        } else if (firstUnit.equals(INCH.getUnit()) && secondUnit.equals(MILE.getUnit())) {
            secondNumber = firstNumber / 63360;
        } else if (firstUnit.equals(FOOT.getUnit()) && secondUnit.equals(INCH.getUnit())) {
            secondNumber = firstNumber * 12;
        } else if (firstUnit.equals(FOOT.getUnit()) && secondUnit.equals(MILE.getUnit())) {
            secondNumber = firstNumber / 5280;
        } else if (firstUnit.equals(MILE.getUnit()) && secondUnit.equals(INCH.getUnit())) {
            secondNumber = firstNumber * 63360;
        } else {
            secondNumber = firstNumber * 5280;
        }
        return secondNumber;
    }
}
