window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    // Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            rootMargin: '0px 0px -40%',
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

    // Activate SimpleLightbox plugin for portfolio items
    new SimpleLightbox({
        elements: '#portfolio a.portfolio-box'
    });

});



//DE AQUI PARA ABAJO VAMOS A PONER LA INTERACION CON EL INDEX


var url = "http://localhost:8080/api/v1/Usuario/";

function ListarUsuario() {
    $.ajax({
        url: url,
        type: "GET",
        success: function (result) {
            var CuerpoTabla = document.getElementById("CuerpoTabla");
            CuerpoTabla.innerHTML = `
                        <td>${result[i]["IdUsuario"]}</td>
                        <td class="text-center align-middle">${result[i]["Nombre"]}</td>
                        <td class="text-center align-middle">${result[i]["Apellido"]}</td>
                        <td class="text-center align-middle">${result[i]["Direccion"]}</td>
                        <td class="text-center align-middle">${result[i]["CorreoElectronico"]}</td>
                        <td class="text-center align-middle">${result[i]["TipoUsuario"]}</td>
                        <td class="text-center align-middle">
                            <i class="btn fas fa-edit editar"  onclick="RegistrarClienteBandera=false;"   data-id="${result[i]["IdUsuario"]}"></i>
                            <i class="btn fas fa-trash-alt eliminar" data-id="${result[i]["IdUsuario"]}"></i>
                        </td>
            
            `;
            CuerpoTabla.appendChild(trRegistro);
        },
        error:function(error){
            alert("Error  en la petición" + error);
        }

    });
}










function BuscarUsuario(Nombre) {
    if (Nombre == '') {
        ListarUsuario();
    } else {
        $.ajax({
            url: "http://localhost:8080/api/v1/Usuario/FiltrarNombre/" + Nombre,
            type: "GET",
            success: function (result) {
                var CuerpoTabla = document.getElementById("CuerpoTabla");
                CuerpoTabla.innerHTML = "";
                for (var i = 0; i < result.length; i++) {
                    var trRegistro = document.createElement("tr");
                    trRegistro.innerHTML = `
                     <td>${result[i]["IdUsuario"]}</td>
                        <td class="text-center align-middle">${result[i]["Nombre"]}</td>
                        <td class="text-center align-middle">${result[i]["Apellido"]}</td>
                        <td class="text-center align-middle">${result[i]["Direccion"]}</td>
                        <td class="text-center align-middle">${result[i]["CorreoElectronico"]}</td>
                        <td class="text-center align-middle">${result[i]["TipoUsuario"]}</td>
                        <td class="text-center align-middle">
                            <i class="btn fas fa-edit editar"  onclick="RegistrarClienteBandera=false;"   data-id="${result[i]["IdUsuario"]}"></i>
                            <i class="btn fas fa-trash-alt eliminar" data-id="${result[i]["IdUsuario"]}"></i>
                        </td>
                    `;
                    CuerpoTabla.appendChild(trRegistro);
                }
            },
            error: function (error) {
                alert("Error en la peticion" + error);
            }
        });
    }
}