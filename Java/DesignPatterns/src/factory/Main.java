package factory;

public class Main {
    public static void main(String[] args) {
        System.out.println(Factory.buildHandler(TipoAccion.ACCION_1).getName());
        System.out.println(Factory.buildHandler(TipoAccion.ACCION_2).getName());
        System.out.println(Factory.buildHandler(TipoAccion.ACCION_3).getName());
        System.out.println(Factory.buildHandler(TipoAccion.ACCION_4).getName());
    }
}