package factory;

import factory.acciones.TipoAccion1;
import factory.acciones.TipoAccion2;
import factory.acciones.TipoAccion3;
import factory.acciones.TipoAccion4;

public class Factory {

    public static <H extends AccionExpecificaHandler<O>, O> H buildHandler(TipoAccion tipoAccion) {
        H handler = null;
        switch (tipoAccion) {
            case ACCION_1:
                handler = (H) new TipoAccion1();
                break;
            case ACCION_2:
                handler = (H) new TipoAccion2();
                break;
            case ACCION_3:
                handler = (H) new TipoAccion3();
                break;
            default:
                handler = (H) new TipoAccion4();
                break;
        }
        return handler;
    }

}
