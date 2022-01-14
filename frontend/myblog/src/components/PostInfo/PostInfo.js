import React, { useState } from 'react';
import './PostInfo.css';
import axios from 'axios';
import { Navigate } from 'react-router-dom';
import { Link } from 'react-router-dom';

const PostInfo = ({post}) => {
    const [redirect, setRedirect] = useState(false);
    const convertToDate = (date) => {
        const d = new Date(date);

        return d.toDateString();
    } 

    const onDeletePost = () => {
        axios.delete(`http://localhost:8080/post/backend/v1/posts/${post.id}`, {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            }
        }).then((request) => {
            alert('Delete Successful');
            setRedirect(true);
        })
    }

    return(
        <div className="post-info">
            {redirect ? <Navigate to="/"/> : 
                <div>
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
                        <button className="detail-button"><Link className="update-link" to={`/post/${post.id}`}>Update</Link></button>
                        <button className="detail-button" onClick={onDeletePost}>Delete</button>
                    </div>
                </div>
            }
        </div>
    )
}

export default PostInfo;