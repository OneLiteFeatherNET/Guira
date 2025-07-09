package net.onelitefeather.guira.event;

import net.minestom.server.event.Event;
import net.minestom.server.event.trait.CancellableEvent;
import net.onelitefeather.guira.data.SetupData;
import org.jetbrains.annotations.NotNull;

/**
 * The {@link SetupFinishEvent} can be used to indicate that a setup process has been finished by the user.
 * If your use case has some condition that needs to be checked before the setup process is finished, you can cancel
 * the event. But you need to handle the cancellation yourself.
 *
 * @author theEvilReaper
 * @version 1.0.0
 * @since 0.1.0
 */
public class SetupFinishEvent implements Event, CancellableEvent {

    private final SetupData setupData;
    private boolean cancelled;

    /**
     * Creates a new instance of the {@link SetupFinishEvent} class.
     *
     * @param setupData the setup data of the event
     */
    public SetupFinishEvent(@NotNull SetupData setupData) {
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
    public @NotNull SetupData getData() {
        return setupData;
    }
}
