package main.scala.state

object Exercise6_10 {
  case class State[+A, S](run: S => (A, S)) {
    def map[B](f: A => B): State[B, S] = State { s =>
      val (a, nextS) = run(s)
      (f(a), nextS)
    }
    def map2[B, C](bs: State[B, S])(f: (A, B) => C): State[C, S] = State { s =>
      val (a, s1) = this.run(s)
      val (b, s2) = bs.run(s1)
      (f(a, b), s2)
    }
    def flatMap[B](f: A => State[B, S]): State[B, S] = State { s =>
      val (a, nextS) = run(s)
      f(a).run(nextS)
    }
  }
  object State {
    def unit[A, S](a: A): State[A, S] = State(s => (a, s))
    def sequence[A, S](states: List[State[A, S]]): State[List[A], S] = states.foldRight(unit[List[A], S](List.empty[A])) { (state, acc) =>
      state.map2(acc)(_ :: _)
    }
  }
}