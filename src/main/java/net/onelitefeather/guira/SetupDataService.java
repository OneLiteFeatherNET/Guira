package net.onelitefeather.guira;

import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * The {@link SetupDataService} is responsible for managing setup data during a runtime session.
 * It allows adding, removing, and retrieving setup data associated with a unique identifier (UUID).
 *

 * @author thEvilReaper
 * @version 1.0.0
 * @since 0.1.0
 */
public interface SetupDataService {

    /**
     * Creates a new instance of SetupDataService.
     *
     * @return a new instance of SetupDataService
     */
    @Contract(pure = true)
    static @NotNull SetupDataService create() {
        return new SetupDataServiceImpl();
    }

    /**
     * Checks if the service contains any setup data.
     *
     * @return true if the service is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Clears all setup data from the service.
     * This method removes all entries from the setup data map.
     */
    void clear();

    /**
     * Adds new setup data to the service.
     *
     * @param uuid the unique identifier for the setup data
     * @param data the setup data to add
     */
    void add(@NotNull UUID uuid, @NotNull SetupData data);

    /**
     * Removes the setup data associated with the given UUID.
     *
     * @param uuid the unique identifier for the setup data
     * @return an optional containing the removed setup data, or empty if not found
     */
    @NotNull Optional<@Nullable SetupData> remove(@NotNull UUID uuid);

    /**
     * Retrieves the setup data associated with the given UUID.
     *
     * @param uuid the unique identifier for the setup data
     * @return an optional containing the setup data, or empty if not found
     */
    @NotNull Optional<@Nullable SetupData> get(@NotNull UUID uuid);

    /**
     * Returns an unmodifiable view of the setup data map.
     *
     * @return an unmodifiable view
     */
    @NotNull
    @UnmodifiableView
    Map<UUID, SetupData> getView();
}
