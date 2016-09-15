package nu.oskarsson.sorrybutton.config;

import nu.oskarsson.sorrybutton.postmates.Delivery;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class Configuration {

  private Map config;

  public Configuration(String resource) {
    InputStream in = Configuration.class.getClassLoader().getResourceAsStream(resource);

    Yaml yaml = new Yaml();
    config = (Map) yaml.load(in);
  }

  public String getPagerDutyInstance() {
    return get("pagerduty").get("instance");
  }

  public String getPagerDutyApiToken() {
    return get("pagerduty").get("apitoken");
  }

  public String getPagerDutyPolicyId() {
    return get("pagerduty").get("policyid");
  }

  public String getPostmatesApiKey() {
    return get("postmates").get("apikey");
  }

  public Delivery createPostmatesDelivery(String name) {
    Map<String, String> postmatesConfig = get("postmates");

    Delivery delivery = new Delivery();
    delivery.setCustomerId(postmatesConfig.get("customer_id"));
    delivery.setManifest(postmatesConfig.get("manifest"));
    delivery.setPickupName(postmatesConfig.get("pickup_name"));
    delivery.setPickupAddress(postmatesConfig.get("pickup_address"));
    delivery.setPickupPhoneNumber(postmatesConfig.get("pickup_phone_number"));
    delivery.setPickupBusinessName(postmatesConfig.get("pickup_business_name"));
    delivery.setDropoffAddress(postmatesConfig.get("dropoff_address"));
    delivery.setDropoffPhoneNumber(postmatesConfig.get("dropoff_phone_number"));
    delivery.setDropoffBusinessName(postmatesConfig.get("dropoff_business_name"));
    delivery.setDropoffName(name);

    return delivery;
  }

  private Map<String, String> get(String key) {
    return (Map<String, String>) config.get(key);
  }

}
