import Models.*; 
import Views.MainView;
import Controllers.CircuitController;
public class Main {
    public static void main(String[] args) {
        /*// Tạo các phần tử mạch
        CircuitElement resistor1 = new Resistor("R1", 10);  // 10 Ohms
        CircuitElement capacitor1 = new Capacitor("C1", 0.001); // 1mF
        CircuitElement voltageSource1 = new VoltageSource("V1", 12); // 12V

        // Tạo mạch
        Circuit circuit = new Circuit();
        circuit.addElement(resistor1);
        circuit.addElement(capacitor1);
        circuit.addElement(voltageSource1);

        // Tính toán tổng điện trở trong mạch nối tiếp
        System.out.println("Tổng điện trở trong mạch nối tiếp: " + circuit.totalResistance() + " Ohms");

        // Tính dòng điện nếu biết điện áp
        double voltage = 12; // Điện áp 12V
        double current = circuit.calculateCurrent(voltage);
        System.out.println("Dòng điện trong mạch: " + current + " A");

        // Tính điện áp với dòng điện đã biết
        double calculatedVoltage = circuit.calculateVoltage(current);
        System.out.println("Điện áp trong mạch: " + calculatedVoltage + " V");
        
        CircuitController controller = new CircuitController();
        controller.start();*/
    	
    	
    	// Tạo đối tượng CircuitController
        CircuitController controller = new CircuitController();

        // Tạo giao diện chính và hiển thị
        MainView mainView = new MainView(controller);
    }
}
