import React from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';
import Author from './components/Author/Author';
import Header from './components/layout/Header/Header';
import HomePage from './pages/HomePage';
import AboutPage from './pages/AboutPage';
import ContactPage from './pages/ContactPage';
import PostPage from './pages/PostPage';
import CommentPage from './pages/CommentPage';
import PostDetailsPage from './pages/PostDetailsPage';
import PostUpdatePage from './pages/PostUpdatePage';

const App = () => {
  return (
    <div className="App">
      <Header />
      <div className="main">
        <Author/>
        <div className="content">
            <Routes>
              <Route path="/" element={<HomePage/>}/>
              <Route path="/about" element={<AboutPage/>}/>
              <Route path="/contact" element={<ContactPage/>}/>
              <Route path="/post" element={<PostPage/>}/>
              <Route path="/post/:id" element={<PostUpdatePage/>}/>
              <Route path="/comments" element={<CommentPage/>}/>
              <Route path="/posts/:id" element={<PostDetailsPage/>}/>
            </Routes>
        </div>
      </div>
    </div>
  )
}

export default App;
