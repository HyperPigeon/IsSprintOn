package net.hyper_pigeon.issprinton.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class IsSprintOnClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(
                client -> {
                    assert client.player != null;
                    if(client.player.isSprinting()){
                        client.player.sendMessage(Text.translatable("SPRINTING"), true);
                    }
                }
        );
    }
}
