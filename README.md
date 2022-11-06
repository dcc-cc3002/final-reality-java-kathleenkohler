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

Implemented an abstract class for mages, called "AbstractMage", since those characters have "mana" and
added "getCurrentMp", "setCurrentMp" and "getMaxMp" functions.

In addition, the "waitTurn" function, which was implemented in the abstract class "AbstractCharacter", was separated.
Dividing a part in the "AbstractPlayerCharacter" class and another in the "Enemy" class, in order to avoid the use of
instanceof.

To restrict the weapons each character can equip, an interface was created for weapons and an exception
is also thrown when it is not equippable by a character.

Finally, the test module was created to test the exceptions and the different methods implemented in each class
of the project.



