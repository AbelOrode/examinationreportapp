import React from "react";
import {Container, Navbar} from "react-bootstrap";

class AdminHomePage extends  React.Component{


    render(){
        return (

            <Navbar expand="lg" variant="light" bg="light">
                <Container>
                    <Navbar.Brand href="#">Navbar</Navbar.Brand>
                </Container>
            </Navbar>

        )
    }

}

export default AdminHomePage;