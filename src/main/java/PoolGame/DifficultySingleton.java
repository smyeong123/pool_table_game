package PoolGame;

import PoolGame.Items.Pocket;
import PoolGame.Items.PoolTable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Arrays;

public class DifficultySingleton {
    /**
     * one instance
     */
    private static DifficultySingleton instance = null;
    private DifficultySingleton() {

    }

    /**
     * Create new instance if instance is null.
     * Otherwise return existing one
     * @return instance of DifficultySingleton
     */
    public static DifficultySingleton getInstance() {
        if (instance == null) {instance = new DifficultySingleton();}
        return instance;
    }

    /**
     * this return path of configuration path by user option.
     * 1 for easy
     * 2 for normal
     * 3 for hard
     * @param configOpt option of button user selected
     * @return path of configuration path
     */
    public String getPath(int configOpt) {
        String path = "";
        if (configOpt == 1) {
            path = "src/main/resources/config_easy.json";
        }else if (configOpt == 2) {
            path = "src/main/resources/config_normal.json";
        }else if (configOpt == 3) {
            path = "src/main/resources/config_hard.json";
        }
        return path;
    }

}
