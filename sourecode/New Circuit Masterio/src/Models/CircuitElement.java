package Models;

public abstract class CircuitElement {
    public String name;
    public double value;  // Giá trị của phần tử, có thể là điện trở, điện dung, hoặc độ tự cảm

    // Constructor
    public CircuitElement(String name, double value) {
        this.name = name;
        this.value = value;
    }

    // Getter cho tên và giá trị
    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

    // Phương thức trừu tượng để tính cường độ dòng điện
    public abstract double calculateCurrent(double voltage);

    // Phương thức trừu tượng để tính điện áp
    public abstract double calculateVoltage(double current);
}
