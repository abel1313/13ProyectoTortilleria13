$(()=>{
    
    
    $('.agregarClienteEncontrado').click(function(){
        enviarCLienteVenta($(this).val());
    });
    
    
});


var enviarCLienteVenta = (valor)=>{
            $.ajax({
            type: 'POST',
            url: './DatosCliente',
            data: {accion: "selecccionarClienteVenta", idCliente:valor},
            success: function () {
                
    $('.mostrarDetalleVenta').load('./Vista/DetalleVenta/DetalleVenta.jsp');
   $('.divVenta').show();
            },
            error: function (xhr, status) {
                console.log('Disculpe, existió un problema');
            },

            // código a ejecutar sin importar si la petición falló o no
            complete: function (xhr, status) {
                console.log('Petición realizada');
            }
        });
};

