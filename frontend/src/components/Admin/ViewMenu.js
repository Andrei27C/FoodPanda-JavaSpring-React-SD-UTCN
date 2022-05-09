import axios from "axios";
import React, { useState, useEffect } from "react";
import {Card, Table} from "react-bootstrap";
import "../../css/FormStyle.css";

function ViewMenu() {
    const [foods, setFoods] = useState([]);
    const [foodCategories, setFoodCategories] = useState(JSON.parse(localStorage.getItem("foodCategories")));

    useEffect(() => {
        console.log("asd1")
        axios
        .get('http://localhost:8080/test/admin/viewMenu', {
            params: {
                restaurantName: JSON.parse(localStorage.getItem("user")).restaurant.name
            }
        })
        .then(response => {
            console.log("asd2:"+response.data + localStorage.getItem("user").restaurantName);
            setFoods(response.data);
        });
    }, []);
    {/*//todo: ViewMenu Fa fain interfata*/}

    return (
        <div className="TableStyle">
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
                                if (food.category.name == category.name) {
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

export default ViewMenu;