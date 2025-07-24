# Mastering Mixology Strategy Plugin

**A RuneLite plugin to enhance the Mixology minigame experience in OSRS.**

## 📋 Overview

The **Mastering Mixology Strategy** plugin helps you optimize your potion brewing during the Mixology minigame. It colors the in-game order widgets to visually guide you based on different brewing strategies, reducing unnecessary brews and helping you complete your Mixology log more efficiently.
<img width="512" height="262" alt="Mastering Mixology Highlighter" src="https://github.com/user-attachments/assets/7a5a47cf-0d9c-49a4-8239-d7bd542eefce" />

## 🔍 Features

- 🔄 Shows which potions to brew based on selected strategies.
- ⚙️ Switch between multiple optimized brewing strategies.
- 🧠 Designed using detailed simulations from [Mastering Mixology Simulator](https://github.com/saladuit/Mastering_Mixology_Simulator).

## 🛠️ How to Use

1. **Install the plugin** via the RuneLite Plugin Hub.
2. Choose your desired strategy in the plugin settings.
3. Start Mastering Mixology in-game.
4. Play as normal — the plugin will highlight which potions to brew.

## 🎯 Strategy Modes

This plugin offers several strategy options designed to minimize the number of potions needed to complete all log entries. These strategies are based on simulations and research available in the [Mastering Mixology Simulator](https://github.com/saladuit/Mastering_Mixology_Simulator).

### 🔄 Current Strategies

#### 1. **Full Orders**
- **Description:** Always brew every potion in each draw.
- **Use When:** You want a simple, brute-force approach.
- **Average Potions Used:** `5289.53`

#### 2. **Reduce Triples**
- **Description:** Skip triple potions (`AAA`, `MMM`, `LLL`) unless the draw includes `MAL`.
- **Use When:** You want to avoid overproducing rare ingredients from triples.
- **Average Potions Used:** `5060.33`

#### 3. **Reduce Double Aga**
- **Description:** Builds on *Reduce Triples*. Also skips double-Aga potions like `AAM` or `ALA` unless `MAL` is present.
- **Use When:** You're trying to minimize excess AGA generation.
- **Average Potions Used:** `4851.29`

#### 4. **Full Order if Lye 4+**
- **Description:** Builds on previous strategies. If a draw has 4 or more Lye units (L), take the full order regardless.
    - Note: `LLL` counts as only 2 L's (20 Lye).
- **Use When:** You want to optimize for efficient Lye production.
- **Average Potions Used:** `4678.46`

#### 5. **Optimised Point Distribution**
- **Description:** Builds on all previous strategies. Prioritizes orders where the ratio of Lye > Mox > Aga.
- **Use When:** You want a balanced approach focused on resource distribution.
- **Average Potions Used:** `4648.31`

> 💡 *You can change strategies at any time in the plugin config. The interface will update automatically.*

---

## 🤝 Contributing

Suggestions or new strategies are welcome! Check out the [Mastering Mixology Simulator](https://github.com/saladuit/Mastering_Mixology_Simulator) repo to see how strategies are modeled and analyzed.

---
