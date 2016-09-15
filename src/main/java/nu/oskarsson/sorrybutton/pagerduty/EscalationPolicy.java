package nu.oskarsson.sorrybutton.pagerduty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({ "num_loops", "description", "services" })
public class EscalationPolicy {

  private String id;
  private String name;

  @JsonProperty("escalation_rules")
  private EscalationRule[] escalationRules;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EscalationRule[] getEscalationRules() {
    return escalationRules;
  }

  public void setEscalationRules(EscalationRule[] escalationRules) {
    this.escalationRules = escalationRules;
  }
}
