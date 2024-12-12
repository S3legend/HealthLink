import React, { useState } from "react";
import icon2 from "../Assets/icon2.png";
import icon1 from "../Assets/icon1.png";
import icon3 from "../Assets/icon3.png";
import logo from "../Assets/lggrey.png";
import {Link} from "react-router-dom";

function PatientSignup() {
    const [formData, setFormData] = useState({
        firstName: "",
        lastName: "",
        email: "",
        password: "",
        confirmation: "",
    });

    const [errors, setErrors] = useState({});
    const [showPassword, setShowPassword] = useState(false);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        let validationErrors = {};

        if (!formData.firstName) validationErrors.firstName = "First Name is required.";
        if (!formData.lastName) validationErrors.lastName = "Last Name is required.";
        if (!formData.email) validationErrors.email = "Email is required.";
        if (!formData.password) validationErrors.password = "Password is required.";
        if (formData.password !== formData.confirmation)
            validationErrors.confirmation = "Passwords do not match.";

        setErrors(validationErrors);

        if (Object.keys(validationErrors).length === 0) {
            console.log("Form submitted successfully:", formData);
            // Submit form or execute further logic
        }
    };

    return (
        <div>
            <section className="bg-[#f5f5f5] text-gray-600 body-font">
                <div className="container px-5 py-24 mx-auto flex flex-wrap items-center">
                    {/* Left Side: Sign-up Form */}
                    <div className="lg:w-2/6 md:w-1/2 bg-white rounded-lg p-8 flex flex-col md:mr-auto w-full mt-10 md:mt-0">
                        {/*<h2 className="text-gray-900 text-lg font-medium title-font mb-7">
                            Create Your HealthLink Account
                        </h2>*/}
                        {/* First Name */}
                        <div className="relative mb-4">
                            <label htmlFor="first-name" className="leading-7 text-sm text-gray-600">
                                First Name
                            </label>
                            <input
                                type="text"
                                id="first-name"
                                name="firstName"
                                value={formData.firstName}
                                onChange={handleChange}
                                className="w-full bg-[#f5f5f5] rounded-lg border border-gray-300 focus:border-[#008080] focus:ring-2 focus:ring-[#008080] text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                            />
                            {errors.firstName && (
                                <p className="text-red-500 text-sm">{errors.firstName}</p>
                            )}
                        </div>

                        {/* Last Name */}
                        <div className="relative mb-4">
                            <label htmlFor="last-name" className="leading-7 text-sm text-gray-600">
                                Last Name
                            </label>
                            <input
                                type="text"
                                id="last-name"
                                name="lastName"
                                value={formData.lastName}
                                onChange={handleChange}
                                className="w-full bg-[#f5f5f5] rounded-lg border border-gray-300 focus:border-[#008080] focus:ring-2 focus:ring-[#008080] text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                            />
                            {errors.lastName && <p className="text-red-500 text-sm">{errors.lastName}</p>}
                        </div>

                        {/* Email */}
                        <div className="relative mb-4">
                            <label htmlFor="email" className="leading-7 text-sm text-gray-600">
                                Email
                            </label>
                            <input
                                type="email"
                                id="email"
                                name="email"
                                value={formData.email}
                                onChange={handleChange}
                                className="w-full bg-[#f5f5f5] rounded-lg border border-gray-300 focus:border-[#008080] focus:ring-2 focus:ring-[#008080] text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                            />
                            {errors.email && <p className="text-red-500 text-sm">{errors.email}</p>}
                        </div>

                        {/* Password */}
                        <div className="relative mb-4">
                            <label htmlFor="password" className="leading-7 text-sm text-gray-600">
                                Password
                            </label>
                            <input
                                type={showPassword ? "text" : "password"}
                                id="password"
                                name="password"
                                value={formData.password}
                                onChange={handleChange}
                                className="w-full bg-[#f5f5f5] rounded-lg border border-gray-300 focus:border-[#008080] focus:ring-2 focus:ring-[#008080] text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                            />
                            {errors.password && <p className="text-red-500 text-sm">{errors.password}</p>}
                        </div>

                        {/* Confirm Password */}
                        <div className="relative mb-4">
                            <label htmlFor="confirmation" className="leading-7 text-sm text-gray-600">
                                Confirm Password
                            </label>
                            <input
                                type="password"
                                id="confirmation"
                                name="confirmation"
                                value={formData.confirmation}
                                onChange={handleChange}
                                className="w-full bg-[#f5f5f5] rounded-lg border border-gray-300 focus:border-[#008080] focus:ring-2 focus:ring-[#008080] text-base outline-none text-gray-700 py-1 px-3 leading-8 transition-colors duration-200 ease-in-out"
                            />
                            {errors.confirmation && (
                                <p className="text-red-500 text-sm">{errors.confirmation}</p>
                            )}
                        </div>

                        <button
                            onClick={handleSubmit}
                            className="text-white bg-[#008080] border-0 py-2 px-8 focus:outline-none hover:bg-[#007272] rounded text-lg"
                        >
                            Register
                        </button>

                        <p className="text-xs text-gray-500 mt-3">
                            Returning user?{" "}
                            <a href="#" className="text-[#008080]">
                                <Link to="/Login"><a href="#">Log in here</a></Link>
                            </a>
                        </p>
                    </div>

                    {/* Right Side: Info Section */}
                    <div className="lg:w-2/5 md:w-1/2 md:pl-16 lg:pl-0 pl-0 flex flex-col items-center mx-auto">
                        <img src={logo} alt="HealthLink Logo" className="w-1/2 mb-8" />
                        <ul className="text-lg text-gray-600 leading-relaxed mt-4">
                            <li className="flex mb-2">
                                <img src={icon1} alt="Appointment Icon" className="mr-2 w-7 h-7" />
                                Book Appointments Easily: Schedule appointments with trusted doctors from home.
                            </li>
                            <li className="flex mb-2">
                                <img src={icon2} alt="Appointment Icon" className="mr-2 w-7 h-7" />
                                Access Medical Advice Anytime: Consult doctors via video call and receive timely
                                prescriptions.
                            </li>
                            <li className="flex">
                                <img src={icon3} alt="Appointment Icon" className="mr-2 w-7 h-7" />
                                Stay Informed: Get notifications for upcoming appointments and prescription
                                reminders.
                            </li>
                        </ul>
                    </div>
                </div>
            </section>
        </div>
    );
}

export default PatientSignup;
