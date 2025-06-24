# 🦣 Cenozoic Kingdom – TODO List

This file lists planned features, improvements, and technical tasks for the mod.  
Feel free to suggest changes or additions via issues or Discord!

---

## ✅ Core Features

- [x] Functional Analyzer block with GUI  
- [x] Functional Synthetizer block with DNA processing logic  
- [x] Item processing system (frozen/fossil items → DNA)  
- [x] Implemented fossil generation in world (frozen variants + fossil_ore (second version is coming soon))  

---

## 🔧 In Progress

- [ ] Add first custom entity from DNA (e.g. Dodo)  
- [ ] Implement entity NBT data saving (for unique traits or mutations)  
- [ ] Create animated models using GeckoLib  
- [ ] Sounds for Analyzer & Synthetizer (UI, working, success/failure)  
- [x] Add tooltips for DNA/genome items  
- [ ] Polish and balance drop/output chances  
- [x] Add Permafrost block variants (with visual differences)  
- [ ] Configurable worldgen (via datapack or config file)  

---

## 🧬 Planned Creatures (Phase 1)

### Paleozoic Creatures:
- [ ] Dimetrodon  
- [ ] Edaphosaurus  
- [ ] Casea  
- [ ] Archeothyris  
- [ ] Eothyris  
- [ ] Ophiacodon

### Mesozoic Creatures:
coming soon...

### Ice Age Mammals:
- [ ] Smilodon  
- [ ] Mastodon  
- [ ] Megatherium  
- [ ] Doedicurus  
- [ ] Kelenken  

### Modern Extinct Species:
- [ ] Thylacine  
- [ ] Dodo  
- [ ] Moa  
- [ ] Haast's Eagle  
- [ ] Aurochs  
- [ ] Passenger Pigeon  
- [ ] Great Auk  
- [ ] Steller's Sea Cow  
- [ ] Quagga  

---

## 🎨 Assets & Art

- [ ] Create and polish icons for all items:  
  - Fossil Fragments  
  - [x] DNA samples  
  - [x] Genome items  
  - Creature eggs  
- [x] Create block textures (fossil ore, permafrost, devices)  
- [ ] Animated textures (Analyzer working, glowing DNA, etc.)  
- [ ] Add biome-appropriate spawn eggs for all mobs  
- [x] Texture variants for Permafrost (deep dark, stone, surface (in future this block will be generated in more biomes, and have custom textures e.g. mossy, cracked))    
- [ ] Entity textures and model templates for all creatures  

---

## 🗺 World Generation

- [x] Fossil ore generation (underground, common fossils)  
- [x] Ice-age fossils under cold biomes (Snowy Plains, Taiga, etc.)  
- [ ] Rare fossils in Deep Dark or Lush Caves    
- [ ] Add biome-specific fossil spawn tables  
- [ ] Add structures (ancient dig sites, research stations, crashed drones)  

---

## 🧠 AI & Mob Behavior

- [ ] Base AI: idle → walk → random look  
- [ ] Basic pathfinding and navigation  
- [ ] Separate logic for herbivores and carnivores  
- [ ] Simple animations (idle, walk, sleep)  
- [ ] Attack and flee logic (carnivores hunt, herbivores run)  
- [ ] Herd behavior (optional for some mobs like Doedicurus)  
- [ ] Creature taming (via DNA injection or special item)  
- [ ] Ageing system (baby → adult)  
- [ ] Breeding (planned for alpha 0.2+)  

---

## 📦 Optimization / Technical

- [x] Clean up ModItems, ModBlocks registries (group DNA by type, fossils by era)  
- [x] Refactor SynthetizerBlockEntity to multiple smaller methods  
- [ ] Add unit tests for weighted DNA output selection  
- [ ] Fix potential duplication bugs (slot edge cases)  
- [ ] Cache genome combinations for faster lookup  
- [ ] Add datagen support for blocks/items/models  

---

## 🔧 Technical Systems to Add

- [ ] DNA classification system (normal, mutated, hybrid)  
- [ ] Genome combination (requires multiple DNA types to unlock)  
- [ ] Incubator/egg hatching system  
- [ ] Mutation system (e.g. albino, strong, fast genes)  
- [ ] DNA scanner item (portable Analyzer)  
- [ ] Entity stat modifiers (speed, health, attack) based on genes  

---

## 🧾 Configs & Compatibility

- [ ] Create a .json or .toml config for:  
  - Fossil spawn rates  
  - Permafrost generation  
  - DNA mutation chance  
- [x] Optional integration with JEI/REI (Analyzer and Synthetizer recipes)  
- [ ] Optional BiomeTags support for mod compatibility (e.g. Terralith)  

---

## 🧑‍🤝‍🧑 Community / Dev

- [ ] credits.json for contributors  
- [ ] README.md with install info  
- [ ] Modrinth + CurseForge pages  
- [ ] Discord bot: auto-ping when build updates on Modrinth  
- [ ] Add localization support (pl_pl.json, es_es.json, jp_jp.json, fr_fr.json, etc.)  
- [ ] Add in-game book or guide (like Patchouli or custom GUI)  
- [ ] Development roadmap (milestone board(Trello) or wiki)  

---

## 📅 Milestones

### 🔹 Alpha 0.1 – First Playable Version
- [ ] At least 1 working creature  
- [ ] Functional Analyzer + Synthetizer pipeline  
- [ ] Balanced worldgen  
- [ ] Textures for all core items  
- [ ] Testing build  

### 🔷 Alpha 0.2 – Creature Variants & Breeding
- [ ] 3–5 mobs with full animations and behavior  
- [ ] Genome combinations / hatching logic  
- [ ] Basic breeding system  
- [ ] Custom sounds 
