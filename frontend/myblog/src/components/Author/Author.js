import React from 'react';
import './Author.css';
import { FaFacebookSquare } from 'react-icons/fa';
import { FaInstagram } from 'react-icons/fa';
import { FaTwitter } from 'react-icons/fa';
import { FaLinkedinIn } from 'react-icons/fa';

const Author = () => {
    return(
        <div className="author">
            <div className="author__avatar">
                <img src="https://scr.vn/wp-content/uploads/2020/07/Avatar-Facebook-tr%E1%BA%AFng.jpg" alt="Avatar"/>
            </div>
            <div className="author__info">
                Denali is a simple responsive blog template.
                Easily add new posts using the Editor or change layout and design using the Designer.
            </div>
            <hr></hr>
            <div className="author__feature">
                <p style={{color: "#333333"}}>Featured Posts:</p><br/>
                <p style={{color: "#afaaaa"}}>According a funnily until preset or arrogant well cheerful</p><br/>
                <p style={{color: "#afaaaa"}}>Overlaid the jeepers uselessly much excluding</p>
            </div>
            <hr></hr>
            <div className="author__contact">
                <a href="/"><FaFacebookSquare className="author__contact__icon"/></a>
                <a href="/"><FaInstagram className="author__contact__icon"/></a>
                <a href="/"><FaTwitter className="author__contact__icon"/></a>
                <a href="/"><FaLinkedinIn className="author__contact__icon"/></a>
            </div>
            <p style={{fontSize: "1.6rem", color: "#afaaaa"}}>BUILD WITH WEBFLOW</p>
        </div>
    )
}

export default Author;