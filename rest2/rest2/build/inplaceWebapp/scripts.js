$(document).ready(function(){
    $('#books').DataTable({
    	"ajax": "/rst2/api/Books",
    	"columns": [
            { "data": "id" },
            { "data": "name" },
            { "data": "author" },
            { "data": "genre" },
            { "data": "pagesNum" }
        ],
        "columnDefs": [
           { className: "dt-body-center", "targets": "_all"}
        ],
        scrollY:        500,
        deferRender:    true,
        scroller:       true
    })
});