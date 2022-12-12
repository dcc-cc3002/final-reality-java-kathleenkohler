Final Reality
=============

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

This work is licensed under a 
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/)

Context
-------

This project's goal is to create a (simplified) clone of _Final Fantasy_'s combat, a game developed
by [_Square Enix_](https://www.square-enix.com)
Broadly speaking for the combat the player has a group of characters to control and a group of 
enemies controlled by the computer.

---
A class was created for each type of weapon, and the existing "Weapon" class was transformed into an abstract class.
Within each weapon class, the equals, hashCode, and toString functions were overwritten.

An interface and an abstract class for wizards have been implemented, called "MageCharacter" and "AbstractMage" 
respectively, since those characters have "mana" and added "getCurrentMp", "setCurrentMp" and "getMaxMp" functions.

In addition, the "waitTurn" function, which was implemented in the abstract class "AbstractCharacter", was separated.
Dividing a part in the "AbstractPlayerCharacter" class and another in the "Enemy" class, in order to avoid the use of
instanceof.

To restrict the weapons each character can equip, an interface was created for weapons and an exception
is also thrown when it is not equippable by a character.

In abstract mage methods were implemented for each spell, to later restrict them according to each mage color.

Consequently, different states were added to the enemy, in which it can be depending on the spell that is used on it.

The attack method was also implemented in the enemy class and in abstractPlayer,
which is used to attack the respective opponent.

Implemented a controller that contains a function that creates the enemies to face, another that sets up an inventory
of characters for the player to choose from, and one that checks if the game is over.

(Continuing with the controller, some commented functions were left, since these were implemented when 
it was not yet explained in detail how the game would work, nor what was requested in the partial deliveries,
but they are functional, and they were also commented on since I did not know how to test functions that received 
inputs and that lowered the coverage.
Among the functions discussed is one that initialized the game, asking which characters the player wanted to play with,
what weapons to equip each one using the respective exception if necessary, and how many enemies they wanted to face
Another commented function is one that implements the "game loop", changing the turns and checking if the game is 
over after each of these. Another that printed the current state of the game, showing the attributes of each character
involved in the game and finally one for the enemy's turn, which attacked a player character and checked the enemy's 
state to see if it was appropriate to change it or keep it and affect it again and one for the player's turn, which 
was complemented by others depending on whether he decided to change his weapon, use a spell, or attack an enemy.)

Finally, the test module was created to test the exceptions and the different methods implemented in each class
of the project.




