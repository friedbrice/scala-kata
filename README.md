# scala-kata

Code Katas for experienced programmers beginning Scala.

## I. SmallestTwo

**Given:** a finite list of integers,

**When:** your function is called on said list,

**Then:** your function returns the smallest and next smallest elements as a tuple.

_Special Requirement:_ This function is trivial to implement using two list traversals. Try to make your solution use only one list traversal (imagine a VERY large lists to justify this design requirement.)

_Source:_ Problem statement from S. Shubin.

## II. SayIt

**Given:** your function might be called with a string or with no argument,

**When:** your function is called with a string or without an argument,

**Then:** if your function was called with a string, then that string is appended to a closure accumulator, if your function was called with nothing, then the accumulator is printed to the console.

_Special Requirement:_ This is trivial to implement using classes/object. The purpose of this example is to capture the same behavior of encapsulated state in a closure.

_Source:_ Problem statement from A. Croll's "If Hemingway Wrote JavaScript".

## III. SumsProds

**Given:** a finite list of pairs of doubles,

**When:** your function is called on said list,

**Then:** your function returns a type with shape `(a, b, c, d)`, where `a` is the sum of the first coordinates, `b` is the sum of the second coordinates, `c` is the product of the first coordinates, and `d` is the product of the second coordinates.

_Source:_ Problem statement from A. Byaly.

## IV. FindLoop

**Given:** a linked list of characters that is known to loop back on itself at some entry,

**When:** your function is called on said list,

**Then:** your function returns the node at which the list rejoins itself.

_Source:_ "Can you get the loop?" by Devouring @ CodeWars.

## V. ValidateTree

**Given:** a binary tree of integer nodes,

**When:** your function is called on said tree,

**Then:** your function returns true if the tree

## VI. Pathfinding

**Given:** a connected graph,

**When:** your function is called with said graph and two nodes,

**Then:** your function returns the distance between those two nodes and at least one minimal path between the two nodes.

## VII. MapReduce

Implement a higher-order function with type signature `(A => B) => ((B, B) => B) => B => List[A] => B`.

The only requirements are that it must be possible for the return value to be different from the third argument and that it "preserves" the order of the passed list (whatever that means).

_Source:_ A non-polymorphic version of this kata is a homework problem from Odersky's "Functional Programming Principles in Scala" MOOC on Coursera.

## VIII. UseMapReduce

Re-implement "SmallestTwo" and "SumsProds" using the map reduce function.

## IX. TreeMapReduce

Implement a higher-order function with type signature `(A => B) => ((B, B) => B) => B => Tree[A] => B`.

The only requirements are that it must be possible for the return value to be different from the third argument and that it "preserves" the order of the passed tree (whatever that means).

## X. MethodTreeMapReduce

Refactor `treeMapReduce` so that it is a method of `Tree[T]` rather than a top-level function.
