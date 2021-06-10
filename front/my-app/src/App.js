import React from 'react';
import { BrowserRouter, Route, Link } from "react-router-dom";
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './components/Header'
import Vlasnik from './components/Vlasnik';
import Ljubimac from './components/Ljubimac';
import Poseta from './components/Poseta';
import Welcome from './components/Welcome';
import JedanVlasnik from './components/JedanVlasnik';

function App() {
  return (
    <div>
      <BrowserRouter>
        <div>
          <Header/>
         
          <Route path="/vlasnik" component={Vlasnik} />
          <Route path="/ljubimac" component={Ljubimac} />
          <Route path="/poseta" component={Poseta} />
          <Route path="/jedanVlasnik" component={JedanVlasnik} />
          <Route path="/" component={Welcome}  exact/>
        </div>
      </BrowserRouter>
     
    </div>
  );
}

export default App;
