package Models;

public class Resistor extends CircuitElement {
    public Resistor(String name, double value) {
        super(name, value); // Giá trị điện trở (Ohms)
    }
    
    public double getResistance() {
        return value; // Trả về giá trị điện trở
    }

    @Override
    public double calculateVoltage(double current) {
        return current * value; // U = I * R
    }

    @Override
    public double calculateCurrent(double voltage) {
        return voltage / value; // I = U / R
    }
}
