import React, { useState, useEffect } from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";
import swal from "sweetalert2";
import axios from "axios";

function HistoricoVeiculos(props) {
  const [modal, setModal] = useState(false);
  const toggle = () => setModal(!modal);
  const [historico, setHistorico] = useState();

  const handleGetHistorico = () => {
    try {
      axios.GET(`http://localhost:8080/locadora/historico`).then((res) => {
        if (res.status === 200) {
          swal.fire("Sucesso", "Histórico obtido!", "success");
          console.log(res);
        } else {
          swal.fire(
            "Erro",
            "Falha ao obter histórico!<br/>" +
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
  };

  return (
    <>
      <button type="button" className="btn btn-secondary m-1" onClick={toggle}>
        Histórico
      </button>
      <Modal isOpen={modal} toggle={toggle}>
        <ModalHeader toggle={toggle}>Devolver Veículo</ModalHeader>
        <ModalBody></ModalBody>
        <ModalFooter>
          <Button color="secondary" onClick={toggle}>
            Cancel
          </Button>
        </ModalFooter>
      </Modal>
    </>
  );
}

export default HistoricoVeiculos;
