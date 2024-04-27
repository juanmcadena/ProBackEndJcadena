package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends CulturemediaException{
    public VideoNotFoundException(){
        super(("Video not Found in list"));
    }//TODO Actualizar mensaje
    public VideoNotFoundException(String title){
        super(MessageFormat.format("Video not found with this tile: {0}", title));
    }
}
