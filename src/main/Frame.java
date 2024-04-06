package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Frame extends JFrame{
    GameLogic glogic1 = new GameLogic();
    JLabel title;
    JButton login;
    JButton exit;
    JButton load;
    Frame (){
        setVisible(true);
        setBounds(200, 50, 650, 650);
        setTitle("Attack or Die");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        title = new JLabel();
        title.setText("<html><strong>ATTACK OR DIE</strong></html>");
        title.setFont(getFont().deriveFont(25f));
        title.setBounds(220, 70, 650, 200);
        title.setForeground(Color.BLUE);
        add(title);

        login = new JButton();
        login.setBounds(220, 200, 200, 50);
        login.setText("Play");
        login.setFont(getFont().deriveFont(15f));
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Game.createGame();
                dispose();
            }
            
        });
        add(login);

        exit = new JButton();
        exit.setBounds(220, 260, 200, 50);
        exit.setText("Exit");
        exit.setFont(getFont().deriveFont(15f));
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                int result = JOptionPane.showConfirmDialog(null, "Game will be closed");
                if (result == 0){
                    System.exit(0);
                }
            }
            
        });
        add(exit);

        load = new JButton();
        load.setBounds(220, 320, 200, 50);
        load.setText("Load");
        load.setFont(getFont().deriveFont(15f));
        add(load);

        repaint();
    }
}
