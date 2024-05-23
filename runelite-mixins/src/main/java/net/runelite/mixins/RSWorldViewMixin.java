package net.runelite.mixins;

import net.runelite.api.IndexedObjectSet;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Projectile;
import net.runelite.api.WorldEntity;
import net.runelite.api.WorldView;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSActor;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSProjectile;
import net.runelite.rs.api.RSTile;
import net.runelite.rs.api.RSWorldEntity;
import net.runelite.rs.api.RSWorldView;

@Mixin(RSWorldView.class)
public abstract class RSWorldViewMixin implements RSWorldView
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public boolean isTopLevel()
	{
		return getId() == -1;
	}

	@Inject
	@Override
	public IndexedObjectSet players()
	{
		return new IndexedObjectSet(this.getPlayers(), this.getPlayerUpdateManager().getPlayerIndexes(), this.getPlayerUpdateManager().getPlayerSize());
	}

	@Inject
	@Override
	public IndexedObjectSet npcs()
	{
		return new IndexedObjectSet(this.getNpcs(), this.getNpcIndexes(), this.getNpcSize());
	}

	@Inject
	@Override
	public IndexedObjectSet worldEntities()
	{
		return new IndexedObjectSet(this.getWorldEntities(), this.getWorldEntityIndexes(), this.getWorldEntitySize());
	}

	@Inject
	@Override
	public RSTile getSelectedSceneTile()
	{
		int var1 = this.getScene().getBaseX();
		int var2 = this.getScene().getBaseY();
		return var1 >= this.getScene().mo && var2 >= this.getScene().eb && var1 < this.getScene().sx && var2 < this.getScene().yd ? this.getScene().xz[this.getPlane()][var1 + this.getScene().rl][var2 + this.getScene().rl] : null;
	}

	@Inject
	@Override
	public Projectile createProjectile(int id, int plane, int startX, int startY, int startZ, int startCycle, int endCycle, int slope, int startHeight, int endHeight, RSActor target, int targetX, int targetY)
	{
		int targetIndex = 0;
		if (target instanceof NPC)
		{
			targetIndex = ((NPC) target).getIndex() + 1;
		}
		else if (target instanceof Player)
		{
			targetIndex = -(((Player) target).getId() + 1);
		}

		RSProjectile projectile = this.newProjectile(id, plane, startX, startY, startZ, startCycle, endCycle, slope, startHeight, targetIndex, endHeight);
		projectile.setWorldView(this);
		projectile.setDestination(targetX, targetY, Perspective.getTileHeight(client, new LocalPoint(targetX, targetY, this), plane), startCycle);
		return projectile;
	}

	@Inject
	@Override
	public static WorldView getWorldView(int id)
	{
		if (id == -1)
		{
			return client.getTopLevelWorldView();
		}
		else
		{
			RSWorldEntity worldEntity = client.getTopLevelWorldView().getWorldEntities()[id];
			return worldEntity == null ? null : worldEntity.getWorldView();
		}
	}
}
