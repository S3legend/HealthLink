import React from 'react';

const PatientInfo = ({ patient }) => {
    return (
        <div className="patient-info">
            <h2>Patient Information</h2>
            <p><strong>Name:</strong> {patient.firstName} {patient.lastName}</p>
            <p><strong>Email:</strong> {patient.email}</p>
            <p><strong>Phone:</strong> {patient.phone}</p>
            <p><strong>Address:</strong> {patient.address}</p>
            <p><strong>City:</strong> {patient.city}</p>
            <p><strong>Country:</strong> {patient.country}</p>
        </div>
    );
};

export default PatientInfo;
