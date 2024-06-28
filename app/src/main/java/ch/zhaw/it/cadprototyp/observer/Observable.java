package ch.zhaw.it.cadprototyp.observer;


/**
 * Generic observable interface for the observer pattern.
 *
 * @param <T> the type of the observed value
 */
public interface Observable<T> {

    /**
     * Add an Observer to the list of Observers.
     *
     * @param observer the Observer to be added
     */
    void addObserver(Observer<T> observer);

    /**
     * Remove an Observer from the list of Observers.
     *
     * @param observer the Observer to be removed
     */
    void removeObserver(Observer<T> observer);

    /**
     * Notify all Observers of this Observable that the property has changed.
     *
     * @param oldValue the old value of the observed object
     * @param newValue the new value of the observed object
     */
    void notifyObserver(T oldValue, T newValue);
}
