package br.ufrn.imd.learningplatform.media.controllers;

import br.ufrn.imd.learningplatform.media.model.dto.QuestionnaireDTO;
import br.ufrn.imd.learningplatform.media.services.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questionnaires")
public class QuestionnaireController {

    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping
    public ResponseEntity<List<QuestionnaireDTO>> getAllQuestionnaires() {
        return new ResponseEntity<>(questionnaireService.getAllQuestionnaires(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionnaireDTO> getQuestionnaireById(@PathVariable String id) {
        return new ResponseEntity<>(questionnaireService.getQuestionnaireById(id), HttpStatus.OK);
    }

    @PostMapping("/{moduleId}")
    public ResponseEntity<QuestionnaireDTO> createQuestionnaire(@PathVariable String moduleId, @RequestBody QuestionnaireDTO questionnaire) {
        return new ResponseEntity<>(questionnaireService.createQuestionnaire(moduleId, questionnaire), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<QuestionnaireDTO> updateQuestionnaire(@RequestBody QuestionnaireDTO questionnaire, @PathVariable String id) {
        return new ResponseEntity<>(questionnaireService.updateQuestionnaire(questionnaire, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestionnaire(@PathVariable String id) {
        questionnaireService.deleteQuestionnaire(id);
        return ResponseEntity.noContent().build();
    }
}
