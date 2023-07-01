function guardarPaciente(formData){
    console.log("ENTRANDO A LA FUNCION GUARDARPACIENTE");
        const url = '/paciente/agregar';
        const settings = {
              method: 'POST',
              headers: {
              'Content-Type': 'application/json',
              },
              body: JSON.stringify(formData)
        }
                fetch(url, settings)
                            .then(response => response.text())
                            .then(data => {
                               //Si no hay ningun error se muestra un mensaje diciendo que el odontologo
                               //se agrego bien
                                 let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong></strong> Paciente agregado </div>'

                                 document.querySelector('#response').innerHTML = successAlert;
                                 document.querySelector('#response').style.display = "block";


                            })
                            .catch(error => {
                                 //Si hay algun error se muestra un mensaje diciendo que el estudiante
                                 //no se pudo guardar y se intente nuevamente
                                 console.log(error)
                                  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                                     '<strong> Error intente nuevamente(postPaciente)</strong> </div>'

                                   document.querySelector('#response').innerHTML = errorAlert;
                                   document.querySelector('#response').style.display = "block";

                            })


}