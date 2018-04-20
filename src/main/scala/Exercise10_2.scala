package main.scala

object Exercise10_1 {
  trait Monoid[A] {
    def combine(a: A, b: A): A
    def empty: A
  }

  def endoMonoid[A] = new Monoid[A => A] {
    override def combine(a: A => A, b: A => A): A => A = ((x: A) => b(a(x)))
    override def empty: A => A = ((x: A) => x)
  }

  def endoMonoid[A] = new Monoid[A => A] {
    override def combine(a: A => A, b: A => A): A => A = ((x: A) => a(b(x)))
    override def empty: A => A = ((x: A) => x)
  }

  // empty: A => A = x => x
  // combine1(f, g) = x => f(g(x))
  // combine2(f, g) = x => g(f(x))


  // 1 - right unit
  // combine1(f, identity)
  // = x => f(identity(x))
  // = x => f(x)
  // = f

  // 1 - left unit
  // combine1(identity, g)
  // = x => identity(g(x))
  // = x => g(x)
  // = g

  // 1 - assoc, forall f, g, h: A => A,
  // combine1(combine1(f, g), h))
  // = x => combine1(f, g)(h(x))
  // = x => (y => f(g(y)))(h(x))
  // = x => f(g(h(x))),
  // combine1(f, combine1(g, h))
  // = combine(f, x => g(h(x)))
  // = y => f((x => g(h(x)))(y))
  // = y => f(g(h(y)))

  // f, g: A => A, f == g <=> forall x: A, f(x) == g(x)
}

