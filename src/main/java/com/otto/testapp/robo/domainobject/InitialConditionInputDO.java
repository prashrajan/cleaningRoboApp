package com.otto.testapp.robo.domainobject;

import com.otto.testapp.robo.domainvalue.*;

public class InitialConditionInputDO {

    private char[][] initialBotMatrix;

    private Postion initialBotPosition = new Postion();

    private Postion finalBotPosition = new Postion();

    private Direction initialBotDirection;

    public InitialConditionInputDO(char[][] matrix, int[] initialPosition, int[] finalPosition,
            char initialDirection) {
        this.initialBotMatrix = matrix;

        this.initialBotPosition.setXPosition(initialPosition[0]);
        this.initialBotPosition.setYPosition(initialPosition[1]);

        this.finalBotPosition.setXPosition(finalPosition[0]);
        this.finalBotPosition.setYPosition(finalPosition[1]);

        switch (String.valueOf(initialDirection)
                      .toUpperCase()) {
        case "N":
            this.initialBotDirection = Direction.NORTH;
            break;
        case "E":
            this.initialBotDirection = Direction.EAST;
            break;
        case "W":
            this.initialBotDirection = Direction.WEST;
            break;
        case "S":
            this.initialBotDirection = Direction.SOUTH;
            break;
        default:
            throw new AssertionError("Unknown Direction");
        }
    }

    public char[][] getInitialBotMatrix() {
        return this.initialBotMatrix;
    }

    public Postion getInitialBotPosition() {
        return this.initialBotPosition;
    }

    public Postion getFinalBotPosition() {
        return this.finalBotPosition;
    }

    public Direction getInitialBotDirection() {
        return this.initialBotDirection;
    }

}
