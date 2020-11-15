package controlador;

import vista.VistaPantallaPrincipal;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorVistaPantallaPrincipal implements MouseListener{
    VistaPantallaPrincipal VistaPantallaPrincipal;
    
    public ControladorVistaPantallaPrincipal(VistaPantallaPrincipal VistaPantallaPrincipal){
        this.VistaPantallaPrincipal = VistaPantallaPrincipal;
        oyentes();
        VistaPantallaPrincipal.setVisible(true);
    }

    private void oyentes() {
        VistaPantallaPrincipal.user.addMouseListener(this);
        VistaPantallaPrincipal.cart.addMouseListener(this);
        VistaPantallaPrincipal.shrink.addMouseListener(this);
        VistaPantallaPrincipal.exit.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == VistaPantallaPrincipal.exit){
            VistaPantallaPrincipal.dispose();
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == VistaPantallaPrincipal.user){
            VistaPantallaPrincipal.user.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == VistaPantallaPrincipal.cart){
            VistaPantallaPrincipal.cart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == VistaPantallaPrincipal.shrink){
            VistaPantallaPrincipal.shrink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == VistaPantallaPrincipal.exit){
            VistaPantallaPrincipal.exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }
}
