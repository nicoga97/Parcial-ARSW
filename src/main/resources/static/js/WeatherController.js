 var weatherValues;
 var selectedCity

function setCity(city){
    selectedCity=city;

}

function searchCityWeather(){
    getCityWeather(updateDetails);
}



 function getCityWeather(callback){

           axios.get( "http://localhost:5000/weather/"+selectedCity)
           .then(function (response) {
                weatherValues=response.data;



           })
           .catch(function (error) {
             console.log('There is a problem with our servers. We apologize for the inconvince, please try again later', error.message);

           })
           .then( function () {
                callback();
               


           });

    }
 function updateDetails(){
       document.getElementById("maxTempText").innerHTML=weatherValues.main.temp_max+" °F";
       document.getElementById("minTempText").innerHTML=weatherValues.main.temp_min+" °F";
       document.getElementById("climaText").innerHTML=weatherValues.weather[0].description;


  }


     function paintTables(){
          var ordersList=frontEnd.getCurrentOrders();
          for(var order=0;order<ordersList.length;order++){

                       var orderArrayHeader = ["Product","Quantity","Price"];
                       var body = document.getElementById("orders");
                       var titulo=order+1;
                       var tituloTabla =document.createElement("h5");

                       tituloTabla.appendChild(document.createTextNode("Table "+titulo));
                       body.appendChild(tituloTabla);
                       var tbl  = document.createElement("table");
                         tbl.setAttribute("class","table table-striped");
                         tbl.setAttribute("id", order);


                         for(var i=0;i<Object.keys(ordersList[order].orderAmountsMap).length;i++){
                                var clave=Object.keys(ordersList[order].orderAmountsMap)[i];
                                 frontEnd.loadProduct(order,clave,tbl);




                         }
                         body.appendChild(tbl);
                         tbl=document.getElementById(order);
                         var header = tbl.createTHead();
                         var row = header.insertRow(0);
                         for(var i = 0; i <orderArrayHeader.length ; i++){
                            var cell = row.insertCell(i);
                            cell.outerHTML ="<th scope='col'>"+ orderArrayHeader[i]+"<th>";}

                         row.deleteCell(5);
                         row.deleteCell(4);
                         row.deleteCell(3);
                         txt = document.createTextNode('\x0A');
                         tbl.appendChild(txt);

                     }


       }

       function createRow(id,order,table,product){
             var ordersList=frontEnd.getCurrentOrders();
             var tr = table.insertRow();
             var td = tr.insertCell();
             td.appendChild(document.createTextNode(product.name));
             td = tr.insertCell();
             td.appendChild(document.createTextNode(ordersList[order].orderAmountsMap[id]));
             td = tr.insertCell();
             td.appendChild(document.createTextNode(ordersList[order].orderAmountsMap[id]*product.price));
       }










