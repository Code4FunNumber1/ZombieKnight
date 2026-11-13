package com.example.zombieknight.game

class World(val input: Input) {

    val tileMap = Array(ROWS) {
        MutableList(40) {Type.EMPTY}
    }

    val tiles = mutableSetOf<Tile>()
    val platforms = mutableListOf<Tile>()
    val portals = mutableListOf<Portal>()
    val bullets = mutableListOf<Bullet>()
    val rubies = mutableListOf<Ruby>()
    lateinit var rubyMaker : RubyMaker
    private val background = Assets.image("background.png")

    init {

    }

    companion object {
        const val ROWS = 23
        const val COLS = 40
    }
}