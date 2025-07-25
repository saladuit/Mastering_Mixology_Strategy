# Mastering Mixology Strategy Plugin

**A RuneLite plugin to enhance the Mixology minigame experience in OSRS.**

## 📋 Overview

The **Mastering Mixology Strategy** plugin helps you optimize your potion brewing during the Mixology minigame. It colors the in-game order widgets to visually guide you based on different brewing strategies, reducing unnecessary brews and helping you complete your Mixology log more efficiently.

## 🔍 Features

- 🔄 Shows which potions to brew based on selected strategies.
- ⚙️ Switch between multiple optimized brewing strategies.
- 🧠 Designed using detailed simulations from [Mastering Mixology Simulator](https://github.com/saladuit/Mastering_Mixology_Simulator).

## 🎥 Video Tutorial

[![Watch the video](https://img.youtube.com/vi/QOWP84_fKfo/0.jpg)](https://youtu.be/QOWP84_fKfo?t=267)

## 🛠️ How to Use

1. **Install the plugin** via the RuneLite Plugin Hub.
2. Choose your desired strategy in the plugin settings.
3. Start Mastering Mixology in-game.
4. Play as normal — the plugin will highlight the potions to create green and the potions to skip red.
   
<img width="512" height="262" alt="Mastering Mixology Highlighter" src="https://github.com/user-attachments/assets/7a5a47cf-0d9c-49a4-8239-d7bd542eefce" />

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

## 🔮 Future of plugin:
- **Track the amount of potions used:** To better track the amount of potions used to reach a certain goal
- **Dynamic strategy:** Ensure that the plugin automatically updates your current best strategy depending on your goal and current point total
- **Custom strategy:** Create your own csv file containing your own strategy

## 🤝 Contributing

Suggestions or new strategies are welcome! Check out the [Mastering Mixology Simulator](https://github.com/saladuit/Mastering_Mixology_Simulator) repo to see how strategies are modeled and analyzed.

---

## 📝 Small note:

While I used the **Optimised Point Distribution** strategy, I green-logged the mini-game almost perfectly.

<img width="618" height="406" alt="Screenshot 2025-07-04 183010" src="https://github.com/user-attachments/assets/fad1e5fb-00f2-4013-ac27-59401b186d46" />

<img width="208" height="467" alt="Screenshot 2025-07-04 183322" src="https://github.com/user-attachments/assets/6e48a08a-cd37-431e-96f8-ac3c998f01b7" />
