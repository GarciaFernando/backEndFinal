window.addEventListener('load', function () {
    const formulario = document.querySelector('#agregar_nuevo_turno');
    formulario.addEventListener('submit', function (event) {
    console.log("CLICK EN EL BOTON GUARDAR");
    event.preventDefault();
        const formData = {
            paciente: {id:document.getElementById('paciente').value},
            odontologo: {id:document.getElementById('odontologo').value},
            fecha: document.getElementById('fecha').value
        };


        console.log("MOSTRANDO FORMDATA DE TURNO");
        console.log(formData);
        const url = '/turnos/agregar';

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
            console.log(data)
            })
            .catch(error => {
            console.log(error);
            })
    });
});