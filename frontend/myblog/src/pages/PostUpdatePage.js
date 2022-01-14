import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import PostUpdateForm from '../components/PostUpdateForm/PostUpdateForm';
import axios from 'axios';

const PostUpdatePage = () => {
    const [postUpdate, setPostUpdate] = useState({});
    const {id} = useParams();

    useEffect(() => {
        axios.get(`http://localhost:8080/post/backend/v1/posts/${id}`, {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            }
        }).then((request) => {
            setPostUpdate(request.data);
            console.log(request);
        })
    }, [id])

    return(
        <div className="update-page">
            <PostUpdateForm postUpdate={postUpdate}/>
        </div>
    )
}

export default PostUpdatePage;