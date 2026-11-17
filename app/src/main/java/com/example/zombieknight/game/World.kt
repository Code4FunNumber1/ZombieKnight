package com.example.zombieknight.game

import com.example.zombieknight.game.Type.*

class World(val input: Input) {

    val tileMap = Array(ROWS) {
        Array(COLS) { EMPTY }
    }

    val tiles = mutableSetOf<Tile>()
    val platforms = mutableListOf<Tile>()
    val portals = mutableListOf<Portal>()
    val bullets = mutableListOf<Bullet>()
    val rubies = mutableListOf<Ruby>()
    lateinit var rubyMaker : RubyMaker
    private val background = Assets.image("background.png")

    private val screen = Rect(Vec2(0f, 0f), Vec2(Entity.WINDOW_WIDTH, Entity.WINDOW_HEIGHT))

    init {
        makeMap()
        buildLevel()
        //game = Game(this, player)
        //game.pauseGame("Zombie Knight",
    }

    private fun makeMap() {
        putPlatform(3,0,14)
        putPlatform(3,25,39)
        putPlatform(8,11,28)
        putPlatform(10,0,5)
        putPlatform(10,34,39)
        putPlatform(15,0,15)
        putPlatform(15,24,39)
        putPlatform(18,18,21)
        fillRow(21, GROUND)
        fillRow(22, DIRT)
    }

    private fun buildLevel() {
        for (row in tileMap.indices) {
            for (col in tileMap[row].indices){
                val pos = Vec2(col * Tile.SIZE.x, row * Tile.SIZE.y)
                when (val type = tileMap[row][col]) {
                    EMPTY -> {}
                    DIRT, GROUND, LEFT_PLATFORM, CENTER_PLATFORM, RIGHT_PLATFORM ->
                        addTile(pos, type)
                }
            }
        }
    }

    private fun putPlatform(row: Int, first: Int, last: Int) {
        for (col in first..last) tileMap[row][col] = CENTER_PLATFORM
        if (first > 0) tileMap[row][first] = LEFT_PLATFORM
        if (last < COLS - 1) tileMap[row][last] = RIGHT_PLATFORM
    }

    private fun fillRow(row: Int, type: Type) {
        for (col in 0..<COLS) tileMap[row][col] = RIGHT_PLATFORM
    }

    private fun addTile(pos: Vec2, type: Type) {
        val tile = Tile(pos, type)
        tiles.add(tile)
        if (tile.isPlatform) platforms.add(tile)
    }

    private fun addPortal(pos: Vec2, color: String) {
        portals.add(Portal(pos, color))
    }

    companion object {
        const val ROWS = 23
        const val COLS = 40
    }
}