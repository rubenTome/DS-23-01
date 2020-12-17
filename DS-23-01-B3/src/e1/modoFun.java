package e1;

public interface modoFun {
    default void  funcionar(Termostato termostato) {}

    default void funcionar(Termostato termostato, int time) {}

    default void funcionar(Termostato termostato, float temperature) {}

    default void screenInfo(Termostato termostato) {}
}
