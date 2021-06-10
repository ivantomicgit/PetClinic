import React, { Component } from 'react';
import {  Button, } from 'reactstrap';

 class JedanVlasnik extends Component {
    
    render() {
        
        return (
            <tr>
                    <td>{this.props.vlasnik.id}</td>
                    <td>{this.props.vlasnik.ime}</td>
                    <td>{this.props.vlasnik.prezime}</td>
                    <td>{this.props.vlasnik.email}</td>
                    <td><Button color="danger" onClick={() => this.props.deleteVlasnika(this.props.vlasnik.id)}>Brisi</Button></td>
                   
                    <td><Button color="secondary" onClick={()=> this.props.handleChange(this.props.vlasnik.id)}>View</Button></td>
                   
                </tr>
        )
    }
}
export default JedanVlasnik
