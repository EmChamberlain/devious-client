package net.runelite.rs.api;

import net.runelite.api.CollisionData;
import net.runelite.api.Deque;
import net.runelite.api.GraphicsObject;
import net.runelite.api.Projectile;
import net.runelite.api.Scene;
import net.runelite.api.WorldView;
import net.runelite.mapping.Construct;
import net.runelite.mapping.Import;

public interface RSWorldView extends WorldView
{
	@Import("id")
	@Override
	int getId();

	@Import("scene")
	@Override
	Scene getScene();

	@Import("players")
	RSPlayer[] getPlayers();

	@Import("playerUpdateManager")
	RSPlayerUpdateManager getPlayerUpdateManager();

	@Import("npcs")
	RSNPC[] getNpcs();

	@Import("npcSize")
	int getNpcSize();

	@Import("npcIndexes")
	int[] getNpcIndexes();

	@Import("worldEntities")
	RSWorldEntity[] getWorldEntities();

	@Import("worldEntitySize")
	int getWorldEntitySize();

	@Import("worldEntityIndexes")
	int[] getWorldEntityIndexes();

	@Import("collisionMaps")
	@Override
	CollisionData[] getCollisionMaps();

	@Import("plane")
	@Override
	int getPlane();

	@Import("tileHeights")
	@Override
	int[][][] getTileHeights();

	@Import("tileSettings")
	@Override
	byte[][][] getTileSettings();

	@Import("baseX")
	@Override
	int getBaseX();

	@Import("baseY")
	@Override
	int getBaseY();

	@Construct
	RSProjectile newProjectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11);

	@Import("projectiles")
	@Override
	Deque<Projectile> getProjectiles();

	@Import("graphicObjects")
	@Override
	Deque<GraphicsObject> getGraphicsObjects();
}
