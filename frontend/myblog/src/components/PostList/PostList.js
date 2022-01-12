import React from 'react';
import PostItem from '../PostItem/PostItem';
import './PostList.css';

const PostList = ({posts}) => {
    return(
        <div className="post-list">
            {
                posts.map((post) => {
                    return <PostItem key={post.id} post={post}/>
                })
            }
        </div>
    )
}

export default PostList;