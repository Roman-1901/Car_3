public class NotDriveLicense extends Exception{
    public NotDriveLicense(String message) {
        throw new IllegalArgumentException(message);
    }
}
