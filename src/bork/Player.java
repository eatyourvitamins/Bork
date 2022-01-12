/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bork;

import java.util.Random;

public class Player {
    
    static private String strUsername;
    static private int intScore, intMax = 100, intMin = 25;
    
    static Random rand = new Random();

    public static String getStrUsername() {
        return strUsername;
    }

    public static void setStrUsername(String aStrUsername) {
        strUsername = aStrUsername;
    }

    public static int getIntScore() {
        return intScore;
    }

    public static void setIntScore(int aIntScore) {
        intScore = aIntScore;
    }
    
    
    public static void generateScore(){
          
        int intRand = rand.nextInt(intMax-intMin) + intMin;
        intScore = intScore + intRand;
        
        setIntScore(intScore);
        
    }
    
    
}
