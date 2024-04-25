package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CulturemediaService {


    List<Video> findAllVideo() throws VideoNotFoundException;

    Video save (Video video);

    View save (View view);


}
