import React from 'react';
import './PostInfo.css';

const PostInfo = ({post}) => {
    const convertToDate = (date) => {
        const d = new Date(date);

        return d.toDateString();
    } 

    return(
        <div className="post-info">
            <img src={post.image} alt="post"/>
            <div className="detail-body">
                <div className="detail-body__title">
                    <p>{post.title}</p>
                </div>
                <div className="detail-body__date">
                    <p>{convertToDate(post.createAt)}  |  {post.category}</p>
                </div>
                <div className="detail-body__content">
                    <p>
                        {post.content}
                    </p>
                </div>
            </div>
        </div>
    )
}

export default PostInfo;