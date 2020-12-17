package e1;

public interface modoFun {
    default void  funcionar(Termostato termostato) {
     throw new UnsupportedOperationException();
    }

    default void funcionar(Termostato termostato, int time) {
       // throw new UnsupportedOperationException();
    }

    default void funcionar(Termostato termostato, float temperature) {
       // throw new UnsupportedOperationException();
    }

    default void screenInfo(Termostato termostato) {
       // throw new UnsupportedOperationException();
    }
}
