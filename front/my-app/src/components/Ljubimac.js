import React, { Component } from "react";
import axios from "axios";
import {
  Table,
} from "reactstrap";

class Ljubimac extends Component {
  constructor(props) {
    super(props);
    this.state = {
      lsitaLjubimaca: [],
      ljubimac: {
        ime: "",
       
      },
    };
  }
  componentDidMount() {
    this.inicijalizacijaVrednosti();
  }

  inicijalizacijaVrednosti() {
    axios
      .get("http://localhost:8080/api/ljubimac/listLjubimaca")
      .then((response) => {
        this.setState({
          lsitaLjubimaca: response.data,
        
        });
      })
      .catch((err) => {});
      console.log(this.state.lsitaLjubimaca)
  }
  render() {
    let sviLjubimci = this.state.lsitaLjubimaca.map((ljubimac) => (
      <tr>
        <td>{ljubimac.id}</td>
        <td>{ljubimac.ime}</td>
      </tr>
    ));
    return (
      <div>
        <Table>
          <thead>
            <tr>
              <th>ID</th>
              <th>Ime</th>
            </tr>
          </thead>
          <tbody>{sviLjubimci}</tbody>
        </Table>
      </div>
    );
  }
}
export default Ljubimac;
