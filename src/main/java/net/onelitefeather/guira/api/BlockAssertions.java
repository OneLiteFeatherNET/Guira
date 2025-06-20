package net.onelitefeather.guira.api;

import net.minestom.server.coordinate.Point;
import net.minestom.server.instance.Instance;
import net.minestom.server.instance.block.Block;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApiStatus.NonExtendable
public final class BlockAssertions {

    /**
     * Asserts that the given block has the expected properties.
     *
     * @param expectedProperties the expected properties of the block
     * @param block              the block to check
     */
    public static void assertProperties(@NotNull Map<String, String> expectedProperties, @NotNull Block block) {
        assertEquals(expectedProperties.size(), block.properties().size(), "Block properties size mismatch");

        for (Map.Entry<String, String> entry : expectedProperties.entrySet()) {
            String property = entry.getKey();
            String expectedValue = entry.getValue();
            String actualValue = block.getProperty(property);
            assertEquals(expectedValue, actualValue, "Property '" + property + "' value mismatch");
        }
    }

    /**
     * Asserts that the given block is present at the specified positions.
     *
     * @param expected  the expected block
     * @param positions the positions to check
     * @param instance  the instance to check the blocks in
     */
    public static <T extends Point> void assertBlock(
            @NotNull Block expected,
            @NotNull Collection<T> positions,
            @NotNull Instance instance
    ) {
        String blockName = expected.name();
        for (T testPosition : positions) {
            Block block = instance.getBlock(testPosition);
            assertNotNull(block);
            assertEquals(expected, block, "The block at " + testPosition + " should be a " + blockName);
        }
    }

    private BlockAssertions() {
        /* no-op */
    }
}
