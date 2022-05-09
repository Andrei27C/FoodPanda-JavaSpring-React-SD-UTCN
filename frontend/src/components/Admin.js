import React from "react";
import {Route, Routes } from 'react-router-dom';
import AdminHome from './Admin/AdminHome';
import ViewMenu from './Admin/ViewMenu';
import CreateMenu from "./Admin/CreateMenu";
import AddRestaurant from "./Admin/AddRestaurant";

function Admin() {
    return (
        <Routes>
            <Route path="/" element={<AdminHome/>}>
                <Route path="viewMenu" element={<ViewMenu/>}/>
                <Route path="addFood" element={<CreateMenu/>}/>
                <Route path="addRestaurant" element={<AddRestaurant/>}/>
            </Route>
        </Routes>
    );
}

export default Admin;