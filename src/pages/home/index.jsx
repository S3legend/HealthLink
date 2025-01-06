import React, { useState, useCallback } from 'react';
import {useNavigate} from 'react-router-dom';
import Navbar from '../../components/Navbar'
import "../../Navbar.css"

const HomePage = () => {
    const [value, setValue] = useState('');
    const navigate = useNavigate();
    const handleJoinRoom = useCallback(() => {
        navigate(`/room/${value}`);
    }, [navigate, value]);

    return (
        <div>
            <Navbar /> {/* Inclure le composant Navbar */}
            <div className="content"> {/* Ajoutez une classe pour le contenu principal */}
                <p className="instruction-text">
                    Veuillez entrer le code de la salle de consultation pour commencer votre rendez-vous.
                </p>
                <div className="input-container">
                    <input
                        value={value}
                        onChange={(e) => setValue(e.target.value)}
                        type="text"
                        placeholder="Entrez le code de la salle"
                    />
                    <button onClick={handleJoinRoom}>Rejoindre</button>
                </div>
            </div>
        </div>
    );
};

export default HomePage;