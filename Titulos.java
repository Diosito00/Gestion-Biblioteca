import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 * Write a description of class MiBoton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Titulos extends JLabel
{
    public Titulos(String text){
        this.setText(text);
        this.setFont(new Font("Corbel", Font.BOLD, 40));
        this.setForeground(new Color(19, 94, 255));
        this.setBounds(10, 0, 600, 60);
    } 
}