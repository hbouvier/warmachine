package com.ruggedcode.security

import akka.actor.ActorSystem
import akka.event.LoggingAdapter
import akka.stream.Materializer
import com.typesafe.config.Config
import scala.concurrent.{ExecutionContextExecutor, Future}

trait API extends Protocols {
  implicit val system: ActorSystem
  implicit def executor: ExecutionContextExecutor
  implicit val materializer: Materializer

  def config: Config
  val logger: LoggingAdapter

  def authenticate(name: String): Future[Either[String, User]] = {
    Future.successful(Right(User(name)))
  }
}
