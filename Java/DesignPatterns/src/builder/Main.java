package builder;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Persona.PersonaBuilder("Leandro").apellido("Baier").fechaNacimiento(new Date()).build().toString());
        System.out.println(new Persona.PersonaBuilder("Leandro").build().toString());
    }

}
