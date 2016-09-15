package nu.oskarsson.sorrybutton;

import com.mashape.unirest.http.Unirest;
import nu.oskarsson.sorrybutton.button.ButtonResponse;
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

  public ButtonResponse execute() throws PostmatesException, PagerdutyException {
    Configuration config = new Configuration("sorrybutton.yaml");

    Pagerduty pagerduty = new Pagerduty(config.getPagerDutyInstance(), config.getPagerDutyApiToken());
    Postmates postmates = new Postmates(config.getPostmatesApiKey());

    String name = pagerduty.getNameOfOnCall(config.getPagerDutyPolicyId());
    logger.info("Name of oncall is {}", name);

    String status = postmates.deliver(config.createPostmatesDelivery(name));

    //Unirest.shutdown();

    return new ButtonResponse(name, status);
  }

  public static void main(String[] args) {
    try {
      new SorryButton().execute();
    } catch (PagerdutyException e) {
      logger.error(e);
    } catch (PostmatesException e) {
      logger.error(e);
    }
  }
}
