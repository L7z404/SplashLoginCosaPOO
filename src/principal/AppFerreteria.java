package principal;


import controlador.ControladorVistaSplash;

import vista.VistaSplash;

public class AppFerreteria {
    public static void main(String[] args){
        VistaSplash VistaSplah = new VistaSplash();
        ControladorVistaSplash ControladorSplash = new ControladorVistaSplash(VistaSplah); 
        
    }
}
