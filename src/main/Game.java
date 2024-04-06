package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener{
    private static Game game;

    GameLogic glogic = new GameLogic();

    Timer timer;

    JTextField commandsfield;
    JLabel action1, action2, action3, action4, action5, action6, action7, action8;
    JLabel hplabel, balancelbl, xplbl, levellbl;
    JButton enter;
    private Game (){
        setVisible(true);
        setBounds(300, 100, 650, 650);
        setTitle("Attack or Die");
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        timer = new Timer(25, this);
        timer.start();

        commandsfield = new JTextField();
        commandsfield.setBounds(70, 500, 350, 70);
        commandsfield.setFont(getFont().deriveFont(20f));
        commandsfield.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    glogic.setCommand(commandsfield.getText());
                    glogic.setInfo(commandsfield.getText());

                    glogic.show();
                    commandsfield.setText("");

                    glogic.check();
                    hplabel.setText("HP: "+glogic.getPlayerHp());
                    balancelbl.setText("$: "+glogic.getPlayerBal());
                    xplbl.setText("XP: "+glogic.getPlayerXp());
                    levellbl.setText("LVL: "+glogic.getPlayerLvl());
                 }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
            
        });
        add(commandsfield);

        enter = new JButton();
        enter.setBounds(430, 500, 150, 70);
        enter.setText("Enter");
        enter.setFont(getFont().deriveFont(20f));
        enter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                glogic.setCommand(commandsfield.getText());
                glogic.setInfo(commandsfield.getText());

                glogic.show();
                commandsfield.setText("");

                glogic.check();
                hplabel.setText("HP: "+glogic.getPlayerHp());
                balancelbl.setText("$: "+glogic.getPlayerBal());
                xplbl.setText("XP: "+glogic.getPlayerXp());
                levellbl.setText("LVL: "+glogic.getPlayerLvl());
            }
            
        });
        add(enter);

        action1 = new JLabel();
        action1.setBounds(70, 400, 650, 70);
        action1.setText("-");
        action1.setFont(getFont().deriveFont(25f));
        add(action1);

        action2 = new JLabel();
        action2.setBounds(70, 370, 650, 70);
        action2.setText("-");
        action2.setFont(getFont().deriveFont(25f));
        add(action2);

        action3 = new JLabel();
        action3.setBounds(70, 340, 650, 70);
        action3.setText("-");
        action3.setFont(getFont().deriveFont(25f));
        add(action3);

        action4 = new JLabel();
        action4.setBounds(70, 310, 650, 70);
        action4.setText("-");
        action4.setFont(getFont().deriveFont(25f));
        add(action4);

        action5 = new JLabel();
        action5.setBounds(70, 280, 650, 70);
        action5.setText("-");
        action5.setFont(getFont().deriveFont(25f));
        add(action5);

        action6 = new JLabel();
        action6.setBounds(70, 250, 650, 70);
        action6.setText("-");
        action6.setFont(getFont().deriveFont(25f));
        add(action6);

        action7 = new JLabel();
        action7.setBounds(70, 220, 650, 70);
        action7.setText("-");
        action7.setFont(getFont().deriveFont(25f));
        add(action7);

        action8 = new JLabel();
        action8.setBounds(70, 190, 650, 70);
        action8.setText("-");
        action8.setFont(getFont().deriveFont(25f));
        add(action8);

        hplabel = new JLabel();
        hplabel.setBounds(70, 50, 350, 70);
        hplabel.setText("HP: "+glogic.getPlayerHp());
        hplabel.setFont(getFont().deriveFont(35f));
        hplabel.setForeground(Color.RED);
        add(hplabel);

        balancelbl = new JLabel();
        balancelbl.setBounds(200, 50, 350, 70);
        balancelbl.setText("$: "+glogic.getPlayerBal());
        balancelbl.setFont(getFont().deriveFont(35f));
        balancelbl.setForeground(Color.GREEN);
        add(balancelbl);

        xplbl = new JLabel();
        xplbl.setBounds(320, 50, 350, 70);
        xplbl.setText("XP: "+glogic.getPlayerXp());
        xplbl.setFont(getFont().deriveFont(35f));
        xplbl.setForeground(Color.BLUE);
        add(xplbl);

        levellbl = new JLabel();
        levellbl.setBounds(470, 50, 350, 70);
        levellbl.setText("LVL: "+glogic.getPlayerLvl());
        levellbl.setFont(getFont().deriveFont(35f));
        levellbl.setForeground(Color.MAGENTA);
        add(levellbl);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        repaint();
    }

    public static void createGame(){
        game = new Game();
    }
    public static Game getGame(){
        return game;
    }
    
}
