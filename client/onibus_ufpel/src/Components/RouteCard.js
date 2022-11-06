import React, { useState } from "react";
import {useHistory} from "react-router-dom";

function RouteCard() {
  const [buses] = useState([
    {
      route: "Anglo - Capão",
      nextStop: "Parada XV",
      estimatedArrival: "07:34"
    },
    {
      route: "Anglo - Capão",
      nextStop: "Parada XV",
      estimatedArrival: "07:34"
    },
    {
      route: "Anglo - Capão",
      nextStop: "Parada XV",
      estimatedArrival: "07:34"
    },
    {
      route: "Anglo - Capão",
      nextStop: "Parada XV",
      estimatedArrival: "07:34"
    },
    {
      route: "Anglo - Capão",
      nextStop: "Parada XV",
      estimatedArrival: "07:34"
    },
  ]);

  let history = useHistory ();

  return (
    <div>
      <section>
        <div className="container">
          <h1>Responsive Cards</h1>
          <div className="cards">
            {buses.map((bus,  i) => (
              <div key={i} className="card">
                <h3 className="card-text"><b>{bus.route}</b></h3>
                <p className="card-text"><b>À caminho: </b>{bus.nextStop}</p>
                <p className="card-text"><b>Horário de chegada estimado: </b>{bus.estimatedArrival}</p>
              <button onClick={() => {
                history.push('/institucional');
                history.go();
              }} className="btn">Visualizar em tempo real</button>
            </div>
            ))}
          </div>
        </div>
      </section>
    </div>

  );
}
export default RouteCard;