import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import BackPage from '../components/layout/BackPage/BackPage';
import PostInfo from '../components/PostInfo/PostInfo';
import axios from 'axios';


const PostDetailsPage = () => {
    const [post, setPost] = useState({});
    const {id} = useParams();

    useEffect(() => {
        axios.get(`http://localhost:8080/post/backend/v1/posts/${id}`, {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            }
        }).then((request) => {
            setPost(request.data);
            console.log(request)
        })
    }, [id])

    return(
        <div className="post-details-page">
            {post.title ? <div><PostInfo post={post}/><BackPage /></div> : ''}
        </div>
    )
}

export default PostDetailsPage;