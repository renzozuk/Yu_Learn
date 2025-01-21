import "./Header.css";
import { Link } from "react-router-dom";
import Logotype from "./Logotype";

export default function Header() {
    return (
        <div className="header">
            <div className="header-logotype">
                {localStorage.getItem("username") ? <Link className="header-navbar-link" to="/catalog/all"><Logotype yucolor={`#111111`} /></Link> : <Link className="header-navbar-link" to="/catalog/all"><Logotype yucolor={`#111111`} /></Link>}
            </div>
            <div className="header-buttons">
                {localStorage.getItem("username") ? 
                <div className="header-buttons">
                    <div className="search-bar">
                        <input className="search-input" style={{ width: "40vw" }}></input>
                        <div className="search-button"></div>
                    </div>
                    <button className="header-button">Sair</button>
                </div> : 
                <div className="header-buttons">
                    <button className="header-button"><Link className="header-navbar-link" to="/signup">Criar Conta</Link></button>
                    <button className="header-button"><Link className="header-navbar-link" to="/login">Entrar</Link></button>
                </div>}
            </div>
        </div>
    );
}