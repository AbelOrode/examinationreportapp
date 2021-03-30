import logo from './logo.svg';
import './App.css';

import {BrowserRouter as Router,Switch,Route,Link} from "react-router-dom";


import {Component} from "react";

import Login from './components/Login'
import {Container} from "react-bootstrap";
import React from "react";
import './App.css';
import AdminHomePage from "./components/AdminHomePage";


class App extends Component {


 // onChange(event){
 //        this.setState(
 //            {
 //                [event.target.name]:event.target.value
 //            }
 //        )
 //    }

    render() {


        return (
            <div className="App">
                <Router>
                    <div className={"mb-4"}></div>
                    <div className={"mb-4"}></div>
                    <div className={"mb-4"}></div>
                    <div className={"mb-4"}></div>
                    <div className={"mb-4"}></div>
                    <div className={"mb-4"}></div>
                    <div className={"mb-4"}></div>
                    <div className={"mb-4"}></div>

                    <Container>
                        <h2 className={"mb-5"}>EXAMINATION REPORT SYSTEM</h2>

                        <div className={"mb-4"}></div>
                        <div className={"mb-4"}></div>
                        <div className={"mb-4"}></div>
                        <div className={"mb-4"}></div>
                        <Switch>
                            <Route exact path={"/"} component={Login}>
                            </Route>
                            <Route  exact path={"/adminHomePage"} component={AdminHomePage}/>
                        </Switch>

                    </Container>
                </Router>
            </div>
        );
    }
}

export default App;
