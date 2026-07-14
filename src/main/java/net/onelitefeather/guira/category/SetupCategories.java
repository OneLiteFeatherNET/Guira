package net.onelitefeather.guira.category;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.format.NamedTextColor;
import net.minestom.server.item.Material;

/**
 * Helper class for providing predefined {@link Category} instances.
 *
 * @author theEvilReaper
 * @version 1.0.0
 * @since 0.10.0
 */
public final class SetupCategories {

    private static final String NAMESPACE = "guira";

    public static final Category NAME =
            new BasicCategory(Key.key(NAMESPACE, "map_data/name"), "Name", Material.ACACIA_SIGN, NamedTextColor.YELLOW);
    public static final Category AUTHOR =
            new BasicCategory(Key.key(NAMESPACE, "map_data/author"), "Builder", Material.DARK_OAK_DOOR, NamedTextColor.AQUA);
    public static final Category SPAWN =
            new BasicCategory(Key.key(NAMESPACE, "map_data/spawn"), "Spawn", Material.COMPASS, NamedTextColor.RED);

    private SetupCategories() {
        // Nothing to do here
    }
}
