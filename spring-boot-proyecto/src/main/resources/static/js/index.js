$(document).ready(function(){

$("#boton_guardar").click(function(){

    var codigo = $("#exampleFormControlTextarea1").val();
    var blob = new Blob([codigo], { type: "text/plain;charset=utf-8" });
    saveAs(blob, "codigo_pic.txt");


});

$("#cargar_archivo").change(function(){
     
    var file = this.files[0];

  var reader = new FileReader();
  reader.onload = function(progressEvent){
    // Entire file
    //console.log(this.result);
    $("#exampleFormControlTextarea1").val(this.result);
    // By lines
   // var lines = this.result.split('\n');
    //for(var line = 0; line < lines.length; line++){
   //  console.log(lines[line]);
   // }
  };
  reader.readAsText(file);

});

$("#boton_cargar").click(function(){
    $("#cargar_archivo").trigger("click");
});

$("#boton_salir").click(function(){
  window.location.replace("https://www.google.com");
});




});