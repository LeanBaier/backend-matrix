package singleton;

import java.util.Objects;

public class Singleton {

    private static Singleton obj;

    private Singleton() {

    }

    public static Singleton getObj() {
        if (Objects.isNull(obj)) {
            obj = new Singleton();
        }
        return obj;
    }

}
