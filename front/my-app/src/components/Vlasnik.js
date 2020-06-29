import React, { Component } from "react";
import axios from 'axios';
import { Table, Button, Modal, ModalHeader, ModalBody, ModalFooter, FormGroup, Label, Input,  } from 'reactstrap';
import { BrowserRouter, Route, Link } from "react-router-dom";
import JedanVlasnik from './JedanVlasnik';

class Vlasnik extends Component {
  constructor(props) {
    super(props);
    this.state = {
      lsitaVlasnika: [],
      noviVlasnik: {
        ime: "",
        prezime: "",
        email: "", 
        ljubimci: []
      },
      
      editVlasnik: {
        id: "",
        ime: "",
        prezime: "",
        email: ""
      },
      modal : false,
      editVlasnikModal: false,
      jedanVlasnikbool: false
    }
    this.toggleForCreating = this.toggleForCreating.bind(this);
    this.toggleForUpdate = this.toggleForUpdate.bind(this);
    // this.handleChange = this.handleChange.bind(this)
  }

  toggleForCreating() {
    this.setState(prevState => ({
        modal: !prevState.modal
    }));
  }

  toggleForUpdate(){
    this.setState({
      editVlasnikModal: !this.state.editVlasnikModal
    });
  }

  componentDidMount(){
    this.inicijalizacijaVrednosti();
 }

  inicijalizacijaVrednosti(){
    axios.get('http://localhost:8080/api/vlasnik/listaVlasnika').then((response) => {
    
        this.setState({
          lsitaVlasnika : response.data
        })
        }).catch((err) => {

        });
}
// ZA CREATE
setovanjeImenaUstejtu = (event) =>{
  let {noviVlasnik} = this.state;
  noviVlasnik.ime = event.target.value;
   this.setState({
    noviVlasnik
   })
}

setovanjePrezimenaUstejtu = (event) =>{
let {noviVlasnik} = this.state;
noviVlasnik.prezime = event.target.value;
this.setState({
  noviVlasnik
})
}

setovanjeEmailaUstejtu = (event) =>{
let {noviVlasnik} = this.state;
noviVlasnik.email = event.target.value;
this.setState({
  noviVlasnik
})
}


upisiVlasnika = (event) => {
  axios.post('http://localhost:8080/api/vlasnik/create', this.state.noviVlasnik).then((response)=>{
      let{lsitaVlasnika} = this.state;
      lsitaVlasnika.push(response.data)
      this.setState({
        lsitaVlasnika,
        noviVlasnik : {
          ime : '',
          prezime : '',
          email : ''
          },
          modal : false
      })
  })
 }

 updateVlasnika = (id, ime, prezime, email)=>{
  console.log(ime);
  this.setState({
      editVlasnik : {id, ime, prezime, email},
      editVlasnikModal : !this.setState.editVlasnikModal
  })
}
// ZA UPDATE
setovanjeImenaUstejtu1 = (event) =>{
  let {editVlasnik} = this.state;
  editVlasnik.ime = event.target.value;
   this.setState({
    editVlasnik
   })
}

setovanjePrezimenaUstejtu1 = (event) =>{
let {editVlasnik} = this.state;
editVlasnik.prezime = event.target.value;
this.setState({
  editVlasnik
})
}

setovanjeEmailaUstejtu1 = (event) =>{
let {editVlasnik} = this.state;
editVlasnik.email = event.target.value;
this.setState({
  editVlasnik
})
}
updateVlasnikBaza = (event)=>{
  let {id, ime, prezime, email} = this.state.editVlasnik;
  axios.put('http://localhost:8080/api/vlasnik/update/vlasnik/'+id, {
      id, ime, prezime, email
  }).then((response) => {
      console.log(response.data);
      this.toggleForUpdate();
      this.inicijalizacijaVrednosti();
  })
}

 deleteVlasnika = (id) => {
  console.log(id);
  axios.delete('http://localhost:8080/api/vlasnik/delete/'+id).then((response)=>{
      let {lsitaVlasnika} = this.state;
  //    let index = kupci.findIndex(this.isLarge);
      let index = lsitaVlasnika.findIndex((temp)=> {
          if(temp.id===id){      
          return  id;
      }
      });
      console.log(index);    
      lsitaVlasnika.splice(index, 1);
      this.setState({
        lsitaVlasnika
      })
  })  
}

handleChange=(la)=>{
  console.log(la);
  axios.get('http://localhost:8080/api/vlasnik/read/vlasnik/'+la).then((response) => {
    
        this.setState({
          noviVlasnik : response.data
        })
        }).catch((err) => {

        });
  // this.setState({
  //   noviVlasnik : {
  //     ime : 'Ivan',
  //     prezime : 'Tomic',
  //     email : 'sas'
  //     }
  // })
};


