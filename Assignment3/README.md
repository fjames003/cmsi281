# Assignment 3
## By: Frankie James

### Core
    For the core package in assignment 3 I took your advice and decided 
    to start from your LameGame beginning and then build it from there.

    * I thought I could've used my Point class from assignment 2 in place of 
    Coordinate but since Point was immutable I stuck with Coordinate. I 
    decided to add toString() into Coordinate and Displacement for use later
    on. Other than that those two classes are still the same basic classes.

    * Added into the Core package was a GameObject class 
    that will be used for all Game Pieces. This class contains a location
    as well as a rendered character. It has methods to set and get its
    location values as well as get and set its rendered character.  

    * The last class in Core is MovableObject, an **_abstract_** class,
    which extends from GameObject. MovableObjects contain everything GameObject 
    did as well as a Displacement, number of hits, and hit percentage. In
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
    For the engine portion of the package I decided to stick with the
    one class that you originally had. Although most of it has changed in
    numerous ways now. It still contained an internal frame integer as well
    as a size integer. All objects in the game however are represented in
    two 1-dimensional arrays; one for non-moving objects and one for moving
    objects, or in other words objects that need to update and those who don't.

    * For the constructor I decided to keep this very clean. I left the createWalls() just
    like it was originally. I had also left the game pieces in static initial positions
    and it was really bugging me and randomizing initial position was going to 
    be in future implementations(see below) but at the last second I figured out
    an easy way to randomize the positions using a method named createPieces().

    * As mentioned createWalls() as well as update() were untouched because they were 
    simple and served their purpose. 

    * The method for rendering though was cut way down. This was the first to go. 
    Once all objects were represented by two arrays I just needed to loop through 
    both loops and put have the rendered character show up in the renderedWorld array. The 
    render() method also prints the hits of each moving object every time its called. 

    * To check for collisions this was also simplified. All moving objects just check its
    collisions with both non moving and moving objects.

    * There is also a method in game engine to have every moving game piece use its displacement 
    randomizer to switch up the game. This is called by the App class during game play.

    * As mentioned above the last method in GameEngine is the create pieces method.
    This method while superficially looks long it is really just a bunch of loops that go
    through for every non-Wall game-piece and assign it an x and y value that haven't been
    used yet. I decided to do one player per 15 squares (App requires a size of 15-100). Then
    there are 4 monsters per player as well as 2 bosses per player. One of each respective type.
    As for rocks and trees there are 1 each for every 10 squares. This keeps things interesting
    because as the board expands so do the interactions.

### GameObjects
    As for the gameobjects package itself, these are very simple in nature.
    All non moving objects _extend_ from GameObject and therefore get everything 
    they need from that class. The only thing each class does differently is the char
    that is set using the super class method. Additionally all classes that extend
    MovingObject must Override the newHit(MovableObject m) method to compile. 

    While I realize that these classes (especially the non moving ones) are very similar
    in nature I felt it important to still represent each type as its own class.
    The thinking behind this was this game could go much further and someone might
    want to allow players to plant trees, give trees a lifespan, smash rocks, you name
    it, it could be implemented. That is my gameobjects in a nutshell.
### App
    I decided to really have fun when it came to the App for this. When it comes
    down to it all of this is really to allow App to make something interesting.
    Keeping this in mind I first decided the user should input the game size,
    within reasonable limits. These limits were determined to be 15-100 the 15
    was so that enough gameobjects could fit and not get stuck on each other. The
    100 was because on a 17" screen it happened to fit going across, as well as allowed
    for a max a of 10 rocks and 10 trees.

    Heavily used in the App is a private method pressEnter(), this method is used 
    whenever the user gives bad input. Instead of throwing some exception and crashing
    the program I decided to print an error message and wait for the user to press enter.
    From this point a default value is given to the program to run with after enter is pressed.
    One more method created was to simply show the commands if ever the key [H] is pressed.
    Finally the main method takes in the user input and depending on what letter it is,
    something is executed whether it be next frame or quit, or a more interesting one added
    which is advance frames. It takes in an integer 1-100 and will advance that number of frames
    ahead for you. This will default to 1 if bad input is given. All in all I really just tried
    to have a little fun with the App to showoff some interesting functionality of GameEngine 
    and the objects on it.

### Future Implementations
    As mentioned earlier on I think it would be interesting to allowing the gameobjects that don't
    move some added abilities. For example trees dying and growing. Players possibly planting trees
    or smashing rocks after rocks have been hit so many times. Similarly I think bosses should be 
    able to do a little bit more. I thought of maybe boss be able to clone another boss if they run 
    into each other. Or maybe an additional object that just moves randomly but destroys everything 
    essentially clearing the board as it went but maybe every 4 frames. (Could solve cloning over 
    population problem).

    It's obvious I could go on forever with this because I really did enjoy building it.
    Sometimes you just have to know when to just stop and leave things be. So here is Frankie's
    Game thus far.
    
