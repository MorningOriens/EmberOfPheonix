package com.glyceryl.emberphoenix.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@SuppressWarnings("unused")
public class WildfireHealParticle extends TextureSheetParticle {

    private final float dustParticleScale;

    private final double originX;
    private final double originY;
    private final double originZ;

    WildfireHealParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz) {
        this(world, x, y, z, 3.0F, vx, vy, vz);
    }

    WildfireHealParticle(ClientLevel world, double x, double y, double z, float scale, double mx, double my, double mz) {
        super(world, x + mx, y + my, z + mz, mx, my, mz);
        float f = this.random.nextFloat() * 0.6F + 0.4F;
        this.xd = mx;
        this.yd = my;
        this.zd = mz;
        this.originX = x;
        this.originY = y;
        this.originZ = z;
        this.rCol = 0.9F * f;
        this.gCol = 0.9F * f;
        this.bCol = f;
        this.dustParticleScale = this.quadSize;
        this.lifetime = (int) (10.0D / (Math.random() * 0.8D + 0.2D));
        this.hasPhysics = true;
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public float getQuadSize(float partialTicks) {
        float f6 = (this.age + partialTicks) / this.lifetime * 32.0F;
        f6 = Mth.clamp(f6, 0f, 1f);
        return this.dustParticleScale * f6;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        float proportion = (float) this.age / (float) this.lifetime;
        proportion = 1.0F - proportion;
        this.x = this.originX + this.xd * proportion;
        this.y = this.originY + this.yd * proportion;
        this.z = this.originZ + this.zd * proportion;
        if (this.age++ >= this.lifetime) {
            this.remove();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet spriteSet;

        public Factory(SpriteSet sprite) {
            this.spriteSet = sprite;
        }

        @Override
        public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            WildfireHealParticle particle = new WildfireHealParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed);
            particle.pickSprite(this.spriteSet);
            return particle;
        }
    }

}