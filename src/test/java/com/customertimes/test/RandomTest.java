package com.customertimes.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class RandomTest {

    @Test
    public void checkRandomRange(){
        Random rand = new Random();
        int expectedRandom = 10;
        int actualRandom = rand.nextInt(10);
        Assert.assertTrue(actualRandom<=expectedRandom, "Random");
    }
}
