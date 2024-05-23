package net.runelite.rs.api;

import net.runelite.api.DecorativeObject;
import net.runelite.api.GameObject;
import net.runelite.api.GroundObject;
import net.runelite.api.Renderable;
import net.runelite.api.Scene;
import net.runelite.api.Tile;
import net.runelite.api.WallObject;
import net.runelite.mapping.Import;

public interface RSScene extends Scene
{
	@Import("tempGameObjects")
	RSGameObject[] getObjects();

	@Import("tiles")
	@Override
	RSTile[][][] getTiles();

	@Import("tileShape2D")
	int[][] getTileShape2D();

	@Import("tileRotation2D")
	int[][] getTileRotation2D();

	@Import("drawTile")
	void draw(Tile tile, boolean var2);

	@Import("tileHeights")
	@Override
	int[][][] getTileHeights();

	@Import("drawTileMinimap")
	void drawTile(int[] pixels, int pixelOffset, int width, int z, int x, int y);

	@Import("occlude")
	void updateOccluders();

	@Import("xSize")
	int getMaxX();

	@Import("planes")
	int getMaxY();

	@Import("ySize")
	int getMaxZ();

	@Import("minPlane")
	int getMinLevel();

	@Import("minPlane")
	void setMinLevel(int lvl);

	@Import("newGroundItemPile")
	void newGroundItemPile(int plane, int x, int y, int hash, RSRenderable var5, long var6, RSRenderable var7, RSRenderable var8);

	@Import("newGameObject")
	boolean newGameObject(int plane, int startX, int startY, int var4, int var5, int centerX, int centerY, int height, RSRenderable entity, int orientation, boolean tmp, long tag, int flags);

	@Import("removeGameObject")
	void removeGameObject(GameObject gameObject);

	@Import("removeGameObject")
	void removeGameObject(int plane, int x, int y);

	void removeWallObject(WallObject wallObject);

	@Import("removeBoundaryObject")
	void removeWallObject(int plane, int x, int y);

	void removeDecorativeObject(DecorativeObject decorativeObject);

	@Import("removeWallDecoration")
	void removeDecorativeObject(int plane, int x, int y);

	void removeGroundObject(GroundObject groundObject);

	@Import("removeFloorDecoration")
	void removeGroundObject(int plane, int x, int y);

	@Override
	short[][][] getUnderlayIds();
	void setUnderlayIds(short[][][] underlayIds);

	@Override
	short[][][] getOverlayIds();
	void setOverlayIds(short[][][] overlayIds);

	@Override
	byte[][][] getTileShapes();
	void setTileShapes(byte[][][] tileShapes);

	@Import("baseX")
	@Override
	int getBaseX();

	@Import("baseY")
	@Override
	int getBaseY();

	@Import("isInInstance")
	@Override
	boolean isInstance();

	@Import("instanceChunkTemplates")
	@Override
	int[][][] getInstanceTemplateChunks();

	@Import("menuOpen")
	void menuOpen(int selectedPlane, int screenX, int screenY, boolean viewportWalking);

	@Import("drawEntity")
	boolean drawEntity(int level, int x, int y, int z, int radius, Renderable renderable, int orientation, long var8, boolean drawFrontTilesFirst);

	@Import("worldViewId")
	@Override
	int getWorldViewId();
}
