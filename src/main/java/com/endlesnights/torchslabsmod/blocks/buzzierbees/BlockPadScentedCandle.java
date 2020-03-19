package com.endlesnights.torchslabsmod.blocks.buzzierbees;

import javax.annotation.Nullable;

import com.bagel.buzzierbees.core.registry.BBTileEntities;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public class BlockPadScentedCandle extends BlockPadCandle
{
	public Effect candleEffectInstance;
	public int duration;
	public int level;
	
	public BlockPadScentedCandle(Effect candleEffectInstance, int duration, int level, Block.Properties properties, Block parent_Block)
	{
		super(properties, parent_Block);
		this.candleEffectInstance = candleEffectInstance;	
		this.duration = duration;
		this.level = level;
	}

   @Override
   public boolean hasTileEntity(BlockState state) {
	   return true;
   }
   
   @Nullable
   @Override
   public TileEntity createTileEntity(BlockState state, IBlockReader world) {
	   return BBTileEntities.SCENTED_CANDLE.get().create();
   }
   
   @Override
   public float getEnchantPowerBonus(BlockState state, IWorldReader world, BlockPos pos) {
	   return (0.2F * state.get(CANDLES));	
   }
   
   //@Override
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		return ActionResultType.FAIL;	
	}
}
