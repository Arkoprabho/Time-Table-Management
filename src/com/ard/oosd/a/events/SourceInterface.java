/**
 * 
 */
package com.ard.oosd.a.events;

import java.util.Vector;

/**
 * All the classes that act as the source of events should implement this interface.
 * @author arko
 *
 */
public interface SourceInterface {
	Vector<ListenerInterface> _listeners = new Vector<ListenerInterface>();
	void addListener(ListenerInterface listener);
	void fireEvent();
}
