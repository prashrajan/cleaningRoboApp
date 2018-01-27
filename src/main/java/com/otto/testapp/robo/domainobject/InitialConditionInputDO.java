package com.otto.testapp.robo.domainobject;

import com.otto.testapp.robo.domainvalue.*;
import com.otto.testapp.robo.util.CustumInvalidInputParameterException;

public class InitialConditionInputDO {

    private char[][] initialBotMatrix;

    private Postion initialBotPosition = new Postion();

    private Postion finalBotPosition = new Postion();

    private Direction initialBotDirection;

    public InitialConditionInputDO(char[][] matrix, int[] initialPosition, int[] finalPosition,
            char initialDirection) throws CustumInvalidInputParameterException {
    	checkAcceptInputMatrix(matrix);
		checkAcceptInitialPosition(initialPosition);
		checkAcceptFinalPosition(finalPosition);
		checkAcceptInitialDirection(initialDirection);
    }
    
    
    private void checkAcceptInputMatrix(char[][] initialMatrix) throws CustumInvalidInputParameterException {
		if (initialMatrix.length >= 2 && initialMatrix[0].length >= 2 && checkValidValues(initialMatrix)) {
			this.initialBotMatrix = initialMatrix;
		} else {
			throw new CustumInvalidInputParameterException("The input matrix is too small or have invalid values, Valid value are :- X or O");
		}

	}

	private boolean checkValidValues(char[][] initialMatrix) {
		for (int i = 0; i < initialMatrix.length; i++) {
            for (int j = 0; j < initialMatrix[0].length; j++) {
            	if(initialMatrix[i][j] != 'X' && initialMatrix[i][j] !='O'){
            		return false;
            	}
            }
        }
		return true;
	}


	private void checkAcceptInitialPosition(int[] initialPosition) throws CustumInvalidInputParameterException {
		if (initialPosition.length == 2 && initialPosition[0] >= 0 && initialPosition[1] >= 0
				&& initialPosition[0] <= initialBotMatrix.length - 1 && initialPosition[1] <= this.initialBotMatrix[0].length - 1) {
			 initialBotPosition.setXPosition(initialPosition[0]);
		     initialBotPosition.setYPosition(initialPosition[1]);
		} else {
			throw new CustumInvalidInputParameterException("The initial position is out of matrix or wrong values");
		}

	}

	private void checkAcceptFinalPosition(int[] finalPosition) throws CustumInvalidInputParameterException {
		if (finalPosition.length == 2 && finalPosition[0] >= 0 && finalPosition[1] >= 0
				&& finalPosition[0] <= this.initialBotMatrix.length - 1 && finalPosition[1] <= this.initialBotMatrix[0].length - 1) {
			 finalBotPosition.setXPosition(finalPosition[0]);
		     finalBotPosition.setYPosition(finalPosition[1]);
		} else {
			throw new CustumInvalidInputParameterException("The final position is out of matrix or wrong values");
		}

	}

	private void checkAcceptInitialDirection(char initialDirection) throws CustumInvalidInputParameterException {
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
		      throw new CustumInvalidInputParameterException("Unknown Direction, the permitted value are:- N, S, E, W");
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
