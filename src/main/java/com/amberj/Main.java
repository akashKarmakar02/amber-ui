package com.amberj;

import com.amberj.ui.AmberApp;
import com.amberj.ui.component.Row;
import com.amberj.ui.component.Text;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AmberApp.width(1200);
        AmberApp.height(800);
        AmberApp.title("Amber Window");


        AmberApp.runApp(
            new Row() {{
                alignment(MainAxisAlignment.END);

                children(
                    new Text("Hello"),
                    new Text("WOrld")
                );
            }}
        );
    }
}