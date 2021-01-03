package lorena

import discord4j.core.DiscordClient
import kotlin.test.Test
import kotlin.test.assertNotNull

class BotTest {
    @Test fun testEstablishDiscordConnection() {
        val classUnderTest = Bot()
        assertNotNull(classUnderTest.token, "app should have a bot token")
        assertNotNull(DiscordClient.create(classUnderTest.token), "connection is failing")
    }
}
