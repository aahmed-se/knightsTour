package com.kcg.knightsmove;

import java.util.ArrayList;
import java.util.List;

public abstract class  Figure {
	

    final private Board board;

	final private List <Move> moves = new ArrayList<Move>();

    private Cell2D position;

	public Figure(final Board board,final Cell2D position)
    {
        this.position = position;
        this.board = board;
        setMoves();
    }

    public Figure(final Board board,final int x,final int y)
    {
        this.position = new Cell2D(x,y);
        this.board = board;
        setMoves();
    }

    public List<Character> availableMoves()
    {
        List <Character> list = new ArrayList<Character>();
        for(Move move : moves)
        {
            Cell2D cell = move.movePostion(position);
            if(board.isValid(cell)){
                list.add(board.getValue(cell));
            }
        }
        return list;
    }

    public abstract void setMoves();
    

    /**
	 * @return the board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * @return the moves
	 */
	public List<Move> getMoves() {
		return moves;
	}

	/**
	 * @return the position
	 */
	public Cell2D getPosition() {
		return position;
	}
	
    /**
	 * @param position the position to set
	 */
	public void setPosition(Cell2D position) {
		this.position = position;
	}

}
