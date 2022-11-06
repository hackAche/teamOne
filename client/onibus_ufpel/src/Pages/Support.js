import React from "react";
import Navbar from "../Components/Navbar";

function Support() {
  return (
    <div>
      <section>
        <div className="container">
          <h1>Suporte</h1>
          <div className="cards">
            <div className="card">
              <h3 className="support-text"><b>Entre em Contato</b></h3>
              <p className="support-text"><b>E-mail: </b>ashdhadsa@inf.ufpel.edu.br</p>
              <p className="support-text"><b>Telefone: </b>(51) 99999-9999</p>
              <button className="btn">Visualizar em tempo real</button>
            </div>
          </div>
        </div>
      </section>
    </div>
  )
}
export default Support;