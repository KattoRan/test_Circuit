package Models;

public class Inductor extends CircuitElement {
    // Constructor
    public Inductor(String name, double value) {
        super(name, value); // Giá trị tính bằng Henry (H)
    }

    // Tính cường độ dòng điện (I = V / L)
    @Override
    public double calculateCurrent(double voltage) {
        return voltage / value; // Giá trị là điện áp / độ tự cảm (L)
    }

    // Tính điện áp (V = I * L)
    @Override
    public double calculateVoltage(double current) {
        return current * value; // Giá trị là dòng điện * độ tự cảm (L)
    }

	public double getInductance() {
		return value;
	}
}
