package strategy;

public class PersonaRunStrategy implements RunStrategy {

    private String nombre;
    private String apellido;

    public PersonaRunStrategy(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;

    }

    @Override
    public void run(int distancia) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.nombre);
        sb.append(" ");
        sb.append(this.apellido);
        sb.append(" esta corriendo: ");
        sb.append(distancia);
        sb.append(" Km.");
        System.out.println(sb);
    }
}
