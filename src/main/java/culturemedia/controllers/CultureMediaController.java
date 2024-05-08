package culturemedia.controllers;

import java.util.List;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CultureMediaService;

public class CultureMediaController {

    private final CultureMediaServiceImpl cultureMediaService;


    public CultureMediaController(CultureMediaServiceImpl cultureMediaService) {
        this.cultureMediaService = cultureMediaService;
    }


    public List<Video> find_allVideos() throws VideoNotFoundException {
        List<Video> videos = null;
        videos = cultureMediaService.findAll();
        return videos;
    }


}