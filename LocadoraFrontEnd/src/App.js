import React, { useState } from "react";
import swal from "sweetalert2";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import axios from "axios";
import Card from "@components/Card";
import Nav from "@components/Nav";
function App() {
  const [diaInicial, setDiaInicial] = useState();
  const [mesInicial, setMesInicial] = useState();
  const [anoInicial, setAnoInicial] = useState();

  const [diaFinal, setDiaFinal] = useState();
  const [mesFinal, setMesFinal] = useState();
  const [anoFinal, setAnoFinal] = useState();

  const [arCondicionado, setArCondicionado] = useState(false);
  const [direcaoHidraulica, setDirecaoHidraulica] = useState(false);
  const [cambioAutomatico, setCambioAutomatico] = useState(false);

  const [carros, setCarros] = useState([]);

  function handlePesquisarCarro() {
    const params = {};
    params["inicioLocacao.dia"] = diaInicial;
    params["inicioLocacao.mes"] = mesInicial;
    params["inicioLocacao.ano"] = anoInicial;
    params["fimLocacao.dia"] = diaFinal;
    params["fimLocacao.mes"] = mesFinal;
    params["fimLocacao.ano"] = anoFinal;
    params["arCondicionado"] = arCondicionado;
    params["cambio"] = cambioAutomatico;
    params["direcao"] = direcaoHidraulica;

    try {
      axios
        .get(`http://localhost:8080/locadora/carrosDisponiveis`, { params })
        .then((res) => {
          if (res.status === 200) {
            let conteudo = res.data;
            if (!conteudo) {
              swal.fire(
                "Sucess!",
                "Requisi\u00E7\u00E3o bem-sucedida, mas corpo da resposta " +
                  "n\u00E3o p\u00F4de ser interpretado",
                "success"
              );
            } else {
              setCarros(res.data);
            }
          } else {
            swal.fire(
              "Erro",
              "Falha ao carregar os produtos!<br/>" +
                `Status da resposta: ${res.status}` +
                `<br/>Mensagem de status da resposta: ${res.statusText}`,
              "error"
            );
          }
        });
    } catch (erro) {
      swal.fire(
        "Erro",
        `Falha ao fazer requisição!<br/>Erro: ${erro}`,
        "error"
      );
    }
  }

  return (
    <>
      <Nav title="Locadora" />
      <div className="container mt-3">
        <div className="row">
          <div className="col-3" id="menu">
            <h3>Locação</h3>
            <div className="mt-4">
              <h5>Início da Locação</h5>
              <input
                type="number"
                className="form-control  mt-1"
                id="diaInicial"
                placeholder="Dia"
                onChange={(e) => setDiaInicial(e.target.value)}
              />
              <input
                type="number"
                className="form-control mt-1"
                id="mesInicial"
                placeholder="Mês"
                onChange={(e) => setMesInicial(e.target.value)}
              />
              <input
                type="number"
                className="form-control  mt-1"
                id="anoInicial"
                onChange
                placeholder="Ano"
                onChange={(e) => setAnoInicial(e.target.value)}
              />
            </div>
            <div className="mt-4">
              <h5>Fim da Locação</h5>
              <input
                type="number"
                className="form-control  mt-1"
                id="diaFinal"
                placeholder="Dia"
                onChange={(e) => setDiaFinal(e.target.value)}
              />
              <input
                type="number"
                className="form-control mt-1"
                id="mesFinal"
                placeholder="Mês"
                onChange={(e) => setMesFinal(e.target.value)}
              />
              <input
                type="number"
                className="form-control  mt-1"
                id="anoFinal"
                onChange
                placeholder="Ano"
                onChange={(e) => setAnoFinal(e.target.value)}
              />
            </div>
            <div className="mt-3">
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="checkbox"
                  name="arCondicionado"
                  id="arcondicionado"
                  onChange={() => setArCondicionado(!arCondicionado)}
                  checked={arCondicionado}
                />
                <label className="form-check-label" htmlFor="arcondicionado">
                  Ar Condicionado
                </label>
              </div>
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="checkbox"
                  name="direcao"
                  id="direcaoHidraulica"
                  onChange={() => setDirecaoHidraulica(!direcaoHidraulica)}
                  checked={direcaoHidraulica}
                />
                <label className="form-check-label" htmlFor="defaultCheck2">
                  Direção Hidráulica
                </label>
              </div>
              <div className="form-check">
                <input
                  className="form-check-input"
                  type="checkbox"
                  name="cambio"
                  id="cambioAutomatico"
                  onChange={() => setCambioAutomatico(!cambioAutomatico)}
                  checked={cambioAutomatico}
                />
                <label className="form-check-label" htmlFor="cambioAutomatico">
                  Câmbio Automático
                </label>
              </div>
            </div>
            <button
              type="button"
              className="btn btn-primary mt-3"
              onClick={handlePesquisarCarro}
            >
              Buscar
            </button>
          </div>
          <div className="col-9 d-flex">
            {carros.length > 0 &&
              carros.map((carro, index) => (
                <Card key={index} carro={carro}></Card>
              ))}
          </div>
        </div>
      </div>
    </>
  );
}

export default App;
