window.addEventListener('load', function () {
    console.log("EJECUTANDO LOAD FUNCTION")

    const formulario = document.querySelector('#agregar_nuevo_paciente');
    formulario.addEventListener('submit', function (event) {
    event.preventDefault();

        const formData = {
            calle: document.querySelector('#calle').value,
            numero: document.querySelector('#numero').value,
            localidad: document.querySelector('#localidad').value,
            provincia: document.querySelector('#provincia').value,
        };

        const url = '/domicilio/agregar';

        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }


        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
            console.log("DATA DEL DOMICILIO")
            console.log(data)

            const formDataPaciente = {
                nombre: document.querySelector('#nombre').value,
                apellido: document.querySelector('#apellido').value,
                dni: document.querySelector('#dni').value,
                email: document.querySelector('#email').value,
                domicilio:{
                     id:data
                }
            };
            guardarPaciente(formDataPaciente);
            resetUploadForm();
            })
            .catch(error => {
                 //Si hay algun error se muestra un mensaje diciendo que el estudiante
                 //no se pudo guardar y se intente nuevamente
                  let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                     '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                     '<strong> Error intente nuevamente(postDomicilio)</strong> </div>'

                   document.querySelector('#response').innerHTML = errorAlert;
                   document.querySelector('#response').style.display = "block";
                   //se dejan todos los campos vacíos por si se quiere ingresar otro estudiante
                   resetUploadForm();
                   })
    });

    function resetUploadForm(){
        document.querySelector('#nombre').value = "";
        document.querySelector('#apellido').value = "";
        document.querySelector('#dni').value = "";
        document.querySelector('#email').value = "";

        document.querySelector('#calle').value = "";
        document.querySelector('#numero').value = "";
        document.querySelector('#localidad').value="";
        document.querySelector('#provincia').value="";
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "/studentsList.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});