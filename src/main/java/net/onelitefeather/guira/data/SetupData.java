package net.onelitefeather.guira.data;

import java.util.UUID;

/**
 * The {@link SetupData} interface defines an object which contains all relevant values about a setup instance.
 *
 * @author theEvilReaper
 * @version 1.2.0
 * @since 0.1.0
 */
public interface SetupData {

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
     * Returns the owner of the setup data.
     *
     * @return the owner as {@link UUID}
     */
    UUID getId();
}
