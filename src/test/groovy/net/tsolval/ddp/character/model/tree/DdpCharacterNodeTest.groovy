package net.tsolval.ddp.character.model.tree

import org.junit.jupiter.api.*

class DdpCharacterNodeTest {

    @Test
    void testCharacter() {
        def character = new DdpCharacterNode()
        def race = new DdpCharacterNode(crunch: [strength: 1, dexterity: 2])
        def abilities = new DdpCharacterNode(crunch: [strength: 12, dexterity: 15])

        character.child = race
        race.child = abilities

        assert character.children.size() == 2
        assert character.children.crunch['strength'].sum() == 13
        assert character.strength == 13
        assert character.dexterity == 17
    }
}
