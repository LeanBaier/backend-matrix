package decorator;

public class DibujableDecorator implements Dibujable{

    protected Dibujable dibujable;

    public DibujableDecorator(Dibujable dibujable){
        this.dibujable = dibujable;
    }

    @Override
    public void dibujar(Integer i) {
        dibujable.dibujar(i);
    }
}
