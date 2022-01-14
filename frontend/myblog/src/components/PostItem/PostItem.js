import React from 'react';
import { Link } from 'react-router-dom';
import './PostItem.css';

const PostItem = ({post}) => {
    const convertToDate = (date) => {
        const d = new Date(date);

        return d.toDateString();
    }

    const subContent = (content) => {
        return content.substring(0, 200);
    }

    return(
        <div className="post-item">
            <div className="post-image">
                <img src={post.image} alt="post"/>
            </div>
            <div className="post-body">
                <div className="post-body__title">
                    <p>{post.title}</p>
                </div>
                <div className="post-body__date">
                    <p>{convertToDate(post.createAt)}  |  {post.category}</p>
                </div>
                <div className="post-body__content">
                    <p>{subContent(post.content)} <Link className="post-body__link" to={`/posts/${post.id}`}>Read more...</Link>
                    </p>
                </div>
            </div>
        </div>
    )
}

export default PostItem;