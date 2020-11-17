package com.acm.fall2020Mod.items;

import com.acm.fall2020Mod.AcmMinecraftMod;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class SkittlesItemBase extends Item {

    public SkittlesItemBase () {
        super(new Item.Properties()
                .food(new Food.Builder()
                    .hunger(8)
                    .saturation(1.2f)
                    .setAlwaysEdible()
                    .effect(new EffectInstance(Effects.SPEED, 6000, 3), 1.0f)
                    .build())
                    .group(AcmMinecraftMod.TAB));
    }

}
