;
var sensor = sensor || {};
sensor.create = (function($){

    var submit_fn = function (form) {
    			 var sensorName = $("#sensorName").val();
    			 var sensorType = $("#sensorType").val();
                var gatewayName = $("#gatewayName").val();
              
                var ajaxHeaders = {};
                
                
                $.ajax({
                    type: "POST",
                    url: "/v1/api/sensor",
                     headers: [{
                            "Access-Control-Allow-Origin": "*"
                        }],
                    data: JSON.stringify( { "sensorName": sensorName,  "sensorType": sensorType, "gatewayName": gatewayName}),
                    xhrFields : {
                        withCredentials : true
                    },
                    crossDomain : true,
                    contentType : "application/json",
                    timeout : 50000,
                    success : function(data, status, request) {
                       
                    },
                    error : function(xhr, status, error) {
                        $('.alert').text('Sensor Already Exist').show();
                    },
                 complete: function(jqXHR, textStatus) { }
                });
                
                
                 
                
                
            
                return false; // required to block normal submit since ajax is used
    }


    return  {
        init: function(){
            $("#sensororm").validate({
                rules : {
                    sensorName : {
                        required : true
                    }

                },
                messages :{
                	sensorName : {
                        required : "Please enter a valid Sensor Name,"
                    }
                    

                },
                submitHandler: function (form){
                    submit_fn(form);
                },
                errorElement : "p"
            });

        },
    };
})(jQuery)