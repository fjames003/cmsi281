# Assignment 3
⋅⋅⋅ ## By: Frankie James

### Core
For the core package in assignment 3 I took your advice and decided 
to start from your LameGame beginning and then build it from there. 
I thought I could've used my Point class from assignment 2 in place of 
Coordinate but since Point was immutable I stuck with Coordinate. I 
decided to add toString() into Coordinate and Displacement for use later
on. Other than that those two classes are still the same basic classes.
Added into the Core package was an **_abstract_** GameObject class 
that will be used for all Game Pieces. This class contains a location
as well as a rendered character. It has methods to set and get its
location values as well as get and set its rendered character. All setters
are protected as to only be used by subclasses and classes in the 
same package but not used by the world. The last class in Core is 
MovableObject, another **_abstract_** class, which extends from 
GameObject. MovableObjects contain everything GameObject did as 
well as a Displacement, number of hits, and hit percentage. In
the constructor of MovableObject an x and y value is needed for 
location as well as its hit percentage. This makes the assumption
that a characters hit percentage remains the same through lifespan.
Then a GameObject is created using that x and y and a displacement is
randomly generated where the Displacement produced cannot equal (0,0).
From here the constructor makes sure that the given hit percentage is 
between 0 and 1 (cannot hit less than 0% of the time or more than 100%).
MovableObject also contains an update method that updates location 
based on displacement. Also checks to make sure the object hasn't hit a 
wall and if so immediately bounce back (prevents exceptions being thrown
by game when manually randomizing displacements discussed later).
MovableObect provides a method to check a collision between any 
GameObject. Collision immediately causes inversion of displacement.
Then the method checks if its hit non-movable object (Wall Excluded) 
and if so increases MovableObjects hits variable. If Moving Object
collides with another MovableObject then the **_abstract_** method
newHit(MovableObject m) is called. This method is defined by each 
individual MovableObject. The last of the methods in Movable Object 
are a getter for hits and hit percentage, as well as a setter for 
hit percentage and a String for printing hits, and finally a method
to randomize the displacements as aforementioned.

### Engine

### GameObjects

### App

