package net.graypikachu.testmod.item.custom;

import net.graypikachu.testmod.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> BlockToBlock = Map.of(
            Blocks.CRAFTING_TABLE, Blocks.CRAFTER,
            Blocks.CRAFTER, Blocks.CRAFTING_TABLE,
            Blocks.LAVA, Blocks.WATER,
            Blocks.WATER, Blocks.LAVA,
            Blocks.STONE, Blocks.STONE_BRICKS,
            ModBlocks.COFFEE_BLOCK, ModBlocks.FOX_BLOCK,
            ModBlocks.FOX_BLOCK, ModBlocks.FOX_BLOCK_BROKEN,
            ModBlocks.FOX_BLOCK_BROKEN, ModBlocks.COFFEE_BLOCK
    );

    public ChiselItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if (BlockToBlock.containsKey(clickedBlock)) {
            world.setBlockState(context.getBlockPos(), BlockToBlock.get(clickedBlock).getDefaultState());
            if (!world.isClient) {
                //world.setBlockState(context.getBlockPos(), BlockToBlock.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME,
                        SoundCategory.BLOCKS);
            }
        }

        return ActionResult.SUCCESS;
    }


}
