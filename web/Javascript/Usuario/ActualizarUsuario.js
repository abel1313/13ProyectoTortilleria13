$(()=>{
   
    $('.divCambContrUsuario').hide();
    $('.registrarDireccion').hide();
    $('.dtsPersonaUsuario').hide();
    
    
$('#defaultCheck1').change(()=>{
   if($('#defaultCheck1').is(':checked')){
       
       $('.divCambContrUsuario').show();
   }else{
       $('.divCambContrUsuario').hide();
   }
});
$('#dtsPersonales').change(()=>{
   $('#dtsPersonales').is(':checked')? $('.dtsPersonaUsuario').show():$('.dtsPersonaUsuario').hide();   
});
$('#dtsDirecion').change(()=>{
   $('#dtsDirecion').is(':checked')? $('.registrarDireccion').show():$('.registrarDireccion').hide();   
});



});