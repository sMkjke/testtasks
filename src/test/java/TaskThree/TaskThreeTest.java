package TaskThree;

import com.github.smkjke.task3.TaskThree;
import org.junit.Assert;
import org.junit.Test;


public class TaskThreeTest {
    @Test
    public void correctCount() {
        TaskThree taskThree = new TaskThree();
        String actual = taskThree.sumRomanNumbers("XII", "IV");
        String expected = "XVI";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void correctCountTwo() {
        TaskThree taskThree = new TaskThree();
        String actual = taskThree.sumRomanNumbers("XCVIII", "XXXIX");
        String expected = "CXXXVII";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void correctCountWithLowerCaseInput() {
        TaskThree taskThree = new TaskThree();
        String actual = taskThree.sumRomanNumbers("ix", "xv");
        String expected = "XXIV";
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectLiterals() {
        TaskThree taskThree = new TaskThree();
        taskThree.sumRomanNumbers("0si", "II");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullInput() {
        TaskThree taskThree = new TaskThree();
        taskThree.sumRomanNumbers("", "I");
    }

    @Test(expected = IllegalArgumentException.class)
    public void biggerThanC() {
        TaskThree taskThree = new TaskThree();
        taskThree.sumRomanNumbers("CI", "VI");
    }

    @Test(expected = IllegalArgumentException.class)
    public void incorrectRomans() {
        TaskThree taskThree = new TaskThree();
        taskThree.sumRomanNumbers("VX", "III");
    }

}
