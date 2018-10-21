# plants-vs-zombies


# Class UML Brainstorm

Class Data (Model)
Plants
-healthPoint
-sunPointCost
-plantType(sun flower - support, pea shooter - dps, etc)
-cooldownTime (cooldown to plant the same plantType)
-spawnTime (when planted, plants like bean mine takes a few turns to activate)

SupportPlants extends Plants
-flowerName
-plantType
-sunPointCharge
-specialEffect (slow, burn, etc - could use equals method to check if zombies can resist, in the conditions the zombie will than be slowed or damaged per turn)

DamageDealingPlants extends Plants
-flowerName
-plantType
-damageOutput
-shootingSpeed (time interval - turns it takes to shoot)

Zombies
-zombieName
-healthPoint
-zombieType(normal, tank, resistant, etc)
-movementSpeed
-resistanceType
-weaponEquipType
-damageOutput

Level
-level
-spawnCount (how many zombie spawns at that level)
-waveCount (zombies spawning per wave in a level)
-listOfZombiesToSpawn
+randomSpawning (spawn zombies in random rows)
+strategicSpawning (spawn next zombie at a row without plant and <# of zombies - incase random spawning has an outlier)
+finalSpawning (double the original wave - last wave at the current level)

MasterLevelEditTool
make use of an interface?

GUI + actionHandler (View + Controls)
gui class
+redoButton
+undoButton
+saveGame
+loadGame
+startRound

gui 
-show grid in buttons (playing field)
-show list of selectable plants
-show list of selectable zombies (MasterLevelEditTool)
-show active buttons (redo,undo,save,load)
-show cashflow
-show wave count
-show zombie left to kill count
-can be fancy design (optional)

Main
-startGame (preset Levels)
-customGame (MasterLevelEditTool)
-quit
