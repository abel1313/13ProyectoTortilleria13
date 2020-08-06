/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(() => {

    $('#formAcEmp').validate({
        rules: {
            //Datos para Dirección
            pais: {required: true, maxlength: 30, minlength: 3},
            estado: {required: true, maxlength: 30, minlength: 3},
            muni: {required: true, maxlength: 30, minlength: 3},
            col: {required: true, maxlength: 30, minlength: 3},
            call: {required: true, maxlength: 30, minlength: 2},
            cp: {required: true, maxlength: 30, minlength: 3},
            nex: {maxlength: 10, minlength: 1, number: true},
            nin: {maxlength: 10, minlength: 1, number: true},
            //Datos de la persona
            nombre: {required: true, maxlength: 15, minlength: 2},
            ApPa: {required: true, maxlength: 20, minlength: 2},
            ApMa: {required: true, maxlength: 20, minlength: 2},
            fech: {required: true, date: true},
            email: {required: true, maxlength: 50, minlength: 2, email: true},
            tel: {maxlength: 11, minlength: 1},
            //Datos del empleado
            puesto: {required: true, maxlength: 20, minlength: 2},
            Sueldo: {required: true, maxlength: 10, minlength: 1, number: true}
        },
        submitHandler: function (form) {
            $.ajax({
                type: 'post',
                url: 'ServletEmp',
                data: $(form).serialize(),
                success: function () {
                    $('.contenedorBody').load("./Vista/Empleado/Empleado.jsp");

                  
                }
            });

        }

    });

    $('#btncancelar').click(function(){
    $('.contenedorBody').load("./Vista/Empleado/Empleado.jsp");
});

});

