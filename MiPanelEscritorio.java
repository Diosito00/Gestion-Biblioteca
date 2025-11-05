import java.awt.*;
import javax.swing.*;

public class MiPanelEscritorio extends JPanel {
    private Image imagen;

    public MiPanelEscritorio(String image) {
        // Carga la imagen desde el archivo (puede ser una ruta absoluta o del proyecto)
        imagen = new ImageIcon(getClass().getResource(image)).getImage();
        this.setBounds(0, 0, 730, 420);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // limpia el fondo antes de dibujar
        // Dibuja la imagen ajustada al tamaño del panel
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
    }
}