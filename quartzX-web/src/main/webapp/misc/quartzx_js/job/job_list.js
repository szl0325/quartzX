$(function () {
    var columns = [
        { "data": "id" },
        { "data": "name" },
        { "data": "phone" },
        {
            "data": "null",
            "render": function (data, type, row, meta) {
                return "123";
            }
        }
    ];
    $("#jobTable").click(function(){
        var param={};
        pagination($("#jobTable"), param, "POST", "/job/showPage", columns);
    });
});