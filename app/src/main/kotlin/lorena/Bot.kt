/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package lorena

import discord4j.core.DiscordClient
import discord4j.core.event.domain.message.MessageCreateEvent
import discord4j.core.event.domain.message.ReactionAddEvent
import discord4j.core.event.domain.message.ReactionRemoveEvent
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactor.mono
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import reactor.util.Loggers


class Bot {
    val token: String = "INSERT TOKEN HERE"
    val logger: Logger = LogManager.getLogger()
}

fun main(args: Array<String>) {
    val client = DiscordClient.create(Bot().token)
    

    Loggers.useConsoleLoggers()

    client.withGateway {
        mono {
            //Bot commands list
            it.on(MessageCreateEvent::class.java)
                    .asFlow()
                    .collect {
                        val message = it.message
                        if(message.content.split(" ").get(0) == "!lore") {
                            when(message.content.split(" ").get(1)) {
                                "ping" -> {
                                    val channel = message.channel.awaitSingle()
                                    channel.createMessage("Pong!").awaitSingle()
                                }
                            }
                        }
                    }
            /* Reaction event handling*/
            // Added Reaction
            it.on(ReactionAddEvent::class.java)
                    .asFlow()
                    .collect {
                        val
                        TODO()
                    }
            // Removed Reaction
            it.on(ReactionRemoveEvent::class.java)
                    .asFlow()
                    .collect {
                        TODO()
                    }
        }
    }
            .block()
}
