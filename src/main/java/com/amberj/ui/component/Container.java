package com.amberj.ui.component;

import com.amberj.ui.Context;
import com.amberj.ui.Widget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Container implements Widget {
    private Color backgroundColor = Color.WHITE;
    private Insets margin = new Insets(0, 0, 0, 0);
    private Insets padding = new Insets(0, 0, 0, 0);
    private int borderRadius = 0;
    private Runnable onClick;

    public Container color(Color color) {
        this.backgroundColor = color;
        return this;
    }

    public Container margin(int top, int left, int bottom, int right) {
        this.margin = new Insets(top, left, bottom, right);
        return this;
    }

    public Container padding(int top, int left, int bottom, int right) {
        this.padding = new Insets(top, left, bottom, right);
        return this;
    }

    public Container borderRadius(int radius) {
        this.borderRadius = radius;
        return this;
    }

    public Container onClick(Runnable action) {
        this.onClick = action;
        return this;
    }

    @Override
    public JComponent render(Context context) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw background with border radius
                g2.setColor(backgroundColor);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), borderRadius, borderRadius);
                g2.dispose();
            }
        };

        panel.setOpaque(false);
        panel.setBackground(backgroundColor);

        // Apply margin
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(margin.top, margin.left, margin.bottom, margin.right),
                BorderFactory.createEmptyBorder(padding.top, padding.left, padding.bottom, padding.right)
        ));

        // Set up onClick listener
        if (onClick != null) {
            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    onClick.run();
                }
            });
        }

        return panel;
    }
}
