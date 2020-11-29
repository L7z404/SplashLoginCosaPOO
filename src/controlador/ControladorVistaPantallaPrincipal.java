package controlador;

import vista.VistaEmpleado;
import vista.VistaPantallaPrincipal;
import vista.VistaProductos;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modelo.ModeloEmpleado;
import modelo.ModeloProducto;

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
            int opc = JOptionPane.showConfirmDialog(null, "Deseas Salir?", "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (opc==0) {
                System.exit(0);
            }
        }else if(e.getSource()==VistaPantallaPrincipal.cart){
            VistaProductos v = new VistaProductos(new JFrame(), true);
            ModeloProducto m = new ModeloProducto();
            ControladorVistaProducto p = new ControladorVistaProducto(m,v);
        }else if(e.getSource()==VistaPantallaPrincipal.shrink){
                VistaPantallaPrincipal.setExtendedState(java.awt.Frame.ICONIFIED);
        }else if(e.getSource() == VistaPantallaPrincipal.user){
            VistaEmpleado v = new VistaEmpleado(new JFrame(), true);
            ModeloEmpleado m = new ModeloEmpleado();
            ControladorVistaEmpleado p = new ControladorVistaEmpleado(m, v);
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
