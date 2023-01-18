import org.example.LotterySystem;
import org.junit.Assert;
import org.junit.Test;

public class LotterySystemTest {

    LotterySystem lotterySystem = new LotterySystem();
    @Test
    public void winningNumbersGeneratorTest(){
        Assert.assertEquals( lotterySystem.getWinningNumbers().size(),6);
    }

    //TODO:We have to ensure that the winning GT , generates only unique winning numbers..
    //UPDATE:This has been implemented
    public void winningNumbersGTForUniqueness(){
        //We have to ensure that the winning GT , generates only unique winning numbers..
        //Probably use a set instead of List..& also ensure that it has unique values..

    }


    public void firstTestCaseTest(){

        //lotterySystem.getWinningAmountForBet()
    }





}
