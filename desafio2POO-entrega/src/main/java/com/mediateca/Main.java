package com.mediateca;
//Prueba de comentario

import com.mediateca.db.DatabaseConnection;
import com.mediateca.vistas.Ventana_PPAL;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Francisco De la O Gonzalez - DG200722
 */

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        configurarLookAndFeel();

        if (!verificarConexionBD()) {
            System.exit(1);
        }


        SwingUtilities.invokeLater(() -> {
            Ventana_PPAL ventana = new Ventana_PPAL();
            ventana.setVisible(true);
        });
    }

  
    private static void configurarLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    return;
                }
            }
        } catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
            logger.log(Level.WARNING, "No se pudo aplicar Nimbus L&F, se usara el predeterminado", ex);
        }
    }


    private static boolean verificarConexionBD() {
        try {
            Connection conn = DatabaseConnection.getInstancia().getConexion();
            if (conn != null && !conn.isClosed()) {
                logger.info("Conexion a base de datos verificada correctamente.");
                return true;
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Error al verificar conexion a BD", ex);
        }

        JOptionPane.showMessageDialog(
            null,
            "<html><b>No se pudo conectar a la base de datos.</b><br><br>"
            + "Verifica que:<br>"
            + " &nbsp;&nbsp;&bull; El servicio de MySQL este corriendo.<br>"
            + " &nbsp;&nbsp;&bull; La base de datos <i>mediateca</i> exista.<br>"
            + " &nbsp;&nbsp;&bull; Las credenciales en <i>config.properties</i> sean correctas.<br><br>"
            + "Revisa la consola para mas detalles.</html>",
            "Error de conexion - Mediateca",
            JOptionPane.ERROR_MESSAGE
        );
        return false;
    }
}
