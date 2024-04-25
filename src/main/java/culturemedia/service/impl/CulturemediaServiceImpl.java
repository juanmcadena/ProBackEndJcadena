package culturemedia.service.impl;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.CulturemediaService;

import java.util.List;

public class CulturemediaServiceImpl implements CulturemediaService {

    private VideoRepository videoRepository;
    private ViewsRepository viewRepository;


    public CulturemediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;

    }

    @Override
    public List<Video> findAllVideo() throws VideoNotFoundException  {
        List<Video> videos = this.videoRepository.findAll();
        if (videos.isEmpty()){
            throw new VideoNotFoundException();
        }
                return videos;
    }
    @Override
    public Video save(Video video) {
        this.videoRepository.save(video);
        return video;
    }

    @Override
    public View save(View view) {
        this.viewRepository.save(view);
        return view;
    }
}
