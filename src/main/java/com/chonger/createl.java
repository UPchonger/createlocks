package com.chonger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class createl implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String a1 = strings[0];

        if (a1.equals("help")){
            commandSender.sendMessage("[createlocks]帮助菜单：给玩家createlocks.true权限节点才能保持他的创造模式否则会变成生存模式");
        }

        return false;
    }
}
