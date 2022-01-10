import React from 'react';
import {Link} from 'react-router-dom';
import './Navigation.css';

const Navigation = () => {
    return(     
        <nav className="header__nav">
            <Link className="header__logo" to="/">Denali</Link>
            <ul className="header__menu">
                <li className="header__item">
                    <Link className="header__item__link" to="/">Home</Link>
                </li>
                <li className="header__item">
                    <Link className="header__item__link" to="/about">About</Link>
                </li>
                <li className="header__item">
                    <Link className="header__item__link" to="/contact">Contact</Link>
                </li>
                <li className="header__item">
                    <Link className="header__item__link" to="/post">Post</Link>
                </li>
                <li className="header__item">
                    <Link className="header__item__link" to="/comments">Comments</Link>
                </li>
            </ul>
        </nav>
    )
}

export default Navigation;