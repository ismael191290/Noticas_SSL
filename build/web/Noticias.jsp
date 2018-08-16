<%-- 
    Document   : Noticias
    Created on : 18/05/2018, 12:13:21 PM
    Author     : GS-Server
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Noti-Integra</title>
        <meta http-equiv="Content-Type" content="text/json; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/ed-grid.css" rel="stylesheet">
        <script type="text/javascript" src="js/vue.js"></script>
        <script src="https://cdn.jsdelivr.net/vue.resource/1.2.1/vue-resource.min.js"></script>
        <style>
            tbody{
                display: block; height: calc(83vh - 1px); min-height: calc(200px + 1 px); overflow-Y: scroll; color: #000;
            }
            
  
h1 {
  padding: 50px;
}

.spinner:after, .spinner:before {
  content: "";
  display: block;
  width: 100px;
  height: 100px;
  border-radius: 50%;
}

.spinner-1:after {
  top: -4px;
  left: -4px;
  border: 4px solid transparent;
  border-top-color: orangered;
  border-bottom-color: orangered;
  -webkit-animation: spinny 1s linear infinite;
          animation: spinny 1s linear infinite;
}

@-webkit-keyframes spinny {
  0% {
    -webkit-transform: rotate(0deg) scale(1);
            transform: rotate(0deg) scale(1);
  }
  50% {
    -webkit-transform: rotate(45deg) scale(1.2);
            transform: rotate(45deg) scale(1.2);
  }
  100% {
    -webkit-transform: rotate(360deg) scale(1);
            transform: rotate(360deg) scale(1);
  }
}

@keyframes spinny {
  0% {
    -webkit-transform: rotate(0deg) scale(1);
            transform: rotate(0deg) scale(1);
  }
  50% {
    -webkit-transform: rotate(45deg) scale(1.2);
            transform: rotate(45deg) scale(1.2);
  }
  100% {
    -webkit-transform: rotate(360deg) scale(1);
            transform: rotate(360deg) scale(1);
  }
}
.spinner-2 {
  -webkit-animation: spin 2s linear infinite;
          animation: spin 2s linear infinite;
}
.spinner-2:before, .spinner-2:after {
  height: 20px;
  width: 20px;
  background: orangered;
  position: absolute;
  top: -10px;
  left: 50%;
  margin-left: -10px;
  -webkit-animation: bouncy 1s ease-in infinite;
          animation: bouncy 1s ease-in infinite;
}
.spinner-2:after {
  top: auto;
  bottom: -10px;
  -webkit-animation: bouncy 0.5s ease-in infinite;
          animation: bouncy 0.5s ease-in infinite;
}

@-webkit-keyframes bouncy {
  0%, 100% {
    -webkit-transform: translateY(0px);
            transform: translateY(0px);
  }
  50% {
    -webkit-transform: translateY(30px);
            transform: translateY(30px);
  }
}

@keyframes bouncy {
  0%, 100% {
    -webkit-transform: translateY(0px);
            transform: translateY(0px);
  }
  50% {
    -webkit-transform: translateY(30px);
            transform: translateY(30px);
  }
}
@-webkit-keyframes spin {
  0% {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
  }
}
@keyframes spin {
  0% {
    -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
  }
  100% {
    -webkit-transform: rotate(360deg);
            transform: rotate(360deg);
  }
}
.spinner-3 {
  background: none;
  border: 4px solid #eee;
}
.spinner-3:after {
  width: 4px;
  height: 66px;
  background: orangered;
  border-radius: 0px;
  position: absolute;
  top: 50%;
  left: 50%;
  margin-left: -2px;
  -webkit-transform-origin: top center;
          transform-origin: top center;
  -webkit-animation: spin 2s linear infinite;
          animation: spin 2s linear infinite;
}

.spinner-4:before, .spinner-4:after {
  position: absolute;
  top: 50%;
  left: 50%;
  margin-top: -50px;
  margin-left: -50px;
  background: orangered;
  -webkit-animation: pulse 3s linear infinite;
          animation: pulse 3s linear infinite;
  opacity: 0;
}
.spinner-4:after {
  -webkit-animation: pulse 2s linear 2.3s infinite;
          animation: pulse 2s linear 2.3s infinite;
}

@-webkit-keyframes pulse {
  0% {
    -webkit-transform: scale(0);
            transform: scale(0);
    opacity: 1;
  }
  100% {
    -webkit-transform: scale(1.3);
            transform: scale(1.3);
    opacity: 0;
  }
}

