package org.mcwonderland

import org.bukkit.ChatColor
import org.bukkit.entity.Player

fun String.color(): String {
    return ChatColor.translateAlternateColorCodes('&', this)
}

fun Player.msg(msg: String) {
    this.sendMessage(msg.color())
}

fun Player.msg(msg: List<String>) {
    msg.forEach { this.msg(it) }
}