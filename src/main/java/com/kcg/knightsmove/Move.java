package com.kcg.knightsmove;

@FunctionalInterface
public interface Move {
	
	public Cell2D movePostion(final Cell2D current);

}
