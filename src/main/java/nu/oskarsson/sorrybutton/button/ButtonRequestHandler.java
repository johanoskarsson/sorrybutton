package nu.oskarsson.sorrybutton.button;

import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.Context;

public class ButtonRequestHandler implements RequestHandler<ButtonRequest, ButtonResponse> {
  public ButtonResponse handleRequest(ButtonRequest request, Context context) {
    return new ButtonResponse();
  }
}