name := "data-filtrator"

version := "0.0.1"

scalaVersion := "2.13.6"

lazy val logbackVersion          = "1.2.3"
lazy val scalaLoggingVersion     = "3.9.3"
lazy val configVersion           = "1.4.1"
lazy val json4sVersion           = "4.0.0"

libraryDependencies ++= Seq(
  "com.typesafe"                   %  "config"          % configVersion,
  "ch.qos.logback"                 %  "logback-classic" % logbackVersion,
  "com.typesafe.scala-logging"     %% "scala-logging"   % scalaLoggingVersion,
  "org.json4s"                     %% "json4s-jackson"  % json4sVersion
)

enablePlugins(JavaAppPackaging)