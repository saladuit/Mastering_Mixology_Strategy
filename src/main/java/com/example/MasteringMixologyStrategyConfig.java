package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

import java.util.Comparator;

@ConfigGroup("masteringmixology")
public interface MasteringMixologyStrategyConfig extends Config
{
	@ConfigItem(
			keyName = "strategy",
			name = "Select Strategy",
			description = "Choose the strategy to simulate during mixology"
	)
	default StrategyType strategy()
	{
		return StrategyType.FULL_ORDERS;
	}

	enum StrategyType
	{
		FULL_ORDERS("Full orders"),
		SKIP_TRIPLES_UNLESS_MAL("Reduce triples"),
		REDUCE_DOUBLE_AGA("Reduce double aga"),
		FULL_ORDER_IF_LYE_4PLUS("Full order if lye 4+"),
		OPTIMISED_POINT_DISTRUBUTION("Optimised point distribution");

		private final String name;

		StrategyType(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}
}

