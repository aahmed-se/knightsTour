package com.kcg.knightsmove;

public class Board {

	final char[][] boardRepresentation;
	
	public Board(char[][] boardRepresentation) {
		this.boardRepresentation = boardRepresentation;
	}

	public boolean isValid(Cell2D cell) {
		if(	cell.X < 0
		 || cell.X > boardRepresentation.length - 1
		 || cell.Y < 0 
		 || cell.Y > boardRepresentation[cell.X].length - 1
		 || boardRepresentation[cell.X][cell.Y] == ' '){
			return false;
		}
		else{
			return true;
		}
		
	}

	public char getValue(Cell2D cell) {
		return boardRepresentation[cell.X][cell.Y];
	}
		
	/**
	 * @return the boardRepresentation
	 */
	public char[][] getBoardRepresentation() {
		return boardRepresentation;
	}

}
