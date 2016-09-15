package nu.oskarsson.sorrybutton.pagerduty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "escalation_delay_in_minutes", "rule_object" })
public class EscalationRule {

  private String id;
  private Target[] targets;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Target[] getTargets() {
    return targets;
  }

  public void setTargets(Target[] targets) {
    this.targets = targets;
  }
}
