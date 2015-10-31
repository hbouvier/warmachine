import NativePackagerKeys._
import ruggedcode._

enablePlugins(JavaAppPackaging)

lazy val security = (project in file("security"))
  .settings(Seq(
    name := "security"
  ))
  .settings(Common.settings: _*)
  .settings(Seq(
    libraryDependencies ++= Dependencies.commonDependencies
  ))

lazy val warmachine = (project in file("warmachine"))
  .settings(Seq(
    name := "warmachine"
  ))
  .settings(Common.settings: _*)
  .settings(Seq(
    libraryDependencies ++= Dependencies.commonDependencies
  ))
  .dependsOn(security)
