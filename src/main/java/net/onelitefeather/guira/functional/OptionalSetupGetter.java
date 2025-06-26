package net.onelitefeather.guira.functional;

import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.UUID;

/**
 * Functional interface for getting setup data associated with a specific UUID.
 *
 * @param <T> the type of setup data
 * @author theEvilReaper
 * @version 0.1.0
 * @since 0.3.0
 */
@FunctionalInterface
public interface OptionalSetupGetter<T extends SetupData<?>> {

    /**
     * Gets the setup data for the given UUID.
     *
     * @param uuid the UUID of the player
     * @return an Optional containing the setup data if it exists, or an empty Optional if it does not
     */
    @NotNull Optional<@Nullable T> get(@NotNull UUID uuid);
}
