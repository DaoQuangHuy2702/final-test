import React from 'react';
import BackPage from '../components/layout/BackPage/BackPage';
import PostInfo from '../components/PostInfo/PostInfo';

const PostDetailsPage = () => {
    return(
        <div className="post-details-page">
            <PostInfo />
            <BackPage />
        </div>
    )
}

export default PostDetailsPage;