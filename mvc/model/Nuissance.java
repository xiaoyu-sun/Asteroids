package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;

public class Nuissance extends NewShipFloater {

    public static final double PULL = 0.25;
    private static final int MIN_DIST_FROM_FALCON = 500;
    private Falcon falcon;

    public Nuissance(Falcon falcon) {
        super();
        this.falcon = falcon;
        setTeam(Team.FOE);
        setColor(Color.ORANGE);

        // set the random starting position of nuissance
        // set its distance from falcon to be at least 500 (to give players some time to react!)
        do {
            int x = Game.R.nextInt(Game.DIM.width);
            int y = Game.R.nextInt(Game.DIM.height);
            setCenter(new Point(x, y));
        } while (Math.sqrt(Math.pow(getCenter().getX() - falcon.getCenter().getX(), 2) +
                Math.pow(getCenter().getY() - falcon.getCenter().getY(), 2)) < MIN_DIST_FROM_FALCON);
    }

    @Override
    public void move() {
        super.move();
        Point myCenter = getCenter();
        Point falCenter = falcon.getCenter();

        if (myCenter.x > falCenter.x){
            setDeltaX(getDeltaX() - PULL);
        } else {
            setDeltaX(getDeltaX() + PULL);
        }
        if (myCenter.y > falCenter.y){
            setDeltaY(getDeltaY() - PULL);
        } else {
            setDeltaY(getDeltaY() + PULL);
        }


    }
}
