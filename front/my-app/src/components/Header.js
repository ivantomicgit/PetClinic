import React, { useState } from 'react';
import {Nav, NavItem, Dropdown, DropdownItem, DropdownToggle, DropdownMenu, NavLink } from 'reactstrap';
import { NavLink as RRNavLink } from 'react-router-dom';


const Header = (props) =>{

  const [dropdownOpen, setDropdownOpen] = useState(false);

  const toggle = () => setDropdownOpen(!dropdownOpen);

  return (
    <div>
      <Nav Nav className="justify-content-center" tabs >
        <NavItem>
        <NavLink to="/" activeClassName="active" tag={RRNavLink}>Welcome</NavLink> 
          {/* <NavLink href="/" >Welcome</NavLink> */}
        </NavItem>
        {/* <Dropdown nav isOpen={dropdownOpen} toggle={toggle}>
          <DropdownToggle nav caret>
            Dropdown
          </DropdownToggle>
          <DropdownMenu>
            <DropdownItem header>Header</DropdownItem>
            <DropdownItem disabled>Action</DropdownItem>
            <DropdownItem>Another Action</DropdownItem>
            <DropdownItem divider />
            <DropdownItem>Another Action</DropdownItem>
          </DropdownMenu>
        </Dropdown> */}
        <NavItem>
        <NavLink to="/vlasnik" activeClassName="active" tag={RRNavLink}>Vlasnici</NavLink> 
          {/* <NavLink href="/vlasnik">Vlasnici</NavLink> */}
        </NavItem>
        <NavItem>
        <NavLink to="/ljubimac" activeClassName="active" tag={RRNavLink}>Ljubimci</NavLink> 
          {/* <NavLink href="/ljubimac">Ljubimci</NavLink> */}
        </NavItem>
        <NavItem>
        <NavLink to="/poseta" activeClassName="active" tag={RRNavLink}>Poseta</NavLink> 
          {/* <NavLink disabled href="#">Disabled Link</NavLink> */}
        </NavItem>
      </Nav>
    </div>
    );
  }
  export default Header;