@keyframes pulse {
  0% {
    -webkit-transform: scale(0);
            transform: scale(0);
    opacity: 1;
  }
  100% {
    -webkit-transform: scale(1.3);
            transform: scale(1.3);
    opacity: 0;
  }
}
.spinner-5 {
  height: 0px;
  width: 0px;
}
.spinner-5 span {
  display: block;
  height: 20px;
  width: 20px;
  background: #ddd;
  border-radius: 50%;
  position: absolute;
  top: 0px;
}
.spinner-5 span:nth-child(1) {
  left: -40px;
  -webkit-animation: bounce 1s ease-in-out infinite;
          animation: bounce 1s ease-in-out infinite;
}
.spinner-5 span:nth-child(2) {
  -webkit-animation: bounce 1s ease-in-out 0.33s infinite;
          animation: bounce 1s ease-in-out 0.33s infinite;
}
.spinner-5 span:nth-child(3) {
  left: 40px;
  -webkit-animation: bounce 1s ease-in-out 0.66s infinite;
          animation: bounce 1s ease-in-out 0.66s infinite;
}

@-webkit-keyframes bounce {
  0%, 75%, 100% {
    -webkit-transform: translateY(0px);
            transform: translateY(0px);
  }
  25% {
    -webkit-transform: translateY(-30px);
            transform: translateY(-30px);
  }
}

@keyframes bounce {
  0%, 75%, 100% {
    -webkit-transform: translateY(0px);
            transform: translateY(0px);
  }
  25% {
    -webkit-transform: translateY(-30px);
            transform: translateY(-30px);
  }
}
.track {
  width: 300px;
  height: 0px;
  border-top: 8px dotted #eee;
  display: inline-block;
}

.kurt {
  -webkit-animation: moveChomp 3s linear infinite;
          animation: moveChomp 3s linear infinite;
  background: pink;
  width: 0px;
  height: 0px;
  position: relative;
  top: -15px;
}

.loader {
  background: none;
  display: inline-block;
  position: relative;
}
.loader:before, .loader:after {
  content: "";
  display: block;
  height: 0px;
  width: 0px;
  border: 30px solid orangered;
  border-radius: 50%;
  border-right-color: transparent;
  border-bottom-color: transparent;
  position: absolute;
  top: 50%;
  margin-top: -34px;
  animation: topchomp 1s ease-in-out infinite reverse;
}
.loader:after {
  border-color: orangered;
  border-top-color: transparent;
  border-right-color: transparent;
  -webkit-animation: bottomchomp 1s ease-in-out infinite;
          animation: bottomchomp 1s ease-in-out infinite;
}
            
        </style>
    </head>
    <body>
   
       
        <div  class="ed-container" id="apps">
            <div  class="ed-container" >
                <div class="ed-item" style="margin-left: 200dp">
                    <input type="text" name="search" id="myInput" onkeyup="myFunction();myFunction2();" placeholder="Buscar.." v-model="search">
                </div>
            </div>
 
            <div class="ed-item m-10" v-if="!status">
                <div class="spinner spinner-1" >
                    <p>Cargando.........</p>
                </div>
            </div>
            

            <div class="ed-item m-45" >
                <p style="text-align: center"></p>
                <div class="ed-container">
                    <table >
                        <thead style="background:#DF3A01; color:#FFFFFF">
                        <th>Noticias Nacionales</th>
                        </thead>
                        <tbody id="nacional">
                            <tr v-for="naciona in noticiasN">
                                <td>{{naciona.title}}</td>
                                <td>{{naciona.fecha}}</td>
                                <td><a  v-bind:href="naciona.link" target="_blank">Link</a></td>
                            </tr>

                        </tbody>

                    </table>
                </div>
            </div>

            <div class="ed-item m-45">
                <p style="text-align: center"></p>
                <div class="ed-container" >
                    <table>
                        <thead style="background:#DF3A01; color:#FFFFFF">
                        <th>Noticias Locales</th>
                        </thead>
                        <tbody id="local">
                            <tr v-for="local in noticiasL">
                                <td>{{local.title}}</td>
                                <td>{{local.fecha}}</td>
                                <td><a  v-bind:href="local.link" target="_blank">Link</a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
        <script>


            function myFunction() {

                var filter, table, tr, td, i;
                var input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("local");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[0];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }

            function myFunction2() {
                var filter, table, tr, td, i;
                var input = document.getElementById("myInput");
                filter = input.value.toUpperCase();
                table = document.getElementById("nacional");
                tr = table.getElementsByTagName("tr");
                for (i = 0; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[0];
                    if (td) {
                        if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }

        </script>
        <script type="text/javascript" src="js/controllers.js"></script>
    </body>

    

 
  <!--div class="spinner spinner-2"></div>
  <div class="spinner spinner-3"></div>
  <div class="spinner spinner-4"></div-->
</html>
