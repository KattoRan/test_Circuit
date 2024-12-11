package Controllers;

import Models.Resistor;
import Models.Capacitor;
import Models.Circuit;
import Models.Inductor;

import java.util.ArrayList;
import java.util.List;

public class CircuitController {
    private List<Resistor> resistors;
    private List<Capacitor> capacitors;
    private List<Inductor> inductors;
    private CalculationManager calculationManager;
    private Circuit circuit; // Đối tượng Circuit để quản lý mạch

    public CircuitController() {
        resistors = new ArrayList<>();
        capacitors = new ArrayList<>();
        inductors = new ArrayList<>();
        calculationManager = new CalculationManager(); // Khởi tạo CalculationManager
        circuit = new Circuit(); // Khởi tạo mạch
    }

    // Thêm điện trở vào mạch
    public void addResistor(String name, double resistance) {
        resistors.add(new Resistor(name, resistance));
    }

    // Thêm tụ điện vào mạch
    public void addCapacitor(String name, double capacitance) {
        capacitors.add(new Capacitor(name, capacitance));
    }

    // Thêm cuộn cảm vào mạch
    public void addInductor(String name, double inductance) {
        inductors.add(new Inductor(name, inductance));
    }
    
    public Circuit getCircuit() {
        return circuit;
    }

    // Tính tổng trở của mạch nối tiếp
    public double calculateSeriesImpedance(double frequency) {
        return calculationManager.calculateSeriesImpedance(resistors, capacitors, inductors, frequency);
    }

    // Tính tổng trở của mạch song song
    public double calculateParallelImpedance(double frequency) {
        return calculationManager.calculateParallelImpedance(resistors, capacitors, inductors, frequency);
    }
}
