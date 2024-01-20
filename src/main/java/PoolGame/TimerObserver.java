package PoolGame;

public class TimerObserver implements Observer{
    /**
     * Game instance
     */
    public Game game;
    /**
     * timer seconds
     */
    public int s;
    /**
     * timer minutes
     */
    public int m;

    /**
     * construct TimerObserver with Game instace
     * @param game
     */

    public TimerObserver(Game game) {
        this.game = game;
    }

    public String info;

    /**
     *
     * @return formatted string of timer
     */
    public String getInfo() {
        return this.info;
    }

    public int getMin() {
        return this.m;
    }
    public int getSec() {
        return this.s;
    }

    public void reset() {
        this.s = 0;
        this.m = 0;
    }
    public void setTimer(int m, int s) {
        this.m = m;
        this.s = s;
    }
    public void update() {
        if (this.game.frame == 59) {
            s++;
            this.game.frame = 0;
        }
        if (s == 59) {
            m++;
            s = 0;
        }
        if (m == 59) {
            System.out.println("Game over");
        }
        this.info = String.format("Timer--%d:%d", this.m, this.s);

    }


}
