package net.onelitefeather.guira.functional;

import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
public interface SetupDataGetter<T extends SetupData<?>> {

    /**
     * Retrieves the setup data for the specified UUID.
     *
     * @param uuid the UUID of the player
     * @return the setup data associated with the UUID, or null if no data exists
     */
    @Nullable T getData(@NotNull UUID uuid);
}
