package com.otto.testapp.robo.domainobject;

import com.otto.testapp.robo.domainvalue.*;

public class BotNextMoveDO {

    private Postion nextPosition;

    private Direction direction;

    public Postion getNextPosition() {
        return nextPosition;
    }

    public void setNextPosition(Postion nextPosition) {
        this.nextPosition = nextPosition;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
