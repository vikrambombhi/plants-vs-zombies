# plants-vs-zombies

The goal of this team project is to implement a puzzle version of the popular Plants vs
Zombies (PvZ) game. PvZ is a game in the tower defense genre available for most
gaming platforms.

# Author
Vikram Bombhi - 101007498
Andrew Nguyen - 100893165
Brian Zhang - 101008207

# Contribution
Vikram Bombhi - Model Classes, Control Classes, Documentation, Makefile
Andrew Nguyen - UML, Sequence, View Classes, Control Classes, Error Implementation, Documentation
Brian Zhang - Model Classes, Control Classes, JUnit, Documentation

================================================================================================================================
# Instruction for the Game
The objective of this game is to stop zombies from reaching the left side of the board, the zombies are denoted with 'Z'
You can buy plants with sunpoints that you earn every round
The sunflower will increase the number of sunpoints you earn per round, the sunflower is denoted with 'S'
The peashooter will shoot damage dealing peas every two turns at the incoming zombies, the peashooter is denoted with 'P'
If the zombie reaches a plant it will start damaging it, this is denoted with 'B'

When the game starts, console will print out the current board playing field with options underneath.
By following the output on console, choose the options from (1)-(4) to proceed further into the game.

================================================================================================================================
# Update/Patch - November 16, 2018
In this iteration, the team implemented MVC into the system along with unit testing to verify everything is in working condition.
The UML of the system has to be changed to incorporate with the MVC format. View will contain multiple subclasses that builds the overall view of the game. Control will handle any events with actionListener. Model will contain all the data from the previous milestone. The GUI will contain some tabs(DimensionChange, Save) that will be implemented in future milestones.

# Milestone 2 Deliverable

GUI-based version (now you’re adding the View and the Controller!) of the
bare-bones version of the game + Unit tests for the Model. The code is allowed to
“smell” at this point


================================================================================================================================
# Update/Patch - October 29, 2018
In this current iteration, the team began by brainstorming the classes we needed to develop for a working game without the extra features.
Once we figured out what classes were needed, we implemented the codes to make sure the game works the way we intended in successful steps.
Ex/ push play, placing sunflower down an existing tile, skipping to next turn, generating zombies, etc.
After playing through the game, we tried to break the game by throwing in invalid inputs. With this consideration, we were able to figure out where the errors surface and push exceptions and fixes to prevent the problems.
Some known issues we experienced and able to fix were:
- IllegalArgumentException
- ArrayIndexOutOfBoundsException
- NumberFormatException
- Out of Bound placement

Currently the game works fine but some future changes we wish to implement down the road are as listed:
- Change Board Tile Layout - Hashmap possibly
- Putting zombies and plants into their own list
- Improved GUI
- Milestone 2 Implmentation

# Milestone 1 Deliverable

A text-based (i.e., console-based input and textual representation), barebones
but playable version of the game (sunflowers, one other type of plant, one type of
zombie, just one level), UML modeling of the problem domain (class diagrams, sequence
diagrams, complete variable and method signatures), detailed description of the choice of
data structures and relevant operations: you are providing an initial design and
implementation for the Model part of the MVC. Do not worry about any GUI yet.
• Deliverables: readme file (see explanation below) + code + UML diagrams +
documentation, all in one zip file.
• Deadline: Wednesday Oct 23rd. Weight: 15% of the overall project grade. 

================================================================================================================================
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

### Plants
- sunFlower
- peaShooter

### Zombies
- regularZombie

### Level
level = 1
spawnCount = 8 (wave1=2, wave2=2, wave3=4)
waveCount = 3
