import React, { useEffect, useState } from "react";
import API from "./../Services/api";
import L from 'leaflet';

function ShowMap() {
    const [count, setCount] = useState(0);
    const [bus, setBus] = useState();

    // request
    useEffect(() => {
        try {
            API
                .get("/onibus/1")
                .then((res) => {
                    if (!res.data.ativo) {
                        setBus(bus);
                    }

                    setTimeout(() => setBus(res.data), 2000);
                })
                .catch((err) => {
                    console.log(err);
                })
        } catch (err) {
            setBus(bus);
        }
    });

    // map
    useEffect(() => {
        console.log(bus);
        let container = L.DomUtil.get('map');
        if (container != null) {
            container._leaflet_id = null;
        }
        let map = L.map('map').setView([-31.773356, -52.343319], 12);

        L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
            maxZoom: 19,
            attribution: '&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>'
        }).addTo(map);

        const busMarkerIcon = L.icon({
            iconUrl: 'https://cdn-icons-png.flaticon.com/512/3774/3774090.png',
            iconSize: [40, 40], // size of the icon
            iconAnchor: [20, 20], // point of the icon which will correspond to marker's location
        });

        L.circle([-31.773356, -52.343319], {
            color: 'cyan',
            fillColor: 'cyan',
            fillOpacity: 0.5,
            radius: 100
        }).addTo(map);

        L.marker([-31.773356, -52.343319]).addTo(map);
        L.marker([-31.772851, -52.348393]).addTo(map);
        L.marker([-31.762406, -52.358084]).addTo(map);
        L.marker([-31.760198, -52.362177]).addTo(map);
        L.marker([-31.762734, -52.418920]).addTo(map);
        L.marker([-31.797449, -52.407675]).addTo(map);


        if (!bus) return;
        //console.log(bus.localizacao.y);
        L.marker([bus.localizacao.x, bus.localizacao.y], { icon: busMarkerIcon }).addTo(map);
    });

    return (
        <div id="map">

        </div>
    )
}
export default ShowMap;