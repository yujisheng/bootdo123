var obj = new Object();
$(function () {

    $("#ios_info").click(function () {
        obj.type = 'ios';
        $("#push_type").val(obj.type);
        console.log("obj.type=" + obj.type);
    });
    $("#android_info").click(function () {
        obj.type = 'android';
        $("#push_type").val(obj.type);
        console.log("obj.type=" + obj.type);
    });

    $("#push_all_1").click(function () {
        obj.targetType = 'all';
        $("#tag_alias").val(obj.targetType);
        console.log("obj.targetType=" + obj.targetType);
    });
    $("#push_all_2").click(function () {
        obj.targetType = 'tag';
        $("#tag_alias").val(obj.targetType);
        console.log("obj.targetType=" + obj.targetType);
    });
    $("#push_all_3").click(function () {
        obj.targetType = 'alias';
        $("#tag_alias").val(obj.targetType);
        console.log("obj.targetType=" + obj.targetType);
    });
});
/**
 * 基本信息提交
 */
$("#base_save").click(function () {
    var hobbyStr = getHobbyStr();
    $("#hobby").val(hobbyStr);
    if ($("#basicInfoForm").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/plugin/push/save",
            data: $('#basicInfoForm').serialize(),
            async: false,
            error: function (request) {
                laryer.alert("Connection error");
            },
            success: function (data) {
                if (data.code == 0) {
                    parent.layer.msg("保存成功");
                    parent.reLoad();
                    var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
                    parent.layer.close(index);
                } else {
                    parent.layer.alert(data.msg)
                }
            }
        });
    }

});

$("#base_push").click(function () {
    var hobbyStr = getHobbyStr();
    $("#hobby").val(hobbyStr);
    if ($("#basicInfoForm").valid()) {
        $.ajax({
            cache: true,
            type: "POST",
            url: "/plugin/push/pushMessage",
            data: $('#basicInfoForm').serialize(),
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

// $("push_tag_1").click(function () {
//     alert("push_tag")
// });
// $("#push_tag_2").click(function () {
//     alert("push_alias")
// });
// $("#push_tag_3").click(function () {
//     alert("push_all")
// });
