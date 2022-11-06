import React from "react";
import Home from "./Pages/Home";
import Institutional from "./Pages/Institutional";
import Support from "./Pages/Support";
import Navbar from "./Components/Navbar"
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";

function App() {
  return(
    <div>
      <Navbar></Navbar>
      <Router>
        <Switch>
          <Route exact path="/" component={Home} />
          <Route exact path="/institucional" component={Institutional} />
          <Route exact path="/suporte" component={Support} />
        </Switch>
      </Router>
    </div>
  )
}
export default App;