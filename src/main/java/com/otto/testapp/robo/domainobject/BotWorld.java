package com.otto.testapp.robo.domainobject;

import org.slf4j.*;

import com.otto.testapp.robo.domainvalue.*;
import com.otto.testapp.robo.util.CustumPathNotException;

public class BotWorld {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(BotWorld.class);

    private Postion finalBotPosition;

    private Postion initialBotPosition;

    private char[][] botMatrix;

    private int sizeOfBotMatrix;

    public char[][] solMatrix;

    public BotWorld(InitialConditionInputDO initialConditionInputDO) {

        botMatrix = initialConditionInputDO.getInitialBotMatrix();

        sizeOfBotMatrix = botMatrix.length;

        finalBotPosition = initialConditionInputDO.getFinalBotPosition();

        initialBotPosition = initialConditionInputDO.getInitialBotPosition();

        solMatrix = new char[sizeOfBotMatrix][sizeOfBotMatrix];

        for (int i = 0; i < sizeOfBotMatrix; i++) {
            for (int j = 0; j < sizeOfBotMatrix; j++) {
                solMatrix[i][j] = 'X';
            }
        }
    }

    public char[][] solveBotWorld() throws CustumPathNotException {
        if (findPath(initialBotPosition.getXPosition(), initialBotPosition.getYPosition(), Direction.SOUTH)) {
            print(solMatrix);
        } else {
            LOG.info("NO PATH FOUND");
            throw new CustumPathNotException ("There is no available path found from robo's source to destination !!!");
        }
        return solMatrix;
    }

    private boolean findPath(int xCurrent, int yCurrent, Direction direction) {

        // check if maze[x][y] is feasible to move
        if (xCurrent == finalBotPosition.getXPosition() && yCurrent == finalBotPosition.getYPosition()) {// we have
            // reached
            solMatrix[xCurrent][yCurrent] = 'O';
            return true;
        }

        if (isSafeToGo(xCurrent, yCurrent)) {
            // move to maze[x][y]
            if (solMatrix[xCurrent][yCurrent] != 'X') {
                return false;
            }

            solMatrix[xCurrent][yCurrent] = 'O';
            // now rat has four options, either go right OR go down or left or go up
            if (!direction.equals(Direction.NORTH) && findPath(xCurrent + 1, yCurrent, Direction.SOUTH)) { // go down
                return true;
            }
            // else go down
            if (!direction.equals(Direction.WEST) && findPath(xCurrent, yCurrent + 1, Direction.EAST)) { // go right
                return true;
            }
            if (!direction.equals(Direction.SOUTH) && findPath(xCurrent - 1, yCurrent, Direction.NORTH)) { // go up
                return true;
            }
            if (!direction.equals(Direction.EAST) && findPath(xCurrent, yCurrent - 1, Direction.WEST)) { // go left
                return true;
            }
            // if none of the options work out BACKTRACK undo the move
            solMatrix[xCurrent][yCurrent] = 'X';
            return false;
        }
        return false;
    }

    // this function will check if mouse can move to this cell
    private boolean isSafeToGo(int xCurrent, int yCurrent) {
        // check if x and y are in limits and cell is not blocked
        boolean safeToGo = xCurrent >= 0 && yCurrent >= 0 && xCurrent < sizeOfBotMatrix && yCurrent < sizeOfBotMatrix
                && botMatrix[xCurrent][yCurrent] != 'X';
        return safeToGo;
    }

    private void print(char[][] finalSolMatrix) {
        for (int i = 0; i < sizeOfBotMatrix; i++) {
            for (int j = 0; j < sizeOfBotMatrix; j++) {
                System.out.print(" " + finalSolMatrix[i][j]);
            }
            System.out.println();
        }
    }

}
