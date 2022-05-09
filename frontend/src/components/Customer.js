import React from "react";
import {Route, Routes } from 'react-router-dom';
import CustomerHome from './Customer/CustomerHome';
import ViewRestaurants from './Customer/ViewRestaurants';
import CustomerViewMenu from "./Customer/CustomerViewMenu";

function Customer() {
    return (
        <Routes>
            <Route path="/" element={<CustomerHome/>}>
                <Route path="viewRestaurants" element={<ViewRestaurants/>}/>
                <Route path="viewMenu" element={<CustomerViewMenu/>}/>
            </Route>
        </Routes>
    );
}

export default Customer;