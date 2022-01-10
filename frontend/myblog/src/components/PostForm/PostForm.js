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
                    <label for="username">Title</label>
                        <input type="text" name="username" id="username" placeholder="Enter your name"/>
                    <label for="email">Image URL</label>
                        <input type="text" name="email" id="email" placeholder="Enter your email address"/>
                    <label for="type">Type</label>
                        <select id="type" name="type">
                            <option value="ART">ART</option>
                            <option value="MUSIC">MUSIC</option>
                            <option value="TECH">TECH</option>
                            <option value="TRAVEL">TRAVEL</option>
                        </select>
                    <label for="message">Content</label>
                        <textarea rows="5" name="message" id="message" placeholder="Enter your message"></textarea>
                    <input type="submit" value="Submit" />
                </form>
            </div>
        </div>
    )
}

export default PostForm;