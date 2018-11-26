package event;

// Empty interface for event all events too implement
// This way all models can simply send a base Event object to listeners
// All listeners are gurenteed to handle event because of Listener interface
public interface Event {}
