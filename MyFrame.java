import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener{
    JButton button = new JButton("Descobrir hipotenusa");
    JButton button2 = new JButton("Descobrir cateto");
    JLabel label = new JLabel("Escolha uma operação");
    Font fonte = new Font("Arial", 19, 18);
   

    MyFrame(){
        label.setBounds(115,130,220,30);
        label.setOpaque(true);
        label.setFont(fonte);
        label.setForeground(Color.RED);
        label.setBackground(Color.GREEN);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.ORANGE));
        label.setVisible(true);

        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setBounds(25,200,190,40);
        button.setFocusable(false);
        button.addActionListener(this);
        button.setForeground(Color.GREEN);
        button.setBackground(Color.RED);
        button.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.GREEN));

        button2.setForeground(Color.GREEN);
        button2.setBackground(Color.RED);
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setVerticalTextPosition(JButton.CENTER);
        button2.setBounds(225,200,190,40);
        button2.setFocusable(false);
        button2.addActionListener(this);
        button2.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.GREEN));

        this.add(label);
        this.add(button);
        this.add(button2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(450, 450);
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);;
        this.setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource()==button){
        new WindowHipotenuse();
        this.dispose();
      } else if(e.getSource()==button2){
        new WindowCatet();
        this.dispose();
      }
    }   
}

