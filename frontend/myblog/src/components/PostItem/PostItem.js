import React from 'react';
import { Link } from 'react-router-dom';
import './PostItem.css';

const PostItem = () => {
    return(
        <div className="post-item">
            <div className="post-image">
                <img src="https://thumbs.dreamstime.com/b/happy-couple-love-travel-raised-hands-cliff-happy-couple-love-travel-raised-hands-cliff-norway-man-woman-112188598.jpg" alt="book"/>
            </div>
            <div className="post-body">
                <div className="post-body__title">
                    <p>Wherever far wow thus a squirrel raccoon jeez jaguar this from along</p>
                </div>
                <div className="post-body__date">
                    <p>June 25, 2021  |  ART</p>
                </div>
                <div className="post-body__content">
                    <p>The copy warned the Little Blind Text, that where it came from it would been have rewritten a thousand times and everything
                        that was left from its origin would be the world "and" and the Little Blind <Link className="post-body__link" to="/posts/1">Read more...</Link>
                    </p>
                </div>
            </div>
        </div>
    )
}

export default PostItem;