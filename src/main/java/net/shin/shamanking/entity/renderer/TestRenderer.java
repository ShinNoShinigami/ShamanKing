package net.shin.shamanking.entity.renderer;

import net.shin.shamanking.entity.TestEntity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class TestRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(TestEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new Modelcustom_model(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("shamanking:textures/amidamaruhuman.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.3
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class Modelcustom_model extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer LeftLeg;
		private final ModelRenderer RightLeg;
		private final ModelRenderer LeftArm;
		private final ModelRenderer RightArm;
		private final ModelRenderer Body;
		private final ModelRenderer Head;
		private final ModelRenderer cube_r1;
		private final ModelRenderer cube_r2;
		private final ModelRenderer bone4;
		private final ModelRenderer cube_r3;
		private final ModelRenderer cube_r4;
		private final ModelRenderer bone2;
		private final ModelRenderer cube_r5;
		private final ModelRenderer cube_r6;
		private final ModelRenderer cube_r7;
		private final ModelRenderer cube_r8;
		private final ModelRenderer bone3;
		private final ModelRenderer cube_r9;
		private final ModelRenderer cube_r10;
		private final ModelRenderer cube_r11;
		private final ModelRenderer cube_r12;
		private final ModelRenderer bone10;
		private final ModelRenderer cube_r13;
		private final ModelRenderer cube_r14;
		private final ModelRenderer bone5;
		private final ModelRenderer cube_r15;
		private final ModelRenderer cube_r16;
		public Modelcustom_model() {
			textureWidth = 128;
			textureHeight = 128;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(0.0F, 24.0F, 0.0F);
			LeftLeg = new ModelRenderer(this);
			LeftLeg.setRotationPoint(1.9F, -12.0F, 0.0F);
			bone.addChild(LeftLeg);
			LeftLeg.setTextureOffset(124, 15).addBox(-0.5F, 4.5F, -2.05F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			LeftLeg.setTextureOffset(124, 15).addBox(-0.5F, 8.0F, -2.05F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			LeftLeg.setTextureOffset(17, 75).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			LeftLeg.setTextureOffset(0, 75).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			RightLeg = new ModelRenderer(this);
			RightLeg.setRotationPoint(-1.9F, -12.0F, 0.0F);
			bone.addChild(RightLeg);
			RightLeg.setTextureOffset(51, 58).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			RightLeg.setTextureOffset(34, 58).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			RightLeg.setTextureOffset(124, 15).addBox(-0.5F, 8.0F, -2.05F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			RightLeg.setTextureOffset(124, 15).addBox(-0.5F, 4.5F, -2.05F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			LeftArm = new ModelRenderer(this);
			LeftArm.setRotationPoint(5.0F, -22.0F, 0.0F);
			bone.addChild(LeftArm);
			LeftArm.setTextureOffset(17, 58).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			LeftArm.setTextureOffset(0, 58).addBox(-1.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			LeftArm.setTextureOffset(124, 15).addBox(2.3F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			LeftArm.setTextureOffset(124, 15).addBox(2.3F, 6.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
			RightArm = new ModelRenderer(this);
			RightArm.setRotationPoint(-5.0F, -22.0F, 0.0F);
			bone.addChild(RightArm);
			RightArm.setTextureOffset(69, 41).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);
			RightArm.setTextureOffset(52, 41).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.25F, false);
			RightArm.setTextureOffset(124, 15).addBox(-3.3F, 3.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			RightArm.setTextureOffset(124, 15).addBox(-3.3F, 6.5F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);
			Body = new ModelRenderer(this);
			Body.setRotationPoint(0.0F, -24.0F, 0.0F);
			bone.addChild(Body);
			Body.setTextureOffset(66, 24).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, 0.0F, false);
			Body.setTextureOffset(88, 43).addBox(-8.0F, 0.0F, -2.0F, 16.0F, 19.0F, 4.0F, 0.35F, false);
			Body.setTextureOffset(27, 41).addBox(-4.0F, 12.0F, -2.0F, 8.0F, 6.0F, 4.0F, 0.3F, false);
			Head = new ModelRenderer(this);
			Head.setRotationPoint(0.0F, -24.0F, 0.0F);
			bone.addChild(Head);
			Head.setTextureOffset(33, 24).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
			Head.setTextureOffset(0, 24).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.5F, false);
			cube_r1 = new ModelRenderer(this);
			cube_r1.setRotationPoint(0.0F, -7.0F, -4.0F);
			Head.addChild(cube_r1);
			setRotationAngle(cube_r1, 0.6109F, 0.0873F, -0.0436F);
			cube_r1.setTextureOffset(120, 0).addBox(0.0F, -5.9647F, -0.1363F, 0.0F, 7.0F, 4.0F, 0.0F, false);
			cube_r2 = new ModelRenderer(this);
			cube_r2.setRotationPoint(-1.0F, -8.0F, -4.0F);
			Head.addChild(cube_r2);
			setRotationAngle(cube_r2, 0.3491F, 0.2618F, -0.1745F);
			cube_r2.setTextureOffset(120, 0).addBox(0.0F, -5.9647F, -0.1363F, 0.0F, 7.0F, 4.0F, 0.0F, false);
			bone4 = new ModelRenderer(this);
			bone4.setRotationPoint(0.0F, -6.0F, 4.0F);
			Head.addChild(bone4);
			setRotationAngle(bone4, 0.2618F, 0.0F, 0.0F);
			bone4.setTextureOffset(77, 118).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			bone4.setTextureOffset(0, 41).addBox(-3.0F, -4.0F, 1.0F, 6.0F, 6.0F, 7.0F, 0.0F, false);
			cube_r3 = new ModelRenderer(this);
			cube_r3.setRotationPoint(0.0F, -1.1566F, 0.8105F);
			bone4.addChild(cube_r3);
			setRotationAngle(cube_r3, 0.0436F, 0.1745F, 0.0F);
			cube_r3.setTextureOffset(0, 41).addBox(-3.0F, -2.8434F, 0.1895F, 6.0F, 6.0F, 7.0F, 0.0F, true);
			cube_r4 = new ModelRenderer(this);
			cube_r4.setRotationPoint(0.0F, -1.1566F, 0.8105F);
			bone4.addChild(cube_r4);
			setRotationAngle(cube_r4, 0.0436F, -0.1745F, 0.0F);
			cube_r4.setTextureOffset(0, 41).addBox(-3.0F, -2.8434F, 0.1895F, 6.0F, 6.0F, 7.0F, 0.0F, false);
			bone2 = new ModelRenderer(this);
			bone2.setRotationPoint(9.0F, -5.0F, 0.0F);
			setRotationAngle(bone2, 0.0873F, 0.0F, -0.0873F);
			cube_r5 = new ModelRenderer(this);
			cube_r5.setRotationPoint(-1.0459F, -1.0457F, -4.0F);
			bone2.addChild(cube_r5);
			setRotationAngle(cube_r5, 0.0F, 0.0F, -0.0873F);
			cube_r5.setTextureOffset(19, 105).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
			cube_r6 = new ModelRenderer(this);
			cube_r6.setRotationPoint(-1.0459F, 1.9543F, -4.0F);
			bone2.addChild(cube_r6);
			setRotationAngle(cube_r6, 0.0F, 0.0F, -0.0873F);
			cube_r6.setTextureOffset(0, 105).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
			cube_r7 = new ModelRenderer(this);
			cube_r7.setRotationPoint(-1.0459F, 4.9543F, -4.0F);
			bone2.addChild(cube_r7);
			setRotationAngle(cube_r7, 0.0F, 0.0F, -0.0873F);
			cube_r7.setTextureOffset(57, 92).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
			cube_r8 = new ModelRenderer(this);
			cube_r8.setRotationPoint(-1.0459F, 7.9543F, -4.0F);
			bone2.addChild(cube_r8);
			setRotationAngle(cube_r8, 0.0F, 0.0F, -0.0873F);
			cube_r8.setTextureOffset(38, 92).addBox(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
			bone3 = new ModelRenderer(this);
			bone3.setRotationPoint(-9.0F, -5.0F, 0.0F);
			setRotationAngle(bone3, 0.0873F, 0.0F, 0.0873F);
			cube_r9 = new ModelRenderer(this);
			cube_r9.setRotationPoint(1.0459F, -1.0457F, -4.0F);
			bone3.addChild(cube_r9);
			setRotationAngle(cube_r9, 0.0F, 0.0F, 0.0873F);
			cube_r9.setTextureOffset(34, 75).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
			cube_r10 = new ModelRenderer(this);
			cube_r10.setRotationPoint(1.0459F, 1.9543F, -4.0F);
			bone3.addChild(cube_r10);
			setRotationAngle(cube_r10, 0.0F, 0.0F, 0.0873F);
			cube_r10.setTextureOffset(53, 75).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
			cube_r11 = new ModelRenderer(this);
			cube_r11.setRotationPoint(1.0459F, 4.9543F, -4.0F);
			bone3.addChild(cube_r11);
			setRotationAngle(cube_r11, 0.0F, 0.0F, 0.0873F);
			cube_r11.setTextureOffset(0, 92).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
			cube_r12 = new ModelRenderer(this);
			cube_r12.setRotationPoint(1.0459F, 7.9543F, -4.0F);
			bone3.addChild(cube_r12);
			setRotationAngle(cube_r12, 0.0F, 0.0F, 0.0873F);
			cube_r12.setTextureOffset(19, 92).addBox(-1.0F, 0.0F, 0.0F, 1.0F, 4.0F, 8.0F, 0.0F, false);
			bone10 = new ModelRenderer(this);
			bone10.setRotationPoint(-4.0F, 13.0F, 0.0F);
			setRotationAngle(bone10, -0.3054F, 0.0F, 0.0F);
			bone10.setTextureOffset(54, 118).addBox(-0.89F, -0.95F, -11.05F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bone10.setTextureOffset(55, 105).addBox(-0.89F, -0.95F, -10.0F, 2.0F, 2.0F, 6.0F, -0.05F, false);
			bone10.setTextureOffset(45, 0).addBox(-0.9F, -1.5F, -3.0F, 2.0F, 3.0F, 20.0F, 0.0F, false);
			bone10.setTextureOffset(18, 118).addBox(-0.9F, -1.5F, 0.0F, 2.0F, 3.0F, 2.0F, 0.1F, false);
			bone10.setTextureOffset(9, 118).addBox(-0.9F, -1.5F, 12.0F, 2.0F, 3.0F, 2.0F, 0.1F, false);
			bone10.setTextureOffset(70, 118).addBox(-0.89F, -0.95F, -4.05F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			bone10.setTextureOffset(28, 124).addBox(-0.89F, -0.447F, -11.9073F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			bone10.setTextureOffset(45, 118).addBox(-1.9F, -1.922F, -3.0826F, 4.0F, 4.0F, 0.0F, 0.0F, false);
			cube_r13 = new ModelRenderer(this);
			cube_r13.setRotationPoint(-2.0F, -1.0153F, -11.0229F);
			bone10.addChild(cube_r13);
			setRotationAngle(cube_r13, 0.5236F, 0.0F, 0.0F);
			cube_r13.setTextureOffset(14, 124).addBox(1.11F, 0.05F, -1.05F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r14 = new ModelRenderer(this);
			cube_r14.setRotationPoint(-2.0F, 1.0229F, -10.9847F);
			bone10.addChild(cube_r14);
			setRotationAngle(cube_r14, -0.5236F, 0.0F, 0.0F);
			cube_r14.setTextureOffset(21, 124).addBox(1.11F, -0.95F, -1.05F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			bone5 = new ModelRenderer(this);
			bone5.setRotationPoint(4.0F, 13.0F, 0.0F);
			setRotationAngle(bone5, -0.3054F, 0.0F, 0.0F);
			bone5.setTextureOffset(36, 118).addBox(-1.11F, -0.95F, -11.05F, 2.0F, 2.0F, 2.0F, 0.0F, false);
			bone5.setTextureOffset(38, 105).addBox(-1.11F, -0.95F, -10.0F, 2.0F, 2.0F, 6.0F, -0.05F, false);
			bone5.setTextureOffset(0, 0).addBox(-1.1F, -1.5F, -3.0F, 2.0F, 3.0F, 20.0F, 0.0F, false);
			bone5.setTextureOffset(0, 118).addBox(-1.1F, -1.5F, 0.0F, 2.0F, 3.0F, 2.0F, 0.1F, false);
			bone5.setTextureOffset(72, 105).addBox(-1.1F, -1.5F, 12.0F, 2.0F, 3.0F, 2.0F, 0.1F, false);
			bone5.setTextureOffset(63, 118).addBox(-1.11F, -0.95F, -4.05F, 2.0F, 2.0F, 1.0F, 0.0F, false);
			bone5.setTextureOffset(7, 124).addBox(-1.11F, -0.447F, -11.9073F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			bone5.setTextureOffset(27, 118).addBox(-2.1F, -1.9079F, -3.1239F, 4.0F, 4.0F, 0.0F, 0.0F, false);
			cube_r15 = new ModelRenderer(this);
			cube_r15.setRotationPoint(2.0F, -1.0153F, -11.0229F);
			bone5.addChild(cube_r15);
			setRotationAngle(cube_r15, 0.5236F, 0.0F, 0.0F);
			cube_r15.setTextureOffset(84, 118).addBox(-3.11F, 0.05F, -1.05F, 2.0F, 1.0F, 1.0F, 0.0F, false);
			cube_r16 = new ModelRenderer(this);
			cube_r16.setRotationPoint(2.0F, 1.0229F, -10.9847F);
			bone5.addChild(cube_r16);
			setRotationAngle(cube_r16, -0.5236F, 0.0F, 0.0F);
			cube_r16.setTextureOffset(0, 124).addBox(-3.11F, -0.95F, -1.05F, 2.0F, 1.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			bone2.render(matrixStack, buffer, packedLight, packedOverlay);
			bone3.render(matrixStack, buffer, packedLight, packedOverlay);
			bone10.render(matrixStack, buffer, packedLight, packedOverlay);
			bone5.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}

		public void setRotationAngles(Entity e, float f, float f1, float f2, float f3, float f4) {
			this.RightArm.rotateAngleY = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftLeg.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
			this.RightLeg.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
			this.LeftArm.rotateAngleY = MathHelper.cos(f * 0.6662F) * f1;
		}
	}
}
