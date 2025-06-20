package net.onelitefeather.guira.api;

import net.minestom.server.coordinate.Point;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiStatus.NonExtendable
public final class PointAssertions {

    public static void assertPointsEquals(@NotNull Collection<Point> expected, @NotNull Collection<Point> actual) {
        if (expected.size() != actual.size()) {
            throw new AssertionError("Expected size: " + expected.size() + ", but was: " + actual.size());
        }



        for (int i = 0; i < expected.size(); i++) {
            Point exp = expected.get(i);
            Point act = actual.get(i);
            assertEquals(exp, act);
            if (!exp.equals(act)) {
                throw new AssertionError("Points at index " + i + " are not equal: expected " + exp + ", but was " + act);
            }
        }
    }

    protected PointAssertions() {
        // Prevent instantiation
    }
}
