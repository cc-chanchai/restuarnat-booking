import React, { Component } from 'react'
import SockJsClient from 'react-stomp';
import { Navbar, FormControl, Button, Table, InputGroup} from 'react-bootstrap';


class Customer extends Component {
  state = {
    
  }
  
  componentDidMount(){
    fetch('http://localhost:8080/api/bookings')
      .then(response => response.json())
        .then(data => this.setState(data))
  }
  render() {
    const elements = ['one', 'two', 'three', 'four'];
    return (
      <div>
        {/* <SockJsClient url='http://localhost:8080/socket' topics={['/topic/messages']}
          onMessage={(msg) => { console.log(msg); }}
          ref={(client) => { this.clientRef = client }} /> */}

        <Navbar bg="dark" variant="dark" className="mb-4">
          <Navbar.Brand>Restaurant Booking</Navbar.Brand>
        </Navbar>

        <div className="container" style={{ width: "600px"}}>
          <ul>
            {elements.map((value, index) => {
              return <Button key="index" className="mr-2">{value}</Button>
            })}
          </ul>
          <div className="mb-3">
              <p>จำนวนโต๊ะว่าง : {this.state.activeTable} </p>
              <p>จำนวนคิวที่รอ : {this.state.queue}</p>
              
          </div>
          <Button className="mr-4" variant="outline-secondary" >Booking</Button>
        </div>
      </div>
    )
  }
}
  
export default Customer;
