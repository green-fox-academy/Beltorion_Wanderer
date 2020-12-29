package com.beltorion.wanderer.repositories;

public enum TileType {

    floor("floor", false),
    wall("wall", true);

    String textureName;
    boolean wallType;

    TileType(String textureName, boolean wallType) {
        this.textureName = textureName;
        this.wallType = wallType;
    }
}
