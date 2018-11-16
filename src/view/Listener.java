package view;

import event.BoardEvent;

public interface Listener {
    void handleEvent(BoardEvent e);
}
