# plants-vs-zombies

The goal of this team project is to implement a puzzle version of the popular Plants vs
Zombies (PvZ) game. PvZ is a game in the tower defense genre available for most
gaming platforms.

# Class UML Brainstorm

## Class Data (Model)
### Plants
- healthPoint
- sunPointCost
- plantType(sun flower - support, pea shooter - dps, etc)
- cooldownTime (cooldown to plant the same plantType)
- spawnTime (when planted, plants like bean mine takes a few turns to activate)

### SupportPlants extends Plants
- flowerName
- plantType
- sunPointCharge
- specialEffect (slow, burn, etc - could use equals method to check if zombies can resist, in the conditions the zombie will than be slowed or damaged per turn)

### DamageDealingPlants extends Plants
- flowerName
- plantType
- damageOutput
- shootingSpeed (time interval - turns it takes to shoot)

### Zombies
- healthPoint
- zombieType(normal, tank, resistant, etc)
- movementSpeed
- resistanceType
- weaponEquipType
- damageOutput

### Level
- level
- spawnCount (how many zombie spawns at that level)
- waveCount (zombies spawning per wave in a level)
- listOfZombiesToSpawn
+ randomSpawning (spawn zombies in random rows)
+ strategicSpawning (spawn next zombie at a row without plant and <# of zombies - incase random spawning has an outlier)
+ finalSpawning (double the original wave - last wave at the current level)

MasterLevelEditTool
make use of an interface?

### GUI + actionHandler (View + Controls)
### gui class
+ redoButton
+ undoButton
+ saveGame
+ loadGame
+ startRound

### gui 
- show grid in buttons (playing field)
- show list of selectable plants
- show list of selectable zombies (MasterLevelEditTool)
- show active buttons (redo,undo,save,load)
- show cashflow
- show wave count
- show zombie left to kill count
- can be fancy design (optional)

### Main
- startGame (preset Levels)
- customGame (MasterLevelEditTool)
- quit

# Milestone 1

A text-based (i.e., console-based input and textual representation), barebones
but playable version of the game (sunflowers, one other type of plant, one type of
zombie, just one level), UML modeling of the problem domain (class diagrams, sequence
diagrams, complete variable and method signatures), detailed description of the choice of
data structures and relevant operations: you are providing an initial design and
implementation for the Model part of the MVC. Do not worry about any GUI yet.
• Deliverables: readme file (see explanation below) + code + UML diagrams +
documentation, all in one zip file.
• Deadline: Wednesday Oct 23rd. Weight: 15% of the overall project grade. 

### Plants
- sunFlower
- peaShooter

### Zombies
- regularZombie

### Level
level = 1
spawnCount = 8 (wave1=2, wave2=2, wave3=4)
waveCount = 3
