import React from 'react';
import {NavLink} from 'react-router-dom';
import './Navigation.css';

const Navigation = () => {
    return(     
        <nav className="header__nav">
            <NavLink className="header__logo" to="/">Denali</NavLink>
            <ul className="header__menu">
                <li className="header__item">
                    <NavLink className={(navData) => (navData.isActive ? 'header__item__link active' : 'header__item__link')} to="/">Home</NavLink>
                </li>
                <li className="header__item">
                    <NavLink className="header__item__link" to="/about">About</NavLink>
                </li>
                <li className="header__item">
                    <NavLink className="header__item__link" to="/contact">Contact</NavLink>
                </li>
                <li className="header__item">
                    <NavLink className="header__item__link" to="/post">Post</NavLink>
                </li>
                <li className="header__item">
                    <NavLink className="header__item__link" to="/comments">Comments</NavLink>
                </li>
            </ul>
        </nav>
    )
}

export default Navigation;