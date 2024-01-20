package PoolGame;

import PoolGame.Items.Ball;

import java.util.List;

public class StateMemento {
    /**
     * list of balls that will be captured
     */
    private List<Ball> state;
    /**
     * timer minute
     */
    private int m;
    /** timer second;
     *
     */
    private int s;

    private int score;
    public StateMemento(List<Ball> state, int m, int s, int score) {
        this.state = state;
        this.m = m;
        this.s = s;
        this.score = score;
    }
    public void setState(List<Ball> balls) {
        this.state =  balls;
    }

    /**
     * get state
     * @return saved list of ball
     */
    public List<Ball> getState() {
        return this.state;
    }

    /**
     * get minutes of timer
     * @return minutes of tiemr
     */
    public int getMinute() {
        return this.m;
    }

    /**
     * get seconds of timer
     * @return seconds of tiemr
     */
    public int getSecond() {
        return this.s;
    }

    /**
     * get score
     * @return score of game
     */
    public int getScore() {
        return this.score;
    }

}
