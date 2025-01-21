import React, { useEffect } from "react";
import { useOutletContext, useParams } from "react-router-dom";
import "./Catalog.css";
import ContentLine from "../components/ContentLine";

export default function Catalog() {
    const { mediaType } = useParams();

    const { updateTitle } = useOutletContext();

    useEffect(() => {
        updateTitle("Catálogo");
    });

    return (
        <div className="catalog-page">
            {(mediaType == `all`) && <div className="section">
                <p className="section-title">Cursos</p>
                <ContentLine mediaType="courses" />
            </div>}
            {(mediaType == `course`) && <div className="section">
                <p className="section-title">Módulos do curso</p>
                <ContentLine mediaType="modules" />
            </div>}
        </div>
    );
}