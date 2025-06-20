package net.onelitefeather.guira.event;

import net.theevilreaper.aves.map.BaseMap;
import net.minestom.server.event.Event;
import net.minestom.server.event.trait.CancellableEvent;
import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.NotNull;

/**
 * The {@link SetupFinishEvent} can be used to indicate that a setup process has been finished by the user.
 * If your use case has some condition which needs to be checked before the setup process is finished, you can cancel
 * the event. But you need to handle the cancellation yourself.
 *
 * @param <T> the reference type of the map
 * @author theEvilReaper
 * @version 1.0.0
 * @since 0.1.0
 */
public class SetupFinishEvent<T extends SetupData<? extends BaseMap>> implements Event, CancellableEvent {

    private final @NotNull T setupData;
    private boolean cancelled;

    /**
     * Creates a new instance of the {@link SetupFinishEvent} class.
     *
     * @param setupData the setup data of the event
     */
    public SetupFinishEvent(@NotNull T setupData) {
        this.setupData = setupData;
    }

    /**
     * Sets the event to be cancelled.
     *
     * @param cancelled true if the event should be cancelled, false otherwise
     */
    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Returns if the event is cancelled.
     *
     * @return {@code true} if the event is cancelled
     */
    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * Returns the setup data of the event.
     *
     * @return the setup data
     */
    public @NotNull T getData() {
        return setupData;
    }
}
