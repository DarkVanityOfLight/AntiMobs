package com.github.DarkVanityOfLight.AntiMobs

import com.github.DarkVanityOfLight.AntiMobs.listeners.EntitySpawn
import com.github.DarkVanityOfLight.AntiMobs.parsers.ConfigParser
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin(){
    private val configParser : ConfigParser = ConfigParser(this, this.config)

    override fun onEnable() {
        Bukkit.getPluginManager().registerEvents(EntitySpawn(configParser), this)
        configParser.reload()
    }

    companion object{
        fun debugLog(message : String){
            Bukkit.getLogger().info("[AntiMobs] [Debug]: $message")
        }
    }
}