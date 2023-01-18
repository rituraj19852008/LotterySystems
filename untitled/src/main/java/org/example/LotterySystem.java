package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class LotterySystem {

    List<Integer> numbersNotMatchedInBets = new ArrayList<>();

    /**
     * This method is used to get the winning amount
     */
    public  Integer getWinningAmountForBet(List<Integer> bettedNumbers){
        
        //Generate a list of Random Winning Numbers
        Set<Integer> winners = getWinningNumbers();

        //Get the number of matched bets
        int matchedItems = getMatchedNumbers(bettedNumbers,new ArrayList<>(winners));

        numbersNotMatchedInBets = winners.stream().filter(num -> !bettedNumbers.contains(num)).collect(Collectors.toList());

        //Get the winning amount based on the matched items
        Integer amount = fetchWinningAmount(matchedItems,bettedNumbers);

        return amount;

    }

    private Integer fetchWinningAmount(int matchedItems, List<Integer> bettedNumbers) {
        int winningAmount = 0;
        int value = 1;
        if(matchedItems<3){
           return getSumOfBetterNumbers(bettedNumbers);
        }else if(matchedItems >2 && matchedItems <=5){
            winningAmount = 500*matchedItems;
            for(int i = 0; i< numbersNotMatchedInBets.size(); i++){
                value = value* numbersNotMatchedInBets.get(i);
            }
            return winningAmount+value;
        }else{
            return Math.toIntExact(1000 * getSumOfBetterNumbers(bettedNumbers));
        }

    }

    private Integer getSumOfBetterNumbers(List<Integer> bettedNumbers) {
        int sum = 0;
        for(int i=0;i<bettedNumbers.size();i++){
            sum = sum+bettedNumbers.get(i);
        }
        return sum;
    }

    private int getMatchedNumbers(List<Integer> betNumbers, List<Integer> winners) {
        int counter = 0;
        for(int i=0;i<betNumbers.size();i++){
            for(int j=0;j<winners.size();j++){
                if(betNumbers.get(i).equals(winners.get(j))){
                    counter++;
                }
            }
        }
        return counter;
    }

    public Set<Integer> getWinningNumbers() {

        Set<Integer> winners = new HashSet<>();
        Random random = new Random();
        while(winners.size()!=6){
            winners.add(random.nextInt(10));
        }
        System.out.println("Random numbers :: "+winners);

        return winners;
    }


}
