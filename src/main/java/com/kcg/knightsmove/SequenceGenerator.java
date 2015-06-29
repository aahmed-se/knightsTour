package com.kcg.knightsmove;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class SequenceGenerator {
	
	static final Set<Character> VOWELS = new HashSet<Character>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
	
    final Board board;
	final Knight knight;
	final int sequenceLength;
	final HashMap<Character,List<Character>> keyMap;
	final int vowelLimit;
	
	public SequenceGenerator(Board board, Knight knight, int sequenceLength ,final int vowelLimit) {
		this.board = board;
		this.knight = knight;
		this.sequenceLength = sequenceLength;
		this.vowelLimit = vowelLimit;
		
		keyMap = new HashMap<Character, List<Character>>();
		
		for(int i = 0 ; i < board.getBoardRepresentation().length; ++i){
			for(int j = 0 ; j < board.getBoardRepresentation()[i].length; ++j){
				if (board.isValid(new Cell2D(i, j))) {
					knight.setPosition(new Cell2D(i, j));
					List<Character> moves = knight.availableMoves();
					keyMap.put(board.getValue(new Cell2D(i, j)), moves);
				}
			}
		}
	}
	
	public abstract long generateValidSequencesCount();

}
