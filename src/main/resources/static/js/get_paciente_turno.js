window.addEventListener('DOMContentLoaded', function () {
    console.log("EJECUTANDO GET_PACIENTE_TURNO");

    (function(){
      //con fetch invocamos a la API de estudiantes con el método GET
      //nos devolverá un JSON con una colección de estudiantes
      const url = '/paciente/listar';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         console.log("CARGANDO PACIENTES AL SELECT");
         console.log(data)
         const select = document.getElementById("paciente");
         for(paciente of data){
            let option = document.createElement("option");
            option.value = paciente.id;
            option.text = paciente.nombre+" "+paciente.apellido;
            select.appendChild(option);
          }
    });

      const urlO = '/odontologo/listar';
          const settingsO = {
            method: 'GET'
        }
        fetch(urlO,settingsO)
        .then(response => response.json())
        .then(data => {
             console.log("CARGANDO ODONTOLOGOS AL SELECT");
             console.log(data)
             const select = document.getElementById("odontologo");
             for(odontologo of data){
                let option = document.createElement("option");
                option.value = odontologo.id;
                option.text = odontologo.nombre+" "+odontologo.apellido;
                select.appendChild(option);
              }
        });
})();
});