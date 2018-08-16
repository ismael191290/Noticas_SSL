new Vue({
    el: '#apps',
    data: {
        // atributos que utilizaremos
        noticiasL: [],
        noticiasN: [],
        status: '',
        search: ''

    },
    created: function () {
        this.locAjax();
        this.nacAjax();
    },
    methods: {
        // metodos para utilizar en el funcionamiento del sistema
        locAjax: function () {
            // muestra noticas Locales
            this.$http.get("http://localhost:8084/xmlNoticias/ServletNoticias?option=loca")
                    .then(function (result) {
                        var json = JSON.parse(result.data.results);
                        this.noticiasL = json;
                        this.status = "1";
                    });
        },
        nacAjax: function () {
            // muestra noticias nacinales
            this.$http.get("http://localhost:8084/xmlNoticias/ServletNoticias?option=nacio")
                    .then(function (result) {
                        var json = JSON.parse(result.data.results);
                        console.log(result);
                        this.noticiasN = json;
                    });
        },
    }
});

