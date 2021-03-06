import React, { useEffect, useState } from 'react';
import Pagination from '../components/layout/Pagination/Pagination';
import PostList from '../components/PostList/PostList';
import axios from 'axios';

const HomePage = () => {
    const [posts, setPosts] = useState([]);
    const [page, setPage] = useState(0);
    const [term, setTerm] = useState('');
    const [isSearch, setIsSearch] = useState(false);
    const limit = 4;

    useEffect(() => {
        axios.get('http://localhost:8080/post/backend/v1/posts', {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            },
            params: {
                page: page,
                limit: limit
            }
        }).then((request) => {
            setPosts(request.data);
            console.log(request)
        })
    }, [page])


    const handlePageChange = (newPage) => {
        setPage(newPage);
        console.log(newPage);
    }

    const onHandleChange = (event) => {
        setTerm(event.target.value);
    }

    const handleSubmit = (event) => {
        event.preventDefault();

        console.log(term);

        axios.get('http://localhost:8080/post/backend/v1/posts/search', {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            },
            params: {
                term: term
            }
        }).then((request) => {
            setPosts(request.data);
            setIsSearch(true);
            console.log(request)
        }).catch((error) => {
            alert(error);
        })
    }

    return(
        <div className="home-page">
            <div className="search-post" onSubmit={handleSubmit}>
                <form className="search-form">
                    <input type="text" name="term" id="name" placeholder="Search" defaultValue={term} onChange={onHandleChange}/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
            <PostList posts={posts}/>
            {posts.length < limit || isSearch ? null : <Pagination onPageChange={handlePageChange} page={page} limit={limit}/>}
        </div>
    )
}

export default HomePage;