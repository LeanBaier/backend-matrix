package strategy;

public class PerroRunStrategy implements RunStrategy {
    private String nombre;

    public PerroRunStrategy(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run(int distancia) {
        StringBuilder sb = new StringBuilder();
        sb.append("El perro ");
        sb.append(this.nombre);
        sb.append(" esta corriendo: ");
        sb.append(distancia);
        sb.append(" Km.");
        System.out.println(sb);
    }
}
