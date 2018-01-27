package com.otto.testapp.robo.domainobject;

import java.util.*;

import com.otto.testapp.robo.domainvalue.*;

public class BotCommandSequenceCreater {

    private static char[][] solMatrix;

    private static InitialConditionInputDO initialConditionInput;

    private static Postion finalBotPosition;

    private Direction recentDirection;

    public BotCommandSequenceCreater(char[][] solutionMatrix, InitialConditionInputDO initialConditionInputDO) {
        solMatrix = solutionMatrix;
        initialConditionInput = initialConditionInputDO;
    }

    public BotCommandSequenceDO createBotCommands() {
        BotCommandSequenceDO botCommandSequence = new BotCommandSequenceDO();
        finalBotPosition = initialConditionInput.getFinalBotPosition();

        Postion currentBotPosition = initialConditionInput.getInitialBotPosition();
        Direction currentDirection = initialConditionInput.getInitialBotDirection();

        List<String> commandSequenceList = new ArrayList<String>();

        while (!isTargetReached(currentBotPosition)) {

            BotNextMoveDO botNextMove = calucateNextMove(currentBotPosition);

            if (botNextMove.getDirection()
                           .equals(currentDirection)) {
                currentBotPosition = botNextMove.getNextPosition();
                commandSequenceList.add(Step.FORWARD.toString());
                recentDirection = currentDirection;
            } else {
                commandSequenceList.add(botNextMove.getDirection()
                                                   .toString());
                commandSequenceList.add(Step.FORWARD.toString());

                currentDirection = turnBot(botNextMove.getDirection());
                recentDirection = currentDirection;
                currentBotPosition = botNextMove.getNextPosition();

            }
        }
        botCommandSequence.setBotCommandSequence(commandSequenceList);
        return botCommandSequence;
    }

    private boolean isTargetReached(Postion currentBotPosition) {

        Boolean targetReached = currentBotPosition.getXPosition()
                                                  .equals(finalBotPosition.getXPosition())
                && currentBotPosition.getYPosition()
                                     .equals(finalBotPosition.getYPosition());

        return targetReached;
    }

    private BotNextMoveDO calucateNextMove(Postion currentBotPosition) {

        BotNextMoveDO botNextMove = new BotNextMoveDO();

        Direction direction = Direction.NORTH;

        Postion nextPossiblePosition = new Postion();

        // go north take absolute value
        if (isNorthFree(currentBotPosition) && recentDirection != Direction.SOUTH) {
            nextPossiblePosition = moveForwardTowardNorth(currentBotPosition);
            direction = Direction.NORTH;
        }

        // go east take absolute value
        if (isEastFree(currentBotPosition) && recentDirection != Direction.WEST) {
            nextPossiblePosition = moveForwardTowardEast(currentBotPosition);
            direction = Direction.EAST;
        }

        // go south take absolute value
        if (isSouthFree(currentBotPosition) && recentDirection != Direction.NORTH) {
            nextPossiblePosition = moveForwardTowardSouth(currentBotPosition);
            direction = Direction.SOUTH;
        }

        // go west take absolute value
        if (isWestFree(currentBotPosition) && recentDirection != Direction.EAST) {
            nextPossiblePosition = moveForwardTowardWest(currentBotPosition);
            direction = Direction.WEST;
        }

        botNextMove.setNextPosition(nextPossiblePosition);
        botNextMove.setDirection(direction);
        return botNextMove;
    }

    private Postion moveForwardTowardNorth(Postion botCurrentPosition) {
        Postion forwardPosition = new Postion();
        forwardPosition.setXPosition(botCurrentPosition.getXPosition() - 1);
        forwardPosition.setYPosition(botCurrentPosition.getYPosition());
        return forwardPosition;
    }

    private Postion moveForwardTowardSouth(Postion botCurrentPosition) {
        Postion forwardPosition = new Postion();
        forwardPosition.setXPosition(botCurrentPosition.getXPosition() + 1);
        forwardPosition.setYPosition(botCurrentPosition.getYPosition());
        return forwardPosition;
    }

    private Postion moveForwardTowardEast(Postion botCurrentPosition) {
        Postion forwardPosition = new Postion();
        forwardPosition.setXPosition(botCurrentPosition.getXPosition());
        forwardPosition.setYPosition(botCurrentPosition.getYPosition() + 1);
        return forwardPosition;
    }

    private Postion moveForwardTowardWest(Postion botCurrentPosition) {
        Postion forwardPosition = new Postion();
        forwardPosition.setXPosition(botCurrentPosition.getXPosition());
        forwardPosition.setYPosition(botCurrentPosition.getYPosition() - 1);
        return forwardPosition;
    }

    private Direction turnBot(Direction newdirection) {
        switch (newdirection.toString()) {
        case "NORTH":
            newdirection = Direction.NORTH;
            break;
        case "SOUTH":
            newdirection = Direction.SOUTH;
            break;
        case "EAST":
            newdirection = Direction.EAST;
            break;
        case "WEST":
            newdirection = Direction.WEST;
            break;
        }
        return newdirection;
    }

    private Boolean isNorthFree(Postion botCurrentPosition) {
        if (botCurrentPosition.getXPosition() == 0) {
            return false;
        }
        return solMatrix[botCurrentPosition.getXPosition() - 1][botCurrentPosition.getYPosition()] != 'X' ? true
                : false;
    }

    private Boolean isSouthFree(Postion botCurrentPosition) {
        if (botCurrentPosition.getXPosition() == solMatrix[0].length - 1) {
            return false;
        }
        return solMatrix[botCurrentPosition.getXPosition() + 1][botCurrentPosition.getYPosition()] != 'X' ? true
                : false;
    }

    private Boolean isEastFree(Postion botCurrentPosition) {
        if (botCurrentPosition.getYPosition() == solMatrix[0].length - 1) {
            return false;
        }

        return solMatrix[botCurrentPosition.getXPosition()][botCurrentPosition.getYPosition() + 1] != 'X' ? true
                : false;
    }

    private Boolean isWestFree(Postion botCurrentPosition) {
        if (botCurrentPosition.getYPosition() == 0) {
            return false;
        }
        return solMatrix[botCurrentPosition.getXPosition()][botCurrentPosition.getYPosition() - 1] != 'X' ? true
                : false;
    }
}
