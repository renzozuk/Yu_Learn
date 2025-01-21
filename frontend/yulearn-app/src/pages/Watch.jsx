import "./Watch.css";
import React, { useState, useEffect } from "react";
import { loadTextLessons, loadVideoLessons } from "../util/Data";
import { useOutletContext, useParams } from "react-router-dom";
import { Viewer } from "@react-pdf-viewer/core";
import "@react-pdf-viewer/core/lib/styles/index.css";

export default function Watch() {
    const [width, setWidth] = useState(window.innerWidth * 0.75);
    const [subject, setSubject] = useState();
    const [media, setMedia] = useState(null);
    /* const [questionnaire, setQuestionnaire] = useState(); */

    const { mediaType, mediaId } = useParams();

    const { updateTitle } = useOutletContext();

    useEffect(() => {
        if (mediaType == `text_lesson`) {
            loadTextLessons().then((text_lessons) => {
                for (let key in text_lessons) {
                    if (text_lessons[key].id == mediaId) {
                        updateTitle(text_lessons[key].title);
                        setSubject(text_lessons[key].description);
                        setMedia(text_lessons[key].pdfUrl);
                    }
                }
            });
        }

        if (mediaType == `video_lesson`) {
            loadVideoLessons().then((video_lessons) => {
                for (let key in video_lessons) {
                    if (video_lessons[key].id == mediaId) {
                        updateTitle(video_lessons[key].title);
                        setSubject(video_lessons[key].description);
                        setMedia(video_lessons[key].videoUrl);
                    }
                }
            });
        }

        const handleResize = () => {
            setWidth(window.innerWidth * 0.75);
        };

        window.addEventListener('resize', handleResize);

        return () => {
            window.removeEventListener('resize', handleResize);
        };
    }, []);

    return (
        <div className="watch-page">
            {localStorage.getItem("username") ? 
            (media ?
                (mediaType == `video_lesson` ? <video className="player-video" style={{ width: width, height: width / 1.7 }} src={media} controls autoPlay></video> : <Viewer fileUrl={media} />) : 
            <p className="video-warning-text">Vídeo não encontrado.</p>) : 
            <p className="video-warning-text">Você precisa estar logado para ter acesso ao conteúdo.</p>}
        </div>
    );
}