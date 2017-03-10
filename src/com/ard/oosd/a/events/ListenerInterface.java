package com.ard.oosd.a.events;

/**
 * All the classes that need to act as listeners should implement this interface.
 * @author arko
 *
 */
public interface ListenerInterface {
    /**
     * Methods to invoke when the event is fired.
     */
	void fireEvent();
}
