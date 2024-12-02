import React from 'react';
import Header from './Header';
import Sidebar from './sidebar';
import MainContent from './maincontent';
import './App.css';

const App = () => {
  return (
      <div className="app">
        <Header />
        <div className="layout">
          <Sidebar />
          <MainContent />
        </div>
      </div>
  );
};

export default App;
