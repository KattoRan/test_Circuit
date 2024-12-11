package Models;

import java.util.ArrayList;
import java.util.List;

public class Circuit {
    List<CircuitElement> elements = new ArrayList<>();

    // Thêm phần tử vào mạch
    public void addElement(CircuitElement element) {
        if (elements.size() >= 5) {
            throw new IllegalArgumentException("Chỉ cho phép tối đa 5 phần tử trong mạch.");
        }
        elements.add(element);
    }

    // Tính toán tổng điện trở trong mạch nối tiếp
    public double totalResistance() {
        double total = 0;
        for (CircuitElement element : elements) {
            if (element instanceof Resistor) {
                total += element.value; // Cộng điện trở trong mạch nối tiếp
            }
        }
        return total;
    }

    // Tính toán tổng điện trở trong mạch song song
    public double totalParallelResistance() {
        double total = 0;
        for (CircuitElement element : elements) {
            if (element instanceof Resistor) {
                total += 1 / element.value; // Công thức mạch song song
            }
        }
        return 1 / total;
    }

    // Tính dòng điện trong mạch
    public double calculateCurrent(double voltage) {
        double resistance = totalResistance();
        return voltage / resistance; // Dòng điện I = U / R
    }

    // Tính điện áp trong mạch
    public double calculateVoltage(double current) {
        double resistance = totalResistance();
        return current * resistance; // Điện áp U = I * R
    }

	public List<CircuitElement> getElements() {
	    return elements; // `elements` là một danh sách đã được khởi tạo
	}
	
	public void checkShortCircuit() throws ShortCircuitException {
        for (CircuitElement element : elements) {
            if (element.getValue() == 0) {
                throw new ShortCircuitException("Ngắn mạch được phát hiện ở phần tử: " + element.getName());
            }
        }
    }
	
	
}
