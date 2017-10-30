package net.danielbrice

import scala.annotation.tailrec

package object scalakata {

  object SmallestTwo {

    /**
      * I. SmallestTwo
      *
      * Given: a finite list of integers, return the smallest and the second
      * smallest,
      *
      * When: your function is called on said list,
      *
      * Then: your function returns the smallest and next smallest elements as a
      * tuple.
      *
      * Special Requirement: This function is trivial to implement using two
      * list traversals. Try to make your solution use only one list traversal.
      */

    def smallestTwo(ints: List[Int]): (Int, Int) = ???

  }

  object SumsProds {

    /**
      * II. SumsProds
      *
      * Given: a finite list of pairs of doubles,
      *
      * When: your function is called on said list,
      *
      * Then: your function returns a type with shape `(a, b, c, d)`, where `a`
      * is the sum of the first coordinates, `b` is the sum of the second
      * coordinates, `c` is the product of the first coordinates, and `d` is the
      * product of the second coordinates.
      */

    def sumsProds(pairs: List[(Double, Double)]): (Double, Double, Double, Double) = ???

  }

  object SayIt {

    /**
      * III. SayIt
      *
      * Given: your function is initially called with a string, and then
      * subsequent calls with a string can be chained onto the result, until
      * a final call is made with no argument.
      *
      * When: the result of a so chained expression is called with no argument
      *
      * Then: return the concatenation of the strings supplied in the calls.
      */

    case class Sayable()

    def sayIt(str: String): Sayable = ???

  }

  object FindLoop {

    /**
      * IV. FindLoop
      *
      * Given: a linked list of characters that is known to loop back on itself
      * at some entry,
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
      * Then: your function returns `true` if the tree satisfies the property
      * that for all branches, the leaves of the left subtree are all smaller
      * then the leaves of the right subtree, your function returns false
      * otherwise.
      */

    sealed trait Tree[+T]
    case class Leaf[+T](value: T) extends Tree[T]
    case class Branch[+T](left: Tree[T], right: Tree[T]) extends Tree[T]

    def validateTree(tree: Tree[Int]): Boolean = ???

  }

  object Pathfinding {

    /**
      * VI. Pathfinding
      *
      * Given: two nodes of a strongly-connected directed graph (meaning, for
      * any two nodes A and B, there is gauranteed to be a path from A to B),
      *
      * When: your function is called with said nodes,
      *
      * Then: your function returns one minimal path between the two nodes.
      */

    case class GraphNode(label: Char, neighbors: Unit => List[GraphNode])

    def pathfinding(start: GraphNode)(end: GraphNode): List[GraphNode] = ???

  }

  object ListFold {

    /**
      * VII. ListFold
      *
      * Implement a function with type signature
      * `(List[A], B) => ((B, A) => B) => B`.
      *
      * The only requirements are that it must be possible for the return value
      * to be different from the third argument and that it "preserves" the
      * order of the passed list (whatever that means).
      */

    def listFold[A,B](as: List[A], b: B)(op: (B, A) => B): B = ???

  }

  object TailRecListFold {

    /**
      * VIII. TailRecListFold
      *
      * Reimplement `ListFold.liftFold` tail recursively if it is not already.
      */

    def listFold[A, B](as: List[A], b: B)(op: (B, A) => B): B = {

      // @tailrec
      // def helper

      ???
    }
  }

  object UseListFold {

    /**
      * IX. UseListFold
      *
      * Re-implement "SmallestTwo" and "SumsProds" using the tail recursive list
      * fold implementation.
      */

    import TailRecListFold._

    def smallestTwo(ints: List[Int]): (Int, Int) = ???

    def sumsProds(pairs: List[(Double, Double)]): (Double, Double, Double, Double) = ???

  }

  object TreeFold {

    /**
      * X. TreeMapReduce
      *
      * Implement a function with type signature
      * `(Tree[A], A => B, (B, B) => B) => B`.
      *
      * The only requirement is that it must "preserve" the order of the tree
      * leaves (whatever that means).
      */

    sealed trait Tree[+T]
    case class Leaf[+T](value: T) extends Tree[T]
    case class Branch[+T](left: Tree[T], right: Tree[T]) extends Tree[T]

    def treeFold[A, B](as: Tree[A], f: A => B, g: (B, B) => B): B = ???

  }

  object TailRecTreeFold {

    /**
      * XI. TailRecTreeFold
      *
      * Reimplement `TreeFold.treeFold` tail recursively if it is not already.
      */

    sealed trait Tree[+T]
    case class Leaf[+T](value: T) extends Tree[T]
    case class Branch[+T](left: Tree[T], right: Tree[T]) extends Tree[T]

    def treeFold[A, B](as: Tree[A], f: A => B, g: (B, B) => B): B = {

      // @tailrec
      // def helper

      ???
    }
  }

  object MethodTreeFold {

    /**
      * XII. MethodTreeFold
      *
      * Reimplement `TreeFold.treeFold` so that it is a method of `Tree[T]`
      * rather than a top-level function.
      */

    sealed trait Tree[+A] {
      def fold[B](f: A => B, g: (B, B) => B): B
    }

    case class Leaf[+A](value: A) extends Tree[A] {
      def fold[B](f: A => B, g: (B, B) => B): B = ???
    }

    case class Branch[+A](left: Tree[A], right: Tree[A]) extends Tree[A] {
      def fold[B](f: A => B, g: (B, B) => B): B = ???
    }
  }
}
