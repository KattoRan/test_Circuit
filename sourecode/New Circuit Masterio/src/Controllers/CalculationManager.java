package Controllers;

import Models.Resistor;
import Models.Capacitor;
import Models.Inductor;
import java.util.List;

public class CalculationManager {

    // Tính tổng trở của mạch nối tiếp
    public double calculateSeriesImpedance(List<Resistor> resistors, List<Capacitor> capacitors, List<Inductor> inductors, double frequency) {
        double totalImpedance = 0;

        // Tính tổng trở của các điện trở trong mạch nối tiếp
        for (Resistor resistor : resistors) {
            totalImpedance += resistor.getResistance();
        }

        // Tính tổng trở của các tụ điện trong mạch nối tiếp (impedance của tụ điện: Z = 1 / jωC)
        for (Capacitor capacitor : capacitors) {
            double capacitiveImpedance = 1 / (2 * Math.PI * frequency * capacitor.getValue());
            totalImpedance += capacitiveImpedance;
        }

        // Tính tổng trở của các cuộn cảm trong mạch nối tiếp (impedance của cuộn cảm: Z = jωL)
        for (Inductor inductor : inductors) {
            double inductiveImpedance = 2 * Math.PI * frequency * inductor.getValue();
            totalImpedance += inductiveImpedance;
        }

        return totalImpedance;
    }

    // Tính tổng trở của mạch song song
    public double calculateParallelImpedance(List<Resistor> resistors, List<Capacitor> capacitors, List<Inductor> inductors, double frequency) {
        double totalImpedance = 0;

        // Đối với mạch song song, tổng trở của điện trở được tính theo công thức 1/Z_total = 1/Z1 + 1/Z2 + ...
        for (Resistor resistor : resistors) {
            totalImpedance += 1 / resistor.getResistance();
        }

        // Tổng trở của các tụ điện trong mạch song song (1/Z_total = 1/Z1 + 1/Z2 + ...)
        for (Capacitor capacitor : capacitors) {
            double capacitiveImpedance = 1 / (2 * Math.PI * frequency * capacitor.getValue());
            totalImpedance += 1 / capacitiveImpedance;
        }

        // Tổng trở của các cuộn cảm trong mạch song song (1/Z_total = 1/Z1 + 1/Z2 + ...)
        for (Inductor inductor : inductors) {
            double inductiveImpedance = 2 * Math.PI * frequency * inductor.getValue();
            totalImpedance += 1 / inductiveImpedance;
        }

        // Trả lại tổng trở của mạch song song
        return 1 / totalImpedance;
    }
}
