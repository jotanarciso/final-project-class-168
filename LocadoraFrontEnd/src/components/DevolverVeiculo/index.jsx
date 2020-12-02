import React, { useState } from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";
import swal from "sweetalert2";
import axios from "axios";

function DevolverVeiculo() {
  const [modal, setModal] = useState(false);

  const toggle = () => setModal(!modal);
  const [placa, setPlaca] = useState();

  const handleDevolverVeiculo = () => {
    try {
      axios
        .post(`http://localhost:8080/locadora/devolverVeiculo`, {placa})
        .then((res) => {
          if (res.status === 200) {
            swal.fire(
              "Sucesso",
              "Devolu\u00E7\u00E3o bem-sucedida!",
              "success"
            );
            window.location.reload();
          } else {
            swal.fire(
              "Erro",
              "Falha ao devolver veículo!<br/>" +
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
        Devolver Veículo
      </button>
      <Modal isOpen={modal} toggle={toggle}>
        <ModalHeader toggle={toggle}>Devolver Veículo</ModalHeader>
        <ModalBody>
          <input
            className="form-control  mt-1"
            id="diaInicial"
            placeholder="Placa do Veículo"
            onChange={(e) => setPlaca(e.target.value)}
          />
        </ModalBody>
        <ModalFooter>
          <Button color="primary" onClick={handleDevolverVeiculo}>
            Devolver
          </Button>{" "}
          <Button color="secondary" onClick={toggle}>
            Cancel
          </Button>
        </ModalFooter>
      </Modal>
    </>
  );
}

export default DevolverVeiculo;
