package com.kcg.knightsmove;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.lang3.mutable.MutableInt;

public class SequenceGeneratorBruteForce extends SequenceGenerator {

	final Logger logger = LoggerFactory.getLogger(SequenceGeneratorBruteForce.class);

	public SequenceGeneratorBruteForce(Board board, Knight knight, int sequenceLength, int vowelLimit) {
		super(board, knight, sequenceLength, vowelLimit);
	}

	@Override
	public long generateValidSequencesCount() {

		MutableInt sequenceCount = new MutableInt(0);

		for (Entry<Character, List<Character>> entry : keyMap.entrySet()) {
			logger.debug("----" + entry.getKey() + entry.getValue());
			sequencerFile(keyMap, 1, new ArrayList<Character>(), entry.getKey(), sequenceCount);
		}

		return sequenceCount.intValue();

	}

	private void sequencerFile(HashMap<Character, List<Character>> dic, int depth, List<Character> sequence,
			Character key, MutableInt sequenceCount) {

		ArrayList<Character> appended_sequence = new ArrayList<Character>(sequence);
		appended_sequence.add(key);

		if (depth == sequenceLength) {
			if (checkSequence(appended_sequence)) {
				if (logger.isDebugEnabled()) {
					logger.debug(appended_sequence.toString());
				}
				sequenceCount.add(1);
			}
			return;
		}

		for (Character c : dic.get(key)) {
			sequencerFile(dic, depth + 1, appended_sequence, c, sequenceCount);
		}

	}

	private boolean checkSequence(List<Character> sequence) {
		int vowelCount = 0;
		for (Character c : sequence) {
			if (VOWELS.contains(c)) {
				vowelCount++;
			}
			if (vowelCount > vowelLimit) {
				return false;
			}
		}

		return true;
	}
}
