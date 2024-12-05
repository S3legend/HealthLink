import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import AppointmentPage from "./pages/AppointmentPage";
import PatientProfilePage from "./pages/PatientProfilePage";
import DashboardPatient from "./pages/DashboardPatient";
function App() {
  return (
    <Router>
      <Routes>
        {/* Define the route for the appointment page */}
        <Route path="/appointments" element={<AppointmentPage />} />
        <Route path="/profile" element={<PatientProfilePage />} />
          <Route path="/dashboard" element={<DashboardPatient />} />
      </Routes>
    </Router>
  );
}

export default App;
