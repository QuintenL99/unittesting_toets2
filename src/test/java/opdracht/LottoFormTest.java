package opdracht;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoFormTest {

    @Test
    void lottoformNullSet() {
        assertThrows(IllegalArgumentException.class, () -> new LottoForm(null));
    }
}
