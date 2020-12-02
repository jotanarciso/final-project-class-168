import React from "react";
import axios from "axios";
import swal from "sweetalert2";
function Card(props) {
  const carro = props.carro;

  function handleAlugarCarro() {
    try {
      axios
        .post(`http://localhost:8080/locadora/confirmaLocacao`, carro )
        .then((res) => {
          if (res.status === 200) {
            let conteudo = res.data;
            if (conteudo) {
              swal.fire(
                "Sucesso",
                "Requisi\u00E7\u00E3o bem-sucedida, mas corpo da resposta " +
                  "n\u00E3o p\u00F4de ser interpretado.",
                "success"
              );
            } else {
              window.location.reload();
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
      <div className="col-3 card m-2">
        <div className="card-body">
          <h5 className="card-title">{carro.placa}</h5>
          <h6 className="card-subtitle mb-2 text-muted">{carro.marca}</h6>
          <p className="card-text">
            Custo: R$ {carro.custoLocacao} <br />
            Seguro: + R$ {carro.seguro} <br />
            Desconto: - R$ {carro.desconto}
          </p>
          <h5 className="mt-3">Total: R$ {carro.totalPagar}</h5>
          <div className="row">
            <div className="col mt-3">
              <button
                type="button"
                className="btn btn-success"
                onClick={handleAlugarCarro}
              >
                Alugar
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Card;
