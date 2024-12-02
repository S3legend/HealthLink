import React from 'react';
import './Header.css'; // Créez un fichier Header.css pour styliser ce composant

const Header = () => {
    return (
        <header className="header">
            <div className="logo">
                <img
                    src="/healthlogo.jpg"
                    alt="HealthLink Logo"
                    className="logo-img"
                />
                <h1 className="healthLinkTitle">
                    <span className="health">Health</span>
                    <span className="link">Link</span>
                </h1>
            </div>
        </header>
    );
};

export default Header;
