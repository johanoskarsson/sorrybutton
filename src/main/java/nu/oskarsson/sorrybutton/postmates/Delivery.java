package nu.oskarsson.sorrybutton.postmates;

/**
 * The data required for a delivery request.
 * See https://postmates.com/developer/docs/endpoints#create_delivery for more info
 */
public class Delivery {
  private String customerId;
  private String manifest;
  private String pickupName;
  private String pickupAddress;
  private String pickupPhoneNumber;
  private String pickupBusinessName;
  private String pickupNotes;
  private String dropoffName;
  private String dropoffAddress;
  private String dropoffPhoneNumber;
  private String dropoffBusinessName;
  private String dropoffNotes;

  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  public String getManifest() {
    return manifest;
  }

  public void setManifest(String manifest) {
    this.manifest = manifest;
  }

  public String getPickupName() {
    return pickupName;
  }

  public void setPickupName(String pickupName) {
    this.pickupName = pickupName;
  }

  public String getPickupAddress() {
    return pickupAddress;
  }

  public void setPickupAddress(String pickupAddress) {
    this.pickupAddress = pickupAddress;
  }

  public String getPickupPhoneNumber() {
    return pickupPhoneNumber;
  }

  public void setPickupPhoneNumber(String pickupPhoneNumber) {
    this.pickupPhoneNumber = pickupPhoneNumber;
  }

  public String getPickupBusinessName() {
    return pickupBusinessName;
  }

  public void setPickupBusinessName(String pickupBusinessName) {
    this.pickupBusinessName = pickupBusinessName;
  }

  public String getPickupNotes() {
    return pickupNotes;
  }

  public void setPickupNotes(String pickupNotes) {
    this.pickupNotes = pickupNotes;
  }

  public String getDropoffName() {
    return dropoffName;
  }

  public void setDropoffName(String dropoffName) {
    this.dropoffName = dropoffName;
  }

  public String getDropoffAddress() {
    return dropoffAddress;
  }

  public void setDropoffAddress(String dropoffAddress) {
    this.dropoffAddress = dropoffAddress;
  }

  public String getDropoffPhoneNumber() {
    return dropoffPhoneNumber;
  }

  public void setDropoffPhoneNumber(String dropoffPhoneNumber) {
    this.dropoffPhoneNumber = dropoffPhoneNumber;
  }

  public String getDropoffBusinessName() {
    return dropoffBusinessName;
  }

  public void setDropoffBusinessName(String dropoffBusinessName) {
    this.dropoffBusinessName = dropoffBusinessName;
  }

  public String getDropoffNotes() {
    return dropoffNotes;
  }

  public void setDropoffNotes(String dropoffNotes) {
    this.dropoffNotes = dropoffNotes;
  }

  @Override
  public String toString() {
    return "Delivery{" +
        "dropoffNotes='" + dropoffNotes + '\'' +
        ", customerId='" + customerId + '\'' +
        ", manifest='" + manifest + '\'' +
        ", pickupName='" + pickupName + '\'' +
        ", pickupAddress='" + pickupAddress + '\'' +
        ", pickupPhoneNumber='" + pickupPhoneNumber + '\'' +
        ", pickupBusinessName='" + pickupBusinessName + '\'' +
        ", pickupNotes='" + pickupNotes + '\'' +
        ", dropoffName='" + dropoffName + '\'' +
        ", dropoffAddress='" + dropoffAddress + '\'' +
        ", dropoffPhoneNumber='" + dropoffPhoneNumber + '\'' +
        ", dropoffBusinessName='" + dropoffBusinessName + '\'' +
        '}';
  }
}
