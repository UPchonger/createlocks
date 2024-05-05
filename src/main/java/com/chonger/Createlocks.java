package com.chonger;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.permissions.Permission;
import org.slf4j.Logger;
import org.bukkit.event.EventHandler;

public final class Createlocks extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[createlocks]欢迎使用创造锁插件！");
        Bukkit.getPluginCommand(  "createl").setExecutor(new createl());
        // 注册权限
        this.getServer().getPluginManager().addPermission(new Permission("createlocks.true"));
        // 注册事件监听器
        this.getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public Logger getSLF4JLogger() {
        return super.getSLF4JLogger();
    }

    @EventHandler
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode newGameMode = event.getNewGameMode();

        // 检查玩家是否尝试切换到创造模式
        if (newGameMode == GameMode.CREATIVE && !player.hasPermission("createlocks.true")) {
            // 异步延迟执行游戏模式切换
            Bukkit.getScheduler().runTaskLater(this, () -> {
                // 切换回生存模式
                player.setGameMode(GameMode.SURVIVAL);
                // 向玩家发送消息通知
                player.sendMessage("你没有权限切换到创造模式，已被自动切换回生存模式。");
            }, 1L); // 1 tick 延迟执行
        }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[createlocks]再见！");
    }
}
