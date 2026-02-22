package com.penguin.smithery.index;

import com.penguin.smithery.CreateSmithery;
import com.penguin.smithery.item.example_item;
import com.tterrag.registrate.util.entry.ItemEntry;

public class SMItems {
    public static final ItemEntry<example_item> EXAMPLE_ITEM = CreateSmithery.REGISTRATE.item("example_item", example_item::new)
            .register();
}
