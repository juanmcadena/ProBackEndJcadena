package culturemedia.exception;

import java.text.MessageFormat;

public class DurationNotValidException extends CulturemediaException{
    public DurationNotValidException (Double fromDuration, Double toDuration){
        super(MessageFormat.format("Duration no valid for video: {0} and duration {1}", fromDuration, toDuration));
    }
}
