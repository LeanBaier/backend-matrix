package decorator;

public class Circulo extends DibujableDecorator{
    public Circulo(Dibujable dibujable) {
        super(dibujable);
    }

    @Override
    public void dibujar(Integer i){
        super.dibujar(++i);
        System.out.println(i + "Dibujando Circulo.");
    }
}
