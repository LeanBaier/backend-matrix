package decorator;

public class FormaBasica implements Dibujable{
    @Override
    public void dibujar(Integer i) {
        System.out.print(++i);
        System.out.println("Forma Basica.");

    }
}
