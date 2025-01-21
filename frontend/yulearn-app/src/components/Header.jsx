import "./Header.css";
import { Link } from "react-router-dom";
import Logotype from "./Logotype";

export default function Header() {
    return (
        <div className="header">
            <div className="header-logotype">
                {localStorage.getItem("username") ? <Link className="header-navbar-link" to="/catalog/all"><Logotype letterocolor={`#111111`} /></Link> : <Link className="header-navbar-link" to="/catalog/all"><Logotype letterocolor={`#111111`} /></Link>}
            </div>
            <div className="header-buttons">
                <button className="header-button"><Link className="header-navbar-link" to="/catalog/trending">Em destaque</Link></button>
                <button className="header-button"><Link className="header-navbar-link" to="/catalog/tvshows">Séries</Link></button>
                <button className="header-button"><Link className="header-navbar-link" to="/catalog/movies">Filmes</Link></button>
                {localStorage.getItem("username") ? <button className="header-button">Meu perfil</button> : <button className="header-button"><Link className="header-navbar-link" to="/login">Entrar</Link></button>}
            </div>
        </div>
    );
}