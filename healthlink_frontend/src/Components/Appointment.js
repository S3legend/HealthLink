import React from 'react';
import '../Styles/Appointment.css';

const Appointment = () => {
    return (
        <section id="appointment" className="appointment">
            <h2>Make An Appointment</h2>
            <p>
                Easily schedule your health consultations at your convenience. Choose your desired
                experience and specialty, then select a suitable date and time.
            </p>
            <button>Book Now</button>
        </section>
    );
};

export default Appointment;
