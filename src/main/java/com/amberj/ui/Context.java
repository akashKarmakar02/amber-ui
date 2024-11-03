package com.amberj.ui;

import com.amberj.common.WidgetRunnerUtil;

import javax.swing.*;

public class Context extends JFrame {

    private final WidgetRunnerUtil widgetRunnerUtil;

    public Context() {
        widgetRunnerUtil = new WidgetRunnerUtil();
    }

    public WidgetRunnerUtil getWidgetRunnerUtil() {
        return widgetRunnerUtil;
    }
}
