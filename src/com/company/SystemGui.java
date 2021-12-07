package com.company;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SystemGui extends JFrame {

    private JTextField ConnectiostextField;
    private JTextField DevicestextField;

    public SystemGui() throws InterruptedException {
        this.getContentPane().setBackground(new Color(59,69,73));
        this.setBounds(100, 100, 1000, 619);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        this.setTitle(" Router Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Rotuer  GUI");
        label.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 29));
        label.setBounds(400, 0, 767, 106);
        label.setForeground(new Color(26, 152, 109));
        this.getContentPane().add(label);
        this.setResizable(true);
        this.setVisible(true);

        JLabel input1 = new JLabel("What is the number of connections your router can accept?");
        input1.setFont(new Font("Corbel", Font.PLAIN, 23));
        input1.setBounds(70, 112, 568, 20);
        input1.setForeground(new Color(26, 152, 109));
        this.getContentPane().add(input1);


        JLabel input2 = new JLabel("What is the number of devices that wishes to connect?");
        input2.setFont(new Font("Corbel", Font.PLAIN, 23));
        input2.setBounds(70, 188, 568, 20);
        input2.setForeground(new Color(26, 152, 109));
        this.getContentPane().add(input2);

        JLabel input3 = new JLabel("Please, enter the names of the devices.");
        input3.setFont(new Font("Corbel", Font.PLAIN, 23));
        input3.setBounds(70, 260, 384, 20);
        input3.setForeground(new Color(26, 152, 109));
        this.getContentPane().add(input3);

        JLabel input4 = new JLabel("Please, enter the types of the devices.");
        input4.setFont(new Font("Corbel", Font.PLAIN, 23));
        input4.setBounds(515, 260, 568, 20);
        input4.setForeground(new Color(26, 152, 109));
        this.getContentPane().add(input4);

        ConnectiostextField = new JTextField();
        ConnectiostextField.setBounds(72, 137, 344, 26);
        this.getContentPane().add(ConnectiostextField);
        ConnectiostextField.setColumns(10);
        ConnectiostextField.setVisible(true);
        ConnectiostextField.requestFocus();

        DevicestextField = new JTextField();
        DevicestextField.setColumns(10);
        DevicestextField.setBounds(72, 218, 344, 26);
        this.getContentPane().add(DevicestextField);
        DevicestextField.requestFocus();

        JTextArea Names_textArea = new JTextArea();
        Names_textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        Names_textArea.setBounds(72, 293, 344, 106);
        Names_textArea.setRows(100);
        this.getContentPane().add(Names_textArea);
        Names_textArea.requestFocus();

        JTextArea TypestextArea = new JTextArea();
        TypestextArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
        TypestextArea.setBounds(519, 293, 344, 106);
        TypestextArea.setRows(100);
        this.getContentPane().add(TypestextArea);
        TypestextArea.requestFocus();

        JButton btnNewButton = new JButton("Start Simulation");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                Network.maxSize = Integer.parseInt(ConnectiostextField.getText());
                Network.numberOfConnection = Integer.parseInt(DevicestextField.getText());
                String[] names = Names_textArea.getText().split("\s");
                String[] types = TypestextArea.getText().split("\s");
                for (int i = 0; i < Integer.parseInt(DevicestextField.getText()); i++) {
                    Network.devices.add(new Device(names[i], types[i]));
                }

//                for (int j = 0; j < Network.N; j++) {
//                  //  Network.names.add("");
//                    NetworkClass.state.add(false);
//                }

                Router routerClass = new Router(Network.maxSize);
                try {
                    routerClass.occupy();
                } catch (Exception e) {
                    // TODO: handle exception
                    e.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 24));
        btnNewButton.setForeground(Color.white);
        btnNewButton.setBackground(new Color(26, 152, 109));
        btnNewButton.setBounds(298, 440, 360, 65);
        btnNewButton.requestFocus();
        this.getContentPane().add(btnNewButton);

    }

}
