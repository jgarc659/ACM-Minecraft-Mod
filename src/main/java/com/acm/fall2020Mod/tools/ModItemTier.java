package com.acm.fall2020Mod.tools;

import com.acm.fall2020Mod.util.RegistryHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    SKITTLES(3, 800, 7.0f, 3.0f, 12, () ->
    {
        return Ingredient.fromItems(RegistryHandler.SKITTLES_SWORD.get());
    });

    private final int _harvestLevel;
    private final int _maxUses;
    private final float _efficiency;
    private final float _attackDamage;
    private final int _enchantability;
    private final Supplier<Ingredient> _repairMaterial;

    // Constructor
    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this._harvestLevel = harvestLevel;
        this._maxUses = maxUses;
        this._efficiency = efficiency;
        this._attackDamage = attackDamage;
        this._enchantability = enchantability;
        this._repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return _maxUses;
    }

    @Override
    public float getEfficiency() {
        return _efficiency;
    }

    @Override
    public float getAttackDamage() {
        return _attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return _harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return _enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return _repairMaterial.get();
    }
}
