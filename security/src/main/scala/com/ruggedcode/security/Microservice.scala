package com.ruggedcode.security

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory

object Microservice extends App with Routes {
  override implicit val system = ActorSystem()
  override implicit val executor = system.dispatcher
  override implicit val materializer = ActorMaterializer()

  implicit class RichConfig(val underlying: Config) extends AnyVal {
    def getOptionalString(path: String): Option[String] = if (underlying.hasPath(path)) {
      Some(underlying.getString(path))
    } else {
      None
    }
  }

  override val config = ConfigFactory.load()
  override val logger = Logging(system, getClass)

  logger.info(s"Version microservice starting on http://${config.getString("http.interface")}:${config.getInt("http.port")}")
  Http().bindAndHandle(routes, config.getString("http.interface"), config.getInt("http.port"))
}
