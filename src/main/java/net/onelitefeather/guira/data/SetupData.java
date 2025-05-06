package net.onelitefeather.guira.data;

import net.theevilreaper.aves.map.BaseMap;
import net.theevilreaper.aves.map.MapEntry;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.UUID;

/**
 * The {@link SetupData} interface defines an object which contains all relevant values about a setup instance.
 *
 * @param <T> the reference type of the map
 */
public sealed interface SetupData<T extends BaseMap> permits BaseSetupData {

    /**
     * Can be used to save the data from the setup into another format.
     */
    void save();

    /**
     * Can be used to reset the setup data.
     */
    void reset();

    /**
     * Can be used to trigger the load process of the data from a file.
     */
    void loadData();

    /**
     * Returns if the setup data has a map file.
     *
     * @return {@code true} if the setup data has a map
     */
    boolean hasMapFile();

    /**
     * Returns the owner of the setup data.
     *
     * @return the owner as {@link UUID}
     */
    @NotNull UUID getId();

    /**
     * Returns the map of the setup data.
     *
     * @return the map as {@link BaseMap}
     */
    @NotNull Optional<T> getMap();

    /**
     * Returns the map entry of the setup data.
     *
     * @return the map entry as {@link MapEntry}
     */
    @NotNull MapEntry getEntry();
}
