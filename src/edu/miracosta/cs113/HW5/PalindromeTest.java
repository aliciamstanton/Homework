package edu.miracosta.cs113.HW5;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * PalindromeTest : a test class for isPalindrome, a method intended to utilize stacks to evaluate if a given
 * string is a palindrome.
 *
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backwards as it does
 * forwards. Such sequences include "madam," "top spot," or "no lemon, no melon".
 */
public class PalindromeTest {

    /** True test cases which include spaces and symbols */
    private static final String[] SIMPLE_TRUE = { "", " ", "A", "7", "%", "  ", "BB", "33", "**" };
    /** False test cases which include spaces and symbols */
    private static final String[] SIMPLE_FALSE = { "AC", "71", "@+" };

    /** True test cases which include spaces */
    private static final String[] WHITE_SPACE_TRUE = { " x ", " t   t  ", " 5 5", " #      # " };
    /** False test cases which include spaces */
    private static final String[] WHITE_SPACE_FALSE = { "m   n  ", "   8  7 ", "  ^      &  "};

    /** Case-sensitive palindromes */
    private static final String[] CASE_SENSITIVE_TRUE = { "ABba", "roTOR", "rAceCaR" };

    /** Complex palindromes which include spaces, symbols, and varied capitalization */
    private static final String[] COMPLEX_TRUE = { "fOO race CAR oof", "AbBa ZaBba", "1 3 3 7  331",
                                                "N0 LEm0n, n0 Mel0n",
                                                "sT RJKLEeE R#@ $A$ @# REeEL K  JRT s" };

    /**
     * Utilizes stacks to determine if the given string is a palindrome. This method ignores whitespace and case
     * sensitivity, but does not ignore digits or symbols.
     *
     * @param s a string comprised of any character
     * @return returns true if a palindrome (ignoring whitespace and case sensitivity), false otherwise
     */
    private boolean isPalindrome(String s) 
    {
    	
    	// Need to consider if the string is null - Should throw IllegalArgumentException
    	// based on test clarification below
    	if(s == null)
    	{
    		throw new IllegalArgumentException();
   
    	}
    	
    	// Then we can consider if the string has a length of 0 - no  letters to compare
    	// Should always return true as a palindrome
    	else if(s.length() == 0)
    	{
    		return true;
    	}
    	
    	// Then we can consider if the string has a length of 1, you'd be comparing a single
    	// character to itself - always a palindrome
    	else if(s.length() == 1)
    	{
    		return true;
    	}
    	
    	// Can also consider if there are only two letters. Can compare individually
    	else if(s.length() == 2)
    	{
    		if(s.charAt(0) == s.charAt(1))
    		{
    			return true;
    		}
    		else 
    		{
    			return false;
    		}
    	}
    	
    	
    	// If none of the above cases apply, then we should implement stacks to compare them 
    	else
    	{
    		// First we need to clean the strings so that they no longer contain 
    		// whitespace and capitalization
    		
    		// Remove uppercase 
    		s = s.toLowerCase();
    		
    		// Remove whitespace
    		s = s.replaceAll("\\s", "");
    		
    		// Create two empty stacks that we can use to compare each string 
    		// Use a Character wrapper class as the data type
    		ArrayListStack<Character> firstHalf = new ArrayListStack<Character>();
    		ArrayListStack<Character> secondHalf = new ArrayListStack<Character>();
    		
    		
    		// Now we want to take the string and put it in the first stack a character at a time
    		// Create a single character 
    		Character singleChar;
    		
    		// Create an integer that clarifies the length of the string with no spaces 
    		// or uppercase letters
    		int stringLength = s.length();
    		
    		// Iterate over the length of the string and place each character in the firstHalf Stack
    		for(int i = 0; i < stringLength; i++)
    		{
    			
    			// Take the character at the beginning 
    			singleChar = s.charAt(0);
    			
    			// push it onto the first stack
    			firstHalf.push(singleChar);
    			
    			// Navigate to the next character in the string
    			s = s.substring(1);
    			
    		}
    		
    		// Now we need to split the string into two stacks 
    		int halfwayPoint = stringLength / 2;
    		
    		// Create another character
    		Character popCharacter;
    		
    		// Iterate over the first half of the firstHalf Stack
    		for(int i = 0; i < halfwayPoint; i++)
    		{
    			// Grab a single character from the firstHalf
    			popCharacter = firstHalf.pop();
    			
    			// Then push it into the secondHalf Stack
    			secondHalf.push(popCharacter);
    			
    		}
    		
    		// Before we can start comparing, we need to make sure that the stacks
    		// are the same length and that the revised string is not odd in length
    		if(stringLength % 2 == 1)
    		{
    			// If odd, then we need to pop off an additional character 
    			// from the firstHalf
    			firstHalf.pop();
    		}
    		
    		// At this point, both stacks should have the same number of characters
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    		
    	
    	}
    
    	// Change this later 
        return false;

    } // End of method isPalindrome

    @Test
    public void testErrors() {
        try {
            isPalindrome(null);
            fail("Checking null to see if it's a palindrome should throw IllegalArgumentException!");
        } catch (IllegalArgumentException iae) { /* Test Passed! */ }
    }

    @Test
    public void testSimpleTrueCases() {
        for (int i = 0; i < SIMPLE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(SIMPLE_TRUE[i]));
        }
    }

    @Test
    public void testSimpleFalseCases() {
        for (int i = 0; i < SIMPLE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(SIMPLE_FALSE[i]));
        }
    }

    @Test
    public void testWhitespaceTrueCases() {
        for (int i = 0; i < WHITE_SPACE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(WHITE_SPACE_TRUE[i]));
        }
    }

    @Test
    public void testWhitespaceFalseCases() {
        for (int i = 0; i < WHITE_SPACE_FALSE.length; i ++) {
            assertFalse((i + " This test is NOT a palindrome"), isPalindrome(WHITE_SPACE_FALSE[i]));
        }
    }

    @Test
    public void testCaseSensitivityCases() {
        for (int i = 0; i < CASE_SENSITIVE_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(CASE_SENSITIVE_TRUE[i]));
        }
    }

    @Test
    public void testComplexCases() {
        for (int i = 0; i < COMPLEX_TRUE.length; i ++) {
            assertTrue((i + " This test is a palindrome"), isPalindrome(COMPLEX_TRUE[i]));
        }
    }

} // End of class PalindromeTest
