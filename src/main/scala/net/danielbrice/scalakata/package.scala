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

    def smallestTwo(ints: List[Int]): (Int, Int) = {

      @tailrec
      def helper(acc: (Int, Int), rest: List[Int]): (Int, Int) =
        (acc, rest) match {
          case (_, Nil) => acc
          case ((fst, _), x::xs) if x < fst => helper((x, fst), xs)
          case ((fst, snd), x::xs) if x < snd => helper((fst, x), xs)
          case (_, _::xs) => helper(acc, xs)
        }

      helper((Int.MaxValue, Int.MaxValue), ints)
    }
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

    type R = Double

    def sumsProds(pairs: List[(R, R)]): (R, R, R, R) = {

      @tailrec
      def helper(acc: (R, R, R, R), rest: List[(R, R)]): (R, R, R, R) =
        (acc, rest) match {
          case (_, Nil) => acc
          case ((a, b, c, d), (x,y)::zs) => helper((a+x, b+y, c*x, d*y), zs)
        }

      helper((0,0,1,1), pairs)
    }
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

    case class Sayable(acc: String) extends (String => Sayable) with (() => String) {
      def apply(): String = acc
      def apply(str: String): Sayable = Sayable(acc + str)
    }

    def sayIt(str: String): Sayable = Sayable(str)
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

    def findLoop(start: ListNode): ListNode = {

      @tailrec
      def helper(seen: List[ListNode], current: ListNode): ListNode = {
        if (seen.contains(current)) current
        else helper(current::seen, current.next(()))
      }

      helper(Nil, start)
    }
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

    def max(tree: Tree[Int]): Int = tree match {
      case Leaf(n) => n
      case Branch(l, r) => math.max(max(l), max(r))
    }

    def min(tree: Tree[Int]): Int = tree match {
      case Leaf(n) => n
      case Branch(l, r) => math.min(min(l), min(r))
    }

    def validateTree(tree: Tree[Int]): Boolean = tree match {
      case Leaf(_) => true
      case Branch(l, r) => (max(l) < min(r)) && validateTree(l) && validateTree(r)
    }
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

    def pathfinding(start: GraphNode, end: GraphNode): List[GraphNode] = {

      def embrace(paths: List[List[GraphNode]]): List[List[GraphNode]] =
        paths.filter(_.head == end)

      def extend(paths: List[List[GraphNode]]): List[List[GraphNode]] =
        paths.flatMap(path => path.head.neighbors(()).map(_::path))

      @tailrec
      def helper(paths: List[List[GraphNode]]): List[GraphNode] = {
        embrace(paths) match {
          case path::_ => path
          case Nil => helper(extend(paths))
        }
      }

      helper(List(List(start))).reverse
    }
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

    @tailrec
    def listFold[A,B](as: List[A], b: B)(op: (B, A) => B): B = as match {
      case Nil => b
      case x::xs => listFold(xs, op(b, x))(op)
    }
  }

  object TailRecListFold {

    /**
      * VIII. TailRecListFold
      *
      * Reimplement `ListFold.liftFold` tail recursively if it is not already.
      */

    def listFold[A, B](as: List[A], b: B)(op: (B, A) => B): B = {

      @tailrec
      def helper(acc: B, rest: List[A]): B =
        rest match {
          case Nil => acc
          case x::xs => helper(op(acc, x), xs)
        }

      helper(b, as)
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

    def smallestTwo(ints: List[Int]): (Int, Int) =
      listFold(ints, (Int.MaxValue, Int.MaxValue)) {
        case ((fst, _), next) if next < fst => (next, fst)
        case ((fst, snd), next) if next < snd => (fst, next)
        case (acc,_) => acc
      }

    type R = Double

    def sumsProds(pairs: List[(R, R)]): (R, R, R, R) =
      listFold(pairs, (0.0, 0.0, 1.0, 1.0)) {
        case ((a, b, c, d), (x, y)) => (a+x, b+y, c*x, d*y)
      }
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

    def treeFold[A, B](as: Tree[A], f: A => B, g: (B, B) => B): B =
      as match {
        case Leaf(v) => f(v)
        case Branch(l, r) => g(treeFold(l, f, g), treeFold(r, f, g))
      }
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

      @tailrec
      def helper(stack: List[Tree[A]], acc: Option[B]): B =
        (stack, acc) match {
          case (Nil, Some(b)) => b
          case (Leaf(a)::rest, None) => helper(rest, Some(f(a)))
          case (Leaf(a)::rest, Some(b)) => helper(rest, Some(g(f(a), b)))
          case (Branch(l, r)::rest, _) => helper(r::l::rest, acc)
        }

      helper(List(as), None)
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
      def fold[B](f: A => B, g: (B, B) => B): B = f(value)
    }

    case class Branch[+A](left: Tree[A], right: Tree[A]) extends Tree[A] {
      def fold[B](f: A => B, g: (B, B) => B): B =
        g(left.fold(f, g), right.fold(f, g))
    }
  }
}
