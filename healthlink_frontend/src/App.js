import React from "react"
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import "./App.css";
import Layout from "./Components/Layout";
import Home from "./Pages/Home";
import NotFound from "./Pages/NotFound";

function App() {
  return (

      <Router>
        <Layout>
        <div>
          <Routes>

            <Route path="/" element={<Home />} />
            <Route path="*" element={<NotFound />} />


            
          </Routes>
        </div>
        </Layout>
      </Router>
  )
}

export default App;
