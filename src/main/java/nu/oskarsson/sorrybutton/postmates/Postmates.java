package nu.oskarsson.sorrybutton.postmates;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.http.utils.Base64Coder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Postmates {

  private static final Logger logger = LogManager.getLogger(Postmates.class);

  private String apiKey;

  public Postmates(String apiKey) {
    this.apiKey = apiKey;
  }

  public void deliver(Delivery delivery) throws PostmatesException {
    logger.info("Scheduling delivery for {}", delivery);
    try {
      HttpResponse<JsonNode> response =
        Unirest.post("https://api.postmates.com/v1/customers/" + delivery.getCustomerId() + "/deliveries")
          .basicAuth(apiKey, "")
          .header("accept", "application/json")
          .fields(createQuery(delivery))
          .asJson();

      if (response.getStatus() != 200) {
        throw new PostmatesException(response.getStatusText());
      }

      JsonNode json = response.getBody();

      String status = json.getObject().getString("status");
      logger.info("Delivery status {}", status);
    } catch (UnirestException e) {
      throw new PostmatesException(e);
    }

  }

  private Map<String, Object> createQuery(Delivery delivery) {
    Map<String, Object> query = new HashMap<String, Object>();
    addIfNotNull(query, "manifest", delivery.getManifest());
    addIfNotNull(query, "pickup_name", delivery.getPickupName());
    addIfNotNull(query, "pickup_address", delivery.getPickupAddress());
    addIfNotNull(query, "pickup_phone_number", delivery.getPickupPhoneNumber());
    addIfNotNull(query, "pickup_business_name", delivery.getPickupBusinessName());
    addIfNotNull(query, "dropoff_name", delivery.getDropoffName());
    addIfNotNull(query, "dropoff_address", delivery.getDropoffAddress());
    addIfNotNull(query, "dropoff_phone_number", delivery.getDropoffPhoneNumber());
    addIfNotNull(query, "dropoff_business_name", delivery.getDropoffBusinessName());
    return query;
  }

  // TODO i assume this is a helper method already somewhere
  private void addIfNotNull(Map<String, Object> query, String key, String value) {
    if (value == null || value.isEmpty()) {
      return;
    }

    query.put(key, value);
  }

}
