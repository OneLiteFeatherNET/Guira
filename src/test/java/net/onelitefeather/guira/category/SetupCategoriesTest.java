package net.onelitefeather.guira.category;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.item.Material;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SetupCategoriesTest {

    private static final String NAMESPACE = "guira";

    static Stream<Named<TestCase>> categories() {
        return Stream.of(
                testCase("NAME", SetupCategories.NAME, "map_data/name", "Name",
                        Material.ACACIA_SIGN, NamedTextColor.YELLOW),
                testCase("AUTHOR", SetupCategories.AUTHOR, "map_data/author", "Builder",
                        Material.DARK_OAK_DOOR, NamedTextColor.AQUA),
                testCase("SPAWN", SetupCategories.SPAWN, "map_data/spawn", "Spawn",
                        Material.COMPASS, NamedTextColor.RED)
        );
    }

    private static Named<TestCase> testCase(
            String displayName,
            Category category,
            String keyValue,
            String name,
            Material material,
            NamedTextColor color
    ) {
        return Named.of(displayName, new TestCase(category, Key.key(NAMESPACE, keyValue), name, material, color));
    }

    @ParameterizedTest
    @MethodSource("categories")
    void shouldProvideCorrectCategory(TestCase testCase) {
        assertAll(
                () -> assertEquals(testCase.key(), testCase.category().key()),
                () -> assertEquals(testCase.name(), testCase.category().displayName()),
                () -> assertEquals(testCase.material(), testCase.category().material()),
                () -> assertEquals(testCase.color(), testCase.category().color())
        );
    }

    private record TestCase(
            Category category,
            Key key,
            String name,
            Material material,
            NamedTextColor color
    ) {
    }
}