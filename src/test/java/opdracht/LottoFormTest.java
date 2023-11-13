package opdracht;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
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

        Exception exception =  assertThrows(IllegalArgumentException.class, () -> lottoForm.play(null,10));

        String expectedMessage = "Expecting 6 unique numbers + 1 extra number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void LottoFormLL_TOO_LOW_Exception(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(1,2));

        Exception exception =  assertThrows(IllegalArgumentException.class, () -> lottoForm.play(gamble,10));

        String expectedMessage = "Expecting 6 unique numbers + 1 extra number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void LottoForm_Congrats_You_Win_Exception(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(1,2,3,4,5,10));

        Exception exception =  assertThrows(IllegalArgumentException.class, () -> lottoForm.play(gamble,10));

        String expectedMessage = "Extra number should be unique";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void LottoForm_UNDER_18_IS_FORBIDDEN_Exception(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        LottoForm lottoForm = new LottoForm(numbers);

        Exception exception =  assertThrows(IllegalArgumentException.class, () -> lottoForm.play(null,8));

        String expectedMessage = "Expecting 6 unique numbers + 1 extra number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void LottoForm_LESS_THAN_7_Exception(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(1,2,3,4,5,10));
        Exception exception =  assertThrows(IllegalArgumentException.class, () -> lottoForm.play(gamble,0));

        String expectedMessage = "Expecting 6 unique numbers + 1 extra number";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
    @Test
    void LottoForm_String_Exception(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(0,2,3,4,5,8));
        Exception exception =  assertThrows(IllegalArgumentException.class, () -> lottoForm.play(gamble,8));

        String expectedMessage = "Extra number should be unique";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void LottoFormPlayFound4(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(0,2,3,4,5,9));
        PlayResult playResult = PlayResult.FOUND_4;
        assertEquals(playResult, lottoForm.play(gamble,8));
    }

    @Test
    void LottoFormPlayFound5(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(1,2,3,4,5,9));
        PlayResult playResult = PlayResult.FOUND_5;
        assertEquals(playResult, lottoForm.play(gamble,8));
    }

    @Test
    void LottoFormPlayFound6(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(1,2,3,4,5,7));
        PlayResult playResult = PlayResult.FOUND_6;
        assertEquals(playResult, lottoForm.play(gamble,8));
    }

    @Test
    void LottoFormPlayFound4plus1(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(8);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(1,2,3,4,9,10));
        PlayResult playResult = PlayResult.FOUND_4PLUS1;
        assertEquals(playResult, lottoForm.play(gamble,8));
    }
    @Test
    void LottoFormPlayFound5plus1(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(8);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(1,2,3,4,5,10));
        PlayResult playResult = PlayResult.FOUND_5PLUS1;
        assertEquals(playResult, lottoForm.play(gamble,8));
    }

    @Test
    void LottoFormPlayNoWinBug(){
        Set <Integer> numbers = new HashSet<Integer>();
        numbers.add(31);
        numbers.add(22);
        numbers.add(33);
        numbers.add(24);
        numbers.add(15);
        numbers.add(0);
        LottoForm lottoForm = new LottoForm(numbers);
        Set <Integer> gamble = new HashSet<Integer>(List.of(11,12,13,14,19,10));
        PlayResult playResult = PlayResult.FOUND_6;
        assertEquals(playResult, lottoForm.play(gamble,8));
    }
}
