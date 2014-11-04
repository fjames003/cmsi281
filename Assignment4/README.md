# Assignment 4
## By: Frankie James

### Decision on Structure
	Ultimately I decided to use an abstract class for the basis of the Nmost Recent list. 
	I chose an abstract class because it allowed me to use the constructor for the one
	thing all three implementations had in common, their size given when made. So the base
	class checks to make sure the size is a valid number and all other methods are left to
	the implementation. Additionally the Nmost Recent class implements the Iterable interface
	so that all implementations must provide an iterator.

### Array Based Implementation
	For the array I decided to use an array of 'Node's because I had built the class before 
	the class discussion that an object[] should be used instead of E[]. I ran into the E[] 
	problem on my own and decided to solve it using the nodes parameterized typing. This 
	eliminated any casting that had to be done. In the end, when the tests run, the array
	implementation is usually the fastest(because the test is a list of 4).

### Linked Allocation Based Implementation	
	For the linked allocation strategy I decided to use a head as well as an end for fast
	retrieval of the oldest and newest (all we care about). Other than that it was pretty 
	straight forward similar to the examples in class.

### Java Based Implementations
	This was by far the easiest of the three. When deciding upon a Linked-List or an Array-
	List I chose to go for the Linked-List because the array is better in cases where we need
	to retireve or add elements to the middle. In this case we do neither so it made more 
	sense to use a linked list that can much easier add to the beginning as sizes grow large.
	This was also the only class that had a built in iterator that I didn't need to build. It 
	has a method to do just about anything (with multiple syntax to do it) you just need to find 
	the method.

### Iterators
	Both iterators are very similar. The main difference is in the linked version I can use the
	built in next function of node to easily traverse the list. In the array based case i needed
	to keep track of the index number and use that to access different elements in the array. Overall
	these are very small classes that serve their purpose.

### Tests
	Overall the testing for this assignment was relatively easy. We needed at least 7 tests per 
	implementation. I ended up adding a few for a total of 11 each. All three test classes are the
	same except for the implementation they use in the beginning for its list. The tests added were
	to make sure you didn't recieve output when calling get oldest or newest when the list is empty.