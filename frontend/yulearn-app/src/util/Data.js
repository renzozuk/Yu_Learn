class Course {
    constructor({ id, title, description, thumbnailUrl, modules }) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.modules = modules;
    }
}

class Module {
    constructor({ id, title, description, thumbnailUrl, animationUrl, episodes }) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.animationUrl = animationUrl;
        this.lessons = lessons;
    }
}

class TextLesson {
    constructor({ id, title, description, thumbnailUrl, categories, pdfUrl }) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.categories = categories;
        this.pdfUrl = pdfUrl;
    }
}

class VideoLesson {
    constructor({ id, title, description, thumbnailUrl, categories, videoUrl }) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.categories = categories;
        this.videoUrl = videoUrl;
    }
}

class Questionnaire {
    constructor({ id, title, description, thumbnailUrl, categories, questions }) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumbnailUrl = thumbnailUrl;
        this.categories = categories;
        this.questions = questions;
    }
}

class Question {
    constructor({ id, content, answers }) {
        this.id = id;
        this.content = content;
        this.answers = answers;
    }
}

class Answer {
    constructor({ id, isCorrect, content }) {
        this.id = id;
        this.isCorrect = isCorrect;
        this.content = content;
    }
}

const path = `http://localhost:8080`;

function loadCourse(courseId) {
    return fetch(`${path}/api/courses/${courseId}`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((course) => {
        return new Course({
            id: course.id,
            title: course.title,
            description: course.description,
            thumbnailUrl: course.thumbnailUrl,
            modules: course.modules
        });
    })
}

function loadCourses() {
    return fetch(`${path}/api/courses`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((courses) => {
        const coursesList = [];

        for (let key in courses) {
            coursesList.push(new Course({
                id: courses[key].id,
                title: courses[key].title,
                description: courses[key].description,
                thumbnailUrl: courses[key].thumbnailUrl,
                modules: courses[key].modules
            }));
        }

        return coursesList;
    })
}

function loadModule(moduleId) {
    return fetch(`${path}/api/modules/${moduleId}`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((module) => {
        return new Module({
            id: module.id,
            title: module.title,
            description: module.description,
            thumbnailUrl: module.thumbnailUrl,
            lessons: module.lessons
        });
    });
}

function loadModules() {
    return fetch(`${path}/api/modules`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((modules) => {
        const modulesList = [];

        for (let key in modules) {
            modulesList.push(new Module({
                id: modules[key].id,
                title: modules[key].title,
                description: modules[key].description,
                thumbnailUrl: modules[key].thumbnailUrl,
                lessons: modules[key].lessons
            }));
        }

        return modulesList;
    });
}

function loadTextLesson(textLessonId) {
    return fetch(`${path}/api/text_lessons/${textLessonId}`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((textLesson) => {
        return new TextLesson({
            id: textLesson.id,
            title: textLesson.title,
            description: textLesson.description,
            thumbnailUrl: textLesson.thumbnailUrl,
            categories: textLesson.categories,
            pdfUrl: textLesson.pdfUrl
        });
    });
}

function loadTextLessons() {
    return fetch(`${path}/api/text_lessons`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((textLesson) => {
        const textLessonsList = [];

        for (let key in textLesson) {
            textLessonsList.push(new TextLesson({
                id: textLesson[key].id,
                title: textLesson[key].title,
                description: textLesson[key].description,
                thumbnailUrl: textLesson[key].thumbnailUrl,
                categories: textLesson[key].categories,
                pdfUrl: textLesson[key].pdfUrl
            }))
        }

        return textLessonsList;
    });
}

function loadVideoLesson(videoLessonId) {
    return fetch(`${path}/api/video_lessons/${videoLessonId}`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((videoLesson) => {
        return new VideoLesson({
            id: videoLesson.id,
            title: videoLesson.title,
            description: videoLesson.description,
            thumbnailUrl: videoLesson.thumbnailUrl,
            categories: videoLesson.categories,
            pdfUrl: videoLesson.pdfUrl
        });
    });
}

function loadVideoLessons() {
    return fetch(`${path}/api/video_lessons`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((videoLesson) => {
        const videoLessonsList = [];

        for (let key in videoLesson) {
            videoLessonsList.push(new VideoLesson({
                id: videoLesson[key].id,
                title: videoLesson[key].title,
                description: videoLesson[key].description,
                thumbnailUrl: videoLesson[key].thumbnailUrl,
                categories: videoLesson[key].categories,
                pdfUrl: videoLesson[key].pdfUrl
            }))
        }

        return videoLessonsList;
    });
}

function loadQuestionnaire(questionnaireId) {
    return fetch(`${path}/api/questionnaires/${questionnaireId}`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((questionnaire) => {
        return new Questionnaire({
            id: questionnaire.id,
            title: questionnaire.title,
            description: questionnaire.description,
            thumbnailUrl: questionnaire.thumbnailUrl,
            categories: questionnaire.categories,
            questions: questionnaire.questions
        });
    });
}

function loadQuestionnaires() {
    return fetch(`${path}/api/questionnaires`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((questionnaire) => {
        const questionnairesList = [];

        for (let key in questionnaire) {
            questionnairesList.push(new VideoLesson({
                id: questionnaire[key].id,
                title: questionnaire[key].title,
                description: questionnaire[key].description,
                thumbnailUrl: questionnaire[key].thumbnailUrl,
                categories: questionnaire[key].categories,
                pdfUrl: questionnaire[key].pdfUrl
            }))
        }

        return questionnairesList;
    });
}

function loadQuestion(questionId) {
    return fetch(`${path}/api/questions/${questionId}`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((question) => {
        return new Question({
            id: question.id,
            content: question.content,
            answers: question.answers
        });
    });
}

function loadQuestions() {
    return fetch(`${path}/api/questions`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((question) => {
        const questionsList = [];

        for (let key in question) {
            questionsList.push(new Question({
                id: question[key].id,
                content: question[key].content,
                answer: question[key].answer
            }))
        }

        return questionsList;
    });
}

function loadAnswer(answerId) {
    return fetch(`${path}/api/answers/${answerId}`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((answer) => {
        return new Answer({
            id: answer.id,
            isCorrect: answer.isCorrect,
            content: answer.content
        });
    });
}

function loadAnswers() {
    return fetch(`${path}/api/answers`, {
        method: "GET"
    })
    .then((response) => {
        if (!response.ok) {
            throw new Error("Network answer was not ok.");
        }
        return response.json();
    })
    .then((answer) => {
        const answersList = [];

        for (let key in answer) {
            answersList.push(new Answer({
                id: answer[key].id,
                isCorrect: answer[key].isCorrect,
                content: answer[key].content
            }))
        }

        return answersList;
    });
}

export { loadCourse, loadCourses, loadModule, loadModules, loadTextLesson, loadTextLessons, loadVideoLesson, loadVideoLessons, loadQuestionnaire, loadQuestionnaires, loadQuestion, loadQuestions, loadAnswer, loadAnswers };