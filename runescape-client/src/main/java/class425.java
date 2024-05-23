import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qg")
public class class425 {
	@ObfuscatedName("ak")
	float[] field4710;
	@ObfuscatedName("al")
	@ObfuscatedGetter(
		intValue = 330454819
	)
	int field4711;

	class425(float[] var1, int var2) {
		this.field4710 = var1;
		this.field4711 = var2;
	}

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		descriptor = "(Ldt;IZI)V",
		garbageValue = "-878952179"
	)
	static void method7948(WorldView var0, int var1, boolean var2) {
		Player var3 = var0.players[var1];
		if (var3 != null && var3.isVisible() && !var3.field1142) {
			var3.field1153 = false;
			if ((Client.isLowDetail && var0.playerUpdateManager.playerSize > 50 || var0.playerUpdateManager.playerSize > 200) && var2 && var3.movementSequence == var3.idleSequence) {
				var3.field1153 = true;
			}

			int var4 = var3.x >> 7;
			int var5 = var3.y >> 7;
			if (var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
				long var6 = KitDefinition.method3900(0, 0, 0, false, var3.field1157, var0.id);
				if (var3.field1158 != null && Client.cycle >= var3.field1143 && Client.cycle < var3.field1144) {
					var3.field1153 = false;
					var3.field1148 = SoundSystem.getTileHeight(var0, var3.x, var3.y, var0.plane);
					var3.playerCycle = Client.cycle;
					var0.scene.addNullableObject(var0.plane, var3.x, var3.y, var3.field1148, 60, var3, var3.rotation, var6, var3.field1149, var3.field1155, var3.field1151, var3.field1140);
				} else {
					if ((var3.x & 127) == 64 && (var3.y & 127) == 64) {
						if (var0.field1338[var4][var5] == Client.viewportDrawCount) {
							return;
						}

						var0.field1338[var4][var5] = Client.viewportDrawCount;
					}

					var3.field1148 = SoundSystem.getTileHeight(var0, var3.x, var3.y, var0.plane);
					var3.playerCycle = Client.cycle;
					var0.scene.drawEntity(var0.plane, var3.x, var3.y, var3.field1148, 60, var3, var3.rotation, var6, var3.isWalking);
				}
			}
		}

	}
}
