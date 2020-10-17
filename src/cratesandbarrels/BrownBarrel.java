package cratesandbarrels;

import de.taron10lp.rust.main.Rust;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Random;

public class BrownBarrel extends Barrel {

    private BarrelManager barrelManager;
    private Rust plugin;

    private ArrayList<ItemStack> loot = new ArrayList<>();
    private ArrayList<ItemStack> possibleLoot = new ArrayList<>();

    public BrownBarrel(BarrelManager barrelManager, Rust plugin) {
        this.barrelManager = barrelManager;
        this.plugin = plugin;
    }

    @Override
    public void open(Player player) {
        player.sendMessage("opening");
        generateLoot(player);
    }
    @Override
    public void generateLoot(Player player) {
        Inventory lootInv = Bukkit.createInventory(null, InventoryType.CHEST, "Loot");

        lootInv.addItem(plugin.getItemComponents().getScrap(2));

        Random random = new Random();
        int amount;
        int chance = random.nextInt(100);
        if (chance < 16) { //16 percent chance
            amount = random.nextInt(2) + 1;
            lootInv.addItem(plugin.getItemComponents().getRope(amount));
            return;
        } else if (chance < 15) {
            lootInv.addItem(plugin.getItemComponents().getMetalBlade(1));
            return;
        } else if (chance < 8) {
            ArrayList<org.bukkit.inventory.ItemStack> percent8Items = new ArrayList<>();
            percent8Items.add(plugin.getItemComponents().getEmptyPropaneTank(1));
            percent8Items.add(plugin.getItemComponents().getTarp(1));
            amount = random.nextInt(4) + 3;
            percent8Items.add(plugin.getItemComponents().getSewingKit(amount));
            int whichItem = random.nextInt(percent8Items.size()) + 1;
            lootInv.addItem(percent8Items.get(whichItem));
        } else if (chance < 1) {
            ArrayList<org.bukkit.inventory.ItemStack> percent1Items = new ArrayList<>();
            percent1Items.add(plugin.getItemComponents().getGears(2));
            amount = random.nextInt(3) + 2;
            percent1Items.add(plugin.getItemComponents().getRoadSigns(amount));
            percent1Items.add(plugin.getItemComponents().getSemiAutoBody(1));
            percent1Items.add(plugin.getItemComponents().getSheetMetal(1));
            amount = random.nextInt(4) + 1;
            percent1Items.add(plugin.getItemComponents().getMetalPipe(amount));
            percent1Items.add(plugin.getItemComponents().getElectricFuse(1));
            percent1Items.add(plugin.getItemComponents().getMetalSpring(1));
            //More Items Later from: https://rustlabs.com/entity/barrel#order;sort=3,1,0
        }
    }
}
