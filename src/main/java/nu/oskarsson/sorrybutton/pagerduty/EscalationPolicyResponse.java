package nu.oskarsson.sorrybutton.pagerduty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EscalationPolicyResponse {

  @JsonProperty("escalation_policy")
  private EscalationPolicy escalationPolicy;

  public EscalationPolicy getEscalationPolicy() {
    return escalationPolicy;
  }

  public void setEscalationPolicy(EscalationPolicy escalationPolicy) {
    this.escalationPolicy = escalationPolicy;
  }
}
