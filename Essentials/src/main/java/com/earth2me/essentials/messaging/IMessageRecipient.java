package com.earth2me.essentials.messaging;

import net.essentialsx.api.v2.services.mail.MailSender;
import org.bukkit.entity.Player;

/**
 * Represents an interface for message recipients.
 */
public interface IMessageRecipient extends MailSender {

    /**
     * Sends (prints) a message to this recipient.
     *
     * @param message message
     */
    void sendMessage(String message);

    /**
     * Sends a translated message to this recipient.
     *
     * @param tlKey key
     * @param args  arguments
     */
    void sendTl(String tlKey, Object... args);

    /**
     * Returns the name of this recipient. This name is typically used internally to identify this recipient.
     *
     * @return name of this recipient
     * @see #getDisplayName()
     */
    String getName();

    /**
     * Returns the display name of this recipient. This name is typically used when formatting messages.
     *
     * @return display name of this recipient
     */
    String getDisplayName();

    boolean isHiddenFrom(Player player);
}
