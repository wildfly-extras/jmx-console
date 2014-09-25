package org.wildfly.extras.jmxconsole.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import java.lang.invoke.MethodHandles;
import java.net.URI;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class SecurityTest {

   private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass().toString());

   @ArquillianResource
   private URI webAppAddress;

   @Deployment(testable = false)
   public static WebArchive deploy() {
      WebArchive archive = Deployments.jmxConsoleDeployment();
      logger.fine("Deploying archive: " + archive.toString(true));
      return archive;
   }

   @Test
   public void shouldHaveSecuredConsole() throws Exception {
      //given
      Invocation.Builder request = ClientBuilder.newClient().target(webAppAddress).request();

      //when
      Response response = request.get();

      //then
      assertEquals(401, response.getStatus());
   }
}
