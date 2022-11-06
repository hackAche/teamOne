import React, { useEffect, useState } from "react";
import API from "./../Services/api";
import RouteCard from "../Components/RouteCard";

function Home() {

  const [lastStop, setLastStop] = useState();
  const [bus, setBus] = useState();

  // request
  useEffect(() => {
    API
      .get("/onibus/1")
      .then((res) => {
        if (!res.data.ativo || !res.data.proximaParada || res.data.proximaParada == lastStop) return;
        setTimeout(() => {
          setLastStop(res.data.proximaParada);
          setBus(res.data);
        }, 2000);
      })
      .catch((err) => {
        console.log(err);
      })
  });

  return (
    <div>
      <section>
        <div className="container">
          <h1>Home</h1>
          <div className="cards"> 
          </div>
        </div>
      </section>
    </div>
  )
}
export default Home;