package Views;

import Controllers.CircuitController;
import Models.CircuitElement;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CircuitPanel {
    private JPanel panel;
    private CircuitController controller;

    public CircuitPanel(CircuitController controller) {
        this.controller = controller;
        initialize();
    }

    // Khởi tạo Panel
    private void initialize() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawCircuit(g);
            }
        };
        panel.setBackground(Color.WHITE);
    }

    // Lấy panel để thêm vào giao diện chính
    public JPanel getPanel() {
        return panel;
    }

    // Vẽ sơ đồ mạch
    private void drawCircuit(Graphics g) {
        List<CircuitElement> elements = controller.getCircuit().getElements();

        if (elements.isEmpty()) {
            g.setColor(Color.BLACK);
            g.drawString("Không có phần tử nào trong mạch.", 20, 20);
            return;
        }

        int x = 50; // Tọa độ x bắt đầu
        int y = 100; // Tọa độ y bắt đầu
        int spacing = 120; // Khoảng cách giữa các phần tử

        for (int i = 0; i < elements.size(); i++) {
            CircuitElement element = elements.get(i);

            // Vẽ hình chữ nhật đại diện cho phần tử
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 100, 50);
            g.drawString(element.name, x + 10, y + 20); // Tên phần tử
            g.drawString("Giá trị: " + element.value, x + 10, y + 40); // Giá trị

            // Vẽ dây kết nối giữa các phần tử
            if (i > 0) {
                g.drawLine(x - 20, y + 25, x, y + 25); // Kết nối từ phần tử trước đến phần tử hiện tại
            }

            x += spacing; // Dịch sang phải cho phần tử tiếp theo
        }
    }

    // Làm mới giao diện
    public void refresh() {
        panel.repaint();
    }
}
