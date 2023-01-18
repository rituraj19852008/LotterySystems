package org.example;

import java.util.Arrays;
import java.util.List;

public class WinningBets {


    public static void main(String[] args) {
        LotterySystem lotterySystem = new LotterySystem();

        List<Integer> userBets = Arrays.asList(1,5,2,4,6,9);

        Integer winningAmount  = lotterySystem.getWinningAmountForBet(userBets);

        System.out.println("Congratulations, you have won :: "+winningAmount);


    }
}
