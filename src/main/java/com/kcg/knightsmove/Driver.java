package com.kcg.knightsmove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Driver {
	
	final static Logger logger = LoggerFactory.getLogger(Driver.class);
	
	static final char[][] boardRepresentation = new char [][] 
								 { {'A','B','C','D','E'},
		   						   {'F','G','H','I','J'},
		   						   {'K','L','M','N','O'},
		   						   {' ','1','2','3',' '} };
		   						   
	static final Board board = new Board(boardRepresentation);
	static final Knight knight = new Knight(board, new Cell2D(0, 0));
	static final int VOWEL_LIMIT = 2;
	static SequenceGenerator sequenceGenerator;
		
	public static void main(String[] args) {
		int sequenceLength;
		
		if (args.length > 0) {
		    try {
		        sequenceLength = Integer.parseInt(args[0]);
		        if(sequenceLength < 1 || sequenceLength > 32){
		        	System.err.println("Argument " + args[0] + " is out of range");
		        	System.exit(1);
		        }
		        sequenceGenerator = new SequenceGeneratorMemonization(board,knight,sequenceLength,VOWEL_LIMIT);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument " + args[0] + " must be an integer.");
		        System.exit(1);
		    }
		}else{
			System.err.println("No Argument specified Integer argument required");
	        System.exit(1);
		}
		long startTimeStamp = System.nanoTime();
		long totalSequencesCount = sequenceGenerator.generateValidSequencesCount();
		long elapsedTime = System.nanoTime() - startTimeStamp;
		logger.debug("Total Number of Sequence : " + totalSequencesCount);
		logger.debug("Time Spent : " + elapsedTime/1000000 + " ms");
		System.out.println(totalSequencesCount);
	}

}
