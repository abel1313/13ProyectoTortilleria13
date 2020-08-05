$(()=>{
      
// setInterval(existenciaProducto,2000);
//    Cargar las existencias en cierto tiempo
    $('#cantidadTortillas').focus();
    $(".clienteCompra").hide();
    $('.realizarCOmpraDomicilio').click(()=>{
        
        $(".divTablaDetalle").hide();
       $(".clienteCompra").show();
        
        
    });
    
    $(".idActualizarTortillas").load('./Vista/DetalleVenta/ActualizarKilos.jsp');
    $(".clienteCompra").load('./Vista/DetalleVenta/MensajeDetalleCompra.jsp');
    
        $('.realizarVenta').click(()=>{
            
        realizarVentax($('.realizarVenta').val(),1);
        
    });
    existenciaProducto();
   
       buscarCliente($('#buscarCliente').val());
    
    $('#buscarCliente').keyup(()=>{
        
        buscarCliente($('#buscarCliente').val());
    });
    $('.cerrarClientes').click(()=>{
        
              $('.contDetalle').show();
            $('.divVenta').show();
            $('.VerClientes').hide();
        
    });
    
    $("#cantidadTortillas").mouseenter(()=>{
        $("#cantTor").text("cantidad");
        $("#cantidadTortillas").val("");
        $("#cantidadTortillas").focus();
    });
    $(".agregarCantidad").click(function(){
        if($("#cantidadTortillas").val() === 0 || $("#cantidadTortillas").val() === "")
        {
           
            $("#cantTor").text("Número no valido");
            
        }else{
        enviarVenta($("#cantidadTortillas").val(),false);
    }
        });
   $('#nuevaVenta').click(()=>{
       
                       $.ajax({
            type: 'POST',
            url: './DatosVenta',
            data: {accion: "nuevaVenta"},
            success: function (rec) {
                
                $('.divVenta').load('./Vista/DetalleVenta/Disponibilidad.jsp');
                $('.mostrarDetalleVenta').load('./Vista/DetalleVenta/DetalleVenta.jsp');
            },
            error: function (xhr, status) {
                console.log('Disculpe, existió un problema');
            },

            // código a ejecutar sin importar si la petición falló o no
            complete: function (xhr, status) {
                console.log('Petición realizada');
            }
        });
   });
   
   
   $('.TodosClientes').load('./Vista/Cliente/TodosClientes.jsp');
   
    $('#exampleFormControlSelect1').change(function(){
        
        $('#cantidadTortillas').focus();
                $.ajax({
            type: 'POST',
            url: './DatosProducto',
            data: {accion: "Producto", id:$(this).val()},
            success: function (rec) {
                
                $('.divVenta').load('./Vista/DetalleVenta/Disponibilidad.jsp');
            },
            error: function (xhr, status) {
                console.log('Disculpe, existió un problema');
            },

            // código a ejecutar sin importar si la petición falló o no
            complete: function (xhr, status) {
                console.log('Petición realizada');
            }
        });
        
    });
    
    $('#cantidadTortillas').keyup(function(e){  
           
        let cantidad =0;
         var cantidad2 =0;
         var verificarPrecio =false;
      
        var code = (e.keyCode ? e.keyCode : e.which);
         if($("#cantidadTortillas").val() === 0 || $("#cantidadTortillas").val() === "")
        {
            $("#cantTor").text("Número no valido");
            return false;
        }
        
        if(code===107){
            // signo mas
            cantidad = $('#cantidadTortillas').val();
             cantidad2 = cantidad.slice(cantidad, -1);
             verificarPrecio = true;
             enviarVenta(cantidad2,verificarPrecio);
            $('#cantidadTortillas').val(cantidad2);
        }
        if(code === 13)
        {
            // enter
            cantidad2 = $('#cantidadTortillas').val();  
            enviarVenta(cantidad2,verificarPrecio);
        }    

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
        
            $('#formDatos').validate({
        rules: {
            Pais: {valueNotEquals: "default"},
            Estado: {selectEstado: "estado"},
            Municipio: {required: true, maxlength: 20, minlength: 5},
            Calle: {required: true, maxlength: 20, minlength: 5},
            Colonia: {required: true, maxlength: 20, minlength: 5},
            CodigoPostal: {required: true, maxlength: 20, minlength: 5},
            Correo: {maxlength: 25, minlength: 5,
                remote: {url: "./DatosCliente", type: "POST", data: {accion: "validarCorreoCliente"}}},
            Sexo: {selectSexo: "sex"},
            Nombre: {required: true, maxlength: 20, minlength: 3},
            Paterno: {required: true, maxlength: 20, minlength: 5},
            Materno: {required: true, maxlength: 20, minlength: 5},

            FechaNacimiento: {required: true}
            
        }, 
                messages: {
            Correo: {
                remote: "El correo ya existe."
            }
        },
        submitHandler: function (form) {
            $('.loaders').css({'display': 'block'});
  
//   alert($(form).serialize());
//           return false;

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
                        

                    }
                });
                
                

                
            }, 3000);

        }
    });
        
    

        $('#noExisteClienteDetalle').click(()=>{
            
        $('.contDetalle').hide();
        $('.divVenta').hide();
        
        $('.datosPersonales').load('./Vista/DetalleVenta/DatosPersonales.jsp');
        $('.datosDireccion').load('./Vista/DetalleVenta/DatosDireccion.jsp');
        $('.AgregarClienteDetalle').css({"display":"block"});
            
        });
        
        $('#cancelarAgregarCliente').click(()=>{
        $('.contDetalle').show();
        $('.divVenta').show();
        
        $('.datosPersonales').empty();
        $('.datosDireccion').empty();
        $('.AgregarClienteDetalle').css({"display":"none"});
            
        });
        
            $('#ExisteClienteDetalle').click(()=>{
             $('.contDetalle').hide();
              $('.divVenta').hide();
            $('.VerClientes').show();
            
        });
    
    
});

var existenciaProducto = ()=>
{
    
                    $.ajax({
                    type: 'post',
                    url: 'DatosProducto',
                    data: {"accion":"buscarProducto","filtro":1},
                    cache:false,
                    success: function (res) {
 $('.divVenta').load('Vista/DetalleVenta/Disponibilidad.jsp');
                      

                    }
                });
    
};


var buscarCliente = (cliente)=>{
    
    
            $.ajax({
            type: 'POST',
            url: './DatosCliente',
            data: {accion: "buscarCliente", buscarCliente: cliente},
            success: function (rec) {
                $('.TodosClientes').load('./Vista/Cliente/TodosClientes.jsp');

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

var enviarVenta = (cantidad,verificar)=>{
    
            $.ajax({
            type: 'POST',
            url: './DatosVenta',
            data: {accion: "agregarProductoDetalle",verificar:verificar ,cantidad:cantidad,idProducto:$('#exampleFormControlSelect1').val()},
            
            success: function (rec) {
                
            $('.mostrarDetalleVenta').load('./Vista/DetalleVenta/DetalleVenta.jsp');
            
            setTimeout(function () {
                $('.Mensajex').load('./Vista/Menu/Mensaje.jsp');
            }, 500);
            
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
var realizarVentax = (accion, tipoPedido) => {

    $.ajax({
        type: 'POST',
        url: './DatosVenta',
        data: {accion: accion, tipoPedido: tipoPedido},
        success: function (rec) {

            $('.mostrarDetalleVenta').load('./Vista/DetalleVenta/DetalleVenta.jsp');
            
            setTimeout(function () {
                $('.Mensajex').load('./Vista/Menu/Mensaje.jsp');
            }, 500);
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