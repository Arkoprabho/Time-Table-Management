package com.ard.oosd.a.events;

import java.util.Enumeration;
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
	void addListener(ListenerInterface listener);

    /**
     * Methods to invoke when the event is fired.
     */
    default void fireEvent() {
        if(!_listeners.isEmpty()) {
            Enumeration enumeration = _listeners.elements();
            while (enumeration.hasMoreElements()) {
                ListenerInterface listenerInterface = (ListenerInterface)enumeration.nextElement();
                listenerInterface.fireEvent();
            }
        }
    }
}
