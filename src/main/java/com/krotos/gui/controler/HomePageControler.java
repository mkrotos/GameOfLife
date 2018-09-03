package com.krotos.gui.controler;

import com.krotos.gui.HomePageGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomePageControler {

    private HomePageGUI homePageGUI;
    private JButton generateButton;
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JTextArea logTextArea;

    public HomePageControler() {
        initGUI();
        initListeners();
    }

    public void show(){
        homePageGUI.setVisible(true);
    }

    private void initGUI(){
        homePageGUI=new HomePageGUI();

        generateButton=homePageGUI.getGenerateButton();
        startButton=homePageGUI.getStartButton();
        pauseButton=homePageGUI.getPauseButton();
        stopButton=homePageGUI.getStopButton();
        logTextArea=homePageGUI.getLogTextArea();
    }

    private void initListeners(){
        generateButton.addActionListener(new generateButtonListener());
        homePageGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    private class generateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            logTextArea.append("generate button click \n");
        }
    }
}
