$(function () {
    $("#saveJob").click(function () {
        if(validform().form()){
            alert('验证通过');
        }
    })
});
function validform()
{
    return $('#jobAddForm').validate({
        rules: {
            jobName: {
                required: true
            }
        },
        messages: {
            jobName: {
                required: "不能为空"
            }
        },
        success: 'valid',
        unhighlight: function (element, errorClass, validClass) { //验证通过
            $(element).tooltip('destroy').removeClass(errorClass);
        },
        errorPlacement: function (error, element) {
            if ($(element).next("div").hasClass("tooltip")) {
                $(element).attr("data-original-title", $(error).text()).tooltip("show");
            } else {
                $(element).attr("title",
                    $(error).text()).tooltip("show");
            }
        }
    });
}