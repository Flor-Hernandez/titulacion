$(document).ready(function(){

$("#boton_guardar").click(function(){

    var codigo = $("#codigo").val();
    var blob = new Blob([codigo], { type: "text/plain;charset=utf-8" });
    saveAs(blob, "codigo_pic.txt");


});

$("#cargar_archivo").change(function(){
     //alert("entro");
    var file = this.files[0];

  var reader = new FileReader();
  reader.onload = function(progressEvent){
    // Entire file
    //alert(this.result);
    $("#codigo").val(this.result);
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
	
	var destino = '/api/compilar/' + $("#lenguage-select").val().toLowerCase();
	
	//alert(destino);
	//return;
	 $.ajax
	    ({
	        type: "POST",
	        //the url where you want to sent the userName and password to
	        url: destino,
	        contentType: 'application/json',
	        async: false,
	        //json object to sent to the authentication url
	        data: JSON.stringify(peticion),
	        success: function (data) {
                //alert(JSON.stringify(data));
	        	if(data.hasError == true){
	        		$("#errorMessage").text(data.errorMessage);
	        		$("#errorMessage").css("display","block");
	        		return;
	        	}
	        	$("#errorMessage").css("display","none");
	        	var blob = new Blob([data.hexString], { type: "text/plain;charset=utf-8" });
	            saveAs(blob, "codigo_pic.hex");

	        	
	        	
	        }
	    })
	//alert(JSON.stringify(peticion))
	
});


});