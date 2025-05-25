package com.example;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

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
		FULL_ORDERS("Full orders", "1_complete_full_orders.csv"),
		SKIP_TRIPLES_UNLESS_MAL("Reduce triples", "2_skip_triples_unless_MAL.csv"),
		REDUCE_DOUBLE_AGA("Reduce double aga", "3_skip_double_aga_for_less_aga_points.csv"),
		FULL_ORDER_IF_LYE_4PLUS("Full order if lye 4+", "4_full_order_if_lye_4plus.csv"),
		OPTIMISED_POINT_DISTRIBUTION("Optimised point distribution", "4.1_full_order_if_lye_4plus.csv");

		private final String name;
		private final String file;

		StrategyType(String name, String file) {
			this.name = name;
			this.file = file;
		}

		public String fileName() {
			return file;
		}
		@Override
		public String toString() {
			return name;
		}
	}
}

