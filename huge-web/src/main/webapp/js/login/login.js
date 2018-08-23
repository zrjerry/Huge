var validateRegExp = {
    num: "^([+-]?)\\d*\\.?\\d+$", //数字
    chinese: "^[\\u4e00-\\u9fa5]+$", //仅中文
    notempty: "^\\S+$", //非空
    url: "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$", //url
    letter: "^[A-Za-z]+$", //字母
    letter_l: "^[a-z]+$", //小写字母
    letter_u: "^[A-Z]+$", //大写字母
    fullNumber: "^[0-9]+$", //数字
    username: "^[A-Za-z0-9_\\-\\u4e00-\\u9fa5]+$", //用户名
    password: "^.*[A-Za-z0-9\\w_-]+.*$"  //密码
};

//验证规则
var validateRules = {
	    isNull: function (str) {
	        return (str == "" || typeof str != "string");
	    },
	    betweenLength: function (str, _min, _max) {
	        return (str.length >= _min && str.length <= _max);
	    },
	    isUid: function (str) {
	        return new RegExp(validateRegExp.username).test(str);
	    },
	    fullNumberName: function (str) {
	        return new RegExp(validateRegExp.fullNumber).test(str);
	    },
	};
//验证文本
var validatePrompt = {
    username: {
        onFocus: "6-20位字符，可由中文、英文、数字及“_”、“-”组成",
        succeed: "",
        isNull: "请输入用户名",
        error: {
            beUsed: "该用户名已被使用，请使用其它用户名注册，如果您是&quot;{1}&quot;，请<a href='../uc/login' class='flk13'>登录</a>",
            badLength: "用户名长度只能在4-20位字符之间",
            badFormat: "用户名只能由中文、英文、数字及“_”、“-”组成",
            fullNumberName: "用户名不能全为数字"
        }
    },
    pwd: {
        onFocus: "6-20位字符，可使用字母、数字或符号的组合",
        succeed: "",
        isNull: "请输入密码",
        error: {
            badLength: "密码长度只能在6-20位字符之间",
            badFormat: "密码只能由英文、数字及标点符号组成",
            simplePwd: "密码太弱，有被盗风险，建议设置多种字符组成的复杂密码"
        }
    }
};

$.extend(validatePrompt, {
    username: {
        onFocus: "",
        succeed: "",
        isNull: "用户名/已验证手机",
        error: "不存在此用户名"
    }
});




setTimeout(function () {
    if (!$("#loginname").val()) {
        $("#loginname").get(0).focus();
    }
}, 0);

$("#loginsubmit").click(function () {
        var _username = $("#formlogin [name=username]").val();
		alert(_username)
        var _password = $("#formlogin [name=password]").val();
        $.ajax({
            type: "POST",
            url: "/service/user/doLogin",
            contentType: "application/x-www-form-urlencoded; charset=utf-8",
            data: {username:_username,password:_password},
            dataType: "json",
            success: function (result) {
                	//把result转成js对象
                    var obj = eval(result);		
                    if (obj.status == 200) {
                    	window.location.href = "/index";
                        return;
                    }
            }
        })
        return false;
})

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	HUGE.checkLogin();
});