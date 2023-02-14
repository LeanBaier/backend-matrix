package decorator;

public class Main {

    public static void main(String[] args){
        System.out.println("\n");
        Dibujable dibujable = new FormaBasica();
        dibujable.dibujar(0);
        System.out.println("\n");
        dibujable = new Rectangulo(dibujable);
        dibujable.dibujar(0);
        System.out.println("\n");
        dibujable = new Circulo(dibujable);
        dibujable.dibujar(0);

    }

}
