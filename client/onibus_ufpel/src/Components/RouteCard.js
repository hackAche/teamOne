import React from "react";
import { useHistory } from "react-router-dom";

function RouteCard({bus}) {
  let history = useHistory();

  return (
    <div>
      <div className="card">
        <h3 className="card-text"><b>{bus.rota.nome}</b></h3>
        <p className="card-text"><b>À caminho: </b>{bus.proximaParada.ponto.nome}</p>
        <p className="card-text"><b>Horário de chegada estimado: </b>07:43</p>
        <button onClick={() => {
          history.push('/mapa');
          history.go();
        }} className="btn">Visualizar em tempo real</button>
      </div>
    </div>

  );
}
export default RouteCard;