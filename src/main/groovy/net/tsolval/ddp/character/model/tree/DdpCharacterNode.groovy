package net.tsolval.ddp.character.model.tree

class DdpCharacterNode {

    // tree links
    DdpCharacterNode parent // null means this is root
    DdpCharacterNode child // contains info about level

    def crunch = [:]

    void setChild(DdpCharacterNode node) {
        node.parent = this
        this.child = node
    }

    List<DdpCharacterNode> getChildren() {
        def result = child?.children
        [child, *result] - null
    }

    def propertyMissing(String name) {
        this.children.crunch?[name].sum()
    }

    @Override
    String toString() {
        "Crunch: [$crunch]"
    }
}
