package net.onelitefeather.guira.category;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.minestom.server.item.Material;

/**
 * @author theEvilReaper
 * @version 1.0.0
 * @since 0.10.0
 */
public interface Category {

    /**
     * Returns the key of the category.
     *
     * @return the key
     */
    Key key();

    /**
     * Returns the display name of the category.
     *
     * @return the display name
     */
    String displayName();

    /**
     * Returns the material associated with the category.
     *
     * @return the material
     */
    Material material();

    /**
     * Returns the color associated with the category.
     *
     * @return the color
     */
    TextColor color();
}
