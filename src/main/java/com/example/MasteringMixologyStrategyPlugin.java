package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Mastering Mixology Strategy"
)
public class MasteringMixologyStrategyPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private MasteringMixologyStrategyConfig config;
	@Inject
	private OrderWidgetDecorator decorator;

	@Provides
	MasteringMixologyStrategyConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(MasteringMixologyStrategyConfig.class);
	}

	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == 7063) // 7063
		{
			decorator.decorateOrderWidgets(); // logic is embedded in the widget, activeOrders unused for now
		}
	}
	@Subscribe
	public void onConfigChanged(ConfigChanged event) {
		if (event.getKey().equals("strategy")) {
			decorator.decorateOrderWidgets();
		}
	}
}
