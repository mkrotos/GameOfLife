package com.krotos.gui.controler;

import com.krotos.gui.HomePageGUI;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HomePageController {

    private HomePageGUI homePageGUI;
    private JButton generateButton;
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JTextArea logTextArea;
    private JPanel textPanel;

    public HomePageController() {
        initGUI();
        initListeners();
    }

    public void show(){
        homePageGUI.setVisible(true);
    }

    private void initGUI(){
        homePageGUI=HomePageGUI.getInstance();

        generateButton=homePageGUI.getGenerateButton();
        startButton=homePageGUI.getStartButton();
        pauseButton=homePageGUI.getPauseButton();
        stopButton=homePageGUI.getStopButton();
        logTextArea=homePageGUI.getLogTextArea();
        textPanel=homePageGUI.getTextPanel();

    }

    private void initListeners(){
        homePageGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        generateButton.addActionListener(new GenerateButtonListener());
        startButton.addActionListener(new StartButtonListener());
        pauseButton.addActionListener(new PauseButtonListener());
        stopButton.addActionListener(new StopButtonListener());
    }


}
