package com.amberj.ui.component;

import com.amberj.ui.Context;
import com.amberj.ui.Widget;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Row implements Widget {
    private final List<Widget> children = new ArrayList<>();
    private MainAxisAlignment alignment = MainAxisAlignment.START;

    public void children(Widget... components) {
        children.addAll(Arrays.asList(components));
    }

    public Row alignment(MainAxisAlignment alignment) {
        this.alignment = alignment;
        return this;
    }

    @Override
    public JComponent render(Context context) {
        JPanel panel = new JPanel() {
            @Override
            public void doLayout() {
                super.doLayout();
                applyJustification(getWidth());
            }

            private void applyJustification(int panelWidth) {
                int totalWidth = children.stream()
                        .mapToInt(component -> (int) component.render(context).getPreferredSize().getWidth())
                        .sum();
                int gap = 0;
                System.out.println(panelWidth);
                switch (alignment) {
                    case CENTER:
                        setLayout(new FlowLayout(FlowLayout.CENTER, gap, 0));
                        break;
                    case END:
                        setLayout(new FlowLayout(FlowLayout.TRAILING, gap, 0));
                        break;
                    case SPACE_BETWEEN:
                        setLayout(new FlowLayout(FlowLayout.TRAILING, gap, 0));
                        break;
                    case SPACE_AROUND:
                        setLayout(new FlowLayout(FlowLayout.CENTER));
                        break;
                    case SPACE_EVENLY:
                        gap = (panelWidth - totalWidth) / 2;
                        setLayout(new FlowLayout(FlowLayout.CENTER, gap, 0));
                        break;
                    case START:
                    default:
                        setLayout(new FlowLayout(FlowLayout.LEFT, gap, 0));
                        break;
                }
            }
        };

        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        children.forEach((child) -> {
            context.getWidgetRunnerUtil().addComponent(panel, child.render(context), child::init);
        });

        return panel;
    }


    public enum MainAxisAlignment {
        START, CENTER, END, SPACE_BETWEEN, SPACE_AROUND, SPACE_EVENLY
    }
}
