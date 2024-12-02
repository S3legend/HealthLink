import React from 'react';
import './sidebar.css';

const Sidebar = () => {
    return (
        <div className="sidebar">
            
                <p className="text">Mon compte</p>
                <p className="text">Mes rendez-vous</p>
                <p className="text">Mon espace famille</p>
                <p className="text">Dossier Médical</p>
                <p className="text">Mes messages</p>
                <p className="text">Mes patients</p>
                <p className="text">Déconnexion</p>
            
        </div>
    );
};

export default Sidebar;
