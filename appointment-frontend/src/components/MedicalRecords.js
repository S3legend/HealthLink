import React from 'react';

const MedicalRecords = ({ records }) => {
    return (
        <div className="medical-records">
            <h2>Medical Records</h2>
            <ul>
                {records.map(record => (
                    <li key={record.id}>
                        <p><strong>Record Date:</strong> {new Date(record.recordDate).toLocaleString()}</p>
                        <p><strong>Details:</strong> {record.details}</p>
                        <p><strong>Doctor:</strong> Dr. {record.doctorName}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default MedicalRecords;
