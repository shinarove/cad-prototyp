package ch.zhaw.it.cadprototyp.tablemodel.observerpattern;

import java.util.Enumeration;

public interface Observer<E> {

    void update(E propertyName, ObservableEvent<?> event);
}
