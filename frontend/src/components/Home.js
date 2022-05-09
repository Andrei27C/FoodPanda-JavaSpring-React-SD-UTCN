import React from 'react';
import '../css/Home.css';
import { Container, Nav, Navbar, Card, NavLink } from 'react-bootstrap';
import {Outlet} from 'react-router-dom';
import axios from "axios";

export default function Home () {

    axios
        .get('http://localhost:8080/test/admin/addRestaurant')
        .then(response => {
            localStorage.setItem('zones', JSON.stringify(response.data));
        });

    return (
        <div>
            <Nav variant="tabs" defaultActiveKey={"/login"}>
                <Container>
                    <Navbar.Brand href="/">Food Panda</Navbar.Brand>
                    <Nav className="me-auto">
                        <Nav.Link href="/customer/register">Register</Nav.Link>
                        <Nav.Link href="/login">Log In</Nav.Link>
                    </Nav>
                </Container>
            </Nav>
            <Card className="Home">
                <Card.Body>Bine Ai Venit La Food Panda!</Card.Body>
            </Card>
            <Outlet />
        </div>
    );
}