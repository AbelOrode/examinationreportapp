import {Component} from "react";

import axios from "axios";
import {Accordion, Card, Container, Button, Form} from "react-bootstrap";
import React from "react";

class Login extends React.Component {


    constructor(props) {
        super(props);
        // this.Student={ username:' ',password:' '}
        this.onChange = this.onChange.bind(this);
        this.adminLogin= this.adminLogin.bind(this);

        this.state={adminUsername:'',adminPassword:''}




    }

    adminLogin(){
        const url= "http://localhost:8080/";
        localStorage.removeItem("user");
        const username= this.state.adminUsername;
        const password= this.state.adminPassword;
        return axios
            .post(url +"users/authenticate",{
                username,
                password
            }).then(response=>{
                if(response.data.token){
                    localStorage.setItem("user",JSON.stringify(response.data));
                    if(response.data.role==="ADMIN"){
                       // alert("Success admin login")
                        this.props.history.push("/adminHomePage");window.location.reload();
                    }
                    else{
                        alert("You are a user with different role")
                    }

                }

            },error=>{
                const  resMessage= (error.response && error.response.data
                    && error.response.data.message) || error.message||error.toString();
                console.log(resMessage);
            })


    }

    onChange(event) {
        this.setState(
            {
                [event.target.name]: event.target.value
            }
        )
    }

    render() {

        return (
            <div>

                <Accordion defaultActiveKey="0">
                    <Card>
                        <Card.Header className={"mb-3"}>
                            <Accordion.Toggle as={Button} variant="link" eventKey="0">
                                Admin Login
                            </Accordion.Toggle>
                        </Card.Header>
                        <Accordion.Collapse eventKey="0">
                            <Card.Body>
                                <div className="container">
                                    <form >
                                        <div className={"col-12"}>
                                            <div className={"row"}>
                                                <div className={"col-sm-4"}>
                                                    <div className={"form-group"}>
                                                        <input type={"text"} className={"form-control"}
                                                               placeholder={"Username"}  onChange={this.onChange} value={this.state.adminUsername} name="adminUsername"/>
                                                    </div>
                                                </div>
                                                <div className={"col-sm-4"}>
                                                    <input type={"password"} className={"form-control"}
                                                           placeholder={"Password"} onChange={this.onChange} value={this.state.adminPassword} name="adminPassword"/>
                                                </div>
                                                <div className={"col-sm-4"}>
                                                    <button  className="btn btn-primary col-sm-6" onClick={this.adminLogin}>Login</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                    <Card>
                        <Card.Header className={"mb-3"}>
                            <Accordion.Toggle as={Button} variant="link" eventKey="1">
                                Lecturer Login
                            </Accordion.Toggle>
                        </Card.Header>
                        <Accordion.Collapse eventKey="1">
                            <Card.Body>
                                <div className="container">
                                    <form>
                                        <div className={"col-12"}>
                                            <div className={"row"}>
                                                <div className={"col-sm-4"}>
                                                    <div className={"form-group"}>
                                                        <input type={"text"} className={"form-control"}
                                                               placeholder={"Username"}/>
                                                    </div>
                                                </div>
                                                <div className={"col-sm-4"}>
                                                    <input type={"password"} className={"form-control"}
                                                           placeholder={"Password"}/>
                                                </div>
                                                <div className={"col-sm-4"}>
                                                    <button className="btn btn-secondary col-sm-6">Login</button>
                                                </div>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                    <Card>
                        <Card.Header className={"mb-3"}>
                            <Accordion.Toggle as={Button} variant="link" eventKey="2">
                                Student Login
                            </Accordion.Toggle>
                        </Card.Header>
                        <Accordion.Collapse eventKey="2">
                            <Card.Body>
                                <div className="container">
                                    <form>
                                        <div className={"col-12"}>
                                            <div className={"row"}>
                                                <div className={"col-sm-4"}>
                                                    <div className={"form-group"}>
                                                        <input type={"text"} className={"form-control"}
                                                               placeholder={"Username"}/>
                                                    </div>
                                                </div>
                                                <div className={"col-sm-4"}>
                                                    <input type={"password"} className={"form-control"}
                                                           placeholder={"Password"}/>
                                                </div>
                                                <div className={"col-sm-4"}>
                                                    <button className="btn btn-warning col-sm-6">Login</button>
                                                </div>
                                            </div>

                                        </div>
                                    </form>
                                </div>
                            </Card.Body>
                        </Accordion.Collapse>
                    </Card>
                </Accordion>

            </div>
        );

    }


}

export default Login;