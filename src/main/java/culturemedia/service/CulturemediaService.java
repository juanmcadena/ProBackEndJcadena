package culturemedia.service;

import culturemedia.exception.DurationNotValidException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CulturemediaService {


    List<Video> findAllVideo() throws VideoNotFoundException;

    Video save (Video video);

    View save (View view);


    List<Video> findAllVideo(String title) throws VideoNotFoundException;

    List<Video> findAllVideo(Double duration) throws  VideoNotFoundException;

    List<Video> findAllVideo(Double fromDuration, Double toDuration) throws DurationNotValidException;

}
