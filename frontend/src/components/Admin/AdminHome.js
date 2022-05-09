import React, {useState, useEffect} from 'react';
import { Container, Nav, Navbar } from 'react-bootstrap';
import {Outlet} from 'react-router-dom';
import axios from "axios";
 
export default function AdminHome() {

    axios
        .get('http://localhost:8080/test/admin/addFood')
        .then(response => {
            localStorage.setItem('foodCategories', JSON.stringify(response.data));
        });

    return (
        <div>
            <Navbar bg="dark" variant="dark" defaultActiveKey={"/login"}>
                <Container>
                    <Navbar.Brand href="/admin/addFood">Admin</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link disabled={JSON.parse(localStorage.getItem("user")).restaurant == null ? "disabled" : ""} href="/admin/addFood">Create Food</Nav.Link>
                        <Nav.Link disabled={JSON.parse(localStorage.getItem("user")).restaurant == null ? "disabled" : ""} href="/admin/viewMenu">View Menu</Nav.Link>
                        <Nav.Link disabled={JSON.parse(localStorage.getItem("user")).restaurant == null ? "disabled" : ""} href="/admin/addRestaurant">Add Restaurant</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
            <Outlet />
        </div>
    );
}