import React, { Component }  from 'react';
import './App.css';
import { BrowserRouter as Router, HashRouter, Route, Routes } from 'react-router-dom';
import Admin from "./components/Admin";
import Login from "./components/Login";
import Home from "./components/Home";
import Customer from "./components/Customer";
import Register from "./components/Register";



function App() {
    return (
        <Router>
            <Routes>
                <Route path="/admin/*" element={<Admin/>}/>
                <Route path="/customer/*" element={<Customer/>}/>
                <Route path="/" element={<Home/>}>
                    <Route path="login" element={<Login/>}/>
                    <Route path="customer/register" element={<Register/>}/>
                </Route>

            </Routes>
        </Router>
    );
}

export default App;
