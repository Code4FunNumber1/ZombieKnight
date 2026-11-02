package com.example.zombieknight.game

object RubyMaker :
        Entity(Vec2(64f, 64f)) {

    private val frames = loadTiles("ruby", 7)

    init {
        showTexture(frames[0])
        setBottomLeft(Vec2(20 * 32f, 0f))
    }

    fun update() {
        animate(frames, 0.25f)
    }
}