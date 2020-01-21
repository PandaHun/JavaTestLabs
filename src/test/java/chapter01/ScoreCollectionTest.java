package chapter01;

import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ScoreCollectionTest {

    @Test
    public void answerArithmeticMeanOfTwoNumbers() {

        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 50);
        collection.add(() -> 70);

        int actualResult = collection.arithmeticMean();

        assertThat(actualResult, equalTo(60));
    }
}
