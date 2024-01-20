package PoolGame;

import java.util.ArrayList;
import java.util.List;

public class StateCaretaker {
    /**
     * memento state
     */
    public StateMemento state;

    /**
     * set memento
     * @param state
     */
    public void setMemento(StateMemento state) {
        this.state = (state);
    }

    /**
     * get memento
     * @return
     */
    public StateMemento getMemento() {
        return this.state;
    }

    /**
     * remove memento
     */
    public void removeMemento() {
        this.state = null;
    }
}