  render() {
      
    // let samoVlasnik = <JedanVlasnik id = {this.handleChange.id}/>
    let sviVlasnici = this.state.lsitaVlasnika.map(vlasnik => <JedanVlasnik vlasnik = {vlasnik} handleChange={this.handleChange}  deleteVlasnika={this.deleteVlasnika}/>)
    
     
    //   return (    
    //   <tr>
    //      <td>{vlasnik.id}</td>
    //      <td>{vlasnik.ime}</td>
    //      <td>{vlasnik.prezime}</td>
    //      <td>{vlasnik.email}</td>
    //      <td><Button color="primary" onClick={this.updateVlasnika.bind(this, vlasnik.id, vlasnik.ime, vlasnik.prezime, vlasnik.email )}>Update</Button></td>
    //      <td><Button color="danger" onClick={this.deleteVlasnika.bind(this, vlasnik.id)}>Delete</Button></td>
        
    //      <Button color="info" onClick={this.handleChange.bind(this, vlasnik.id)}>View</Button>
       
    //      {/* <td><Button color="info" onClick={this.deleteVlasnika.bind(this, vlasnik.id)}>View</Button></td> */}
    //     </tr>
        
    //     )
    // })

    return (
      <div>
        <Button color="primary" onClick={this.toggleForCreating}>
          Insert
        </Button>
        {/* CREATE */
        /* CREATE */
        /* CREATE */
        /* CREATE */}
        <Modal
          isOpen={this.state.modal}
          toggle={this.toggleForCreating}
          className={this.props.className}
        >
          <ModalHeader toggle={this.toggleForCreating}></ModalHeader>
          <ModalBody>
            <FormGroup>
              <Label for="exampleEmail">Ime</Label>
              <Input
                id="ime"
                value={this.state.value}
                onChange={this.setovanjeImenaUstejtu}
                placeholder="unesite ime"
              />
              <Label for="exampleEmail">Prezime</Label>
              <Input
                id="prezime"
                value={this.state.value}
                onChange={this.setovanjePrezimenaUstejtu}
                placeholder="unesite prezime"
              />
              <Label for="exampleEmail">Email</Label>
              <Input
                id="email"
                value={this.state.value}
                onChange={this.setovanjeEmailaUstejtu}
                placeholder="unesite email"
              />
            </FormGroup>
          </ModalBody>
          <ModalFooter>
            <Button color="primary" onClick={this.upisiVlasnika}>
              Dodaj Vlasnika
            </Button>{" "}
            <Button color="secondary" onClick={this.toggleForCreating}>
              Cancel
            </Button>
          </ModalFooter>
        </Modal>

        {/* UPADATE */
        /* UPADATE */
        /* UPADATE */
        /* UPADATE */}
        <Modal
          isOpen={this.state.editVlasnikModal}
          toggle={this.toggleForUpdate.bind(this)}
          className={this.props.className}
        >
          <ModalHeader toggle={this.toggleForUpdate.bind(this)}></ModalHeader>
          <ModalBody>
            <FormGroup>
              <Label for="exampleEmail">Ime</Label>
              <Input
                id="ime"
                value={this.state.editVlasnik.ime}
                onChange={this.setovanjeImenaUstejtu1}
              />
              <Label for="exampleEmail">Prezime</Label>
              <Input
                id="prezime"
                value={this.state.editVlasnik.prezime}
                onChange={this.setovanjePrezimenaUstejtu1}
                placeholder="unesite prezime"
              />
              <Label for="exampleEmail">Email</Label>
              <Input
                id="email"
                value={this.state.editVlasnik.email}
                onChange={this.setovanjeEmailaUstejtu1}
                placeholder="unesite email"
              />
            </FormGroup>
          </ModalBody>
          <ModalFooter>
            <Button color="primary" onClick={this.updateVlasnikBaza.bind(this)}>
              Update
            </Button>{" "}
            <Button color="secondary" onClick={this.toggleForUpdate.bind(this)}>
              Cancel
            </Button>
          </ModalFooter>
        </Modal>
        <Table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Ime</th>
              <th>Prezime</th>
              <th>Email</th>
            </tr>
          </thead>
          <tbody>{sviVlasnici}</tbody>
        </Table>
        <h1>Vlasnik</h1>
        
        <Table>
        <tr>
          <td>{this.state.noviVlasnik.ime}</td>
          <td>fchfh</td>
          <td> {this.state.noviVlasnik.email}</td>
        <td>{this.state.noviVlasnik.ljubimci.map(ljubimac => <ul><li>{ljubimac.ime}</li></ul>)}</td>
        </tr>
        </Table>
        {/* { this.state.jedanVlasnikbool? this.handleChange : null} */}
        {/* {this.handleChange} */}
      </div>
    );
  }
}
export default Vlasnik;
