package com.kcg.knightsmove;

public class Knight extends Figure{

	public Knight(Board board,Cell2D cell){
		super(board, cell);
	}
	
	@Override
	public void setMoves() {
		this.getMoves().add( (Move) (Cell2D cel) -> { return new Cell2D(cel.X+1,cel.Y+2);}) ;
		this.getMoves().add( (Move) (Cell2D cel) -> { return new Cell2D(cel.X+2,cel.Y+1);}) ;
		this.getMoves().add( (Move) (Cell2D cel) -> { return new Cell2D(cel.X+2,cel.Y-1);}) ;
		this.getMoves().add( (Move) (Cell2D cel) -> { return new Cell2D(cel.X+1,cel.Y-2);}) ;
		this.getMoves().add( (Move) (Cell2D cel) -> { return new Cell2D(cel.X-1,cel.Y-2);}) ;
		this.getMoves().add( (Move) (Cell2D cel) -> { return new Cell2D(cel.X-2,cel.Y-1);}) ;
		this.getMoves().add( (Move) (Cell2D cel) -> { return new Cell2D(cel.X-2,cel.Y+1);}) ;
		this.getMoves().add( (Move) (Cell2D cel) -> { return new Cell2D(cel.X-1,cel.Y+2);}) ;
	}
}
