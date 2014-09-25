package org.wildfly.extras.jmxconsole.test;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.PomEquippedResolveStage;

import java.io.File;

public class Deployments {

   public static WebArchive jmxConsoleDeployment() {
      PomEquippedResolveStage mavenResolver = Maven.resolver().loadPomFromFile(new File("pom.xml"));

      return ShrinkWrap.create(ZipImporter.class, "test.war").importFrom(mavenResolver.resolve("org.wildfly.extras" +
            ".jmx-console:jmx-console:war:1.0.0-SNAPSHOT").withoutTransitivity().asSingleFile())
            .as(WebArchive.class);
   }

}