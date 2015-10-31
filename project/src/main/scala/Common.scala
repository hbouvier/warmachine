package ruggedcode

import sbt._
import Keys._

object Common {
  object Scala {
    lazy val version = "2.11.7"
  }

  object Akka {
    lazy val version       = "2.3.14"
    lazy val streamVersion = "1.0"
  }

  object Warmachine {
    // from: ../version.sbt
    lazy val buildVersion = (version in ThisBuild)
  }

  val settings: Seq[Def.Setting[_]] = Seq(
     version := Warmachine.buildVersion.value
    ,scalaVersion := Scala.version
  )
}