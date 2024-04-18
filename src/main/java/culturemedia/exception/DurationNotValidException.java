package culturemedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CulturemediaException{
    public DurationNotValidException (String title, Double duration){
        super(MessageFormat.format("Duration no valid for video: {0} and duration {1}", title, duration));
    }
}
