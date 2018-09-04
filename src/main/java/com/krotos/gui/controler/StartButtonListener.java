package com.krotos.gui.controler;

import com.krotos.gui.HomePageGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonListener implements ActionListener {

    private JTextArea logTextArea;
    private HomePageGUI homePageGUI;


    public StartButtonListener() {
        homePageGUI=HomePageGUI.getInstance();
        logTextArea = homePageGUI.getLogTextArea();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        logTextArea.append("Start... \n");
    }
}
