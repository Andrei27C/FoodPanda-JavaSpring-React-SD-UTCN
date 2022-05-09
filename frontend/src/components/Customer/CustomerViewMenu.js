import React, { useState, useEffect } from "react";
import {Card, Table, Button, Modal, ListGroup, ListGroupItem} from "react-bootstrap";
import "../../css/FormStyle.css";
import axios from "axios";
import Dropdown from "bootstrap/js/src/dropdown";
import { CardBody } from "reactstrap";

function ViewAllMenus() {
    const [restaurants, setRestaurants] = useState(JSON.parse(localStorage.getItem("restaurants")));
    const [foodCategories, setFoodCategories] = useState(JSON.parse(localStorage.getItem("foodCategories")));
    const [foods, setFoods] = useState([]);

    useEffect(() => {
        axios
            .get('http://localhost:8080/test/customer/viewMenu')
            .then(response => {
                setFoods(response.data);
            });
    }, []);

    return (
        <div key="initial" className="TableStyle">
            <br/>
            <div>
                {
                    foodCategories.map(category => {
                        return (
                            <div key={category.name}>
                                <Card className="CardStyle">
                                    <Card.Body>{category.name}</Card.Body>
                                </Card>
                                <Table striped bordered hover key={category.name}>
                                    <thead>
                                    <tr>
                                        <th>Food Name</th>
                                        <th>Description</th>
                                        <th>Price</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {foods.map(food => {
                                        if (food.category.name === category.name) {
                                            return (
                                                <tr key={food.name}>
                                                    <td key={food.name}>{food.name}</td>
                                                    <td key={food.description}>{food.description}</td>
                                                    <td key={food.price}>{food.price + " RON"}</td>
                                                </tr>
                                            );
                                        }
                                    })}
                                    </tbody>
                                </Table>
                                <br/>
                                <br/>
                            </div>
                        );
                    })
                }
            </div>
        </div>
    );
}

export default ViewAllMenus;