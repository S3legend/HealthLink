import React from 'react';
import '../Styles/Hero.css'; // Import the corresponding CSS file

const Hero = () => {
    return (
        <section className="hero text-center">
            <h1>Simplifying Your Path to Better Health</h1>
            <p>Your Journey to Better Health Starts Here</p>
            <button className="btn btn-primary mx-2">Get Started as a Doctor</button>
            <button className="btn btn-primary mx-2">Get Started as a Patient</button>
        </section>
    );
}

export default Hero;
