name := """cic-room-api"""
organization := "br.unb.tp1"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.3"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies ++= Seq(
  filters,
  "org.postgresql" % "postgresql" % "9.4.1208"
)
libraryDependencies += "com.typesafe.play" %% "play-slick" %  "3.0.2"
libraryDependencies += "com.typesafe.play" %% "play-slick-evolutions" % "3.0.2"

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "br.unb.tp1.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "br.unb.tp1.binders._"
