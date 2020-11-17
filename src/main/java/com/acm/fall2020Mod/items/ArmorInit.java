package com.acm.fall2020Mod.items;

import com.acm.fall2020Mod.AcmMinecraftMod;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = AcmMinecraftMod.MOD_ID, bus = Bus.MOD)
@ObjectHolder(AcmMinecraftMod.MOD_ID)
public class ArmorInit {

    // Armor
    public static final Item skittle_chestplate = null;
    public static final Item skittle_helmet = null;
    public static final Item skittle_leggings = null;
    public static final Item skittle_boots = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        // Armor
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.CHEST, new Item.Properties().group(AcmMinecraftMod.TAB)).setRegistryName("skittle_chestplate"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.HEAD, new Item.Properties().group(AcmMinecraftMod.TAB)).setRegistryName("skittle_helmet"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.LEGS, new Item.Properties().group(AcmMinecraftMod.TAB)).setRegistryName("skittle_leggings"));
        event.getRegistry().register(new ArmorItem(ModArmorMaterial.TEST, EquipmentSlotType.FEET, new Item.Properties().group(AcmMinecraftMod.TAB)).setRegistryName("skittle_boots"));
    }

    public enum ModArmorMaterial implements IArmorMaterial{
        // : armor_layer, Max Damage, Damage Reduction Amount {Boots, Leggings, Chestplate, Helmet}, Enchantability, Sound, Toughness.
        TEST(AcmMinecraftMod.MOD_ID + ":skittle", 5, new int[]{7, 9, 11, 7}, 420, SoundEvents.field_226142_fM_, 6.9F, () -> {
            // Repair Item
            return Ingredient.fromItems(new SkittlesItemBase());
        });

        private static final int[] MAX_DAMAGE_ARRAY = new int[] {16, 16, 16, 16};
        private final String name;
        private final int maxDamageFactor;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final float toughness;
        private final LazyValue<Ingredient> repairMaterial;

        private ModArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantability, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
            this.name = nameIn;
            this.maxDamageFactor = maxDamageFactorIn;
            this.damageReductionAmountArray = damageReductionAmountIn;
            this.enchantability = enchantability;
            this.soundEvent = soundEventIn;
            this.toughness = toughnessIn;
            this.repairMaterial = new LazyValue<>(repairMaterialIn);
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn) {
            return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn) {
            return this.damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability() { return this.enchantability; }

        @Override
        public SoundEvent getSoundEvent() { return this.soundEvent; }

        @Override
        public Ingredient getRepairMaterial() { return this.repairMaterial.getValue(); }

        @OnlyIn(Dist.CLIENT)
        @Override
        public String getName() { return this.name; }

        @Override
        public float getToughness() { return this.toughness; }
    }
}
