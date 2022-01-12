import React, { useEffect, useState } from 'react';
import Pagination from '../components/layout/Pagination/Pagination';
import PostList from '../components/PostList/PostList';
import axios from 'axios';

const HomePage = () => {
    const [posts, setPosts] = useState([]);
    useEffect(() => {
        axios.get('http://localhost:8080/post/backend/v1/posts', {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            }
        }).then((request) => {
            setPosts(request.data);
            console.log(request)
        })
    }, [])
    return(
        <div className="home-page">
            <PostList posts={posts}/>
            <Pagination/>
        </div>
    )
}

export default HomePage;