package PoolGame;

public interface Observer {
    /**
     * update observer
     */
    public void update();

    /**
     * return minute of timer
     * @return minute of timer
     */
    public int getMin();

    /**
     * return second of timer
     * @return second of timer
     */
    public int getSec();

    /**
     * formatted string
     * @return
     */
    public String getInfo();

    /**
     * set timer with minute adn second
     * @param m minute of timer
     * @param s second of timer
     */
    public void setTimer(int m, int s);

    /**
     * reset timer
     */
    public void reset();

}

