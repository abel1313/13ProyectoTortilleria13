$(()=>{
         // Form add Service 
    $('#formEditarProducto').validate({
        rules: {
           nameService:{required: true, maxlength: 20, minlength: 3}, 
           DescriptionService:{required: true, maxlength: 200, minlength: 5},
           PrecioService:{required: true, maxlength: 10, minlength: 1, number: true},
           KilosDisponibles:{required: true, maxlength: 10, minlength: 1, number: true}
            
        },            
        submitHandler: function (form) {

                $.ajax({
                    type: 'post',
                    url: 'DatosProducto',
                    data: $(form).serialize(),
                    success: function () {
                        $('.contenedorBody').load("./Vista/Producto/Producto.jsp");

                    }
                });


        }
    });  
    
});


function filterFloat(evt,input){
    // Backspace = 8, Enter = 13, ‘0′ = 48, ‘9′ = 57, ‘.’ = 46, ‘-’ = 43
    var key = window.Event ? evt.which : evt.keyCode;    
    var chark = String.fromCharCode(key);
    var tempValue = input.value+chark;
    if(key >= 48 && key <= 57){
        if(filter(tempValue)=== false){
            return false;
        }else{       
            return true;
        }
    }else{
          if(key == 8 || key == 13 || key == 0) {     
              return true;              
          }else if(key == 46){
                if(filter(tempValue)=== false){
                    return false;
                }else{       
                    return true;
                }
          }else{
              return false;
          }
    }
}
function filter(__val__){
    var preg = /^([0-9]+\.?[0-9]{0,2})$/; 
    if(preg.test(__val__) === true){
        return true;
    }else{
       return false;
    }
    
}

function soloNumeros(numero)
{
    $(numero).bind('keypress', function(event) {
        var regex = new RegExp("^[0-9]+$");
        var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
        if (!regex.test(key)) {
          event.preventDefault();
          return false;
        }
      });
}

function numeroLetras(letra)
{
    $(letra).bind('keypress', function(event) {
        var regex = new RegExp("^[a-zA-Z0-9 ]+$");
        var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
        if (!regex.test(key)) {
          event.preventDefault();
          return false;
       }
      });
}

