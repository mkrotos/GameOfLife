package com.krotos.gui;

import javax.swing.*;


public class HomePageGUI extends JFrame{
    public static final int WIDTH = 500;
    public static final int HEIGHT = 300;
    private JPanel mainPanel;
    private JButton generateButton;
    private JButton startButton;
    private JButton pauseButton;
    private JButton stopButton;
    private JTextArea logTextArea;
    private JScrollBar scrollBar1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public HomePageGUI() {
        setSize(WIDTH, HEIGHT);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
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
}
