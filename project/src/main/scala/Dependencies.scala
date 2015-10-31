package ruggedcode

import sbt._
import Keys._

object Dependencies {

  val commonDependencies: Seq[ModuleID] = Seq(
    // Akka Core
     "com.typesafe.akka" %% "akka-actor"   % Common.Akka.version
    ,"com.typesafe.akka" %% "akka-testkit" % Common.Akka.version

    // akka http
    ,"com.typesafe.akka" %% "akka-http-experimental"            % Common.Akka.streamVersion
    ,"com.typesafe.akka" %% "akka-http-spray-json-experimental" % Common.Akka.streamVersion
  )
/*
  val couchdbDependencies: Seq[ModuleID] = Seq(
    // Couchdb
    "com.ibm" %% "couchdb-scala" % couchdbVersion
  )
testOptions += Tests.Argument(TestFrameworks.JUnit, "-v")
*/

}