package net.onelitefeather.guira.functional;

import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Functional interface for getting setup data associated with a specific {@link UUID}.
 *
 * @author theEvilReaper
 * @version 0.1.0
 * @since 0.3.0
 */
@FunctionalInterface
public interface SetupDataGetter {

    /**
     * Retrieves the setup data for the specified {@link UUID}.
     *
     * @param uuid the {@link UUID} of the player
     * @return the setup data associated with the {@link UUID}, or null if no data exists
     */
    @Nullable SetupData getData(@NotNull UUID uuid);
}
