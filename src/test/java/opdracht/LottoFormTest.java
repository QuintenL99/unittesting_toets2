package opdracht;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoFormTest {

    @Test
    void lottoformNullSet() {
        assertThrows(IllegalArgumentException.class, () -> new LottoForm(null));
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
}
