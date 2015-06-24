addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "3.0.0" )
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.6.0")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.0.4")


resolvers += "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/"
resolvers += "sonatype-releases" at "https://oss.sonatype.org/content/repositories/releases/"
resolvers += Classpaths.sbtPluginReleases


