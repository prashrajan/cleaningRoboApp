package com.otto.testapp.robo.datatransferobject;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InitialConditionInputDTO {

	@NotNull(message = "matrix can not be null!")
	private char[][] matrix;

	@NotNull(message = "initialPosition can not be null!")
	private int[] initialPosition;

	@NotNull(message = "finalPosition can not be null!")
	private int[] finalPosition;

	@NotNull(message = "initial bot direction can not be null!")
	private char initialDirection;

	public InitialConditionInputDTO() {
	}

	public InitialConditionInputDTO(char[][] matrix, int[] initialPosition, int[] finalPosition,
			char initialDirection) {
		this.matrix = matrix;
		this.initialPosition = initialPosition;
		this.finalPosition = finalPosition;
		this.initialDirection = initialDirection;
	}

	public char[][] getMatrix() {
		return matrix;
	}

	public int[] getInitialPosition() {
		return initialPosition;
	}

	public int[] getFinalPosition() {
		return finalPosition;
	}

	public char getInitialDirection() {
		return initialDirection;
	}

}
