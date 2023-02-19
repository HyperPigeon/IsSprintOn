package net.hyper_pigeon.issprinton.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class IsSprintOnClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        ClientTickEvents.END_CLIENT_TICK.register(
//                client -> {
//                    if(client.player != null && client.player.isSprinting()){
//                        client.player.sendMessage(Text.translatable("SPRINTING"), true);
//                    }
//                }
//        );
        HudRenderCallback.EVENT.register((matrixStack, tickDelta) -> {
            TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
            int scaledWidth = MinecraftClient.getInstance().getWindow().getScaledWidth();
            int scaledHeight = MinecraftClient.getInstance().getWindow().getScaledHeight();

            if(MinecraftClient.getInstance().player != null) {
                if(MinecraftClient.getInstance().player.isSprinting()){
                    textRenderer.drawWithShadow(matrixStack, "SPRINTING", ((float)scaledWidth/2)-20, scaledHeight - 60, 0xFFFFFF);
                }
                else {
                    textRenderer.drawWithShadow(matrixStack, "WALKING", ((float)scaledWidth/2)-20, scaledHeight - 60, 0xFFFFFF);
                }
            }

        });
    }
}
