package Models;

public class Capacitor extends CircuitElement {
    public Capacitor(String name, double value) {
        super(name, value); // Giá trị điện dung (Farads)
    }

    @Override
	public double calculateVoltage(double current) {
        return current * value; // U = I * C (Công thức đơn giản cho tụ điện)
    }

    @Override
    public double calculateCurrent(double voltage) {
        return voltage / value; // I = U / C
    }

	public double getCapacitance() {
		return value;
	}
}

