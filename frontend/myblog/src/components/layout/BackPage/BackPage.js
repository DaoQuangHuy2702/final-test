import React from 'react';
import './BackPage.css';
import { HiOutlineArrowNarrowLeft } from 'react-icons/hi';
import { Link } from 'react-router-dom';

const BackPage = () => {
    return(
        <div className="back-page">
            <button><div><HiOutlineArrowNarrowLeft className="back-icon"/></div><Link className="back-link" to="/">All posts</Link></button>
        </div>
    )
}

export default BackPage;