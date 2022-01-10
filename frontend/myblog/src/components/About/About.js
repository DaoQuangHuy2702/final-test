import React from 'react';
import { Link } from 'react-router-dom';
import './About.css'

const About = () => {
    return(
        <div className="about">
            <div className="about-me">
                <p className="about-title">About me</p>
                <p>
                    The rich text element allows you to create and format headings, paragraphs, blockquotes, images and video
                    all in one place instead of having to add and format them individually. Just double-click and easily
                    create content.
                </p>
            </div>
            <div className="something-else">
                <p className="something-title">Something else here</p>
                <p>
                    Maecenas faucibus mollis interdum. Vivamus gagitis lacus vel augue laureet rutrum faucibus dolor auctor.
                    Curabitor blandis tempus porttios. Lorem ipsum dolor sit amet, consecteur adipiscing elit.
                    Vestibulum id ligula porta felis euismod semper.
                </p>
                <p>
                    Vestibulum id ligula porta felis euismod semper. Cum sociis natoque penatibus et magnis dis parturient montes,
                    nascetur ridiculus mus. Donec id elit non mi porta gravida at eget metus. Donec ullamcorper nulla non metus 
                    auctor fringilla.
                </p>
            </div>
            <button className="get-in-touch"><Link className="touch-link" to="/contact">Get in touch</Link></button>
        </div>
    )
}

export default About;