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


## Execution Instructions
  Upon executing the program, welcoming text will be printed to the terminal along with a prompt to enter the first word. For best results, do not type anything into the terminal before being prompted. The program will check that both words are of the same length and are found in the text file being used for the dictionary, the program will stop and print an appropriate message if either of these is not true. After inputting an ending word the program will compute the ladder and print its results, the results either being the ladder or that the ladder could not be found. Additionally the program will not solve for a ladder that does not need solving, that is one with matching start and end words or one with start and end words that differ by only one letter. 

## Testing


## Recursion
  Both recursiveSearch(String, String) and backtrack(String) employ recursion. The recursive call of both occur when a for-each loop finds a word a list of candidates which is a valid next entry in the ladder causing both return the recursiveSearch(String, String) method. The base case is the first call of recursiveSearch(String, String) which returns the value passed up from subsequent calls of recursiveSearch(String, String) and backtrack(String).

## Backtracking
  If the search does not find a valid next entry for the ladder it will return backtrack(String) which will perform the search from the previous entry the word that needed to be backtracked from will then be added to a list of bad words and removed from the ladder. If another valid entry is not found from this word it will recursively call backtrack(String) until one is found returning recursiveSearch(String, String) or the ladder is backtracked to the start returning false. Additionally a counter is included that will return false after a thousand backtracks to prevent infinite looping, this is left over from before the check for bad words was refined, it may not be needed and is set entirely arbitrarily; a ladder is considered unfindable if should require more than this number of backtracks.

## Visited Words
  Tracking visited words is handled by only considering words that aren't in the ladder or bad words list to be valid next entries. Words are added to the bad words list when they are backtracked from.

## OOP


## AI Use
  This project was made with very limited AI usage, the most extensive of which being the Googles AI overview in web searches which I used to check for correct syntax in methods.
