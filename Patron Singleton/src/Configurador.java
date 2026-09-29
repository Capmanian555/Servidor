public class Configurador {
    private String Configuracion;
    private  static Configurador INSTANCIA;
    private Configurador(){

    }
    public static Configurador obtenerInstancia(){
        if(INSTANCIA == null){
            INSTANCIA = new Configurador();
        }
        return  INSTANCIA;
    }

    public void establecerConfiguracion(String Configuracion){
         this.Configuracion = Configuracion;
    }

    public String getConfiguracion() {
        return Configuracion;
    }

}

