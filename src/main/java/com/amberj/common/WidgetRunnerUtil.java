package com.amberj.common;

import javax.swing.*;

public class WidgetRunnerUtil {

    public void addComponent(JComponent parent, JComponent child, Runnable initFunction) {
        parent.add(child);
        Thread.ofVirtual().start(initFunction);
    }

}
