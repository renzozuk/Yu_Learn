package br.ufrn.imd.learningplatform.media.controllers;

import br.ufrn.imd.learningplatform.media.model.dto.VideoLessonDTO;
import br.ufrn.imd.learningplatform.media.services.VideoLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api/videolessons", "/api/video-lessons", "/api/video_lessons"})
public class VideoLessonController {

    @Autowired
    private VideoLessonService videoLessonService;

    @GetMapping
    public ResponseEntity<List<VideoLessonDTO>> getAllVideoLessons() {
        return new ResponseEntity<>(videoLessonService.getAllVideoLessons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoLessonDTO> getVideoLessonById(@PathVariable String id) {
        return new ResponseEntity<>(videoLessonService.getVideoLessonById(id), HttpStatus.OK);
    }

    @PostMapping("/{moduleId}")
    public ResponseEntity<VideoLessonDTO> createVideoLesson(@PathVariable String moduleId, @RequestBody VideoLessonDTO videoLessonDTO) {
        return new ResponseEntity<>(videoLessonService.createVideoLesson(moduleId, videoLessonDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VideoLessonDTO> updateVideoLesson(@RequestBody VideoLessonDTO videoLessonDTO, @PathVariable String id) {
        return new ResponseEntity<>(videoLessonService.updateVideoLesson(videoLessonDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VideoLessonDTO> deleteVideoLesson(@PathVariable String id) {
        videoLessonService.deleteVideoLesson(id);
        return ResponseEntity.noContent().build();
    }
}
