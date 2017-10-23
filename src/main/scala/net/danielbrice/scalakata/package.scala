package net.danielbrice

package object scalakata {

  object SmallestTwo {

    /**
     * I. SmallestTwo
     *
     * Given: a finite list of integers, return the smallest and the second smallest,
     *
     * When: your function is called on said list,
     *
     * Then: your function returns the smallest and next smallest elements as a tuple.
     *
     * Special Requirement: This function is trivial to implement using two list traversals.
     * Try to make your solution use only one list traversal (the hidden tests will
     * pass a series of VERY large lists to justify this design requirement.)
     */

    def smallestTwo(ints: List[Int]): (Int, Int) = ???

  }

  object SayIt {

    /**
     * II. SayIt
     *
     * Given: your function might be called with a string or with no argument,
     * (actually, it'll be called with an Option[String])
     *
     * When: your function is called with a string or without an argument,
     *
     * Then: if your function was called with a string, then that string is appended
     * to a closure accumulator, if your function was called with nothing, then the
     * accumulator is printed to the console.
     *
     * Special Requirement: This is trivial to implement using classes/objects. The
     * purpose of this exercise is to capture the same behavior of encapsulated state
     * in a closure.
     */

    // a Sayable is a function : Option[String] => Sayable
    sealed trait Sayable extends (Option[String] => Sayable)

    // SayableTerminate returns itself, regardless of argument
    case object SayableTerminate extends Sayable {
      def apply(optStr : Option[String]): Sayable = SayableTerminate
    }

    // a Sayable Accumulate is given a function at construction,
    // it simply applies the function it was given
    case class SayableAccumulate(f: Option[String] => Sayable) extends Sayable {
      def apply(optStr: Option[String]): Sayable = f(optStr)
    }

    // sayIt should take an Option[String] and return a Sayable
    // If the argument is Some(str), then we need to somehow store str
    // If the argument is None, then we need to println
    def sayIt(optStr: Option[String]): Sayable = ???

  }

  object SumsProds {

    /**
     * III. SumsProds
     *
     * Given: a finite list of pairs of doubles,
     *
     * When: your function is called on said list,
     *
     * Then: your function returns a type with shape `(a, b, c, d)`, where `a`
     * is the sum of the first coordinates, `b` is the sum of the second coordinates,
     * `c` is the product of the first coordinates, and `d` is the product of the
     * second coordinates.
     */

    def sumsProds(pairs: List[(Double, Double)]): (Double, Double, Double, Double) = ???

  }

  object FindLoop {

    /**
     * IV. FindLoop
     *
     * Given: a linked list of characters that is known to loop back on itself at
     * some entry,
     *
     * When: your function is called on said list,
     *
     * Then: your function returns the node at which the list rejoins itself.
     */

    case class ListNode(label: Char, next: Unit => ListNode)

    def findLoop(start: ListNode): ListNode = ???

  }

  object ValidateTree {

    /**
     * V. ValidateTree
     *
     * Given: a binary tree of integer nodes,
     *
     * When: your function is called on said tree,
     *
     * Then: your function returns `true` if the tree satisfies the property that
     * for all nodes the nodes to the left have a smaller integer and the nodes
     * to the right have a larger integer, your function returns false otherwise.
     */

    // Below, we define a data struct `Tree[T]` with the following shape:
    // Tree[T] = Leaf | Branch(value : T, left : Tree[T], right : Tree[T])
    sealed trait Tree[+T]
    case object Leaf extends Tree[Nothing]
    case class Branch[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

    def validateTree(tree: Tree[Int]): Boolean = ???

  }

  object Pathfinding {

    /**
     * VI. Pathfinding
     *
     * Given: two nodes of a strongly-connected directed graph
     * (meaning, for any two nodes A and B, there is gauranteed
     * to be a path from A to B),
     *
     * When: your function is called with said nodes,
     *
     * Then: your function returns one minimal path between the two nodes.
     */

    case class GraphNode(label: Char, neighbors: Unit => List[GraphNode])

    def pathfinding(start: GraphNode)(end: GraphNode): List[GraphNode] = ???

  }

  object MapReduce {

    /**
     * VII. MapReduce
     *
     * Implement a function with type signature
     * `(A => B) => ((B, B) => B) => B => List[A] => B`.
     *
     * The only requirements are that it must be possible for the return value to
     * be different from the third argument and that it "preserves" the order of
     * the passed list (whatever that means).
     */

    def mapReduce[A,B](f: A => B)(g: (B, B) => B)(z: B)(l: List[A]): B = ???

  }

  object UseMapReduce {

    /**
     * VIII. UseMapReduce
     *
     * Re-implement "SmallestTwo" and "SumsProds" using the polymorphic
     * map reduce higher-order function.
     */

    def mapReduce[A,B](f: A => B)(g: (B, B) => B)(z: B)(l: List[A]): B = ???

    def smallestTwo(ints: List[Int]): (Int, Int) = ???

    def sumsProds(pairs: List[(Double, Double)]): (Double, Double, Double, Double) = ???

  }

  object TreeMapReduce {

    /**
     * IX. TreeMapReduce
     *
     * Implement a function with type signature
     * `(A => B) => ((B, B) => B) => B => Tree[A] => B`.
     *
     * The only requirements are that it must be possible for the return value to
     * be different from the third argument and that it "preserves" the order of
     * the passed tree (whatever that means).
     */

    sealed trait Tree[+T]
    case object Leaf extends Tree[Nothing]
    case class Branch[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]

    def treeMapReduce[A,B](f: A => B)(g: (B, B) => B)(z: B)(tree: Tree[A]): B = ???

  }

  object MethodTreeMapReduce {

    /**
     * X. MethodTreeMapReduce
     *
     * Refactor `treeMapReduce` so that it is a method of `Tree[T]`
     * rather than a top-level function.
     */

    sealed trait Tree[+T] {
      def mapReduce[S](f: T => S)(g: (S, S) => S)(z: S): S
    }

    case object Leaf extends Tree[Nothing] {
      def mapReduce[S](f: Nothing => S)(g: (S, S) => S)(z: S): S = ???
    }

    case class Branch[+T](v: T, l: Tree[T], r: Tree[T]) extends Tree[T] {
      def mapReduce[S](f: T => S)(g: (S, S) => S)(z: S): S = ???
    }
  }
}
