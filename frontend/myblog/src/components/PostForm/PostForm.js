import React, { useState } from 'react';
import './PostForm.css';
import axios from 'axios';
import { Navigate } from 'react-router-dom';

const PostForm = () => {
    const [post, setPost] = useState({
        title: "",
        image: "",
        content: "",
        category: "ART"
    })
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

        axios.post('http://localhost:8080/post/backend/v1/posts', {
            ...post
        }, 
        {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            }
        }).then((request) => {
            alert('Add Post Successful');
            setRedirect(true);
        }).catch((error) => {alert(error)})
    }

    return(
        <div className="add-post">
            {
                redirect ? <Navigate to="/"/> :
                <div>
                    <div className="add-info">
                        <p className="add-info__title">Add Post</p>
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
                                <input type="text" name="title" id="title" value={post.title} onChange={onHandleChange} placeholder="Enter post title"/>
                            <label htmlFor="image">Image URL</label>
                                <input type="text" name="image" id="image" value={post.image} onChange={onHandleChange} placeholder="Enter post image url"/>
                            <label htmlFor="category">Category</label>
                                <select id="category" name="category" defaultValue={post.category} onChange={onHandleChange}>
                                    <option selected={post.category === "ART"} value="ART">ART</option>
                                    <option selected={post.category === "MUSIC"} value="MUSIC">MUSIC</option>
                                    <option selected={post.category === "TECH"} value="TECH">TECH</option>
                                    <option selected={post.category === "TRAVEL"} value="TRAVEL">TRAVEL</option>
                                </select>
                            <label htmlFor="content">Content</label>
                                <textarea rows="5" name="content" id="content" value={post.content} onChange={onHandleChange} placeholder="Enter post content"></textarea>
                            <input type="submit" value="Submit" />
                        </form>
                    </div>
                </div>
                }
        </div>
    )
}

export default PostForm;