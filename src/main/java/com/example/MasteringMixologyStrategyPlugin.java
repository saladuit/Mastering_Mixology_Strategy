package com.example;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
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
	@SuppressWarnings("unused")
	@Inject
	private OrderWidgetDecorator decorator;

	@SuppressWarnings("unused")
	@Provides
	MasteringMixologyStrategyConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(MasteringMixologyStrategyConfig.class);
	}

	@SuppressWarnings("unused")
	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		if (event.getScriptId() == 7063) // 7063
		{
			decorator.decorateOrderWidgets(); // logic is embedded in the widget, activeOrders unused for now
		}
	}
	@SuppressWarnings("unused")
	@Subscribe
	public void onConfigChanged(ConfigChanged event) {
		if (event.getKey().equals("strategy")) {
			decorator.decorateOrderWidgets();
		}
	}
}
