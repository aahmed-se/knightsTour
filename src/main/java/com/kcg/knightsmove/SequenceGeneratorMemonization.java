package com.kcg.knightsmove;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.HashBiMap;

public class SequenceGeneratorMemonization extends SequenceGenerator {
	
	final Logger logger = LoggerFactory.getLogger(SequenceGeneratorMemonization.class);

	final long[][][] numMatrix;

	final int numbOfKeys = keyMap.keySet().size();

	final boolean[] isVowel = new boolean[numbOfKeys];

	final HashBiMap<Character, Integer> elementIndexMap;

	public SequenceGeneratorMemonization(Board board, Knight knight, int sequenceLength, int vowelLimit) {
		super(board, knight, sequenceLength, vowelLimit);
		numMatrix = new long[sequenceLength][vowelLimit+1][numbOfKeys];
		elementIndexMap = HashBiMap.create();
		int index = 0;
		for (Character c : keyMap.keySet()) {
			elementIndexMap.put(c, index++);
		}
		index = 0;
		for (Character c : keyMap.keySet()) {
			if (VOWELS.contains(c)) {
				isVowel[index] = true;
			}
			index++;
		}

		logger.debug("Initialized memonization sequence generator");
		logger.debug("n is " + this.sequenceLength);
	}

	@Override
	public long generateValidSequencesCount() {

		long summation = 0L;

		for (Character c : keyMap.keySet()) {
			summation += buildSequence(c, 1, 0);
		}

		return summation;

	}

	private long buildSequence(Character key, int sequenceNumber, int vowelCount) {

		if (VOWELS.contains(key)) {
			vowelCount++;
			if (vowelCount > vowelLimit) {
				vowelCount--;
				return 0;
			}
		}

		if (sequenceNumber == sequenceLength) {
			numMatrix[sequenceNumber-1][vowelCount][elementIndexMap.get(key)] = 0;
			return 1;
		} 
		else {
			if(numMatrix[sequenceNumber-1][vowelCount][elementIndexMap.get(key)] != 0){
				return numMatrix[sequenceNumber-1][vowelCount][elementIndexMap.get(key)];
			}
			else{
				numMatrix[sequenceNumber-1][vowelCount][elementIndexMap.get(key)] = 0L;
				for (Character c : keyMap.get(key)) {
					numMatrix[sequenceNumber-1][vowelCount][elementIndexMap.get(key)] += buildSequence(c,
							sequenceNumber + 1, vowelCount);
				}
			}
		}

		return numMatrix[sequenceNumber-1][vowelCount][elementIndexMap.get(key)];

	}

}
