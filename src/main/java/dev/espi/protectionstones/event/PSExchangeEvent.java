package dev.espi.protectionstones.event;

import dev.espi.protectionstones.PSRegion;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Event that is called when a protection stones region is sold
 * Cancelling this event will prevent the region from being sold
 */
public class PSExchangeEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS = new HandlerList();

    private final PSRegion region;
    private final UUID buyer;
    private final UUID seller;
    private boolean isCancelled = false;

    public PSExchangeEvent(PSRegion region, UUID buyer, UUID seller) {
        this.region = checkNotNull(region);
        this.buyer = checkNotNull(buyer);
        this.seller = checkNotNull(seller);
    }

    /**
     * Returns the region being exchanged.
     * @return the region being exchanged
     */
    public PSRegion getRegion() {
        return region;
    }

    /**
     * Returns the uuid of the player that is buying the region.
     * @return the uuid of the player that is buying the region
     */
    public UUID getBuyer() {
        return buyer;
    }

    /**
     * Returns the uuid of the player that is selling the region.
     * @return the uuid of the player that is selling the region
     */
    public UUID getSeller() {
        return seller;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}
