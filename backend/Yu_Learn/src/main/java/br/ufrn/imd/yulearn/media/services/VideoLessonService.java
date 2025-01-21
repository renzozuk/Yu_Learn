package br.ufrn.imd.yulearn.media.services;

import br.ufrn.imd.yulearn.mapper.Mapper;
import br.ufrn.imd.yulearn.media.model.dto.VideoLessonDTO;
import br.ufrn.imd.yulearn.media.model.entities.VideoLesson;
import br.ufrn.imd.yulearn.media.repositories.LessonRepository;
import br.ufrn.imd.yulearn.media.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoLessonService {

    private final LessonRepository lessonRepository;
    private final ModuleRepository moduleRepository;
    private final Mapper mapper;

    @Autowired
    public VideoLessonService(LessonRepository lessonRepository, ModuleRepository moduleRepository, Mapper mapper) {
        this.lessonRepository = lessonRepository;
        this.moduleRepository = moduleRepository;
        this.mapper = mapper;
    }

    public List<VideoLessonDTO> getAllVideoLessons() {
        return mapper.convertList(lessonRepository.findAll().stream().filter(lesson -> lesson instanceof VideoLesson).toList(), VideoLessonDTO.class);
    }

    public VideoLessonDTO getVideoLessonById(String id) {

        var lesson = lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found."));

        if (!(lesson instanceof VideoLesson)) {
            throw new RuntimeException("Lesson found is not a VideoLesson.");
        }

        var videoLesson = (VideoLesson) lesson;

        return mapper.convertValue(videoLesson, VideoLessonDTO.class);
    }

    public VideoLessonDTO createVideoLesson(String moduleId, VideoLessonDTO videoLessonDTO) {

        var module = moduleRepository.findById(moduleId).orElseThrow(() -> new RuntimeException("Module not found."));

        var videoLesson = mapper.convertValue(videoLessonDTO, VideoLesson.class);
        videoLesson.setModule(module);

        var createdVideoLesson = lessonRepository.save(videoLesson);

        module.getLessons().add(createdVideoLesson);
        moduleRepository.save(module);

        return mapper.convertValue(createdVideoLesson, VideoLessonDTO.class);
    }

    public VideoLessonDTO updateVideoLesson(VideoLessonDTO videoLessonDTO, String id) {

        var lesson = lessonRepository.findById(id).orElseThrow(() -> new RuntimeException("Lesson not found."));

        if (!(lesson instanceof VideoLesson)) {
            throw new RuntimeException("Lesson found is not a VideoLesson.");
        }

        var videoLesson = (VideoLesson) lesson;

        videoLesson.setTitle(videoLessonDTO.getTitle());
        videoLesson.setDescription(videoLessonDTO.getDescription());
        videoLesson.setThumbnailUrl(videoLessonDTO.getThumbnailUrl());
        videoLesson.setCategories(videoLessonDTO.getCategories());
        videoLesson.setVideoUrl(videoLessonDTO.getVideoUrl());

        var updatedVideoLesson = lessonRepository.save(videoLesson);

        return mapper.convertValue(updatedVideoLesson, VideoLessonDTO.class);
    }

    public void deleteVideoLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
