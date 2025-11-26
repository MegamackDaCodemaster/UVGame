package se.yrgo.game.monster;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrollTest {
    private Troll troll = new Troll();

    @Test
    void shouldCreateInstanceWithProvidedValues() {
        var customTroll = new Troll("custum-made troll",
                "A horrible monster of a troll",
                5000,
                5000,
                5000);

        assertInstanceOf(Troll.class, customTroll);
        assertEquals("custum-made troll", customTroll.getMonsterType());
        assertEquals(5000, customTroll.getStrength());
    }

    @Test
    void shouldThrowNullPointerEx_whenGivenNullValsRequiredInConstructor() {
        assertThrows(NullPointerException.class, () -> {
                    var customTroll = new Troll(null,
                            null,
                            5000,
                            5000,
                            5000);
                }
        );
    }

    @Test
    void shouldThrowIllArgEx_whenGivenZeroOrNegativeFieldValsInConstructor() {
        assertThrows(IllegalArgumentException.class, () -> {
                    var customTroll = new Troll("custum-made troll",
                            "A horrible monster of a troll",
                            0,
                            -10,
                            0);
                }
        );
    }

    @RepeatedTest(5000)
    void shouldReturnValuesBetweenOneAndStrengthFieldValue() {
        int randomAttack = troll.getRandomAttack();
        assertTrue(randomAttack > 0 && randomAttack <= troll.getStrength());
    }

    @Test
    void shouldNotChangeHealthVal_ifArgIsNegative() {
        int healthBeforeWound = troll.getHealth();
        troll.wound(-10);
        assertEquals(healthBeforeWound, troll.getHealth());
    }
}