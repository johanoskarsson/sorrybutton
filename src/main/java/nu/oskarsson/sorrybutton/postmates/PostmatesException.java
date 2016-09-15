package nu.oskarsson.sorrybutton.postmates;

public class PostmatesException extends Exception {

  public PostmatesException(Throwable cause) {
    super(cause);
  }

  public PostmatesException(String message) {
    super(message);
  }
}
