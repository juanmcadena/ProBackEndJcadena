package culturemedia.service;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.impl.CulturemediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CulturemediaServiceTest {
    private CulturemediaService culturemediaService;

    @BeforeEach
    void init() {
        VideoRepository videoRepository = new VideoRepositoryImpl();
        ViewsRepository viewsRepository = new ViewsRepositoryImpl();

        culturemediaService = new CulturemediaServiceImpl(videoRepository, viewsRepository);
    }
    private void createVideos() throws VideoNotFoundException {
        List<Video> videos = List.of(new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic", "----", 5.7),
                new Video("06", "Clic", "----", 5.1));


        for (Video video : videos) {
            culturemediaService.save(video);
        }
    }
    @Test

    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException{
        createVideos();
        List<Video> videos = culturemediaService.findAllVideo();
        assertEquals(6, videos.size());
    }

    @Test
    void exceptionsTesting() {
                VideoNotFoundException thrown = assertThrows(VideoNotFoundException.class, ()-> culturemediaService.findAllVideo());
    }



}


