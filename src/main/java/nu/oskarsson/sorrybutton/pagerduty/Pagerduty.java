package nu.oskarsson.sorrybutton.pagerduty;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

public class Pagerduty {

  private static final Logger logger = LogManager.getLogger(Pagerduty.class);

  private String pagerdutyInstance;
  private String apiToken;

  public Pagerduty(String pagerdutyInstance, String apiToken) {
    this.pagerdutyInstance = pagerdutyInstance;
    this.apiToken = apiToken;

    Unirest.setObjectMapper(new ObjectMapper() {
      private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
        = new com.fasterxml.jackson.databind.ObjectMapper();

      public <T> T readValue(String value, Class<T> valueType) {
        try {
          return jacksonObjectMapper.readValue(value, valueType);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }

      public String writeValue(Object value) {
        try {
          return jacksonObjectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
          throw new RuntimeException(e);
        }
      }
    });
  }

  public String getNameOfOnCall(String policyId) throws PagerdutyException {
    logger.info("Fetching name of oncall for policy {}", policyId);
    try {
      EscalationPolicyResponse escalationPolicyResponse =
        Unirest.get("https://" + pagerdutyInstance + ".pagerduty.com/api/v1/escalation_policies/" + policyId)
          .header("accept", "application/json")
          .header("Authorization", "Token token=" + apiToken)
          .asObject(EscalationPolicyResponse.class)
          .getBody();

      // TODO make more robust
      EscalationPolicy escalationPolicy = escalationPolicyResponse.getEscalationPolicy();
      EscalationRule[] rules = escalationPolicy.getEscalationRules();
      Target[] targets = rules[0].getTargets();
      return targets[0].getName();

    } catch (UnirestException e) {
      throw new PagerdutyException(e);
    }
  }

}
