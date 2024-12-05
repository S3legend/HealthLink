import '../Styles/Login.css';
import React, { useState } from 'react';
import logo from '../Assets/logohori.png';
import { Link } from 'react-router-dom';

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [showPassword, setShowPassword] = useState(false);

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Login form submitted', { email, password });
    };

    return (
        <div className="login-page">
            <div className="login-header">
                <img src={logo} alt="HealthLink Logo" className="logo"/>
                <Link to="/DocSignup"><button className="signup-btn">Sign Up</button></Link>
            </div>
            <div className="login-container">
                <h2>Log in to Your HealthLink Account</h2>
                <form onSubmit={handleSubmit}>
                    <div className="textbox" id="email-textbox">
                        <label className="label">Email</label>
                        <input
                            type="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </div>
                    <div className="textbox" id="password-textbox">
                        <label className="label">Password</label>
                        <div className="password-container">
                            <input
                                type={showPassword ? 'text' : 'password'}
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                required
                            />
                            <span className="icon" onClick={() => setShowPassword(!showPassword)}>
              </span>
                        </div>
                    </div>
                    <button type="submit" className="login-btn">Log In</button>
                    <div className="forgot-password">
                        <a href="#">Forgot Password?</a>
                    </div>
                    <button className="google-login-btn">
                        <span>G</span> Login with Google
                    </button>
                </form>
            </div>
        </div>
    );
};

export default Login;