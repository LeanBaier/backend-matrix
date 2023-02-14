package singleton;

public class Main {

    public static void main(String[] args){
        Singleton obj1 = Singleton.getObj();
        Singleton obj2 = Singleton.getObj();

        System.out.println(obj1.hashCode() == obj2.hashCode());
    }

}
