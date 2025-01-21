import { useEffect, useState } from "react";
import ContentCell from "./ContentCell";
import { loadCourses, loadModules } from "../util/Data";
import "./ContentLine.css";

export default function ContentLine(props) {
    const [contents, setContents] = useState([]);
    
    useEffect(() => {
        if (props.mediaType == `course`) {
            loadCourses().then((courses) => {
                const coursesList = [];
                for (let key in courses) {
                    coursesList.push(courses[key]);
                }
                setContents(coursesList);
            });
        }

        if (props.mediaType == `module`) {
            loadModules.then((modules) => {
                const modulesList = [];
                for (let key in modules) {
                    modulesList.push(modules[key]);
                }
                setContents(modulesList);
            })
        }
    });

    return (
        <div className="content-line">
            {contents.map((content) => (
                <ContentCell id={content.id} title={content.title} thumbnail={content.thumbnailUrl} animation={content.animationUrl} mediaType={props.mediaType} />
            ))}
        </div>
    );
}