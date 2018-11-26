package view;

import event.Event;

/*
 * Basic interface for all views to implement in order to register as listeners to the models
 * This way all the models can notify the views using the same interface
 */
public interface Listener {
    void handleEvent(Event e);
}
