/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package careerpathx;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author walisaalam
 */
public class ModernScrollBarUI extends BasicScrollBarUI {

    private final int THUMB_SIZE = 60;

    @Override
    protected Dimension getMaximumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected Dimension getMinimumThumbSize() {
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            return new Dimension(0, THUMB_SIZE);
        } else {
            return new Dimension(THUMB_SIZE, 0);
        }
    }

    @Override
    protected JButton createIncreaseButton(int i) {
        return new ScrollBarButton();
    }

    @Override
    protected JButton createDecreaseButton(int i) {
        return new ScrollBarButton();
    }

    @Override
    protected void paintTrack(Graphics grphcs, JComponent jc, Rectangle retngle) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int orientation = scrollbar.getOrientation();
        int size;
        int x;
        int y;
        int width;
        int height;
        if (orientation == JScrollBar.VERTICAL) {
            size = retngle.width / 2;
            x = retngle.x + ((retngle.width - size) / 2);
            y = retngle.y;
            width = size;
            height = retngle.height;
        } else {
            size = retngle.height / 2;
            y = retngle.y + ((retngle.height - size) / 2);
            x = 0;
            width = retngle.width;
            height = size;

        }
        g2.setColor(new Color(240, 240, 240));
        g2.fillRect(x, y, width, height);

    }

    protected void paintThumb(Graphics grphcs, JComponent jc, Rectangle retngle) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x = retngle.x;
        int y = retngle.y;
        int width = retngle.width;
        int height = retngle.height;
        if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
            y += 20;
            height -= 16;
        } else {
            x += 20;
            width -= 16;
        }
        g2.setColor(scrollbar.getForeground());
        g2.fillRoundRect(x, y, width, height, 10, 10);
    }

    private class ScrollBarButton extends JButton {

        public ScrollBarButton() {
            setBorder(BorderFactory.createEmptyBorder());
        }

        @Override
        public void paint(Graphics grphcs) {

        }

    }

    @Override
    protected void configureScrollBarColors() {
        super.configureScrollBarColors();
        scrollbar.setUnitIncrement(10); // Adjust the unit increment for fine-grained scrolling
        scrollbar.setBlockIncrement(50); // Adjust the block increment for faster scrolling
    }
}
