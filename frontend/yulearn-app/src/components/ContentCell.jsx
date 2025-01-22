import "./ContentCell.css";
import { Link } from "react-router-dom";
import { useState } from "react";

export default function ContentCell(props) {
    
    const noImageLink = "https://placehold.jp/20/fff100/333333/120x200.png?text=no+image";

    return (
        <div>
            {props.mediaType == `course` && <Link to={`/showcase/${props.id}`}>
                <img className="content-cell-image" onMouseOver={handleMouseEnter} onMouseLeave={handleMouseLeave} src={(props.thumbnail || noImageLink)}></img>
            </Link>}
            {props.mediaType == `module` && <Link to={`/showcase/${props.id}`}>
                <img className="content-cell-image" onMouseOver={handleMouseEnter} onMouseLeave={handleMouseLeave} src={(props.thumbnail || noImageLink)}></img>
            </Link>}
        </div>
    );
}