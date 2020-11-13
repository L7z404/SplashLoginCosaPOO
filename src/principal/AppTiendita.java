package principal;


import controlador.ControladorVistaSplash;

import vista.VistaSplash;

public class AppTiendita {
    public static void main(String[] args){
        VistaSplash VistaSplah = new VistaSplash();
        ControladorVistaSplash ControladorSplash = new ControladorVistaSplash(VistaSplah); 
    }
}
