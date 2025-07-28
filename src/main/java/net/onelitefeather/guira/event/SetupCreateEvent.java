package net.onelitefeather.guira.event;

import net.minestom.server.event.Event;
import net.minestom.server.event.trait.CancellableEvent;
import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.NotNull;

/**
 * The {@link SetupCreateEvent} can be used to indicate that a setup has started by the owner.
 * You need to call it on your own and the handling of it.
 *
 * @author thEvilReaper
 * @version 1.0.0
 * @since 0.1.0
 */
public class SetupCreateEvent implements Event, CancellableEvent {

    private boolean cancelled;
    private final SetupData data;

    /**
     * Creates a new instance of {@link SetupCreateEvent} with the given {@link SetupData}.
     *
     * @param data the setup data that is involved in the event
     */
    public SetupCreateEvent(@NotNull SetupData data) {
        this.data = data;
    }

    /**
     * Returns the involved {@link SetupData} reference.
     *
     * @return the reference
     */
    public SetupData getData() {
        return data;
    }

    /**
     * Set a new state of the cancellation
     *
     * @param cancelled true if the event should be cancelled, false otherwise
     */
    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    /**
     * Returns the cancellation state from the event.
     *
     * @return the state of cancellation
     */
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }
}
