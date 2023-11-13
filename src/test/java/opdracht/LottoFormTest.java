package opdracht;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LottoFormTest {

    @Test
    void lottoformNullSet() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new LottoForm(null));

        String expectedMessage = "Expecting 6 unique numbers";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void LottoFormGetGGWith6set(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        LottoForm lottoForm = new LottoForm(numbers);
        assertEquals(8,lottoForm.getGg());
    }
    @Test
    void LottoFormGetGGWithMoreThan6set(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        LottoForm lottoForm = new LottoForm(numbers);
        assertEquals(7,lottoForm.getGg());
    }

    @Test
    void LottoFormToomanyAttemptException(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        LottoForm lottoForm = new LottoForm(numbers);
        assertThrows(IllegalArgumentException.class, () -> lottoForm.play(null,10));

        Exception exception =  assertThrows(IllegalArgumentException.class, () -> lottoForm.play(null,10));

        String expectedMessage = "Expecting 6 unique numbers + 1 extra number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
