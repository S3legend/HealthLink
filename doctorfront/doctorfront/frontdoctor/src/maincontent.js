import React from 'react';
//import ContactInfo from './contactinfo';
//import MedicalHistory from './medicalhistory';

const MainContent = () => {
    return (
        <div className="main-content">
            <div className="patient-info">
                <div className="profile-image">
                    <img src="/femme.jpg" alt="Description de l'image" />
                </div>
                <h2>BENTALEB Meriem</h2>
                <p className="nom1">meriembentaleb@gmail.com</p>
                <div className="patient-details">
                    <span className="age">Age</span>
                    <span className="age1">22</span>
                    <span className="genre">Genre</span>
                    <span className="genre1"> -</span>
                    <span className="taille">Taille</span>
                    <span className="taille1">0 cm</span>
                    <span className="poids">Poids</span>
                    <span className="poids1">0 kg</span>
                </div>
            </div>
            <div className="info-section">
                <div className="info-card1">
                <h3>Informations de Contact 📞</h3>
                    <p>Prénom :</p>
                    <p>Nom :</p>
                    <p>Numéro de téléphone :</p>
                    <p>Relation :</p>
                </div>
                <div className="info-card">
                    <h3>Historique Médical du Patient 🩺</h3>
                    <p>Antécédents médicaux :</p>
                    <p>Chirurgies précédentes :</p>
                    <p>Maladies chroniques :</p>
                </div>
            </div>
            <div className="button-section">
                <button className="button-item">Mes rendez-vous</button>
                <button className="button-item1">Mon espace familial</button>
                <button className="button-item2">Mes patients</button>
            </div>
        </div>
    );
}


export default MainContent;
