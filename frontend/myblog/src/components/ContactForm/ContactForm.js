import React, { useState } from 'react';
import './ContactForm.css';
import axios from 'axios';
import { Navigate } from 'react-router-dom';

const ContactForm = () => {
    const [contact, setContact] = useState({
        name: "",
        email: "",
        message: ""
    });
    const [redirect, setRedirect] = useState(false);

    const handleChange = (event) => {
        setContact({
            ...contact,
            [event.target.name] : event.target.value
        })
    }

    const handleSubmit = (event) => {
        event.preventDefault();

        console.log(contact);

        axios.post('http://localhost:8080/post/backend/v1/contacts', {
            ...contact
        }, 
        {
            headers: {
                apikey: "2347edfd-c55c-4f59-96ee-600492f904f3",
                "Access-Control-Allow-Origin": "*"
            }
        }).then((request) => {
            setContact(request.data);
            alert('Add Contact Successful');
            setRedirect(true);
            console.log(request)
        }).catch((error) => {alert(error)})
    }

    return(
        <div className="contact">
            {
                redirect ? <Navigate to="/comments"/> :
                <div>
                    <div className="contact-info">
                        <p className="contact-info__title">Get in touch</p>
                        <p>
                            Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consecteur ac,
                            vestibulum at eros. Nulla vitae elit libero, apharetra augue. Nulla vitae elit libero, apharetra augue.
                            Sed posuere consecteur est at lobortis. Fusce dapibus, tellus ac cursus commodo, tortor mauris 
                            condimentum nibh, ut fermentum massa justo sit amet risus.
                        </p>
                        <p>
                            Morbi leo risus, porta ac consecteur ac, vestibulum as eros. Etiam porta sem malesuada magna mollis
                            eusimod. Etiam porta sem malesuada agna mollis eusimod. Aenean eu leo quam. Pellentesque ornare
                            sem lacinia quam venenatis vestibulum.
                        </p>
                    </div>
                    <div>
                        <form className="contact-form" onSubmit={handleSubmit}>
                            <label htmlFor="name">Name</label>
                            <input type="text" name="name" id="name" placeholder="Enter your name" value={contact.name} onChange={handleChange}/>
                            <label htmlFor="email">Email Address</label>
                            <input type="text" name="email" id="email" placeholder="Enter your email address" value={contact.email} onChange={handleChange}/>
                            <label htmlFor="message">Email Address</label>
                            <textarea rows="5" name="message" id="message" placeholder="Enter your message" value={contact.message} onChange={handleChange}></textarea>
                            <input type="submit" value="Submit"/>
                        </form>
                    </div>
                </div>
            }
        </div>
    )
}

export default ContactForm;