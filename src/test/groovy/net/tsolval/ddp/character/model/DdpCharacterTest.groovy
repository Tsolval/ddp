package net.tsolval.ddp.character.model

import org.junit.jupiter.api.*

class DdpCharacterTest {

    @Test
    void testCharacter() {
        def character = [
                fluff: [name: 'test', age: '22'],
                feats: [
                    [name: 'feat1'],
                    [name: 'feat2'],
                    [name: 'feat3'],
                ]
        ] as DdpCharacter

        character.feats << [name: 'feat4']

        assert character.fluff.name == 'test'
        assert character.fluff.age == '22'
        assert character.feats.size() == 4
        assert character.feats.collect {it.name} == ['feat1', 'feat2', 'feat3', 'feat4']
    }
}
