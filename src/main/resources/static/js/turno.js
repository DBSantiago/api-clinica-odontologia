window.onload = () => {

  const tabla = document.getElementById("tabla");

  const getPacientes = () => {

    const selectPaciente = document.getElementById("input-paciente-a");

    const URL = "http://localhost:8080/pacientes";
    const CREDENTIALS = btoa("admin@digital.com:admin");
    const SETTINGS = {
      method: "GET",
      headers: {
        Authorization: `Basic ${CREDENTIALS}`,
        "Content-Type": "application/json",
        "Access-Control-Allow-Origin": "*",
      },
    };

    fetch(URL, SETTINGS)
                      .then(response => response.json())
                      .then(data => {

                      for (paciente of data){

                        let option = document.createElement("option");
                        option.value = paciente.id;
                        option.innerHTML = `${paciente.nombre} ${paciente.apellido}`;

                         selectPaciente.appendChild(option);
                      }

                      })




  };

  const getOdontologos = () => {

      const selectOdontologo = document.getElementById("input-odontologo-a");

      const URL = "http://localhost:8080/odontologos";
      const CREDENTIALS = btoa("admin@digital.com:admin");
      const SETTINGS = {
        method: "GET",
        headers: {
          Authorization: `Basic ${CREDENTIALS}`,
          "Content-Type": "application/json",
          "Access-Control-Allow-Origin": "*",
        },
      };

      fetch(URL, SETTINGS)
                        .then(response => response.json())
                        .then(data => {

                        for (odontologo of data){

                          let option = document.createElement("option");
                          option.value = odontologo.id;
                          option.innerHTML = `${odontologo.nombre} ${odontologo.apellido}`

                          selectOdontologo.appendChild(option);

                        }

                        })



  };

  const getTurnos = () => {
        const URL = "http://localhost:8080/turnos";
        const CREDENTIALS = btoa("user@digital.com:user");
        const SETTINGS = {
          method: "GET",
          headers: {
            Authorization: `Basic ${CREDENTIALS}`,
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
          },
        };


        fetch(URL, SETTINGS)
                          .then(response => response.json())
                          .then(data => {

                          for (turno of data){
                            let row = document.createElement("tr");
                              row.setAttribute("id", `fila_${turno.id}`);

                              let th = document.createElement("th");
                              th.setAttribute("id", `id_${turno.id}`);
                              th.scope = "row";

                              let td_paciente = document.createElement("td");
                              td_paciente.setAttribute("id", `paciente_${turno.paciente.id}`);
                              td_paciente.innerHTML = `${turno.paciente.nombre} ${turno.paciente.apellido}`;

                              let td_fecha = document.createElement("td");
                              td_fecha.setAttribute("id", `fecha_${turno.id}`);
                              td_fecha.innerHTML = turno.fecha;

                              let td_odontologo = document.createElement("td");
                              td_odontologo.setAttribute("id", `odontologo_${turno.id}`);
                              td_odontologo.innerHTML = `${turno.odontologo.nombre} ${turno.odontologo.apellido}`

                              let bot_id = document.createElement("button");
                              bot_id.setAttribute("id", `modificar_${turno.id}`);
                              bot_id.type = "button";
                              bot_id.classList.add("btn", "btn-dark", "boton-id");
                              bot_id.innerHTML = turno.id;

                              let bot_x = document.createElement("button");
                              bot_x.setAttribute("id", `eliminar_${turno.id}`);
                              bot_x.type = "button";
                              bot_x.classList.add("btn", "btn-danger", "boton-eliminar");
                              bot_x.innerHTML = "X";
                              bot_x.addEventListener("click", eliminarRegistro);

                              let td_bot = document.createElement("td");
                              td_bot.appendChild(bot_x);

                              th.appendChild(bot_id);

                              row.appendChild(th);
                              row.appendChild(td_paciente);
                              row.appendChild(td_fecha);
                              row.appendChild(td_odontologo);
                              row.appendChild(td_bot);

                              tabla.appendChild(row);
                          }

                          })




  };

  getOdontologos();
  getPacientes();
  getTurnos();

  const botonAgregarTurno = document.getElementById(
        "boton-agregar-turno"
  );

  botonAgregarTurno.onclick = ()=>{

    document.getElementById("form-agregar-container").classList.remove("no-mostrar");

  }

  const formularioAgregar = document.getElementById("form-agregar");


  formularioAgregar.onsubmit = (event) => {
        event.preventDefault();

        const formData = {
          paciente: document.getElementById("input-paciente-a").value,
          odontologo: document.getElementById("input-odontologo-a").value,
          fecha: document.getElementById("input-fecha-a").value
        };

        const URL = "http://localhost:8080/turnos";
        const CREDENTIALS = btoa("user@digital.com:user");
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
            alert("Turno agregado");
          })

        formularioAgregar.submit();
        formularioAgregar.reset();

        location.reload()
  };


  function eliminarRegistro(){

    const id = parseInt(event.target.id.replace("eliminar_",""));
    console.log(`id ${id}`)
    const URL = "http://localhost:8080/turnos/" + id;
    const CREDENTIALS = btoa("user@digital.com:user");
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

    alert("Turno eliminado");

    location.reload();

  }



};