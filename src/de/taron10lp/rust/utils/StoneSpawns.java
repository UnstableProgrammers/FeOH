package de.taron10lp.rust.utils;

import de.taron10lp.rust.main.Rust;
import org.bukkit.Location;
import org.bukkit.Material;

import java.util.ArrayList;

public class StoneSpawns {

    private Rust plugin;

    private ArrayList<Location> stoneSpawnpoints = new ArrayList<>();

    public StoneSpawns(Rust plugin) {
        this.plugin = plugin;
    }

    public ArrayList<Location> getStoneSpawnpoints() { return stoneSpawnpoints; }
    public void addStoneSpawns(Location location) { stoneSpawnpoints.add(location); }
}