/**
 * Copyright (C) 2009-2014 Typesafe Inc. <http://www.typesafe.com>
 */
package akka.stream.scaladsl2

import akka.stream.scaladsl2
import akka.stream.FlattenStrategy

object FlattenStrategy {

  /**
   * Strategy that flattens a stream of streams by concatenating them. This means taking an incoming stream
   * emitting its elements directly to the output until it completes and then taking the next stream. This has the
   * consequence that if one of the input stream is infinite, no other streams after that will be consumed from.
   */
  def concat[T]: FlattenStrategy[scaladsl2.Source[T], T] = Concat[T]()

  private[akka] case class Concat[T]() extends FlattenStrategy[scaladsl2.Source[T], T]
}
