package nu.oskarsson.sorrybutton.button;

public class ButtonResponse {

  private String onCallName;
  private String status;

  public ButtonResponse(String onCallName, String status) {
    this.onCallName = onCallName;
    this.status = status;
  }

  public ButtonResponse() {
  }

  public String getOnCallName() {
    return onCallName;
  }

  public void setOnCallName(String onCallName) {
    this.onCallName = onCallName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
