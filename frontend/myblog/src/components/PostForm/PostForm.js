import React from 'react';
import './PostForm.css';

const PostForm = () => {
    return(
        <div className="add-post">
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
                <form className="post-form">
                    <label htmlFor="title">Title</label>
                        <input type="text" name="title" id="title" placeholder="Enter post title"/>
                    <label htmlFor="image">Image URL</label>
                        <input type="text" name="image" id="image" placeholder="Enter post image url"/>
                    <label htmlFor="category">Type</label>
                        <select id="category" name="category">
                            <option value="ART">ART</option>
                            <option value="MUSIC">MUSIC</option>
                            <option value="TECH">TECH</option>
                            <option value="TRAVEL">TRAVEL</option>
                        </select>
                    <label htmlFor="content">Content</label>
                        <textarea rows="5" name="content" id="content" placeholder="Enter post content"></textarea>
                    <input type="submit" value="Submit" />
                </form>
            </div>
        </div>
    )
}

export default PostForm;