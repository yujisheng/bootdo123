
$(function () {
    laydate({
        elem: '#birth'
    });
});
/**
 * 基本信息提交
 */
$("#base_save_android").click(function () {
    var hobbyStr = getHobbyStr();
    $("#hobby").val(hobbyStr);
    if ($("#basicInfoForm-android").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/plugin/push/save",
            data: $('#basicInfoForm-android').serialize(),
            async: false,
            error: function (request) {
                laryer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.msg("保存成功");
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }

});
$("#base_save_ios").click(function () {
    var hobbyStr = getHobbyStr();
    $("#hobby").val(hobbyStr);
    if ($("#basicInfoForm-ios").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/plugin/push/save",
            data: $('#basicInfoForm-ios').serialize(),
            async: false,
            error: function (request) {
                laryer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.msg("保存成功");
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }

});
$("#base_push_android").click(function () {
    var hobbyStr = getHobbyStr();
    $("#hobby").val(hobbyStr);
    if ($("#basicInfoForm-android").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/plugin/push/pushMessageToAndroidAll",
            data: $('#basicInfoForm-android').serialize(),
            async: false,
            error: function (request) {
                laryer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.msg("推送成功");
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }

});
$("#base_push_ios").click(function () {
    var hobbyStr = getHobbyStr();
    $("#hobby").val(hobbyStr);
    if ($("#basicInfoForm-ios").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/plugin/push/pushMessageToIosAll",
            data: $('#basicInfoForm-ios').serialize(),
            async: false,
            error: function (request) {
                laryer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.msg("推送成功");
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }

});

$("#pwd_save").click(function () {
    if ($("#modifyPwd").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "#",
            data: $('#modifyPwd').serialize(),
            async: false,
            error: function (request) {
                parent.laryer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.alert("更新密码成功");
                    $("#photo_info").click();
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }
});

function getHobbyStr() {
    var hobbyStr = "";
    $(".hobby").each(function () {
        if ($(this).is(":checked")) {
            hobbyStr += $(this).val() + ";";
        }
    });
    return hobbyStr;
}