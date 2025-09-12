package net.onelitefeather.guira.data;

import net.theevilreaper.aves.map.BaseMap;
import net.theevilreaper.aves.map.MapEntry;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * The {@link MapSetupData} is a generic implementation of the {@link SetupData} interface.
 * It provides a basic implementation and needs to be extended by a specific setup data class.
 *
 * @param <T> the reference type of the map
 * @author theEvilReaper
 * @version 1.0.1
 * @since 0.1.0
 */
public abstract class MapSetupData<T extends BaseMap> implements SetupData {

    protected final UUID uuid;
    protected final MapEntry mapEntry;
    protected @Nullable  T map;

    /**
     * Creates a new instance of {@link MapSetupData} with the given UUID and map entry.
     *
     * @param uuid     the unique identifier for the map setup data
     * @param mapEntry the map entry containing the map information
     */
    protected MapSetupData(UUID uuid, MapEntry mapEntry) {
        this.uuid = uuid;
        this.mapEntry = mapEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MapSetupData<?> that)) return false;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(uuid);
    }

    /**
     * Returns if the setup data has a map file.
     *
     * @return {@code true} if the setup data has a map
     */
    public boolean hasMapFile() {
        return this.mapEntry.hasMapFile();
    }

    /**
     * Returns the map entry of the setup data.
     *
     * @return the map entry as {@link MapEntry}
     */
    public MapEntry getEntry() {
        return this.mapEntry;
    }

    /**
     * Returns the map of the setup data.
     *
     * @return the map as {@link BaseMap}
     */
    public UUID getId() {
        return this.uuid;
    }

    /**
     * Returns the map of the setup data if it exists.
     *
     * @return an {@link Optional} containing the map if it exists, otherwise empty
     */
    public Optional<@Nullable T> getMap() {
        return Optional.ofNullable(this.map);
    }
}
