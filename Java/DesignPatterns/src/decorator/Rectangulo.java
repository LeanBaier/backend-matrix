package decorator;

public class Rectangulo extends DibujableDecorator{
    public Rectangulo(Dibujable dibujable) {
        super(dibujable);
    }

    @Override
    public void dibujar(Integer i){
        super.dibujar(++i);
        System.out.println(i + "Dibujando Rectangulo.");
    }
}
