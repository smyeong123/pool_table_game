package PoolGame;

import java.util.ArrayList;
import java.util.List;

import PoolGame.Builder.BallBuilderDirector;
import PoolGame.Config.BallConfig;
import PoolGame.Config.PocketConfig;
import PoolGame.Items.Ball;
import PoolGame.Items.Pocket;
import PoolGame.Items.PoolTable;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

/** The game class that runs the game */
public class Game {
    public Observer o;
    public int frame = 0;
    public int score = 0;

    public boolean rollBacked = false;

    StateCaretaker caretaker;


    private PoolTable table;
    private boolean shownWonText = false;

    private final Text winText = new Text(50, 50, "Win and Bye");
    private Text timer = new Text();
    private Text scoreText = new Text();
    /**
     * Initialise the game with the provided config
     * @param config The config parser to load the config from
     */
    public Game(ConfigReader config) {
        this.setup(config);
    }

    public void inform() {
        if (o != null) {
            this.o.update();
        }
    }

    private void setup(ConfigReader config) {
        this.o = new TimerObserver(this);

        this.table = new PoolTable(config.getConfig().getTableConfig());
        List<BallConfig> ballsConf = config.getConfig().getBallsConfig().getBallConfigs();
        List<Ball> balls = new ArrayList<>();
        BallBuilderDirector builder = new BallBuilderDirector();
        builder.registerDefault();
        for (BallConfig ballConf: ballsConf) {
            Ball ball = builder.construct(ballConf);
            if (ball == null) {
                System.err.println("WARNING: Unknown ball, skipping...");
            } else {
                balls.add(ball);
            }
        }
        this.table.setupBalls(balls);

        //TODO configure pockets
        List<Pocket> pockets = new ArrayList<>();
        List<PocketConfig> pocketsConf = config.getConfig().getTableConfig().getPocketsConf();
        for(PocketConfig p : pocketsConf) {
            pockets.add(new Pocket(p.getX(), p.getY(), p.getRadius()));
        }
        this.table.setPockets(pockets);

        this.winText.setVisible(false);
        this.winText.setX(table.getDimX() / 2);
        this.winText.setY(table.getDimY() / 2);

        //set states
        this.caretaker = new StateCaretaker();
        this.caretaker.setMemento(saveState());
    }
    /**
     * Save state
     * @return StateMomento
      */
    public StateMemento saveState() {
        List<Ball> clonedBalls = new ArrayList<>();
        for(Ball ball : this.table.getBalls()) {
            Ball cBall = (Ball) ball.clone();
            clonedBalls.add(cBall);
        }
        return new StateMemento(clonedBalls, this.o.getMin(), this.o.getSec(), this.score);
    }


     /**
     * Rollback returns
     */
    public void rollBack(StateMemento state) {
        if (this.caretaker.getMemento() != null) {
            this.table.rollBack(state.getState());
            this.o.setTimer(state.getMinute(), state.getSecond());
            this.frame = 0;
            this.score = state.getScore();
            this.rollBacked = true;
        }
    }

    /**
     * Check if all balls on table have been stopped
     * @return boolean type of result
     */
    public boolean allBallsStopped() {
        for (Ball ball : this.table.getBalls()) {
            if (!ball.hasStopped()) {
                return false;
            }
        }
        return true;
    }
    public void cheatBall(String color) {
        for (Ball ball : this.table.getBalls()) {
            if (!ball.isDisabled()) {
                if (ball.getColour().equals(Paint.valueOf("red")) && color == "red") {
                    this.score += 1;
                    ball.disable();
                }else if (ball.getColour().equals(Paint.valueOf("yellow")) && color == "yellow") {
                    this.score += 2;
                    ball.disable();
                }else if (ball.getColour().equals(Paint.valueOf("green")) && color == "green") {
                    this.score += 3;
                    ball.disable();
                }else if (ball.getColour().equals(Paint.valueOf("brown")) && color == "brown") {
                    this.score += 4;
                    ball.disable();
                }else if (ball.getColour().equals(Paint.valueOf("blue")) && color == "blue") {
                    this.score += 5;
                    ball.disable();
                }else if (ball.getColour().equals(Paint.valueOf("purple")) && color == "purple") {
                    this.score += 6;
                    ball.disable();
                }else if (ball.getColour().equals(Paint.valueOf("black")) && color == "black") {
                    this.score += 7;
                    ball.disable();
                }else if (ball.getColour().equals(Paint.valueOf("orange")) && color == "orange") {
                    this.score += 8;
                    ball.disable();
                }
            }

        }
    }


    /**
     * Get the window dimension in the x-axis
     * @return The x-axis size of the window dimension
     */
    public double getWindowDimX() {
        return this.table.getDimX();
    }

    /**
     * Get the window dimension in the y-axis
     * @return The y-axis size of the window dimension
     */
    public double getWindowDimY() {
        return this.table.getDimY();
    }

    /**
     * Get the pool table associated with the game
     * @return The pool table instance of the game
     */
    public PoolTable getPoolTable() {
        return this.table;
    }

    /** Add all drawable object to the JavaFX group
     * @param root The JavaFX `Group` instance
    */
    public void addDrawables(Group root) {
        ObservableList<Node> groupChildren = root.getChildren();
        table.addToGroup(groupChildren);
        groupChildren.add(this.winText);
        groupChildren.add(this.timer);
        groupChildren.add(this.scoreText);
        Text instruction = new Text(800, 50, "* Press `r` to remove all red balls\n" +
                "* Press `y` to remove all yellow balls\n" +
                "* Press `g` to remove all green balls\n" +
                "* Press `b` to remove all brown balls\n" +
                "* Press `e` to remove all blue balls\n" +
                "* Press `p` to remove all purple balls\n" +
                "* Press `l` to remove all black balls\n" +
                "* Press `o` to remove all orange balls.");
        groupChildren.add(instruction);
    }

    /** Reset the game */
    public void reset() {
        this.winText.setVisible(false);
        this.shownWonText = false;
        this.table.reset();
        this.score = 0;
        this.frame = 0;
        this.caretaker.setMemento(saveState());
        this.o.reset();
    }
    public boolean isDiff(List<Ball> balls, List<Ball> cBalls) {
        if (balls.size() != cBalls.size()){
            return true;
        }
        for (int i = 0 ; i < balls.size() ; i++) {
            if (balls.get(i).getXPos() != cBalls.get(i).getXPos()) {
                return true;
            }
            if (balls.get(i).getYPos() != cBalls.get(i).getYPos()) {
                return true;
            }
        }
        return false;
    }

    /** Code to execute every tick. */
    public void tick() {
        if (table.hasWon() && !this.shownWonText) {
            System.out.println(this.winText.getText());
            this.winText.setVisible(true);
            this.shownWonText = true;
        }
        table.checkPocket(this);
        table.handleCollision();
        this.table.applyFrictionToBalls();
        for (Ball ball : this.table.getBalls()) {
            ball.move();
        }


//        Memento operation
        if (allBallsStopped()) {
            if (isDiff(this.table.getBalls(),caretaker.getMemento().getState())) {
                caretaker.setMemento(saveState());
                System.out.println("changed");
                rollBacked = false;
            }
        }
        this.timer.setText( this.o.getInfo());
        // color of timer
        this.timer.setFill(Color.RED);
        this.timer.relocate(50,50);

        this.scoreText.setText("Score : " + Integer.toString(this.score));
        this.scoreText.setFill(Color.RED);
        this.scoreText.relocate(50,65);

        frame++;
        inform();
    }
}
