package br.ufrn.imd.learningplatform.media.controllers;

import br.ufrn.imd.learningplatform.media.model.dto.AnswerDTO;
import br.ufrn.imd.learningplatform.media.model.entities.Answer;
import br.ufrn.imd.learningplatform.media.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @GetMapping
    public ResponseEntity<List<AnswerDTO>> getAllAnswers() {
        return new ResponseEntity<>(answerService.getAllAnswers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerDTO> getAnswerById(@PathVariable String id) {
        return new ResponseEntity<>(answerService.getAnswerById(id), HttpStatus.OK);
    }

    @PostMapping("/{questionId}")
    public ResponseEntity<AnswerDTO> createAnswer(@PathVariable String questionId, @RequestBody AnswerDTO answerDTO) {
        return new ResponseEntity<>(answerService.createAnswer(questionId, answerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnswerDTO> updateAnswer(@RequestBody AnswerDTO answerDTO, @PathVariable String id) {
        return new ResponseEntity<>(answerService.updateAnswer(answerDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable String id) {
        answerService.deleteAnswer(id);
        return ResponseEntity.noContent().build();
    }
}
