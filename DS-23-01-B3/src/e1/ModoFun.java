package e1;

public interface ModoFun {

    default void manual(Termostato termostato) {
        throw new UnsupportedOperationException();
    }

    default void apagar(Termostato termostato) {
        throw new UnsupportedOperationException();
    }
    default void timer(Termostato termostato, int time) {
        throw new UnsupportedOperationException();
    }

    default void program(Termostato termostato, float temperature) {
        throw new UnsupportedOperationException();
    }

    default void screenInfo(Termostato termostato) {
        throw new UnsupportedOperationException();
    }
}
