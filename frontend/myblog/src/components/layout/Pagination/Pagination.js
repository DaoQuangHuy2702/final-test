import React from 'react';
import './Pagination.css';
import { HiOutlineArrowNarrowRight } from 'react-icons/hi';

const Pagination = () => {
    return(
        <div className="pagination">
            <button><div style={{marginTop: '2px'}}>More post</div> <div><HiOutlineArrowNarrowRight className="pagination-icon"/></div></button>
        </div>
    )
}

export default Pagination;