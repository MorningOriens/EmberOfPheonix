package com.glyceryl.emberphoenix.common.world.biomes;

import com.glyceryl.emberphoenix.common.world.EPPlacedFeatures;
import com.glyceryl.emberphoenix.common.world.ore.EPOrePlacements;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.BiomeSpecialEffects;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;

public class EPBiomesCreator {

    public static Biome createDefaultBiomes(float temperature) {
        MobSpawnSettings mobspawnsettings = (new MobSpawnSettings.Builder()).build();
        BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder());
        EPPlacedFeatures.addDefaultPhoenixOres(builder);
        EPPlacedFeatures.addDefaultPhoenixUndergroundVariety(builder);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPPlacedFeatures.PATCH_TUMBLEWEED)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPPlacedFeatures.PATCH_FIRE_FLOWER)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPPlacedFeatures.PATCH_BARREN_GRASS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPPlacedFeatures.PATCH_BARREN_TALL_GRASS)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPPlacedFeatures.BIGGER_LAKE_LAVA_SURFACE);
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).temperature(temperature).downfall(0.0F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(3344392)
                .skyColor(OverworldBiomes.calculateSkyColor(2.0F)).build()).mobSpawnSettings(mobspawnsettings).generationSettings(builder.build()).build();
    }

    public static Biome createRosaaniaVolcano() {
        MobSpawnSettings mobspawnsettings = (new MobSpawnSettings.Builder()).build();
        BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder());
        EPPlacedFeatures.addDefaultPhoenixOres(builder);
        EPPlacedFeatures.addDefaultPhoenixUndergroundVariety(builder);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPPlacedFeatures.SURFACE_HOLE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPPlacedFeatures.BIGGER_LAKE_LAVA_SURFACE);
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).temperature(2.8F).downfall(0.0F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(3344392)
                .skyColor(OverworldBiomes.calculateSkyColor(2.0F)).build()).mobSpawnSettings(mobspawnsettings).generationSettings(builder.build()).build();
    }

    public static Biome createAshPlain() {
        MobSpawnSettings mobspawnsettings = (new MobSpawnSettings.Builder()).build();
        BiomeGenerationSettings.Builder builder = (new BiomeGenerationSettings.Builder());
        EPPlacedFeatures.addDefaultPhoenixOres(builder);
        EPPlacedFeatures.addDefaultPhoenixUndergroundVariety(builder);
        builder.addCarver(GenerationStep.Carving.AIR, Carvers.CAVE)
                .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, EPOrePlacements.ORE_ASH_BLOCK)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, EPPlacedFeatures.BIGGER_LAKE_LAVA_SURFACE);
        return (new Biome.BiomeBuilder()).precipitation(Biome.Precipitation.NONE).biomeCategory(Biome.BiomeCategory.NETHER).temperature(1.8F).downfall(0.0F)
                .specialEffects((new BiomeSpecialEffects.Builder()).waterColor(4159204).waterFogColor(329011).fogColor(3344392)
                .skyColor(OverworldBiomes.calculateSkyColor(2.0F)).build()).mobSpawnSettings(mobspawnsettings).generationSettings(builder.build()).build();
    }

    public static void init() {}

}