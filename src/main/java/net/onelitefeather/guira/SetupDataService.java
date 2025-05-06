package net.onelitefeather.guira;

import net.theevilreaper.aves.map.BaseMap;
import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * The (@link SetupDataService} is responsible for managing setup data during a runtime session.
 * It allows adding, removing, and retrieving setup data associated with a unique identifier (UUID).
 *
 * @param <T> the type of setup data
 * @author thEvilReaper
 * @version 1.0.0
 * @since 0.1.0
 */
public interface SetupDataService<T extends SetupData<? extends BaseMap>> {

    /**
     * Creates a new instance of SetupDataService.
     *
     * @param <T> the type of setup data
     * @return a new instance of SetupDataService
     */
    @Contract(pure = true)
    static @NotNull <T extends SetupData<? extends BaseMap>> SetupDataService<T> create() {
        return new SetupDataServiceImpl<>();
    }

    /**
     * Adds a new setup data to the service.
     *
     * @param uuid the unique identifier for the setup data
     * @param data the setup data to add
     */
    void add(@NotNull UUID uuid, @NotNull T data);

    /**
     * Removes the setup data associated with the given UUID.
     *
     * @param uuid the unique identifier for the setup data
     * @return an optional containing the removed setup data, or empty if not found
     */
    @NotNull Optional<@Nullable T> remove(@NotNull UUID uuid);

    /**
     * Retrieves the setup data associated with the given UUID.
     *
     * @param uuid the unique identifier for the setup data
     * @return an optional containing the setup data, or empty if not found
     */
    @NotNull Optional<@Nullable T> get(@NotNull UUID uuid);

    /**
     * Returns an unmodifiable view of the setup data map.
     *
     * @return an unmodifiable view
     */
    @NotNull
    @UnmodifiableView
    Map<UUID, T> getView();
}
