package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener{
    GameLogic glogic = new GameLogic();

    String info;

    Timer timer;

    JTextField commandsfield;
    JLabel action1, action2, action3, action4, action5;
    JLabel hplabel, balancelbl, xplbl, levellbl;
    JButton enter;
    Game (){
        setVisible(true);
        setBounds(300, 100, 650, 650);
        setTitle("Attack or Die");
        setLayout(null);
        setResizable(false);

        timer = new Timer(25, this);
        timer.start();

        commandsfield = new JTextField();
        commandsfield.setBounds(70, 500, 350, 70);
        commandsfield.setFont(getFont().deriveFont(20f));
        add(commandsfield);

        enter = new JButton();
        enter.setBounds(430, 500, 150, 70);
        enter.setText("Enter");
        enter.setFont(getFont().deriveFont(20f));
        enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                glogic.command = commandsfield.getText();
                glogic.info = commandsfield.getText();

                action5.setText(action4.getText());
                action4.setText(action3.getText());
                action3.setText(action2.getText());
                action2.setText(action1.getText());
                action1.setText(glogic.info);
                commandsfield.setText("");

                glogic.check();
                hplabel.setText("HP: "+glogic.player_hp);
                balancelbl.setText("$: "+glogic.player_bal);
                xplbl.setText("XP: "+glogic.player_xp);
                levellbl.setText("LVL: "+glogic.player_lvl);

                action5.setText(action4.getText());
                action4.setText(action3.getText());
                action3.setText(action2.getText());
                action2.setText(action1.getText());
                action1.setText(glogic.info);
                commandsfield.setText("");

                hplabel.setText("HP: "+glogic.player_hp);
                balancelbl.setText("$: "+glogic.player_bal);
                xplbl.setText("XP: "+glogic.player_xp);
                levellbl.setText("LVL: "+glogic.player_lvl);
            }
            
        });
        add(enter);

        action1 = new JLabel();
        action1.setBounds(70, 400, 650, 70);
        action1.setText("-");
        action1.setFont(getFont().deriveFont(30f));
        add(action1);

        action2 = new JLabel();
        action2.setBounds(70, 370, 650, 70);
        action2.setText("-");
        action2.setFont(getFont().deriveFont(30f));
        add(action2);

        action3 = new JLabel();
        action3.setBounds(70, 340, 650, 70);
        action3.setText("-");
        action3.setFont(getFont().deriveFont(30f));
        add(action3);

        action4 = new JLabel();
        action4.setBounds(70, 310, 650, 70);
        action4.setText("-");
        action4.setFont(getFont().deriveFont(30f));
        add(action4);

        action5 = new JLabel();
        action5.setBounds(70, 280, 650, 70);
        action5.setText("-");
        action5.setFont(getFont().deriveFont(30f));
        add(action5);

        hplabel = new JLabel();
        hplabel.setBounds(70, 50, 350, 70);
        hplabel.setText("HP: "+glogic.player_hp);
        hplabel.setFont(getFont().deriveFont(35f));
        hplabel.setForeground(Color.RED);
        add(hplabel);

        balancelbl = new JLabel();
        balancelbl.setBounds(200, 50, 350, 70);
        balancelbl.setText("$: "+glogic.player_bal);
        balancelbl.setFont(getFont().deriveFont(35f));
        balancelbl.setForeground(Color.GREEN);
        add(balancelbl);

        xplbl = new JLabel();
        xplbl.setBounds(320, 50, 350, 70);
        xplbl.setText("XP: "+glogic.player_xp);
        xplbl.setFont(getFont().deriveFont(35f));
        xplbl.setForeground(Color.BLUE);
        add(xplbl);

        levellbl = new JLabel();
        levellbl.setBounds(470, 50, 350, 70);
        levellbl.setText("LVL: "+glogic.player_lvl);
        levellbl.setFont(getFont().deriveFont(35f));
        levellbl.setForeground(Color.MAGENTA);
        add(levellbl);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }
}
