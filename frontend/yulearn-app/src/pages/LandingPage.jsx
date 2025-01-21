import { useEffect } from "react";
import "./LandingPage.css";
import { Link, useOutletContext } from "react-router-dom";

export default function LandingPage() {
    const { updateTitle } = useOutletContext();

    useEffect(() => {
        document.title = `YuLearn`;
        updateTitle(`Olá, seja bem-vindo`);
    })

    return (
        <div className="landing-page">
            <img></img>
        </div>
    );
}