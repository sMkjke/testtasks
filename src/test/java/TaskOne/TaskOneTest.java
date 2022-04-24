package TaskOne;

import com.github.smkjke.task1.TaskOne;
import org.junit.Assert;
import org.junit.Test;


public class TaskOneTest {

    @Test
    public void correctWall() {
        TaskOne taskOne = new TaskOne();
        int actual = taskOne.rebuildWall("1 2 3");
        int expected = 2;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void incorrectInput() {
        TaskOne taskOne = new TaskOne();
        taskOne.validateData("1 2 j");
        Assert.assertFalse(false);
    }

    @Test
    public void incorrectWallHeight() {
        TaskOne taskOne = new TaskOne();
        taskOne.validateData("11 10 1");
        Assert.assertFalse(false);
    }

    @Test
    public void correctWallTwo() {
        TaskOne taskOne = new TaskOne();
        int actual = taskOne.rebuildWall("6 5 9 1 3 4");
        int expected = 12;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void nullInput() {
        TaskOne taskOne = new TaskOne();
        taskOne.validateData(" ");
        Assert.assertFalse(false);
    }
}
