;
var gateway = gateway || {};
gateway.create = (function($){

    var submit_fn = function (form) {
                var gatewayName = $("#gatewayName").val();
              
                var ajaxHeaders = {};
                
                
                $.ajax({
                    type: "POST",
                    url: "/v1/api/gateway",
                     headers: [{
                            "Access-Control-Allow-Origin": "*"
                        }],
                    data: JSON.stringify( { "gatewayName": gatewayName}),
                    xhrFields : {
                        withCredentials : true
                    },
                    crossDomain : true,
                    contentType : "application/json",
                    timeout : 50000,
                    success : function(data, status, request) {
                       
                    },
                    error : function(xhr, status, error) {
                        $('.alert').text('User Already Exist').show();
                    },
                 complete: function(jqXHR, textStatus) { }
                });
                
                
                 
                
                
            
                return false; // required to block normal submit since ajax is used
    }


    return  {
        init: function(){
            $("#gatewayForm").validate({
                rules : {
                    gatewayName : {
                        required : true
                    }

                },
                messages :{
                	gatewayName : {
                        required : "Please enter a valid Gateway Name,"
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