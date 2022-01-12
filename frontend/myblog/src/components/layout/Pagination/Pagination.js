import React from 'react';
import './Pagination.css';
import { HiOutlineArrowNarrowRight } from 'react-icons/hi';

const Pagination = ({onPageChange, page, limit}) => {
    return(
        <div className="pagination">
            <button onClick={() => onPageChange(page + limit)}>
                <div style={{marginTop: '2px'}}>
                    More post
                </div> 
                <div><HiOutlineArrowNarrowRight className="pagination-icon"/></div>
            </button>
        </div>
    )
}

export default Pagination;