###             Homework Assignment 2
##                      By: Frankie James

#The Build
    First off this was quite a challenging build. Not only
    did it take ample time to complete but some of the 
    tests needed were rather tricky. That being said I 
    did complete nearly all of the assignment.

    I decided to put my shapes in a package called shapes
    located inside the Assignment2 package because I thought
    it went nicely. I did leave however Line and Point in the 
    Assignment2 package for the reason that they are both the 
    heart and soul of Assingment2 and the shapes are just the 
    resulting product of those key classes.

#Point Class
    For my Point I created all of the required methods and 
    tested them although I did add a toString() method as well
    that was also tested. Additionally for practical reasons in
    righting my shapes I included getX() and getY() methods to be 
    used in other classes. All tests are passing.

#Line Class
    I decided that my Line would consist of 
    two Points essentially so that many of the 
    methods needed for Line could just use already
    working methods in Point like in the length() 
    method. There was one hard method though and that
    was the intersecting lines method. Because the
    lines were segments and not continous it made things 
    tricky. I ended up figuring out a way using cross
    products and tried to comment through what each step
    was doing. All tests for Line are also passing.

#Circle
    The Circle class was actually the easiest of all the shapes.
    This was becuase a Circle only requires a cnter Point and 
    a radius. I tested things like whether the radius with the 
    given center would hit negative values and likewise on a 
    translate. Most methods in this one were essentially just 
    basic geometry. There is one test failure though and it actually
    occurs in all of my shapes. It is the translate test. Although I 
    think this may be due to my little knowledge of Junit because
    my cannotTranslate() test does throw an exception as expected 
    but on the translate test no exception is thrown (which in the code 
    of translate() means that the shapes points are being changed) 
    but when I check to see if the shapes contains an old Point that
    is no longer in it, it returns true instead of false. And I know my
    containsPoint() methods work because those tests also passed. All in all
    I get nearly everything for Circle working except possibly translate().

#Rectangle
    The Rectangle class is when things really started getting more difficult.
    In order to validate whether the rectangle was actually a rectangle, meaning
    it had two pairs of sides with equal lengths, I first made sure there were no 
    null values or any same points, then I had to compare the distances between 
    all three pairs of lines, that is the horizontal, the vertical, and the diagonals and
    make sure they matched their pair. In the constructors for Rectangle I decided 
    that simplicity should be on the side of the user which is why I decided to 
    make the constructors either take four Points or just a Point[] containing 
    four points. I did this because in order to say create a Rectangle on the user
    side using Lines, they would need to first create 8 points (two for each Line)
    and then the Rectangle. So instead I made a method inside Rectangle to build the 
    Lines. This also proved tricky because I needed to figure it which line was the diagonal
    and NOT build that Line. So I compared each side to a maxLength found. I included again
    all required methods as well as some others that made testing easier such as isEqualTo, which 
    I also tested. And Again all tests were passing except the translate method for aformentioned
    reasons.

#Square
    For the Square Class I stole the childhood saying that a Square is
    a Rectangle but a rectangle is not a Square. So my Square steals a lot
    of functionality from Rectangle because it was already tested and they 
    are essentially the same thing. That being said I did still validate that it
    was indeed a Square. Square contains all required methods and is fully tested.
    Although some things were not tested like constructor arguments being null and this
    is because all the arguments are run through Rectangle which is tested in that manner.
    The only test failure for Square is again the translate Test.

#Right Triangle
    The Right Triangle actually proved to be the most challenging and the only 
    class in which all required methods were not complete. This is because two methods
    proved to be challenging. First the containsPoint() was very hard and I actaully found
    a way using cross products again but I didn't have enough time to figure out out. Because 
    this I also was not able to test my translate() method (I used containsPoin()). I was
    also not able to get the bounding rectangle because while I had three of the four points
    for the rectangle, finding the fourth proved difficult. This was because it all depended on
    the orientation of the triangle relative to the 90 degree angle. I did validate that it
    is actually a Right Triangle using pythagorean's theorem. All in all I thought this class
    was very hard to program but could probaly get most things working if given some more time.