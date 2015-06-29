package com.kcg.knightsmove.unit;
import org.junit.Test;

import com.kcg.knightsmove.Board;
import com.kcg.knightsmove.Cell2D;
import com.kcg.knightsmove.Knight;
import com.kcg.knightsmove.SequenceGenerator;
import com.kcg.knightsmove.SequenceGeneratorMemonization;

import static org.junit.Assert.*;

public class KnightMovesTest {
    @Test public void testMemonizationSequenceGeneratorLength10() {
    	
    	char[][] boardRepresentation = new char [][] 
				     { {'A','B','C','D','E'},
					   {'F','G','H','I','J'},
					   {'K','L','M','N','O'},
					   {' ','1','2','3',' '} };
					   
		Board board = new Board(boardRepresentation);
		Knight knight = new Knight(board, new Cell2D(0, 0));
        int vowelLimit = 2;
        SequenceGenerator memnoicSequence = new SequenceGeneratorMemonization(board, knight, 10, vowelLimit);
        assertEquals("For sequence length 10 and vowel limit 2", 1013398L, memnoicSequence.generateValidSequencesCount());
    }
    
    @Test public void testMemonizationSequenceGeneratorLength1() {
    	
    	char[][] boardRepresentation = new char [][] 
				     { {'A','B','C','D','E'},
					   {'F','G','H','I','J'},
					   {'K','L','M','N','O'},
					   {' ','1','2','3',' '} };
					   
		Board board = new Board(boardRepresentation);
		Knight knight = new Knight(board, new Cell2D(0, 0));
        int vowelLimit = 2;
        SequenceGenerator memnoicSequence = new SequenceGeneratorMemonization(board, knight, 1, vowelLimit);
        assertEquals("For sequence length 1 and vowel limit 2", 18L, memnoicSequence.generateValidSequencesCount());
    }
    
    @Test public void testMemonizationSequenceGeneratorLength32() {
    	char[][] boardRepresentation = new char [][] 
				 	 { {'A','B','C','D','E'},
					   {'F','G','H','I','J'},
					   {'K','L','M','N','O'},
					   {' ','1','2','3',' '} };
    	Board board = new Board(boardRepresentation);
		Knight knight = new Knight(board, new Cell2D(0, 0));
        int vowelLimit = 2;
        SequenceGenerator memnoicSequence = new SequenceGeneratorMemonization(board, knight, 32, vowelLimit);
        assertEquals("For sequence length 32 and vowel limit 2", 129891093550589788L, memnoicSequence.generateValidSequencesCount());	
    }
  
}
