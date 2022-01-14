import React, { useEffect, useState } from 'react';
import './PostUpdateForm.css';
import axios from 'axios';
import { Navigate } from 'react-router-dom';

const PostUpdateForm = ({postUpdate}) => {
    const [post, setPost] = useState({
        id: "",
        title: "",
        content: "",
        category: ""
    });
    const [redirect, setRedirect] = useState(false);

    const onHandleChange = (event) => {
        setPost({
            ...post,
            [event.target.name] : event.target.value
        })
    }

    const handleSubmit = (event) => {
        event.preventDefault();

        console.log(post);

        axios.put(`http://localhost:8080/post/backend/v1/posts/${post.id}`, {
            ...post
        }, 
        {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            }
        }).then((request) => {
            alert('Update Post Successful');
            setRedirect(true);
        }).catch((error) => {alert(error)})
    }

    useEffect(() => {
        setPost(postUpdate);
    },[postUpdate])

    return(
        <div className="add-post">
            {
                redirect ? <Navigate to="/"/> :
                <div>
                    <div className="add-info">
                        <p className="add-info__title">Update Post</p>
                        <p>
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consecteur ac,
                            vestibulum at eros. Nulla vitae elit libero, apharetra augue. Nulla vitae elit libero, apharetra augue.
                            Sed posuere consecteur est at lobortis. Fusce dapibus, tellus ac cursus commodo, tortor mauris 
                            condimentum nibh, ut fermentum massa justo sit amet risus.
                        </p>
                    </div>
                    <div>
                        <form className="post-form" onSubmit={handleSubmit}>
                            <label htmlFor="title">Title</label>
                                <input type="text" name="title" id="title" defaultValue={post.title} onChange={onHandleChange} placeholder="Enter post title"/>
                            <label htmlFor="image">Image URL</label>
                                <input type="text" name="image" id="image" defaultValue={post.image} onChange={onHandleChange} placeholder="Enter post image url"/>
                            <label htmlFor="category">Category</label>
                                <select id="category" name="category" defaultValue={post.category} onChange={onHandleChange}>
                                    <option selected={post.category === "ART"} value="ART">ART</option>
                                    <option selected={post.category === "MUSIC"} value="MUSIC">MUSIC</option>
                                    <option selected={post.category === "TECH"} value="TECH">TECH</option>
                                    <option selected={post.category === "TRAVEL"} value="TRAVEL">TRAVEL</option>
                                </select>
                            <label htmlFor="content">Content</label>
                                <textarea rows="5" name="content" id="content" defaultValue={post.content} onChange={onHandleChange} placeholder="Enter post content"></textarea>
                            <input type="submit" value="Submit" />
                        </form>
                    </div>
                </div>
            }
        </div>
    )
}

export default PostUpdateForm;