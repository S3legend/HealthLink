import React from 'react';
import './home.css';
import { Link } from 'react-router-dom';
import logo from './logohori.png';

function App() {
    return (
        <div className="App">
            <header className="container">
                <div className="logo">
                    <img src={logo} alt="HealthLink Logo" className="logo"/>
                </div>
                <nav className="nav">
                <ul>
                        <li><button className="nav-link">Home</button></li>
                        <li><button className="nav-link">Categories</button></li>
                        <li><button className="nav-link">About</button></li>
                        <li><button className="nav-link">Pages</button></li>
                        <li><button className="nav-link">Contacts</button></li>
                    </ul>
                </nav>
            </header>

            <section className="hero">
                <h2>Simplifying Your Path to Better Health</h2>
                <p>Your Journey to Better Health Starts Here</p>
                <div className="cta-buttons">
                    <Link to="/DocSignup"><button>Doctor</button></Link>
                    <button>Patient</button>
                    <Link to="/login"><button>Log in</button></Link>
                </div>
            </section>

            <section className="services">
                <h2>Discover Our Services</h2>
                <p>Explore various healthcare services we offer to enhance your well-being.</p>
                <div className="service-cards">
                    <div className="service-card">
                        <img src="telemedicine.jpg" alt="Telemedicine" />
                        <h3>Telemedicine</h3>
                        <p>Consult with certified doctors remotely via video call.</p>
                        <button>Start</button>
                    </div>
                    <div className="service-card">
                        <img src="prescription.jpg" alt="Prescription Management" />
                        <h3>Prescription Management</h3>
                        <p>Receive and manage prescriptions from your doctor with automated refill reminders.</p>
                        <button>Start</button>
                    </div>
                    <div className="service-card">
                        <img src="firstAid.jpg" alt="First Aid Tips" />
                        <h3>First Aid Tips</h3>
                        <p>Learn essential first aid tips for emergencies.</p>
                        <button>Start</button>
                    </div>
                    <div className="service-card">
                        <img src="medical_record.jpg" alt="Medical Record Access" />
                        <h3>Medical Record Access</h3>
                        <p>View and share your medical history securely with doctors for better care coordination.</p>
                        <button>Start</button>
                    </div>
                </div>
            </section>
            <section className="appointment">
                <h2>Make An Appointment</h2>
                <p>Easily schedule your health consultations at your convenience. Choose your desired experience and specialty, then select a suitable date and time.</p>
                <button>Book Now</button>
            </section>


            <section className="expert-doctors">
                <h2>Our Expert Doctors</h2>
                <p>Meet our highly qualified and experienced doctors ready to assist you.</p>
                <div className="doctor-cards">
                    <div className="doctor-card">
                        <img src="doctor_emily.jpg" alt="Dr. Emily Carter" />
                        <h3>Dr. Emily Carter</h3>
                        <p>Pediatrician</p>
                        <button>Rate</button>
                    </div>
                    <div className="doctor-card">
                        <img src="doctor_michael.jpg" alt="Dr. Michael Zhang" />
                        <h3>Dr. Michael Zhang</h3>
                        <p>Cardiologist</p>
                        <button>Rate</button>
                    </div>
                    <div className="doctor-card">
                        <img src="doctor_sarah.jpg" alt="Dr. Sarah Patel" />
                        <h3>Dr. Sarah Patel</h3>
                        <p>Dermatologist</p>
                        <button>Rate</button>
                    </div>
                </div>
            </section>

            <section className="testimonial">
                <div className="testimonial-content">
                    <img src="emily_johnson.jpg" alt="Emily Johnson" className="testimonial-img" />
                    <div className="testimonial-text">
                        <h3>Emily Johnson</h3>
                        <p>Teacher</p>
                        <div className="stars">⭐⭐⭐⭐⭐</div>
                        <p>"Healthlink has transformed my healthcare experience. The app is user-friendly and has made scheduling appointments a breeze."</p>
                    </div>
                </div>
            </section>

            <footer className="footer">
                <p>© 2024 HealthLink. All Rights Reserved.</p>
            </footer>
        </div>
    );
}

export default App;
