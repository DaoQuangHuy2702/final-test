import React from 'react';
import './ContactList.css';

const ContactList = ({comments, onDeleteComment}) => {
    return(
        <div className="comment-list">
            <div className="comment-info">
                <p className="comment-info__title">Comments</p>
                <p>
                    Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consecteur ac,
                    vestibulum at eros. Nulla vitae elit libero, apharetra augue. Nulla vitae elit libero, apharetra augue.
                    Sed posuere consecteur est at lobortis. Fusce dapibus, tellus ac cursus commodo, tortor mauris 
                    condimentum nibh, ut fermentum massa justo sit amet risus.
                </p>
            </div>
            <div>
                <table className="comment-table">
                    <tr>
                        <th style={{width: '10%'}}>STT</th>
                        <th style={{width: '20%'}}>Name</th>
                        <th style={{width: '25%'}}>Email</th>
                        <th style={{width: '30%'}}>Content</th>
                        <th style={{width: '15%'}}>Action</th>
                    </tr>
                    {
                        comments.map((comment, index) => {
                            return  <tr>
                                        <td style={{width: '10%'}}>{index + 1}</td>
                                        <td style={{width: '20%'}}>{comment.name}</td>
                                        <td style={{width: '20%'}}><div>{comment.email}</div></td>
                                        <td style={{width: '40%'}}>{comment.message}</td>
                                        <td style={{width: '10%'}}><button onClick={() => onDeleteComment(comment.id)}>Delete</button></td>
                                    </tr>
                        })
                    }
                </table>
            </div>
        </div>
    )
}

export default ContactList;