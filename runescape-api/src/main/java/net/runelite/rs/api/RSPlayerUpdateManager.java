package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSPlayerUpdateManager
{
	@Import("playerSize")
	int getPlayerSize();

	@Import("playerIndexes")
	int[] getPlayerIndexes();
}
