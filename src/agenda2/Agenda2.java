/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package agenda2;

import vista.interfaz1;

/**
 *
 * @author emanuelyepesmolina
 */
public class Agenda2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /* Crear y mostrar la ventana */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new interfaz1().setVisible(true);
            }
        });
    }
}

