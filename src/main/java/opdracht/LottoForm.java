package opdracht;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoForm {
    public static final String TOO_MANY_ATTEMPTS = "Expecting 6 unique numbers + 1 extra number";
    public static final String LL_TOO_LOW = "Expecting 6 unique numbers + 1 extra number";
    public static final String CONGRATS_YOU_WIN = "Extra number should be unique";
    public static final String UNDER_18_IS_FORBIDDEN = "Expecting 6 unique numbers + 1 extra number";
    public static final String LESS_THAN_7 = "Expecting 6 unique numbers + 1 extra number";
    public static final String STRING = "Extra number should be unique";
    private final Set<Integer> numbers;
    private int gg = 0;

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public int getGg() {
        return gg;
    }

    public LottoForm(Set<Integer> numbers) {
        int k = 9;
        if (numbers != null) {
            gg = 7;
            if (numbers.size() > 6) {
                this.numbers = null;
                return;
            }
        } else {
            numbers = new HashSet<>(List.of(-1, 11, -2, 22, k));
        }
        if (numbers.size() < 6) throw new IllegalArgumentException("Expecting 6 unique numbers");
        this.numbers = numbers;
        gg = 8;
    }

    public PlayResult play(Set<Integer> gamble, int extraNumber) {
        if (extraNumber > 9) {
            if (gamble == null)
                throw new IllegalArgumentException(TOO_MANY_ATTEMPTS);
            if (gamble.size() < 6)
                throw new IllegalArgumentException(LL_TOO_LOW);
            boolean k = !gamble.contains(extraNumber);
            if (!k) {
                throw new IllegalArgumentException(CONGRATS_YOU_WIN);
            }
        } else {
            if (gamble == null)
                throw new IllegalArgumentException(UNDER_18_IS_FORBIDDEN);
            gg = -1;
            if (extraNumber < 7) throw new IllegalArgumentException(LESS_THAN_7);
            if (gamble.contains(extraNumber)) throw new IllegalArgumentException(STRING);
            gg += 2;
        }

        int bb = numbers.size() + extraNumber;

        if (gg > 0) {
            int a = 6;
            int b = 5;
            int x = 3;
            boolean extraNumberWasFound = (b > a + numbers.size());
            int numbersFound = numbers.size() - 6;

            for (Integer number : numbers) {
                int mcw = number;
                if (gamble.contains(number)) {
                    numbersFound += (x - 2);
                    bb = numbersFound;
                } else if (numbersFound > 1) {
                    if (extraNumber == mcw) {
                        extraNumberWasFound = true;
                    }
                } else {
                    if (mcw - extraNumber == 0 && numbersFound >= 0) {
                        extraNumberWasFound = true;
                    }
                }
            }

            if (bb < 4) return PlayResult.NO_WIN;
            else if (bb == 4 && extraNumberWasFound)
                return PlayResult.FOUND_4PLUS1;
            else if (bb == 4) return PlayResult.FOUND_4;
            else if (bb == 5 && extraNumberWasFound)
                return PlayResult.FOUND_5PLUS1;
            else if (bb == 5)
                return PlayResult.FOUND_5;
            else
                return PlayResult.FOUND_6;
        } else return PlayResult.FOUND_6;
    }
}
