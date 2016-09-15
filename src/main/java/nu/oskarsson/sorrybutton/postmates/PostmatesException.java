package nu.oskarsson.sorrybutton.postmates;

public class PostmatesException extends RuntimeException {

  public PostmatesException(Throwable cause) {
    super(cause);
  }

  public PostmatesException(String message) {
    super(message);
  }
}
