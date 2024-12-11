package Views;

// MainView.java
import javax.swing.*;

import Controllers.CircuitController;

import java.awt.*;

public class MainView {
    private JFrame frame;
    private JPanel panel;
    private JTabbedPane tabbedPane;
    private CircuitController controller;

    public MainView(CircuitController controller2) {
        controller = new CircuitController();
        frame = new JFrame("Circuit Simulator");
        panel = new JPanel();
        tabbedPane = new JTabbedPane();

        // Thiết lập tab mạch nối tiếp và mạch song song
        tabbedPane.addTab("Mạch Nối Tiếp", createSeriesPanel());
        tabbedPane.addTab("Mạch Song Song", createParallelPanel());

        panel.setLayout(new BorderLayout());
        panel.add(tabbedPane, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JPanel createSeriesPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Các thành phần mạch nối tiếp
        JButton addResistorButton = new JButton("Thêm Điện Trở");
        addResistorButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nhập tên điện trở:");
            double resistance = Double.parseDouble(JOptionPane.showInputDialog("Nhập giá trị điện trở (Ohm):"));
            controller.addResistor(name, resistance);
        });
        
        JButton addCapacitorButton = new JButton("Thêm Tụ Điện");
        addCapacitorButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nhập tên tụ điện:");
            double capacitance = Double.parseDouble(JOptionPane.showInputDialog("Nhập giá trị tụ điện (Farad):"));
            controller.addCapacitor(name, capacitance);
        });

        JButton addInductorButton = new JButton("Thêm Cuộn Cảm");
        addInductorButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nhập tên cuộn cảm:");
            double inductance = Double.parseDouble(JOptionPane.showInputDialog("Nhập giá trị cuộn cảm (Henry):"));
            controller.addInductor(name, inductance);
        });

        // Thêm các nút vào panel
        panel.add(addResistorButton);
        panel.add(addCapacitorButton);
        panel.add(addInductorButton);

        // Nút tính toán
        JButton calculateButton = new JButton("Tính Toán Tổng Trở");
        calculateButton.addActionListener(e -> {
            double frequency = Double.parseDouble(JOptionPane.showInputDialog("Nhập tần số (Hz):"));
            double totalImpedance = controller.calculateSeriesImpedance(frequency);
            JOptionPane.showMessageDialog(frame, "Tổng trở mạch nối tiếp: " + totalImpedance + " Ohm");
        });

        panel.add(calculateButton);
        return panel;
    }

    private JPanel createParallelPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Các thành phần mạch song song
        JButton addResistorButton = new JButton("Thêm Điện Trở");
        addResistorButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nhập tên điện trở:");
            double resistance = Double.parseDouble(JOptionPane.showInputDialog("Nhập giá trị điện trở (Ohm):"));
            controller.addResistor(name, resistance);
        });

        JButton addCapacitorButton = new JButton("Thêm Tụ Điện");
        addCapacitorButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nhập tên tụ điện:");
            double capacitance = Double.parseDouble(JOptionPane.showInputDialog("Nhập giá trị tụ điện (Farad):"));
            controller.addCapacitor(name, capacitance);
        });

        JButton addInductorButton = new JButton("Thêm Cuộn Cảm");
        addInductorButton.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Nhập tên cuộn cảm:");
            double inductance = Double.parseDouble(JOptionPane.showInputDialog("Nhập giá trị cuộn cảm (Henry):"));
            controller.addInductor(name, inductance);
        });

        // Thêm các nút vào panel
        panel.add(addResistorButton);
        panel.add(addCapacitorButton);
        panel.add(addInductorButton);

        // Nút tính toán
        JButton calculateButton = new JButton("Tính Toán Tổng Trở");
        calculateButton.addActionListener(e -> {
            double frequency = Double.parseDouble(JOptionPane.showInputDialog("Nhập tần số (Hz):"));
            double totalImpedance = controller.calculateParallelImpedance(frequency);
            JOptionPane.showMessageDialog(frame, "Tổng trở mạch song song: " + totalImpedance + " Ohm");
        });

        panel.add(calculateButton);
        return panel;
    }
}
