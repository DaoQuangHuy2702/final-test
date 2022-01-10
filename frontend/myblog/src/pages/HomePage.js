import React from 'react';
import Pagination from '../components/layout/Pagination/Pagination';
import PostList from '../components/PostList/PostList';

const HomePage = () => {
    return(
        <div className="home-page">
            <PostList/>
            <Pagination/>
        </div>
    )
}

export default HomePage;