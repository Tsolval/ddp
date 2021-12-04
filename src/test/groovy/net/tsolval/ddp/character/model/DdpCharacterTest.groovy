package net.tsolval.ddp.character.model

import org.junit.jupiter.api.Test

class DdpCharacterTest {

    @Test
    void testCharacter() {
        def character = [
                fluff: [name: 'test', age: '22'],
                stats: [strength: 8, dexterity: 16, constitution: 16, intelligence: 12, wisdom: 13, charisma: 17],
                race: [name: 'Dragonborn', subrace: 'Metallic Dragonborn', type: 'humanoid', size: 'medium',
                       asi: [charisma: 1, constitution: 2]],
                actions: [
                        attack: [
                                replaces: 'attack',
                                name: 'Cold Breath',
                                range: "15' cone",
                                save: 'dexterity',
                                dc: 'constitution',
                                target: 'area',
                                damage: '1d10 cold',
                                saveFor: 'half',
                                limited: 'proficiency',
                                recover: 'long rest' ]
                ],
                feats: [ [name: 'feat1'], [name: 'feat2'], [name: 'feat3'], ]
        ] as DdpCharacter

        character.feats << [name: 'feat4']

        assert character.fluff.name == 'test'
        assert character.fluff.age == '22'
        assert character.feats.size() == 4
        assert character.feats.collect { it.name } == ['feat1', 'feat2', 'feat3', 'feat4']
        assert character.race.asi['charisma'] == 1
        assert character.stats.collect { it.value + (character.race.asi.get(it.key)?:0) } == [8, 16, 18, 12, 13, 18]
    }
}
