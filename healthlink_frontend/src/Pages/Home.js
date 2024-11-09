import React from 'react';
import Navbar from "../Components/Navbar";
import Footer from "../Components/Footer";
import '../Styles/Home.css'
import Hero from "../Components/Hero";

const Home = () => {
    return (
        <div>
         <Navbar />

           <Hero />
            <section className="services text-center">
                <h2>Discover Our Services</h2>
                <div className="row">
                    <div className="col-md-3">
                        <h3>Telemedicine</h3>
                        <p>Consult with doctors online</p>
                    </div>
                    <div className="col-md-3">
                        <h3>Prescription Management</h3>
                        <p>Manage your prescriptions easily</p>
                    </div>
                    <div className="col-md-3">
                        <h3>First Aid Tips</h3>
                        <p>Learn basic first aid tips</p>
                    </div>
                    <div className="col-md-3">
                        <h3>Medical Record Access</h3>
                        <p>Access your health records securely</p>
                    </div>
                </div>
            </section>






            <Footer />
        </div>
    );
}

export default Home;
