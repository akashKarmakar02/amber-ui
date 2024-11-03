package com.amberj.ui;

import javax.swing.*;

public interface Widget {
    default void init() {}

    public JComponent render(Context context);

    default void dispose() {}
}
