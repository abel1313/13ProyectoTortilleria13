$(()=>{
   
        $(".recogerTortilleria").click(function(){
            realizarVenta("tortillriaPedido",1);
        });
    
       $(".cocontenedorDireccionDiferente").hide();
        $(".confirmarDireccion").hide();
        
        $(".btnDireccionNuevaDetalle").click(function(){
            $(".cocontenedorDireccionDiferente").show();
        });
        
        $(".cancelarDireccionDiferente").click(function(){
            $(".cocontenedorDireccionDiferente").hide();
        });
        
        $(".cancelarEnvioDetalle").click(function(){
            
            $(".clienteCompra").hide();
            $(".divTablaDetalle").show();
        });
        
        
    $(".envioDomicilioDetalle").mouseenter(function(){
          $(".confirmarDireccion").show();
    });
        $(".confirmarDireccion").mouseenter(function(){
          $(".confirmarDireccion").show();
    });
    
        $(".confirmarDireccion").mouseleave(function(){
          $(this).hide();
    });
     $(".contMensajeDetalle").mouseleave(function(){
          $(".confirmarDireccion").hide();
    });
    
            $(".recogerTortilleria").mouseenter(function(){
          $(".confirmarDireccion").hide();
    });
    
    
        $('.btnDireccionActualDetalle').click(()=>{
        realizarVenta("direccionCliente",2);
    });
    
    $(".direccionDeferente").load('./Vista/DetalleVenta/DatosDireccion.jsp');
    $('.btnDireccionNuevaDetalle').click(()=>{
        
    });


$.validator.addMethod("valueNotEquals", function(value, element, arg){
  return arg !== value;
 }, "Seleccione su Pais");
  $.validator.addMethod("selectEstado", function(value, element, arg){
  return arg !== value;
 }, "Seleccione su Estado");
   $.validator.addMethod("selectSexo", function(value, element, arg){
  return arg !== value;
 }, "Seleccione su Sexo");
        
            $('#agregarDireccionDiferente').validate({
        rules: {
            Pais: {valueNotEquals: "default"},
            Estado: {selectEstado: "estado"},
            Municipio:{required: true, maxlength: 20, minlength: 5}, 
           Calle:{required: true, maxlength: 20, minlength: 5}, 
           Colonia:{required: true, maxlength: 20, minlength: 5}, 
           CodigoPostal:{required: true, maxlength: 20, minlength: 5}, 
           
            Sexo: {selectSexo: "sex"},
           Nombre:{required: true, maxlength: 20, minlength: 3}, 
           Paterno:{required: true, maxlength: 20, minlength: 5},
            Materno:{required: true, maxlength: 20, minlength: 5},
            
            FechaNacimiento: {required : true}
            
        },            
        submitHandler: function (form) {
            // $('.loaders').css({'display': 'block'});
  
  // alert($(form).serialize());
    //       return false;

            setTimeout(function ()
            {
                
                $.ajax({
                    type: 'post',
                    url: 'DatosCliente',
                    data: $(form).serialize(),
                    cache: false,
                    processData: false,
                    success: function (res) {
                
     
    $('.contenedorBody').load('./Vista/Venta/Venta.jsp');
                                    setTimeout(function () {
                $('.Mensajex').load('./Vista/Menu/Mensaje.jsp');
            }, 500);

                    }
                });
                
                

                
            }, 3000);

        }
    });


    
});



var realizarVenta = (accion, tipoPedido) => {

    $.ajax({
        type: 'POST',
        url: './DatosCliente',
        data: {accion: accion, tipoPedido: tipoPedido},
        success: function (rec) {


            $('.mostrarDetalleVenta').load('./Vista/DetalleVenta/DetalleVenta.jsp');
            
                        setTimeout(function () {
                $('.Mensajex').load('./Vista/Menu/Mensaje.jsp');
            }, 800);

        },
        error: function (xhr, status) {
//                console.log('Disculpe, existió un problema');
        },

        // código a ejecutar sin importar si la petición falló o no
        complete: function (xhr, status) {
//                console.log('Petición realizada');
        }
    });
};

