#Assignment5
##By: Frankie James

###Recursive Programs
#####Fibonacci
		This was my favorite program to work on. Mostly because of the fact
		that I just love the Fibonacci sequence so much. That being said, 
		some of the decisions I made in this program were; I chose to use
		BigInteger and this actually stems from my second decision.
		The second choice I made was to implement tail-recursion. Doing
		this allowed my program to work up to around the ten's of thousands
		Fibonacci indexes. Because these numbers are very long the only type 
		that could fit them was BigInteger. Long broke at about index 92. Other 
		than these two things, Fibonacci was a rather easy build.
#####Multiplication
		In order to do multiplication without actually doing multiplication I 
		chose to recursively add the second number to itself for every unit of the
		first number. So if the first number is 2 and the second is 5, 5 would add to
		itself twice, 5 + 5 is 10 and the answer. it becomes recursive because you can
		do the same thing with one less value of the first number. Overall not a lot of 
		decisions to make and a rather straight forward program.
#####String to Int Converter
		To convert a string to an int I decided to look at the very first character
		of the string and then gets its ASCII code, then subtract the ASCII of zero 
		to get an integer. After doing so it adds to a sum and then returns the
		same things with that first character removed. The only tricky part here was
		that every time you remove a character the next one is one less significant
		in terms of digits. So when adding the number to the sum the significance of 
		the digit must be accounted for, which can be done by seeing how far from the 
		end the character is.
###Parenthesis and Bracket Balancer
	For the balancer program I actually decided to implement both a recursive and an 
	iterative solution. I first chose iterative because I thought that the assignment
	guided us that direction by not including this question with the other recursive ones.
	That being said once I built the iterative I realized that it would be just as easy
	if not easier to just do this program recursively as well. I applied the same tester I 
	had already built and everything was working. In the end I think they are both pretty similar,
	if I had to choose though I think the recursive is more interesting. Easiness to read however,
	iterative might win.
###Tests
	I ended up doing some extra testing than was required and that was just to make sure that 
	everything was really working the way I wanted. All in all not a bad assignment.
