import React from "react"
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import "./App.css";
import Navbar  from "./Components/Navbar";
import Home from "./Pages/Home";
import RegisterDoc from "./components/RegisterDoc";

function App() {
  return (

      <Router>
        <div>
          <Routes>

            <Route path="/" element={<Home />} />

            <RegisterDoc />
            
          </Routes>
        </div>
      </Router>
  )
}

export default App;
