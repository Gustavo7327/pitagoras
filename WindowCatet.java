import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WindowCatet extends JFrame implements ActionListener{
    Font fonteToUseTwo = new Font("Arial", Font.BOLD,16);
    JButton button3 = new JButton("Voltar");
    JButton button5 = new JButton("Obter Resultado");
    JTextField cateto = new JTextField();
    JTextField hipotenusa = new JTextField();
    double catetoADescobrir;
    double cateto1;
    double hipotenuse;
    JTextField resultadoo = new JTextField();
    JLabel labelCatetoo = new JLabel();
    JLabel labelHipotenusa = new JLabel();
    JLabel labelResult = new JLabel();
    JLabel labelException = new JLabel(); 
    JLabel labelExceptionTwo = new JLabel(); 
    WindowCatet(){
        button3.setHorizontalTextPosition(JButton.CENTER);
        button3.setVerticalTextPosition(JButton.CENTER);
        button3.setBounds(245,255,160,40);
        button3.setFocusable(false);
        button3.addActionListener(this);
        button3.setForeground(Color.GREEN);
        button3.setBackground(Color.RED);
        button3.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.GREEN));

        labelException.setForeground(Color.GREEN);
        labelException.setBounds(183, 71, 230, 25);
        labelException.setVisible(true);

        labelExceptionTwo.setForeground(Color.GREEN);
        labelExceptionTwo.setBounds(183, 136, 230, 25);
        labelExceptionTwo.setVisible(true);
 
        resultadoo.setBounds(173,170,200,30);
        resultadoo.setBackground(Color.DARK_GRAY);
        resultadoo.setForeground(Color.WHITE);
        resultadoo.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE));
        resultadoo.setEditable(false);
        resultadoo.setFont(fonteToUseTwo);
        
        cateto.setBounds(173,40,200,30);
        cateto.setBackground(Color.DARK_GRAY);
        cateto.setForeground(Color.WHITE);
        cateto.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE));
        cateto.setFont(fonteToUseTwo);
       
        hipotenusa.setBounds(173,105,200,30);
        hipotenusa.setBackground(Color.DARK_GRAY);
        hipotenusa.setForeground(Color.WHITE);
        hipotenusa.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE));
        hipotenusa.setFont(fonteToUseTwo);

        labelCatetoo.setText("Cateto");
        labelCatetoo.setForeground(Color.WHITE);
        labelCatetoo.setOpaque(false);
        labelCatetoo.setBounds(63,40,120,30);
        labelCatetoo.setFont(fonteToUseTwo);

        labelHipotenusa.setText("Hipotenusa");
        labelHipotenusa.setForeground(Color.WHITE);
        labelHipotenusa.setOpaque(false);
        labelHipotenusa.setBounds(63,105,120,30);
        labelHipotenusa.setFont(fonteToUseTwo);

        labelResult.setText("Resultado");
        labelResult.setForeground(Color.WHITE);
        labelResult.setOpaque(false);
        labelResult.setBounds(63,170,120,30);
        labelResult.setFont(fonteToUseTwo);

        button5.setBounds(40,255,160,40);
        button5.setFocusable(false);
        button5.addActionListener(this);
        button5.setForeground(Color.GREEN);
        button5.setBackground(Color.RED);
        button5.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.GREEN));

        this.add(labelExceptionTwo);
        this.add(labelException);
        this.add(labelCatetoo);
        this.add(labelHipotenusa);
        this.add(labelResult);
        this.add(resultadoo);
        this.add(hipotenusa);
        this.add(cateto);
        this.add(button5);
        this.add(button3);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(450, 450);
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(button3)){
            new MyFrame();
            this.dispose();
       } else if(e.getSource().equals(button5)){
           try{
            cateto1 = Double.valueOf(cateto.getText());
            hipotenuse = Double.valueOf(hipotenusa.getText());
            catetoADescobrir = Math.sqrt((hipotenuse*hipotenuse)-(cateto1*cateto1));
            resultadoo.setText(""+catetoADescobrir);
            labelException.setText("");
            labelExceptionTwo.setText("");

            if(cateto1 == 0 && hipotenuse == 0){
                labelException.setText("Digite um numero(n > 0)");
                labelExceptionTwo.setText("Digite um numero(n > 0)");
                resultadoo.setText("");
                
            } else if(hipotenuse == 0){
                labelExceptionTwo.setText("Digite um numero(n > 0)");
                labelException.setText("");
                resultadoo.setText("");

            } else if(cateto1 == 0){
                labelException.setText("Digite um numero(n > 0)");  
                labelExceptionTwo.setText("");
                resultadoo.setText("");

            } else if(cateto1 > hipotenuse){
                labelException.setText("Cateto < hipotenusa");
                labelExceptionTwo.setText("");
                resultadoo.setText("");
            
            } else if(cateto1 == hipotenuse){
                labelException.setText("");
                labelExceptionTwo.setText("Hipotenusa > cateto");
                resultadoo.setText("");
            }

        } catch(NumberFormatException exception){

                if(!hipotenusa.getText().matches("[0-9]*") && !cateto.getText().matches("[0-9]*")){
                 labelException.setText("Digite um numero(n > 0)"); 
                 labelExceptionTwo.setText("Digite um numero(n > 0)");
                 resultadoo.setText("");
                 
                } else if(!hipotenusa.getText().matches("[0-9]*") && cateto1 > 0){
                    labelExceptionTwo.setText("Digite um numero(n > 0)");
                    labelException.setText("");
                    resultadoo.setText("");

                } else if(!hipotenusa.getText().matches("[0-9]*") && cateto1 == 0){
                    labelException.setText("Digite um numero(n > 0)"); 
                    labelExceptionTwo.setText("Digite um numero(n > 0)");
                    resultadoo.setText("");

                } else if(!cateto.getText().matches("[0-9]*") && hipotenuse > 0){
                    labelException.setText("Digite um numero(n > 0)"); 
                    labelExceptionTwo.setText("");
                    resultadoo.setText("");

                } else if(!cateto.getText().matches("[0-9]*") && hipotenuse == 0){
                    labelException.setText("Digite um numero(n > 0)"); 
                    labelExceptionTwo.setText("Digite um numero(n > 0)");
                    resultadoo.setText("");

                } 
                     
            } 
       } 
    }
}
