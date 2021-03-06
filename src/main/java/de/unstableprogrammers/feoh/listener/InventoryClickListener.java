package de.unstableprogrammers.feoh.listener;

import de.unstableprogrammers.feoh.main.FeOH;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    private FeOH plugin;

    public InventoryClickListener(FeOH plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClickSurvInvCraft(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        if(event.getClickedInventory() == null) {
            return;
        }

        if(event.getCurrentItem() == null) {
            return;
        }

        if(event.getCurrentItem().getItemMeta() == null) {
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) {
            return;
        }

        if(!(event.getCurrentItem().getItemMeta().getDisplayName().equals(plugin.getItemStacks().getInvCraftingPlaceHolder().getItemMeta().getDisplayName()))) {
            return;
        }
        event.setCancelled(true);
        plugin.getInventorys().openSurvCraftingInv(player);
    }

    @EventHandler
    public void onInventoryClickPlaceholder(InventoryClickEvent event) {
        if(!(event.getWhoClicked() instanceof Player)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();

        if(event.getClickedInventory() == null) {
            return;
        }

        if(event.getCurrentItem() == null) {
            return;
        }

        if(event.getCurrentItem().getItemMeta() == null) {
            return;
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName() == null) {
            return;
        }

        if(!(event.getCurrentItem().getItemMeta().getDisplayName().equals(" "))) {
            return;
        }
        event.setCancelled(true);
    }

}
