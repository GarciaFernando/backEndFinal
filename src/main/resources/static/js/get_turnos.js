window.addEventListener('DOMContentLoaded', function () {
    console.log("EJECUTANDO GET_PACIENTE_TURNO");

    (function(){
      //con fetch invocamos a la API de estudiantes con el método GET
      //nos devolverá un JSON con una colección de estudiantes
      const url = '/turnos/listar';
      const settings = {
        method: 'GET'
    }
    fetch(url,settings)
    .then(response => response.json())
    .then(data => {
         const tabla = document.getElementById('turnosTable');
         let fecha;
         let dia;
         let mes;
         let anio;
         let hora;
         let min;
         let fechaFormateada;

         for(turno of data){
         console.log("VER CONTENIDO DE TURNO OF DATA")
         console.log(turno)
            let turnoRow = tabla.insertRow();
            let tr_id = 'tr_'+turno.id;
            turnoRow.id = tr_id;
            fecha = new Date(turno.fecha);
            dia = fecha.getDate();
            mes = fecha.getMonth()+1;
            anio = fecha.getFullYear();
            hora = fecha.getHours();
            min = fecha.getMinutes();
            fechaFormateada = `${dia<10? "0"+dia:dia}-${mes < 10 ? "0" + mes : mes}-${anio} ${hora < 10 ? "0"+hora:hora}:${min <10 ? "0"+min:min}`;

            let deleteButton = '<button' +
                               ' id=' + '\"' + 'btn_delete_' + turno.id + '\"' +
                               ' type="button" onclick="deleteBy('+turno.id+')" class="btn btn-danger btn_delete">' +
                               '&times' +
                               '</button>';

            let updateButton = '<button' +
                               ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                               ' type="button" onclick="alert(\'No es posible editar un turno\')" class="btn btn-info btn_id">' +
                               turno.id +
                               '</button>';

            turnoRow.innerHTML = '<td>' + updateButton + '</td>' +
                                          '<td class=\"td_paciente\">' + turno.paciente.nombre.toUpperCase()+ " "+turno.paciente.apellido.toUpperCase() + '</td>' +
                                          '<td class=\"td_odontologo\">' + turno.odontologo.nombre.toUpperCase()+" "+turno.odontologo.apellido.toUpperCase()+ '</td>' +
                                          '<td class=\"td_fecha\">' + fechaFormateada + '</td>' +
                                          '<td>' + deleteButton + '</td>';

          }
    });
})();
});