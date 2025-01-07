package us.timinc.mc.cobblemon.spawnnotification.events

import com.cobblemon.mod.common.api.events.pokemon.PokemonSentPostEvent
import us.timinc.mc.cobblemon.spawnnotification.SpawnNotification.LEGENDARY_SOUND_EVENT
import us.timinc.mc.cobblemon.spawnnotification.SpawnNotification.SHINY_SOUND_EVENT
import us.timinc.mc.cobblemon.spawnnotification.SpawnNotification.config
import us.timinc.mc.cobblemon.spawnnotification.broadcasters.SoundBroadcaster

object PlayShinyPlayerSound {
    fun handle(evt: PokemonSentPostEvent) {
        if (config.playShinySoundPlayer && evt.pokemon.shiny) {
            SoundBroadcaster(
                evt.pokemonEntity.world,
                evt.pokemonEntity.blockPos,
                SHINY_SOUND_EVENT
            ).playSound()
        }
        if(config.playLegendarySoundPlayer && evt.pokemon.hasLabels("legendary")){
            SoundBroadcaster(
                evt.pokemonEntity.world,
                evt.pokemonEntity.blockPos,
                LEGENDARY_SOUND_EVENT
            ).playSound()
        }
    }
}