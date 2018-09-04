package com.krotos.gui;

import javax.swing.*;


public class HomePageGUI extends JFrame{
    private static final int WIDTH = 500;
    private static final int HEIGHT = 300;
    private JPanel mainPanel;
    private JButton generateButton;
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JTextArea logTextArea;
    private JPanel textPanel;

    private static HomePageGUI instance;

    private void createUIComponents() {

    }

    private HomePageGUI() {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setResizable(false);

        logTextArea.setSize(WIDTH, 50);

    }
    public static HomePageGUI getInstance(){
        if(instance==null){
            synchronized (HomePageGUI.class){
                if(instance==null){
                    instance=new HomePageGUI();
                }
            }
        }
        return instance;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getPauseButton() {
        return pauseButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public JTextArea getLogTextArea() {
        return logTextArea;
    }

    public JPanel getTextPanel() {
        return textPanel;
    }
}
