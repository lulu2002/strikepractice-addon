package org.mcwonderland

import be.seeseemelk.mockbukkit.MockBukkit
import be.seeseemelk.mockbukkit.ServerMock
import be.seeseemelk.mockbukkit.entity.PlayerMock
import be.seeseemelk.mockbukkit.entity.PlayerMockFactory
import org.bukkit.entity.Player
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import kotlin.test.assertEquals

abstract class BukkitTestBase {
    protected lateinit var server: ServerMock
    protected lateinit var playerFactory: PlayerMockFactory

    @BeforeEach
    fun loadMockBukkit() {
        server = MockBukkit.mock()
        playerFactory = PlayerMockFactory(server)
    }

    @AfterEach
    fun unloadMockBukkit() {
        MockBukkit.unmock()
    }

    fun Player.assertMessageSent(messages: List<String>) {
        messages.forEach { assertEquals(it.color(), (this as PlayerMock).nextMessage()) }
    }
}