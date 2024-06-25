package ch.zhaw.it.cadprototyp.observer;

/**
 * Generic observer interface for the observer pattern.
 *
 * @param <T> the type of the observed value
 */
public interface Observer<T> {

    /**
     * Update method called by the Observable, when the observed object changes.
     *
     * @param oldValue the old value of the observed object
     * @param newValue the new value of the observed object
     */
    void update(T oldValue, T newValue);
}
