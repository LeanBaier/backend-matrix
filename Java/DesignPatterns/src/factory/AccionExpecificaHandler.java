package factory;

public abstract class AccionExpecificaHandler <O>{

    public String getName(){
        return this.getClass().getSimpleName();
    }

}
