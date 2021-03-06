package com.nth.clock.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * Created by HAU TRUNG NGUYEN <haunt.hcm2015@gmail.com> on Nov 18, 2021
 */
public class ClockPanel extends JPanel {

    Clock clock;

    private final int rimWidth = 20;
    private final double percentToRadians = 2 * Math.PI;

    public ClockPanel(Clock clock) {
        this.clock = clock;

        this.setPreferredSize(new Dimension(400, 400));
        this.setMinimumSize(new Dimension(rimWidth * 4, rimWidth * 4));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        int width = this.getWidth();
        int height = this.getHeight();

        width = Math.min(width, height);
        height = Math.min(width, height);
        int center = width / 2;

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.fillOval(0, 0, width, height);

        g2d.setColor(Color.WHITE);

        g2d.fillOval(rimWidth, rimWidth, width - rimWidth * 2, height - rimWidth * 2);

        float hourHandLength = width / 4.0f;
        float minuteHandLength = width / 3.0f;
        float secondHandLength = minuteHandLength;

        int offsetX = (int) (Math.cos((clock.getHours() - 3) / 12.0 * percentToRadians) * hourHandLength);
        int offsetY = (int) (Math.sin((clock.getHours() - 3) / 12.0 * percentToRadians) * hourHandLength);
        g.setColor(Color.BLACK);
        g2d.drawLine(width / 2, height / 2, width / 2 + offsetX, height / 2 + offsetY);

        offsetX = (int) (Math.cos((clock.getMinutes() - 15) / 60.0 * percentToRadians) * minuteHandLength);
        offsetY = (int) (Math.sin((clock.getMinutes() - 15) / 60.0 * percentToRadians) * minuteHandLength);
        g.setColor(Color.BLACK);
        g2d.drawLine(width / 2, height / 2, width / 2 + offsetX, height / 2 + offsetY);

        offsetX = (int) (Math.cos((clock.getSeconds() - 15) / 60.0 * percentToRadians) * secondHandLength);
        offsetY = (int) (Math.sin((clock.getSeconds() - 15) / 60.0 * percentToRadians) * secondHandLength);
        g.setColor(Color.RED);
        g2d.drawLine(width / 2, height / 2, width / 2 + offsetX, height / 2 + offsetY);

    }

}
