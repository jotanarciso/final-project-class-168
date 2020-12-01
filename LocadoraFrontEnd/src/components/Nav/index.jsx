import React from "react";
import DevolverVeiculo from "@components/DevolverVeiculo";
import HistoricoVeiculos from "@components/HistoricoVeiculos";
function Nav(props) {
  return (
    <nav className="navbar navbar-expand-lg navbar-light bg-light">
      <div className="container">
        <a className="navbar-brand" href="#">
          {props.title}
        </a>
        <button
          className="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav ml-auto">
            <li className="nav-item">
              <DevolverVeiculo />
            </li>
            <li className="nav-item">
              <HistoricoVeiculos />
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
}

export default Nav;
