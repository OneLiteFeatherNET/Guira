package net.onelitefeather.guira;

import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.UnmodifiableView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * The {@link SetupDataServiceImpl} is an implementation of the {@link SetupDataService} interface.
 * It provides methods to manage setup data associated with unique identifiers (UUIDs).
 * This service allows adding, removing, retrieving, and clearing setup data.
 *
 * @author theEvilReaper
 * @version 1.0.0
 * @since 0.1.0
 */
public final class SetupDataServiceImpl implements SetupDataService {

    private final Map<UUID, SetupData> dataMap;

    /**
     * Creates a new instance of {@link SetupDataServiceImpl} with an empty data map.
     */
    SetupDataServiceImpl() {
        this.dataMap = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        if (this.dataMap.isEmpty()) return;
        this.dataMap.clear();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmpty() {
        return this.dataMap.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(UUID uuid, SetupData data) {
        dataMap.put(uuid, data);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<SetupData> remove(UUID uuid) {
        return Optional.ofNullable(this.dataMap.remove(uuid));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<SetupData> get(UUID uuid) {
        return Optional.ofNullable(this.dataMap.get(uuid));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public @UnmodifiableView Map<UUID, SetupData> getView() {
        return Collections.unmodifiableMap(this.dataMap);
    }
}
