package net.graypikachu.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.graypikachu.testmod.TestMod;
import net.graypikachu.testmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup COFFEE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "coffee_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.CUP))
                    .displayName(Text.translatable("itemgroup.testmod.coffee_items"))
                    .entries((displayContext, entries) -> {
                      entries.add(ModItems.CUP);
                      entries.add(ModBlocks.COFFEE_BLOCK);
                    }).build());

    public static final ItemGroup FOXES_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestMod.MOD_ID, "fox_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.FOX_BLOCK))
                    .displayName(Text.translatable("itemgroup.testmod.fox_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FOX_BLOCK);
                        entries.add(ModBlocks.FOX_BLOCK_BROKEN);
                        entries.add(ModItems.CHISEL);
                    }).build());



    public static void registerItemGroups() {
        TestMod.LOGGER.info("Регистрируем новую модовую групу предметов для мода " + TestMod.MOD_ID);
    }
}
