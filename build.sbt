name := "wordcount streaming"

version := "1.0"

scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
                      "org.apache.spark" %% "spark-core" % "1.2.1",
                      "org.apache.spark" %% "spark-streaming" % "1.2.1",
                      "org.apache.spark" %% "spark-streaming-twitter" % "1.2.1"
                    )
