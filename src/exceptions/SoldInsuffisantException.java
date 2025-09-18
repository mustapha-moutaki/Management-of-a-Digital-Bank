package exceptions;

public class SoldInsuffisantException extends  RuntimeException{

    public SoldInsuffisantException(String message) {
        super(message);
    }
}
