package ch.zhaw.it.cadprototyp.tablemodel.observerpattern;

public record ObservableEvent<T> (T oldValue, T newValue) {

}
