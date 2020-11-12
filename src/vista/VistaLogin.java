package vista;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class VistaLogin extends JFrame{
    
    JPanel ImageThingCosa = new JPanel();
    
    ImageIcon ImLogin = new ImageIcon(getClass().getResource("/imagenes/loginbg.png"));
    public JLabel LblLogin = new JLabel(ImLogin);
    
    ImageIcon ImVerContra = new ImageIcon(getClass().getResource("/imagenes/verContra.png"));
    public JLabel LblVerContra = new JLabel(ImVerContra);
    
    ImageIcon ImOcutarContra = new ImageIcon(getClass().getResource("/imagenes/ocultarContra.png"));
    public JLabel LblOcutarContra = new JLabel(ImOcutarContra);
    
    ImageIcon ImUsuarioIcon = new ImageIcon(getClass().getResource("/imagenes/usuario.png"));
    public JLabel LblUsuarioIcon = new JLabel(ImUsuarioIcon);
    
    ImageIcon ImIniciar = new ImageIcon(getClass().getResource("/imagenes/Iniciar.png"));
    public JLabel LblIniciar = new JLabel(ImIniciar);
    
    ImageIcon ImSesion = new ImageIcon(getClass().getResource("/imagenes/Sesion.png"));
    public JLabel LblSesion = new JLabel(ImSesion);
    
    ImageIcon ImUser = new ImageIcon(getClass().getResource("/imagenes/User.png"));
    public JLabel LblUsuario = new JLabel(ImUser);
    
    ImageIcon ImLock = new ImageIcon(getClass().getResource("/imagenes/Lock.png"));
    public JLabel LblPassword = new JLabel(ImLock);
    

    JLabel LblRemember = new JLabel("Recordar Usuario");
    JCheckBox ChkRecordar = new JCheckBox();
    JTextField TxtUsuario = new JTextField();
    public JPasswordField TxtPassword = new JPasswordField();
    JButton BtnLogin = new JButton("Login");
    
    
    public VistaLogin(){
        configuracion();
        agregarComponentes();
    }

    private void configuracion() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.setSize(ImLogin.getIconWidth(),ImLogin.getIconHeight());
        this.setLocationRelativeTo(null); 
        
        this.setUndecorated(true);

        this.getContentPane().setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        this.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        
        ImageThingCosa.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        ImageThingCosa.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        
        
        
        this.setAlwaysOnTop(true);
        this.add(ImageThingCosa);
    }
    
    GridBagConstraints c = new GridBagConstraints();
    GridBagConstraints d = new GridBagConstraints();
    GridBagConstraints e = new GridBagConstraints();
    GridBagConstraints f = new GridBagConstraints();
    GridBagConstraints g = new GridBagConstraints();
    GridBagConstraints h = new GridBagConstraints();
    GridBagConstraints i = new GridBagConstraints();
    GridBagConstraints j = new GridBagConstraints();
    GridBagConstraints k = new GridBagConstraints();
    GridBagConstraints l = new GridBagConstraints();
    GridBagConstraints m = new GridBagConstraints();
    GridBagConstraints n = new GridBagConstraints();
    
    private void agregarComponentes() {
        LblLogin.setLayout(new GridBagLayout());
        
        
        // TxtUsuario
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(-50,89,0,30);
        TxtUsuario.setToolTipText("Ingresa Tu Usuario");
        LblLogin.add(TxtUsuario, c);
        
        
        // LblOcutarContra
        m.fill = GridBagConstraints.CENTER;
        m.gridx = 0;
        m.gridy = 0;
        m.insets = new Insets(50,250,0,0);
        LblLogin.add(LblOcutarContra, m);
        
        
        // LblVerContra
        n.fill = GridBagConstraints.CENTER;
        n.gridx = 0;
        n.gridy = 0;
        n.insets = new Insets(50,250,0,0);
        LblLogin.add(LblVerContra, n);
        
        
        // TxtPassword
        e.fill = GridBagConstraints.HORIZONTAL;
        e.gridx = 0;
        e.gridy = 0;
        e.insets = new Insets(50,89,0,30);
        TxtPassword.setToolTipText("Ingresa Tu Contraseña");
        LblLogin.add(TxtPassword, e);
        
        
        
        // BtnLogin
        d.fill = GridBagConstraints.CENTER;
        d.gridx = 0;
        d.gridy = 0;
        d.insets = new Insets(200,200,0,0);
        LblLogin.add(BtnLogin, d);
        
        
        // LblUsuarioIcon
        f.fill = GridBagConstraints.CENTER;
        f.gridx = 0;
        f.gridy = 0;
        f.insets = new Insets(-315,40,0,0);
        LblLogin.add(LblUsuarioIcon, f);
        
        
        // LblIniciar
        g.fill = GridBagConstraints.CENTER;
        g.gridx = 0;
        g.gridy = 0;
        g.insets = new Insets(-180,-40,0,0);
        LblLogin.add(LblIniciar, g);
        
        
        // LblSesion
        h.fill = GridBagConstraints.CENTER;
        h.gridx = 0;
        h.gridy = 0;
        h.insets = new Insets(-180,110,0,0);
        LblLogin.add(LblSesion, h);
        
        
        // LblUser
        i.fill = GridBagConstraints.CENTER;
        i.gridx = 0;
        i.gridy = 0;
        i.insets = new Insets(-50,-160,0,0);
        LblLogin.add(LblUsuario, i);
        
        
        // LblLock
        j.fill = GridBagConstraints.CENTER;
        j.gridx = 0;
        j.gridy = 0;
        j.insets = new Insets(50,-160,0,0);
        LblLogin.add(LblPassword, j);
        
        
        // LblRemember
        k.fill = GridBagConstraints.CENTER;
        k.gridx = 0;
        k.gridy = 0;
        k.insets = new Insets(200,-40,0,0);
        LblLogin.add(LblRemember, k);
        
        
        // ChkRecordar
        l.fill = GridBagConstraints.CENTER;
        l.gridx = 0;
        l.gridy = 0;
        l.insets = new Insets(200,80,0,0);
        ChkRecordar.setOpaque(false);
        LblLogin.add(ChkRecordar, l);
        
        ImageThingCosa.add(LblLogin);
        this.pack();
    }
}
