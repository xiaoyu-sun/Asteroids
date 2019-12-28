package _08final.mvc.model;

import java.awt.*;
import java.util.ArrayList;

public class HeatSeekingMissile extends Sprite {

    private final double MISSILE_SPEED = 5.5;

    //private Falcon falcon;

    public HeatSeekingMissile(Ghost ghost, Falcon falcon) {

        super();
        //this.falcon = falcon;

        setTeam(Team.FOE);
        setColor(Color.MAGENTA);

        ArrayList<Point> pntCs = new ArrayList<Point>();
        pntCs.add(new Point(0,10));
        pntCs.add(new Point(1,7));
        pntCs.add(new Point(1,0));
        pntCs.add(new Point(2,-1));
        pntCs.add(new Point(0,0));
        pntCs.add(new Point(-2,-1));
        pntCs.add(new Point(-1,0));
        pntCs.add(new Point(-1,7));
        assignPolarPoints(pntCs);

        setRadius(35);
        setCenter(ghost.getCenter());

        double dRadians = computeAngle();
        setDeltaX(MISSILE_SPEED * Math.cos(dRadians));
        setDeltaY(MISSILE_SPEED * Math.sin(dRadians));
        setOrientation((int) Math.toDegrees(dRadians));

    }

    @Override
    public void move() {
        super.move();
        Point myCenter = getCenter();
        Point falCenter = CommandCenter.getInstance().getFalcon().getCenter();

        // adjust the direction according to real-time position of falcon
        double dRadians = computeAngle();
        setDeltaX(MISSILE_SPEED * Math.cos(dRadians));
        setDeltaY(MISSILE_SPEED * Math.sin(dRadians));
        setOrientation((int) Math.toDegrees(computeAngle()));
    }

    private double computeAngle() {
        double dRadians = Math.atan2(CommandCenter.getInstance().getFalcon().getCenter().y - this.getCenter().y,
                CommandCenter.getInstance().getFalcon().getCenter().x - this.getCenter().x);
        return dRadians;
    }

}
