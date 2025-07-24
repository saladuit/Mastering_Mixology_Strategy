package com.example;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetType;
import net.runelite.client.callback.ClientThread;
import net.runelite.api.ChatMessageType;

import javax.inject.Inject;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Inject)
public class OrderWidgetDecorator {

    private static final int COMPONENT_POTION_ORDERS_GROUP_ID = 882;
    private static final int COMPONENT_POTION_ORDERS = COMPONENT_POTION_ORDERS_GROUP_ID << 16 | 2;

    private final Client client;
    private final ClientThread clientThread;
    private final StrategyLookup strategyLookup;
    private final MasteringMixologyStrategyConfig config;

    private static final Map<String, String> NAME_TO_CODE = Map.of(
            "Alco-augmentator", "AAA",
            "Mammoth-might mix", "MMM",
            "Liplack liquor", "LLL",
            "Mystic mana amalgam", "MMA",
            "Marley's moonlight", "MML",
            "Azure aura mix", "AAM",
            "Aqualux amalgam", "ALA",
            "Megalite liquid", "MLL",
            "Anti-leech lotion", "ALL",
            "Mixalot", "MAL"
    );

    public void decorateOrderWidgets()
    {
        clientThread.invoke(() -> {
            Widget parent = client.getWidget(COMPONENT_POTION_ORDERS);
            if (parent == null || parent.getChildren() == null) {
                return;
            }
            List<String> codes = new ArrayList<>();
            List<Widget> potionOrderWidgets = new ArrayList<>();
            Widget[] children = parent.getChildren();
            for (Widget child : children) {
                if (codes.size() > 3) {
                    break;
                }
                if (child.getType() != WidgetType.TEXT) {
                    continue;
                }
                String originalText = child.getText();
                if (originalText == null || originalText.isEmpty()) {
                    continue;
                }
                boolean containsPotion = NAME_TO_CODE.keySet().stream().anyMatch(originalText::contains);
                if (!containsPotion) {
                    continue;
                }
                // Extract potion codes from full names using map
                codes.addAll(
                        NAME_TO_CODE.entrySet().stream()
                                .filter(e -> originalText.contains(e.getKey()))
                                .map(Map.Entry::getValue)
                                .collect(Collectors.toList())
                );
                potionOrderWidgets.add(child);
                log.debug("Extracted codes: {} from widget text: {}", codes, originalText);
            }
//            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "Mastering Mixology", "Found codes: " + String.join(", ", codes), null);

            if (codes.size() == 3) {

            String formattedKey = String.join("-", codes);
            String expected = strategyLookup.getChoiceForDraw(config.strategy(), formattedKey);

            Map<String, Long> expectedCount = expected == null ? Map.of() :
                    Arrays.stream(expected.split("-"))
                            .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

            Map<String, Integer> appliedCount = new HashMap<>();

            for (Widget child : potionOrderWidgets) {
                String text = child.getText();
                if (text == null) continue;

                // Identify which potion this widget represents
                Optional<Map.Entry<String, String>> match = NAME_TO_CODE.entrySet().stream()
                        .filter(e -> text.contains(e.getKey()))
                        .findFirst();

                if (match.isEmpty()) continue;

                String code = match.get().getValue();

                long allowed = expectedCount.getOrDefault(code, 0L);
                int used = appliedCount.getOrDefault(code, 0);

                boolean isIncluded = used < allowed;
                if (isIncluded) {
                    appliedCount.put(code, used + 1);
                }
                child.setTextColor(isIncluded ? Color.GREEN.getRGB() : Color.RED.getRGB());
                child.revalidate();
            }
            expectedCount.clear();
            appliedCount.clear();
            codes.clear();
            potionOrderWidgets.clear();
            }
        });
    }
}
