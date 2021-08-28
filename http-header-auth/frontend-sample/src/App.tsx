import React from 'react';
import './App.scss';
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Home from "./page/Home";
import Page1 from "./page/Page1";
import Page2 from "./page/Page2";

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/">
          <Home />
        </Route>
        <Route exact path="/page1">
          <Page1 />
        </Route>
        <Route exact path="/page2">
          <Page2 />
        </Route>
      </Switch>
    </Router>
  );
}

export default App;
