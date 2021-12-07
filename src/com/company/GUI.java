package com.company;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private JFrame frame;
    JTextArea output_textArea;

    public GUI() {
        initialize();
        frame.setVisible(true);

    }

    public void addUpdates(String str) {
        output_textArea.append(str);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setBounds(100, 100, 1000, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(new Color(59,69,73));
        JLabel label = new JLabel("Router GUI");
        label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 29));
        label.setBounds(400, 16, 767, 41);
        label.setForeground(new Color(26, 152, 109));
        frame.getContentPane().add(label);

        JLabel lblConnectionBehaviourUpdates = new JLabel("Connection behaviour");
        lblConnectionBehaviourUpdates.setFont(new Font("Corbel", Font.PLAIN, 23));
        lblConnectionBehaviourUpdates.setBounds(390, 88, 309, 29);
        lblConnectionBehaviourUpdates.setForeground(new Color(26, 152, 109));
        frame.getContentPane().add(lblConnectionBehaviourUpdates);

        output_textArea = new JTextArea();
        output_textArea.setEditable(false);
        output_textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        output_textArea.setBounds(200, 125, 600, 600);
        output_textArea.setBackground(new Color(26, 152, 109));
        output_textArea.setForeground(Color.white);
        frame.getContentPane().add(output_textArea);
    }
    
}
