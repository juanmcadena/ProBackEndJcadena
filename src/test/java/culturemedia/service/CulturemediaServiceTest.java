package culturemedia.service;

import culturemedia.exception.DurationNotValidException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.repository.impl.VideoRepositoryImpl;
import culturemedia.repository.impl.ViewsRepositoryImpl;
import culturemedia.service.impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class CulturemediaServiceTest {
    private CultureMediaService culturemediaService;
    private VideoRepository videoRepository = Mockito.mock();
    @BeforeEach
    void init() {
        VideoRepository videoRepository = new VideoRepositoryImpl();
        ViewsRepository viewsRepository = new ViewsRepositoryImpl();

        culturemediaService = new CultureMediaServiceImpl(videoRepository, viewsRepository);
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

@Test
    void when_FindAll_By_Title_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        var videos = new Video ("01", "juan", "Horror", 4.6);
        culturemediaService.save(videos);

        assertThrows(VideoNotFoundException.class, ()-> culturemediaService.findAllVideo("juanC"));
    }

    @Test
    void when_FindAll_By_Durations_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() throws VideoNotFoundException{
        var videos = new Video ("01", "juan", "Horror", 4.6);
        culturemediaService.save(videos);
        assertThrows(DurationNotValidException.class, ()-> culturemediaService.findAllVideo( 4.7, 5.0));
    }

    @Test
    void  when_findAll_all_video_returned_succesfully() throws VideoNotFoundException{
        createVideos();
        List<Video> videos = culturemediaService.findAllVideo();
        doReturn(videos).when(videoRepository).findAll();
        assertEquals(6, videos.size());
    }

    @Test
    void when_find_by_title_should_return_match_video() throws VideoNotFoundException{
        createVideos();
        List<Video> videos = culturemediaService.findAllVideo();
        doReturn(videos).when(videoRepository).find("Título 2");

    }


}


