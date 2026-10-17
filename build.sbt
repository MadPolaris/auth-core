ThisBuild / organization := "net.imadz"
ThisBuild / organizationName := "MadPolaris"
ThisBuild / organizationHomepage := Some(url("https://github.com/MadPolaris"))
ThisBuild / scalaVersion := "2.13.14"
ThisBuild / version := "0.1.0"
ThisBuild / versionScheme := Some("early-semver")

licenses := List("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

val akkaVersion = "2.6.20"

resolvers ++= Seq(
  "Aliyun" at "https://maven.aliyun.com/repository/public/",
  "Huawei" at "https://repo.huaweicloud.com/repository/maven/"
)

Compile / scalacOptions ++= Seq("-target:11", "-deprecation", "-feature", "-unchecked", "-Xlint")
Compile / javacOptions ++= Seq("--release", "11")

dependencyOverrides ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "org.reactivemongo" %% "reactivemongo" % "1.1.0-noshaded-RC11",
  "com.typesafe.play" %% "play-json" % "2.9.3",
  "org.slf4j" % "slf4j-api" % "2.0.4",
  "org.scalatest" %% "scalatest" % "3.2.15" % Test,
  "ch.qos.logback" % "logback-classic" % "1.4.5" % Test
)

// Auth — role-based authorization DSL: Endpoint DSL, ApiError, TokenService,
// RoleGate/AuthAction, password hashing, login rate limiting, identity codecs.
// Note: per-module generated stubs (CommandRoleMap / ViewKeys) stay in the target
// project — they are NOT part of this library.
name := "auth-core"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play-json" % "2.9.3",
  "com.typesafe.play" %% "play" % "2.8.20",
  "com.github.jwt-scala" %% "jwt-play" % "9.1.2",
  "com.github.ben-manes.caffeine" % "caffeine" % "3.1.8",
  "org.mongodb.scala" %% "mongo-scala-driver" % "4.11.0",
  "javax.inject" % "javax.inject" % "1",
  "com.google.inject" % "guice" % "5.1.0"
)
