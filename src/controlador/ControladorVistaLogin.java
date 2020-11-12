package controlador;

import vista.VistaLogin;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;

public class ControladorVistaLogin implements MouseListener{
    VistaLogin VistaLogin;
    
    public ControladorVistaLogin(VistaLogin VistaLogin){
        this.VistaLogin = VistaLogin;
        oyentes();
        VistaLogin.setVisible(true);
        VistaLogin.LblVerContra.setVisible(false);
    }

    private void oyentes() {
        VistaLogin.LblOcutarContra.addMouseListener(this);
        VistaLogin.LblVerContra.addMouseListener(this);
        VistaLogin.LblPassword.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblOcutarContra) {
            VistaLogin.LblOcutarContra.setVisible(false);
            VistaLogin.LblVerContra.setVisible(true);
            VistaLogin.TxtPassword.setEchoChar((char)0);
        }
        

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblOcutarContra) {
            VistaLogin.LblVerContra.setVisible(false);
            VistaLogin.LblOcutarContra.setVisible(true);
            VistaLogin.TxtPassword.setEchoChar('*');
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == VistaLogin.LblOcutarContra) {
            VistaLogin.LblOcutarContra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if (e.getSource() == VistaLogin.LblVerContra) {
            VistaLogin.LblVerContra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
