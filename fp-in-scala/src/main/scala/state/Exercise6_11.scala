package main.scala.state

import Exercise6_10._

object Exercise6_11 {
  sealed trait Input
  case object Coin extends Input
  case object Turn extends Input

  case class Machine(locked: Boolean, candies: Int, coins: Int)

  def simulateMachine(inputs: List[Input]): State[(Int, Int), Machine] = inputs.foldRight[State[(Int, Int), Machine]](State(machine => ((machine.coins, machine.candies), machine))) { case (input, acc) =>
    State { machine =>
      val ((coins, candies), nextMachine) = acc.run(machine)
      input match {
        case Coin if nextMachine.locked && candies > 0 => ((coins + 1, candies), Machine(locked = false, candies = candies, coins = coins + 1))
        case Turn if !nextMachine.locked && candies > 0 => ((coins, candies - 1), Machine(locked = true, candies = candies - 1, coins = coins))
        case _ => ((coins, candies), nextMachine)
      }
    }
  }
}