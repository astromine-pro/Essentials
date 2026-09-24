package com.earth2me.essentials.commands;

import com.earth2me.essentials.CommandSource;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class Commandping extends EssentialsCommand {
    public Commandping() {
        super("ping");
    }

    @Override
    public void run(final Server server, final CommandSource sender, final String commandLabel, final String[] args) throws Exception {
        if (args.length == 0) {
            if (!sender.isPlayer()) {
                throw new NotEnoughArgumentsException();
            }
            sender.sendTl("pingSelf", sender.getPlayer().spigot().getPing());
            return;
        }

        if (args.length != 1 || !sender.isAuthorized("essentials.ping.others")) {
            throw new NotEnoughArgumentsException();
        }

        final Player target = getPlayer(server, sender, args, 0).getBase();
        sender.sendTl("pingOther", target.getName(), target.spigot().getPing());
    }

    @Override
    protected List<String> getTabCompleteOptions(final Server server, final CommandSource sender, final String commandLabel, final String[] args) {
        return args.length == 1 && sender.isAuthorized("essentials.ping.others") ? getPlayers(sender) : Collections.emptyList();
    }
}
