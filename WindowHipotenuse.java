import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WindowHipotenuse extends JFrame implements ActionListener{
    Font fonteToUse = new Font("Arial", Font.BOLD,16);
    JButton button4 = new JButton("Voltar");
    JButton button6 = new JButton("Obter Resultado");
    double catetoUm;
    double catetoDois;
    double hipotenusa; 
    JTextField cateto = new JTextField();
    JTextField cateto2 = new JTextField();
    JTextField resultado = new JTextField();
    JLabel labelCateto = new JLabel();
    JLabel labelCatetoTwo = new JLabel();
    JLabel labelResult = new JLabel();
    JLabel labelException = new JLabel(); 
    JLabel labelExceptionTwo = new JLabel(); 
    WindowHipotenuse(){
        button4.setHorizontalTextPosition(JButton.CENTER);
        button4.setVerticalTextPosition(JButton.CENTER);
        button4.setBounds(245,255,160,40);
        button4.setFocusable(false);
        button4.addActionListener(this);
        button4.setForeground(Color.GREEN);
        button4.setBackground(Color.RED);
        button4.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.GREEN));

        labelException.setForeground(Color.GREEN);
        labelException.setBounds(183, 71, 200, 25);
        labelException.setVisible(true);

        labelExceptionTwo.setForeground(Color.GREEN);
        labelExceptionTwo.setBounds(183, 136, 200, 25);
        labelExceptionTwo.setVisible(true);

        resultado.setBounds(173,170,200,30);
        resultado.setBackground(Color.DARK_GRAY);
        resultado.setForeground(Color.WHITE);
        resultado.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE));
        resultado.setEditable(false);
        resultado.setFont(fonteToUse);
        
        cateto.setBounds(173,40,200,30);
        cateto.setBackground(Color.DARK_GRAY);
        cateto.setForeground(Color.WHITE);
        cateto.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE));
        cateto.setFont(fonteToUse);

        labelCateto.setText("1° Cateto");
        labelCateto.setForeground(Color.WHITE);
        labelCateto.setOpaque(false);
        labelCateto.setBounds(63,40,120,30);
        labelCateto.setFont(fonteToUse);

        labelCatetoTwo.setText("2° Cateto");
        labelCatetoTwo.setForeground(Color.WHITE);
        labelCatetoTwo.setOpaque(false);
        labelCatetoTwo.setBounds(63,105,120,30);
        labelCatetoTwo.setFont(fonteToUse);

        labelResult.setText("Resultado");
        labelResult.setForeground(Color.WHITE);
        labelResult.setOpaque(false);
        labelResult.setBounds(63,170,120,30);
        labelResult.setFont(fonteToUse);

        cateto2.setBounds(173,105,200,30);
        cateto2.setBackground(Color.DARK_GRAY);
        cateto2.setForeground(Color.WHITE);
        cateto2.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE));
        cateto2.setFont(fonteToUse);

        button6.setBounds(40,255,160,40);
        button6.setFocusable(false);
        button6.addActionListener(this);
        button6.setForeground(Color.GREEN);
        button6.setBackground(Color.RED);
        button6.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.GREEN));

        this.add(labelException);
        this.add(labelExceptionTwo);
        this.add(labelCateto);
        this.add(labelCatetoTwo);
        this.add(labelResult);
        this.add(resultado);
        this.add(cateto);
        this.add(cateto2);
        this.add(button6);
        this.add(button4);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setSize(450, 450);
        this.setLayout(null);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false); 

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(button4)){
            new MyFrame();
            this.dispose(); 
    }   else if(e.getSource().equals(button6)){  
        try{
            catetoUm = Double.valueOf(cateto.getText());
            catetoDois = Double.valueOf(cateto2.getText());
            hipotenusa = Math.sqrt((catetoUm*catetoUm)+(catetoDois*catetoDois)); 
            resultado.setText(""+hipotenusa);
            labelException.setText("");
            labelExceptionTwo.setText("");

            if(catetoUm == 0 && catetoDois == 0){
                labelException.setText("Digite um numero(n > 0)");
                labelExceptionTwo.setText("Digite um numero(n > 0)");
                resultado.setText("");

            } else if(catetoUm == 0){
                labelException.setText("Digite um numero(n > 0)"); 
                labelExceptionTwo.setText(""); 
                resultado.setText("");

            } else if(catetoDois == 0){
                labelExceptionTwo.setText("Digite um numero(n > 0)");
                labelException.setText(""); 
                resultado.setText("");
            } 

        } catch(NumberFormatException exception){

                if(!cateto.getText().matches("[0-9]*") && !cateto2.getText().matches("[0-9]*")){
                 labelException.setText("Digite um numero(n > 0)"); 
                 labelExceptionTwo.setText("Digite um numero(n > 0)");

                } else if(!cateto.getText().matches("[0-9]*") && catetoDois == 0){
                    labelException.setText("Digite um numero(n > 0)");
                    labelExceptionTwo.setText("Digite um numero(n > 0)");

                } else if(!cateto.getText().matches("[0-9]*") && catetoDois > 0){
                    labelException.setText("Digite um numero(n > 0)");
                    labelExceptionTwo.setText("");

                } else if(!cateto2.getText().matches("[0-9]*") && catetoUm == 0){
                    labelExceptionTwo.setText("Digite um numero(n > 0)"); 
                    labelException.setText("Digite um numero(n > 0)");

                } else if(!cateto2.getText().matches("[0-9]*") && catetoUm > 0){
                    labelExceptionTwo.setText("Digite um numero(n > 0)"); 
                    labelException.setText("");
                } 
        }       
    }
} 
}