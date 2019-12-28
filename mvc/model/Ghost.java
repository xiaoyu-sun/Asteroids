package _08final.mvc.model;

import _08final.mvc.controller.Game;

import java.awt.*;
import java.util.ArrayList;

public class Ghost extends Sprite {

    public Ghost() {
        super();
        setTeam(Team.FOE);

        //random delta-x
        int nDX = Game.R.nextInt(10);
        if(nDX %2 ==0)
            nDX = -nDX;
        setDeltaX(nDX);
        //random delta-y
        int nDY = Game.R.nextInt(10);
        if(nDY %2 ==0)
            nDY = -nDY;
        setDeltaY(nDY);

        setColor(Color.YELLOW);
        ArrayList<Point> pntCs = new ArrayList<Point>();
        pntCs.add(new Point(0,0));
        pntCs.add(new Point(0,9));
        pntCs.add(new Point(2,9));
        pntCs.add(new Point(3,8));
        pntCs.add(new Point(3,6));
        pntCs.add(new Point(5,6));
        pntCs.add(new Point(6,5));
        pntCs.add(new Point(6,4));
        pntCs.add(new Point(5,3));
        pntCs.add(new Point(3,3));
        pntCs.add(new Point(3,1));
        pntCs.add(new Point(2,0));
        assignPolarPoints(pntCs);

        setCenter(new Point(Game.R.nextInt(Game.DIM.width),
                Game.R.nextInt(Game.DIM.height)));
        setRadius(35);
        setExpire(400);
    }

    @Override
    public void move() {
        super.move();
        if (getExpire() == 0) {
            CommandCenter.getInstance().getOpsList().enqueue(this, CollisionOp.Operation.REMOVE);
        }
        else {
            setExpire(getExpire() - 1);
        }

        if (getExpire() % 150 == 0) {
            CommandCenter.getInstance().getOpsList().enqueue(
                    new HeatSeekingMissile(this, CommandCenter.getInstance().getFalcon()),
                    CollisionOp.Operation.ADD);
        }
    }
}
