package io.liquirium.util.store

import io.liquirium.core.Candle

import java.time.{Duration, Instant}
import scala.concurrent.Future

trait CandleStore {

  def candleLength: Duration

  def add(candles: Iterable[Candle]): Future[Unit]

  def get(from: Option[Instant] = None, until: Option[Instant] = None): Future[Iterable[Candle]]

  def clear(): Unit

  def deleteFrom(start: Instant): Future[Unit]

}
