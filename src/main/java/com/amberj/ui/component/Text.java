package com.amberj.ui.component;

import com.amberj.ui.Context;
import com.amberj.ui.Widget;

import javax.swing.*;
import java.awt.*;

public class Text implements Widget {
    private String text;
    private Color color = Color.BLACK;
    private int fontSize = 12;
    private int fontStyle = Font.PLAIN;
    private int alignment = JLabel.LEFT;

    public Text(String text) {
        this.text = text;
    }

    public Text color(Color color) {
        this.color = color;
        return this;
    }

    public Text fontSize(int size) {
        this.fontSize = size;
        return this;
    }

    public Text fontStyle(int style) {
        this.fontStyle = style;
        return this;
    }

    public Text alignment(int alignment) {
        this.alignment = alignment;
        return this;
    }

    @Override
    public JComponent render(Context context) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(new Font(label.getFont().getName(), fontStyle, fontSize));
        label.setHorizontalAlignment(alignment);
        return label;
    }
}
