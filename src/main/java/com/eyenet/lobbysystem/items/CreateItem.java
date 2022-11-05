package com.eyenet.lobbysystem.items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CreateItem {

    public static ItemStack createItem(Material mat, int anzahl, int shortid, String Name) {
        short s = (short)shortid;
        ItemStack i = new ItemStack(mat, anzahl, s);
        ItemMeta meta = i.getItemMeta();
        assert meta != null;
        ((ItemMeta) meta).setDisplayName(Name);
        i.setItemMeta(meta);
        return i;
    }
}
