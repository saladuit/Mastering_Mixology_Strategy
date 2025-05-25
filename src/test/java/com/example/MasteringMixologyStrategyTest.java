package com.example;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class MasteringMixologyStrategyTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(MasteringMixologyStrategyPlugin.class);
		RuneLite.main(args);
	}
}