package nu.oskarsson.sorrybutton;

import com.mashape.unirest.http.Unirest;
import nu.oskarsson.sorrybutton.config.Configuration;
import nu.oskarsson.sorrybutton.pagerduty.Pagerduty;
import nu.oskarsson.sorrybutton.pagerduty.PagerdutyException;
import nu.oskarsson.sorrybutton.postmates.Postmates;
import nu.oskarsson.sorrybutton.postmates.PostmatesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class SorryButton {
  private static final Logger logger = LogManager.getLogger(SorryButton.class);

  public static void main(String[] args) {
    Configuration config = new Configuration("sorrybutton.yaml");

    Pagerduty pagerduty = new Pagerduty(config.getPagerDutyInstance(), config.getPagerDutyApiToken());
    Postmates postmates = new Postmates(config.getPostmatesApiKey());

    try {
      String name = pagerduty.getNameOfOnCall(config.getPagerDutyPolicyId());
      logger.info("Name of oncall is {}", name);

      postmates.deliver(config.createPostmatesDelivery(name));

      Unirest.shutdown();
    } catch (PagerdutyException e) {
      logger.error(e);
    } catch (PostmatesException e) {
      logger.error(e);
    } catch (IOException e) {
      logger.error(e);
    }
  }
}
