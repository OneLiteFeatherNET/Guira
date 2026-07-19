package net.onelitefeather.guira.category;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.format.TextColor;
import net.minestom.server.item.Material;

/**
 * Implementation of {@link Category} that provides basic information about a category.
 *
 * @param key         of the category
 * @param displayName of the category
 * @param material    of the category
 * @param color       of the category
 * @author theEvilReaper
 * @version 1.0.0
 * @since 0.10.0
 */
public record BasicCategory(
        Key key,
        String displayName,
        Material material,
        TextColor color
) implements Category {

}
