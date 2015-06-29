Knights-Moves Keypad
====================

Program to knight move sequences on a keypad.


Requirements
============

Java 8 and Gradle


Instructions
============

Below are the commands to execute to run the program

```shell
 $ export JAVA_HOME=$(/usr/libexec/java_home -v 1.8) # if required on mac and default java is not jdk 8.
 $ gradle fatJar
 $ java -jar build/libs/knightsTour.jar 10
 $ java -Dorg.slf4j.simpleLogger.defaultLogLevel=debug -jar build/libs/knightsTour.jar 10 # for debug output
```

Design Notes
============

The implementation to be used is managed by the Driver class it is currently set to SequenceGeneratorMemonization , there is also a SequenceGeneratorBruteForce that is useful for comparison and results validation. The Brute force approach computationally is exponential since it computes the same sub problem over and over . The SequenceGeneratorMemonization approach uses dynamic programming and Memonization to avoid recomputation and hence its's much more efficient. The space required for this approach is O(kp(v+1)) where where k is the number of keys , p is sequence depth ( n input) and v is the number of allowable vowels in a sequence. The Runtime is O(p*(v+1)) 
