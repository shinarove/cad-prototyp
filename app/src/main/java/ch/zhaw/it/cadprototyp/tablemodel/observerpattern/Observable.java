package ch.zhaw.it.cadprototyp.tablemodel.observerpattern;

import java.util.ArrayList;
import java.util.List;

public class Observable<T, E> {

    private final E propertyName;
    private final List<Observer<E>> observers = new ArrayList<>();

    public Observable(E propertyName) {
        this.propertyName = propertyName;
    }

    public void addObserver(Observer<E> observer){
        observers.add(observer);
    }

    public void removeObserver(Observer<E> observer){
        observers.remove(observer);
    }

    public void fireUpdate(ObservableEvent<T> event){
        for(Observer<E> observer : observers){
            observer.update(propertyName, event);
        }
    }

    public void fireUpdate(T oldValue, T newValue) {
        fireUpdate(new ObservableEvent<>(oldValue, newValue));
    }
}
