package PoolGame.Config;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;

public class PocketConfig implements Configurable{
    private double x;
    private double y;
    private double radius;
    public PocketConfig(Object obj) {
        this.parseJSON(obj);
    }
    private void init(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public Configurable parseJSON(Object obj) {
        JSONObject json = (JSONObject) obj;
        double radius = (Double)json.get("radius");
        JSONObject positionObj = (JSONObject) json.get("position");
        double x = (Double) positionObj.get("x");
        double y = (Double) positionObj.get("y");
        this.init(x, y, radius);
        return null;
    }
    public double getX() {return this.x;}
    public double getY() {return this.y;}
    public double getRadius() {return this.radius;}

}
