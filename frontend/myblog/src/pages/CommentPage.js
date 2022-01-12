import React, { useEffect, useState } from 'react';
import ContactList from '../components/ContactList/ContactList';
import axios from 'axios';

const CommentPage = () => {
    const [comments, setComments] = useState([]);

    const fetchData = async () => {
        try{
            axios.get('http://localhost:8080/post/backend/v1/contacts', {
                headers: {
                    apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                    "Access-Control-Allow-Origin": "*"
                }
            }).then((request) => {
                setComments(request.data);
                console.log(request)
            }) 
        }catch(error) {
            console.log(error);
        }
    }

    const handleDeleteComment = (commentId) => {
        axios.delete(`http://localhost:8080/post/backend/v1/contacts/${commentId}`, {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            }
        }).then((request) => {
            alert('Delete Successful');
            fetchData();
        })
    }

    useEffect(() => {
        fetchData();
    }, [])
    return(
        <div className="comment-page">
            <ContactList comments={comments} onDeleteComment={handleDeleteComment}/>
        </div>
    )
}

export default CommentPage;