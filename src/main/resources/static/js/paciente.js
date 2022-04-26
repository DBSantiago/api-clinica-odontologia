window.onload = () => {

  const tabla = document.getElementById("tabla");

  const getPacientes = () => {
    const URL = "http://localhost:8080/pacientes";
    const CREDENTIALS = btoa("admin@digital.com:admin");
    const SETTINGS = {
      method: "GET",
      headers: {
        "Authorization": `Basic ${CREDENTIALS}`,
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
      },
    };

    fetch(URL, SETTINGS)
        .then(response => response.json())
        .then(data => {
            console.log(data)
            for (paciente of data){
                let row = document.createElement('tr');
                row.setAttribute("id",`fila_${paciente.id}`);

                let th = document.createElement("th");
                th.setAttribute("id", `id_${paciente.id}`)
                th.scope = "row";

                let td_nom = document.createElement("td");
                td_nom.setAttribute("id", `nombre_${paciente.id}`)
                td_nom.innerHTML = paciente.nombre;

                let td_ape = document.createElement("td");
                td_ape.setAttribute("id", `apellido_${paciente.id}`)
                td_ape.innerHTML = paciente.apellido;

                let bot_id = document.createElement("button");
                bot_id.setAttribute("id", `modificar_${paciente.id}`);
                bot_id.type = "button";
                bot_id.classList.add("btn", "btn-dark", "boton-id");
                bot_id.innerHTML = paciente.id;
                bot_id.addEventListener("click",mostrarForm);

                let bot_x = document.createElement("button");
                bot_x.setAttribute("id", `eliminar_${paciente.id}`);
                bot_x.type = "button";
                bot_x.classList.add("btn", "btn-danger", "boton-eliminar");
                bot_x.innerHTML = "X";
                bot_x.addEventListener("click", eliminarRegistro)

                let td_bot = document.createElement("td");
                td_bot.appendChild(bot_x);

                th.appendChild(bot_id);

                row.appendChild(th);
                row.appendChild(td_nom);
                row.appendChild(td_ape);
                row.appendChild(td_bot);

                tabla.appendChild(row);
            }

        })
        .catch(error => {
            alert("Error. Probá de nuevo")
            console.log(error);
        })

  };

  getPacientes();

  const botonAgregarPaciente = document.getElementById(
    "boton-agregar-paciente"
  );

  const botonSubmitAgregar = document.getElementById("submit-agregar");

  const botonSubmitModificar = document.getElementById("submit-modificar");

  const formularioAgregar = document.getElementById("form-agregar");

  const formularioModificar = document.getElementById("form-modificar");

  botonAgregarPaciente.onclick = () => {
    document
      .getElementById("form-agregar-container")
      .classList.remove("no-mostrar");
  };

  formularioAgregar.onsubmit = (event) => {
      event.preventDefault();
      const formData = {
        nombre: document.getElementById("input-nombre-a").value,
        apellido: document.getElementById("input-apellido-a").value,
        dni: document.getElementById("input-dni-a").value,
        domicilio: {
          "calle": document.getElementById("input-calle-a").value,
          "numero": document.getElementById("input-numero-a").value,
          "localidad": document.getElementById("input-localidad-a").value,
          "provincia": document.getElementById("input-provincia-a").value
        },
        fecha: "2022-04-23"
      };

      const URL = "http://localhost:8080/pacientes";
      const CREDENTIALS = btoa("admin@digital.com:admin");
      const SETTINGS = {
        method: "POST",
        headers: {
          "Authorization": `Basic ${CREDENTIALS}`,
          "Content-Type": "application/json",
          "Access-Control-Allow-Origin": "*",
        },
        body: JSON.stringify(formData)
      };

      fetch(URL, SETTINGS)
        .then((response) => response.json())
        .then((data) => {
          alert("Paciente agregado");
        })

      formularioAgregar.submit();
      formularioAgregar.reset();

      location.reload()
  };

  function mostrarForm(event){
        document
          .getElementById("form-modificar-container")
          .classList.remove("no-mostrar");

        const id = event.target.innerHTML
        document.getElementById("input-id-m").value = parseInt(id);
        document.getElementById("input-nombre-m").value = document.getElementById(`nombre_${id}`).innerHTML;
        document.getElementById("input-apellido-m").value = document.getElementById(`apellido_${id}`).innerHTML;

  }

  function eliminarRegistro(event){

    const id = parseInt(event.target.id.replace("eliminar_",""));
    console.log(`id ${id}`)
    const URL = "http://localhost:8080/pacientes/" + id;
    const CREDENTIALS = btoa("admin@digital.com:admin");
    const SETTINGS = {
      method: "DELETE",
      headers: {
        "Authorization": `Basic ${CREDENTIALS}`,
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
      },
    };

    fetch(URL, SETTINGS)
        .then(response=>response.text())
        .then(data=>console.log(data))

    alert("Paciente eliminado");

    location.reload();

  }

  formularioModificar.onsubmit = (event) => {

      event.preventDefault();

      const id = parseInt(document.getElementById("input-id-m"));

      console.log(`id ${id}`)

      const formData = {
        id: id,
        nombre: document.getElementById("input-nombre-m").value,
        apellido: document.getElementById("input-apellido-m").value,
        dni: document.getElementById("input-dni-m").value,
        domicilio: {
          "calle": document.getElementById("input-calle-m").value,
          "numero": document.getElementById("input-numero-m").value,
          "localidad": document.getElementById("input-localidad-m").value,
          "provincia": document.getElementById("input-provincia-m").value
        },
        fecha: "2022-04-23"
      };

      const URL = "http://localhost:8080/pacientes/" + id;
      const CREDENTIALS = btoa("admin@digital.com:admin");
      const SETTINGS = {
        method: "PUT",
        headers: {
          "Authorization": `Basic ${CREDENTIALS}`,
          "Content-Type": "application/json",
          "Access-Control-Allow-Origin": "*",
        },
        body: JSON.stringify(formData)
      };

      fetch(URL, SETTINGS)
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.log(error));

      formularioModificar.submit();
      formularioModificar.reset();

      location.reload();
  }

};