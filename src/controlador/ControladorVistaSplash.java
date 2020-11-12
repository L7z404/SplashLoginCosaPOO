package controlador;

import vista.VistaLogin;
import vista.VistaSplash;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ControladorVistaSplash implements MouseListener, MouseMotionListener, MouseWheelListener {
    // se declara un objeto que apuntara al original que viene en el constructor
    VistaSplash VistaSplash;
    int x, y;

    public ControladorVistaSplash(VistaSplash VistaSplash) {
        // Asigna el objeto original a la variable de clase de arriba
        this.VistaSplash = VistaSplash;
        oyentes();
        VistaSplash.setVisible(true); // Pone visible al splash

        // Duerme y mata al splash despues de determinados segundos
        dormirMatarSplash(5); // Se pasa el numero de segundos a dormir el splash
    }

    private void dormirMatarSplash(int i) {
        try {
            Thread.sleep(i * 1000); // Multiplicamos por 1000 el valor de i para convertirlo a segundos
        } catch (InterruptedException ex) { // Si falla, cacha el error en ex
            System.out.println("Error: "+ex);
        } finally{ //pase o no pase algun error finally significa: Ejecuta lo siguiente
            VistaSplash.dispose(); //Quita la ventala o mata la ventana Splash
            
            //darpaso al login creando la vista y el controlador
            VistaLogin vistaLogin = new VistaLogin();
            ControladorVistaLogin controladorVistaLogin = new ControladorVistaLogin(vistaLogin);
        }
    }

    private void oyentes() {
        VistaSplash.LblSplash.addMouseListener(this);

        VistaSplash.LblSplash.addMouseMotionListener(this);
        
        VistaSplash.LblSplash.addMouseWheelListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == VistaSplash.LblSplash) {
            x = e.getX(); // Para obtener las coordenadas de x del frame
            y = e.getY(); // Para obtener las coordenadas de y del frame
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == VistaSplash.LblSplash) {
            VistaSplash.LblSplash.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (e.getSource() == VistaSplash.LblSplash) {
            VistaSplash.setLocation(VistaSplash.getLocation().x + e.getX() - x,
                    VistaSplash.getLocation().y + e.getY() - y);
        }

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getSource()==VistaSplash.LblSplash){
            VistaSplash.dispose(); //Libera el JFrame de la memoria ram
        }

    }
}
