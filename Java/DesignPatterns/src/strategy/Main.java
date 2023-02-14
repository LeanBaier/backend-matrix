package strategy;

public class Main {

    public static void main(String[] args) {
        int distancia = 2;
        new PersonaRunStrategy("Leandro", "Baier").run(distancia);
        new PerroRunStrategy("Pilar").run(distancia);
    }

}
