package Models;

public class ACVoltageSource extends CircuitElement {
    public ACVoltageSource(String name, double value) {
        super(name, value); // Giá trị điện áp (Volts)
    }

    @Override
    public double calculateVoltage(double current) {
        return value; // Nguồn điện có điện áp cố định
    }

    @Override
    public double calculateCurrent(double voltage) {
        return voltage / value; // I = U / R, nếu có điện trở ngoài
    }
}

