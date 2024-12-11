package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectionBox {
    private JPanel panel;
    private Rectangle selectionBox;
    private Point startPoint;

    public SelectionBox(JPanel panel) {
        this.panel = panel;
        initialize();
    }

    private void initialize() {
        selectionBox = new Rectangle();

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                selectionBox.setBounds(startPoint.x, startPoint.y, 0, 0);
                panel.repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                selectionBox.setBounds(0, 0, 0, 0); // Xóa vùng chọn
                panel.repaint();
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = Math.min(startPoint.x, e.getX());
                int y = Math.min(startPoint.y, e.getY());
                int width = Math.abs(startPoint.x - e.getX());
                int height = Math.abs(startPoint.y - e.getY());
                selectionBox.setBounds(x, y, width, height);
                panel.repaint();
            }
        });

        panel.setOpaque(true);
        panel.setBackground(Color.WHITE);
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        g2d.setStroke(new BasicStroke(1));
        g2d.draw(selectionBox);
    }

    public Rectangle getSelectionBox() {
        return selectionBox;
    }
}
