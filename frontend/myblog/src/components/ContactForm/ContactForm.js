import React from 'react';
import './ContactForm.css';

const ContactForm = () => {
    return(
        <div className="contact">
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
                <form className="contact-form">
                    <label htmlFor="name">Name</label>
                    <input type="text" name="name" id="name" placeholder="Enter your name"/>
                    <label htmlFor="email">Email Address</label>
                    <input type="text" name="email" id="email" placeholder="Enter your email address"/>
                    <label htmlFor="message">Email Address</label>
                    <textarea rows="5" name="message" id="message" placeholder="Enter your message"></textarea>
                    <input type="submit" value="Submit" />
                </form>
            </div>
        </div>
    )
}

export default ContactForm;