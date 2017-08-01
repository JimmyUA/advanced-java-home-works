package com.sergey.prykhodko.homework7.reverse;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sergey on 25.07.2017.
 */
public class StringReverseTest {


    ///////////////////////////////////////////////////////////////////////
    //////////////////////////reverseString////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    @Test
    public void stringShouldBeReversedAfterCallMethodReverseString(){
        String inputString = "abcde";
        String reversedString = "edcba";
        StringReverse stringReverse = new StringReverse();

        String afterMethodInvoked = stringReverse.reverseString(inputString);

        Assert.assertTrue(afterMethodInvoked.equals(reversedString));
    }

    @Test
    public void methodReverseStringShouldReturnNullIfInputStringIsNull(){
        String inputString = null;
        String reversedString = null;
        StringReverse stringReverse = new StringReverse();

        String afterMethodInvoked = stringReverse.reverseString(inputString);

        Assert.assertEquals(inputString, reversedString);
    }

    ///////////////////////////////////////////////////////////////////////
    //////////////////reverseStringNoTouchingNonLetters////////////////////
    //////////////////////////////////////////////////////////////////////

    @Test
    public void methodShouldReturnReversedStringWithNonLettersOnOldPositions(){
        String inputString = "ab2cd_ghd*hj abd#fd";
        String reversedString = "jh2dh_gdc*ba dfd#ba";
        StringReverse stringReverse = new StringReverse();

        String afterMethodInvoked = stringReverse.reverseStringNoTouchingNonLetters(inputString);

        Assert.assertTrue(afterMethodInvoked.equals(reversedString));
    }



}