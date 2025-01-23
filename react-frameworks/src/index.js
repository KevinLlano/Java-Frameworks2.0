// Import necessary modules and components
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';

import reportWebVitals from './reportWebVitals';
import { BrowserRouter as Router } from 'react-router-dom';

// Create a root element for rendering the React app
const root = ReactDOM.createRoot(document.getElementById('root'));

// Render the App component wrapped in Router and StrictMode
root.render(
  <React.StrictMode>
    <Router>
      <App />
    </Router>
  </React.StrictMode>
);

// Measuring app performance for Browser
reportWebVitals();
