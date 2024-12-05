import React, { useEffect, useState } from 'react';
import axios from 'axios';
import PatientInfo from '../components/PatientInfo';
import MedicalRecords from '../components/MedicalRecords';
import '../styles/PatientDashboard.css'; // Import the CSS file for styling

const PatientDashboard = () => {
    const [patient, setPatient] = useState(null);
    const [medicalRecords, setMedicalRecords] = useState([]);

    useEffect(() => {
        const fetchPatientInfo = async () => {
            const response = await axios.get('http://localhost:8080/api/patients/2'); // replace with actual patient ID
            setPatient(response.data);
        };

        const fetchMedicalRecords = async () => {
            const response = await axios.get('http://localhost:8080/api/medical-records/patient/2'); // replace with actual patient ID
            setMedicalRecords(response.data);
        };

        fetchPatientInfo();
        fetchMedicalRecords();
    }, []);

    return (
        <div className="patient-dashboard">
            <div className="patient-info-container">
                {patient && <PatientInfo patient={patient} />}
            </div>

            <div className="medical-records-container">
                {medicalRecords && <MedicalRecords records={medicalRecords} />}
            </div>
        </div>
    );
};

export default PatientDashboard;
