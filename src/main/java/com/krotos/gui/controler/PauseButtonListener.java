package com.krotos.gui.controler;

import com.krotos.gui.HomePageGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseButtonListener implements ActionListener {

    private JTextArea logTextArea;
    private HomePageGUI homePageGUI;


    public PauseButtonListener() {
        homePageGUI=HomePageGUI.getInstance();
        logTextArea=homePageGUI.getLogTextArea();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        logTextArea.append("Pause... \n");
    }
}
