package com.amberj.ui;

import javax.swing.*;

public class AmberApp {
    private static int width = 800;
    private static int height = 600;
    private static String title = "Amber App";
    private static final Context frame;
    private static boolean showWindowDecoration = true;

    static {
        frame = new Context();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void title(String title) {
        AmberApp.title = title;
    }

    public static void width(int width) {
        AmberApp.width = width;
    }

    public static void height(int height) {
        AmberApp.height = height;
    }

    public static void runApp(Widget component) {
        frame.setSize(width, height);
        frame.setTitle(title);
        frame.setUndecorated(!showWindowDecoration);
        frame.setLocationRelativeTo(null);
        frame.add(component.render(frame));
        frame.setVisible(true);
    }
}
