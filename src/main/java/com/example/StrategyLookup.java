package com.example;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
public class StrategyLookup
{
    private final Map<String, Map<String, String>> strategyMap = new HashMap<>();

    public StrategyLookup()
    {
        for (MasteringMixologyStrategyConfig.StrategyType strategy : MasteringMixologyStrategyConfig.StrategyType.values())
        {
            String filename = strategy.fileName();
            String path = "/strategies/" + filename;

            try (InputStream input = getClass().getResourceAsStream(path))
            {
                if (input == null)
                {
                    log.warn("Strategy file not found: {}", path);
                    continue;
                }

                Map<String, String> drawToChoice = new HashMap<>();

                try (BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8)))
                {
                    reader.lines()
                            .skip(1)
                            .map(line -> line.split(",", 2))
                            .filter(parts -> parts.length == 2)
                            .forEach(parts -> drawToChoice.put(parts[0].trim(), parts[1].trim()));
                }

                log.info("Loaded strategy '{}': {} entries from {}", strategy.name(), drawToChoice.size(), filename);
                strategyMap.put(strategy.name(), drawToChoice);
            }
            catch (Exception e)
            {
                log.error("Failed to read strategy file: {}", path, e);
            }
        }
    }
    @Nullable
    public String getChoiceForDraw(MasteringMixologyStrategyConfig.StrategyType strategy, String draw)
    {
        Map<String, String> drawMap = strategyMap.get(strategy.name());
        if (drawMap == null)
        {
            return null;
        }

        String normalizedDraw = normalizeDraw(draw);

        for (Map.Entry<String, String> entry : drawMap.entrySet())
        {
            if (normalizeDraw(entry.getKey()).equals(normalizedDraw))
            {
                return entry.getValue();
            }
        }
        return null;
    }

    private String normalizeDraw(String draw)
    {
        String[] parts = draw.split("-");
        Arrays.sort(parts);
        return String.join("-", parts);
    }
}
