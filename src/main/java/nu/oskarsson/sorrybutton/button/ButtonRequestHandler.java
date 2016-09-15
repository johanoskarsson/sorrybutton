package nu.oskarsson.sorrybutton.button;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;
import nu.oskarsson.sorrybutton.SorryButton;
import nu.oskarsson.sorrybutton.pagerduty.PagerdutyException;
import nu.oskarsson.sorrybutton.postmates.PostmatesException;

import java.io.IOException;

public class ButtonRequestHandler implements RequestHandler<ButtonRequest, ButtonResponse> {
  public ButtonResponse handleRequest(ButtonRequest request, Context context) {
    SorryButton button = new SorryButton();
    return button.execute();
  }
}