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

$("#boton_compilar").click(function(){
	
	var peticion = {
			lenguaje: $("#lenguage-select").val(),
			codigo: $("#codigo").val()
	}
	
	 $.ajax
	    ({
	        type: "POST",
	        //the url where you want to sent the userName and password to
	        url: '/api/compilar',
	        contentType: 'application/json',
	        async: false,
	        //json object to sent to the authentication url
	        data: JSON.stringify(peticion),
	        success: function (data) {
                //alert(data);
	        	var blob = new Blob([data], { type: "text/plain;charset=utf-8" });
	            saveAs(blob, "codigo_pic.hex");

	        	
	        	
	        }
	    })
	//alert(JSON.stringify(peticion))
	
});


});