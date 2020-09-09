package com.github.DarkVanityOfLight.AntiMobs.listeners

import com.github.DarkVanityOfLight.AntiMobs.parsers.ConfigParser
import com.massivecraft.factions.Board
import com.massivecraft.factions.FLocation
import com.massivecraft.factions.Faction
import com.massivecraft.factions.FactionsPlugin
import org.bukkit.Bukkit
import org.bukkit.entity.LivingEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntitySpawnEvent

class EntitySpawn(val configParser: ConfigParser) : Listener{

    @EventHandler
    fun onEntitySpawn(event: EntitySpawnEvent){
        if (event.entity is LivingEntity && event.entity !is  Player){
            val board : Board = Board.getInstance()
            val faction : Faction = board.getFactionAt(FLocation(event.entity.location))
            if (faction.tag !in configParser.enabledSpawnFactions || (!configParser.spawnInWilderness && faction.isWilderness)){
                event.isCancelled = true
            }

        }
    }
}