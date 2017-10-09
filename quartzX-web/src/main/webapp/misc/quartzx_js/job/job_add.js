$(function () {
    $("#myModal").on("hidden.bs.modal", function() {
        clearForm($('#jobAddForm'));
    });
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

function clearForm(form) {
    // input清空
    $(':input', form).each(function () {
        var type = this.type;
        var tag = this.tagName.toLowerCase(); // normalize case
        if (type == 'text' || type == 'password' || tag == 'textarea')
            this.value = "";
        // 多选checkboxes清空
        // select 下拉框清空
        else if (tag == 'select')
            this.selectedIndex = -1;
        $(this).tooltip('destroy').removeClass(errorClass);
    });
};