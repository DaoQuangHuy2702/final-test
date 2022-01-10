import React from 'react';
import './PostInfo.css';

const PostInfo = () => {
    return(
        <div className="post-info">
            <img src="https://thumbs.dreamstime.com/b/happy-couple-love-travel-raised-hands-cliff-happy-couple-love-travel-raised-hands-cliff-norway-man-woman-112188598.jpg" alt="book"/>
            <div className="detail-body">
                <div className="detail-body__title">
                    <p>Wherever far wow thus a squirrel raccoon jeez jaguar this from along</p>
                </div>
                <div className="detail-body__date">
                    <p>June 25, 2021  |  ART</p>
                </div>
                <div className="detail-body__content">
                    <p>The copy warned the Little Blind Text, that where it came from it would been have rewritten a thousand times and everything
                        that was left from its origin would be the world "and" and the Little Blind
                    </p>
                </div>
            </div>
        </div>
    )
}

export default PostInfo;