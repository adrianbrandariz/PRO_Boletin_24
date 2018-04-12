/*
 *                          BOLETIN 24
 *
 * Crea una aplicación que tenga un JtextField con el número 0 por defecto,
 * un botón con el texto “dibuja” y otro con el texto “limpia”. 
 * Cuando se pulsa el botón “dibuja” el programa debe dibujar tantos círculos 
 * rojos como indica el número que aparece en el JtextField y cuando es pulsado
 * el boton “Limpia” no deben aparecer los círculos.
 */
package pro_boletin_24;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author abrandarizdominguez
 */
public class Metodos {

    JFrame marco;
    JPanel panel;
    JTextField jtNumber;
    JButton bDib, bLimp;
    Graphics graph;

    public Metodos() {
        // Se instancian los componentes:
        marco = new JFrame("Boletin 24 Programacion");
        panel = new JPanel();
        jtNumber = new JTextField("0");
        bDib = new JButton("Dibuja");
        bLimp = new JButton("Limpia");
        // Se dan las características a los objetos:
        marco.setSize(1200, 600);
        panel.add(jtNumber);
        panel.add(bDib);
        panel.add(bLimp);
        marco.add(panel);
        Dibujar dib = new Dibujar();
        // Se añade al boton el ActionListener:
        bDib.addActionListener(dib);
        bLimp.addActionListener(dib);
        // Se hace visible:
        marco.setLocationRelativeTo(marco);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }

    // Clase interna:
    public class Dibujar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            /*
             * Para poder diferenciar que botón es el pulsado utilizamos para el
             * ActionEvent su método .getSource.
             */
            Object boton = ae.getSource();
            if (boton == bDib) {
                paint(panel.getGraphics());
            } else {
                jtNumber.setText("0");
                panel.repaint();
            }
        }

        public void paint(Graphics g) {
            int x = 50;
            int y = 50;
            for (int i = 0; i < Integer.parseInt(jtNumber.getText()); i++) {
                if (x > 950) {
                    x = 50;
                    y = y + 50;
                }
                x = x + 50;
                g.setColor(Color.RED);
                g.fillOval(x, y, 20, 20);
            }

        }
    }
}
