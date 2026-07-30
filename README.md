# cis287-word-ladder

## Student Information
Thomas Cinque

CIS 287

Lab Assignment 6: Recursive Word Ladder

## Program Description
  Creates a word ladder by finding a string of words, each one letter different from the previous and the next, that connects a given starting and ending word.

## Class Descriptions

###WordLadderApp

  Main point of execution for the program. Contains some logic to facilitate the validation of user inputs. Handles most of the input and output.

###WordDictionary

  Loads the dictionary text file into an ArrayList. Contains methods to check if a word is in the dictionary and to get words of a particular length from the dictionary.

###WordLadderSolver

  Contains solver method used in WordLadderApp. Uses recursion in searching and backtracking during this searching.

###WordUtils

  Contains method that determines if two words differ by only one letter.

## Compilation Instructions

  javac *.java

## Execution Instructions
  java WordLadderApp

## Testing
  A successful ladder will be produced from inputting "fish" as the first word, and "mast" as the ending word. This a yield the ladder:
  [fish, dish, dash, cash, case, care, card, cart, cast, mast]

  An ladder will not be produced from an invalid input for either the starting or ending words. For example, if a word is used that is not listed in the dictionary like "amigo" the message "One or more input words is not in the dictionary. It is incumbent on the user to know what words are and are not in the dictionary before using the program.

## Recursion
  Both recursiveSearch(String, String) and backtrack(String) employ recursion. The recursive call of both occur when a for-each loop finds a word a list of candidates which is a valid next entry in the ladder causing both return the recursiveSearch(String, String) method. The base case is the first call of recursiveSearch(String, String) which returns the value passed up from subsequent calls of recursiveSearch(String, String) and backtrack(String).

## Backtracking
  If the search does not find a valid next entry for the ladder it will return backtrack(String) which will perform the search from the previous entry the word that needed to be backtracked from will then be added to a list of bad words and removed from the ladder. If another valid entry is not found from this word it will recursively call backtrack(String) until one is found returning recursiveSearch(String, String) or the ladder is backtracked to the start returning false. Additionally a counter is included that will return false after a thousand backtracks to prevent infinite looping, this is left over from before the check for bad words was refined, it may not be needed and is set entirely arbitrarily; a ladder is considered unfindable if should require more than this number of backtracks.

## Visited Words
  Before tracking bad words, words which needed to be backtracked from, backtracking would often cause an infinite cycle during which the same word kept being attempted and needed to be backtracked from. Now if a word does not make any forward progress with the ladder it is removed.

## OOP
  Encapsulation is demonstrated through the private access of the dictionary and the methods used to solve the ladder. This prevents the user from changing the dictionary after it has been loaded or using the solving methods outside the context for which they are intended to be used. Composition is demonstrated the only constructor of the WordLadderSolver class which takes an object of WordDictionary as a parameter. This object is created in the WordLadderApp class and is passed to WordLadderSolver when its constructor is called allowing both to use the methods and variables of WordDictionary, importantly including the list of dictionary words which read from the file whose name is input in WordLadderApp. The separation of responsibilities makes code easier to read and write when classes are made leaner so they only contain code related to their primary function. The objects communicate through public methods and variables.

## AI Use
  This project was made with very limited AI usage, the most extensive of which being the Googles AI overview in web searches which I used to check for correct syntax in methods. No direct prompting was used. The only code being produced were samples of for-each loops and if-else branching.
