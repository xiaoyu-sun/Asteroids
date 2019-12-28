package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.util.ArrayList;

public class ShieldFloater extends Sprite {

    public ShieldFloater() {

        super();
        setTeam(Team.FLOATER);

        ArrayList<Point> pntCs = new ArrayList<Point>();
        pntCs.add(new Point(0,4));
        pntCs.add(new Point(2,4));
        pntCs.add(new Point(2,1));
        pntCs.add(new Point(0,0));
        pntCs.add(new Point(-2,1));
        pntCs.add(new Point(-2,4));
        pntCs.add(new Point(0,4));
        assignPolarPoints(pntCs);

        setExpire(250);
        setRadius(40);
        setColor(Color.CYAN);

        int nX = Game.R.nextInt(8);
        int nY = Game.R.nextInt(8);
        if (nX % 2 == 0)
            setDeltaX(nX);
        else
            setDeltaX(-nX);
        if (nY % 2 == 0)
            setDeltaX(nY);
        else
            setDeltaX(-nY);

        setCenter(new Point(Game.R.nextInt(Game.DIM.width),
                Game.R.nextInt(Game.DIM.height))); // random point on the screen
        setOrientation(270);

    }

    @Override
    public void move() {
        super.move();
        if (getExpire() == 0)
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        else
            setExpire(getExpire() - 1);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.fillPolygon(getXcoords(), getYcoords(), dDegrees.length);
        g.setColor(Color.WHITE);
        g.drawPolygon(getXcoords(), getYcoords(), dDegrees.length);
    }

}
