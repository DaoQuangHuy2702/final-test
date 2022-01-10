import React from 'react';
import PostItem from '../PostItem/PostItem';
import './PostList.css';

const PostList = () => {
    return(
        <div className="post-list">
            <PostItem />
            <PostItem />
            <PostItem />
            <PostItem />
        </div>
    )
}

export default PostList;