package com.ard.oosd.a.events;

import java.util.Vector;

/**
 * All the classes that act as the source of events should implement this interface.
 * @author arko
 *
 */
public interface SourceInterface {
	Vector<ListenerInterface> _listeners = new Vector<>();

	/**
	 * Adds a listener to the list
	 * @param listener object to add
	 */
	default void addListener(ListenerInterface listener){
	    _listeners.add(listener);
    }

    /**
     * Methods to invoke when the event is fired.
     */
    default void fireEvent() {
        if(!_listeners.isEmpty()) {
            for (ListenerInterface listenerInterface : _listeners) {
                listenerInterface.fireEvent();
            }
        }
    }
}
