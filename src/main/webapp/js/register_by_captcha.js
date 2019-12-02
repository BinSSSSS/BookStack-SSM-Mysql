$(function() {

	var $iptName = $("#usernamesignup"); // 用户名输入框
	var $iptPass = $("#passwordsignup"); // 密码输入框
	var $iptRepPass = $("#passwordsignup_confirm"); // 重复密码输入框
	var $iptPhoneNum = $("#phonenumsignup"); // 手机号输入框
	var $iptRegister = $("#ipt-register"); // 注册按钮
	var $errorTips; // 错误提示
	var $msgSender = $("#msg-sender"); // 手机验证码发送

	/* 每次加载页面的时候点击link标签 */
	if (document.getElementById("link") != null)
		document.getElementById("link").click();

	var isAllReady = [ 1, 1, 1, 1 ]; // 表示注册的所有元素是否全部正确

	
	//验证手机号码格式是否正确
	function verifyPhoneNumber($phoneNum){
		
		console.log("phone number " + $phoneNum);
		var pattern = /^1[3578]\d{9}$/;
		if ($phoneNum.length != 11) {
			inputError($iptPhoneNum, "手机号码必须是11位!");
		} else if (!pattern.test($phoneNum)) {
			inputError($iptPhoneNum, "手机号码格式不正确!");
		}else {
			return true;
		}
		return false;
	}
	
	// /输入正确的时候调用的函数
	function inputSuccess(input) {
		$errorTips = input.next(); // 拿到兄弟元素
		$errorTips.text("");
	}

	// /输入错误的时候调用的函数
	function inputError(input, errMsg) {
		$errorTips = input.next(); // 拿到兄弟元素
		$errorTips.text(errMsg);
	}
	// 输入框失去焦点时的事件

	// 1. 用户名输入
	$iptName.focusout(function() {

		var $str = $(this).val();
		var len = 0;
		isAllReady[0] = 0; // 初始状态

		// /中文字符算为两个长度-英文字符算作一个长度
		for (var i = 0; i < $str.length; ++i) {
			if ($str.charCodeAt(i) > 127 || $str.charCodeAt(i) == 94) {
				len += 2;
			} else {
				len++;
			}
		}
		// /用户名不能为空或者是超过24个长度
		if (len == 0) {
			inputError($(this), "用户名不能为空");
		} else if (len > 24) {
			inputError($(this), "用户名中文最多12位，英文24位");
		} else {
			inputSuccess($(this));
			isAllReady[0] = 1; // 如果成功设置为1
		}
	})
	var $password = null; // 记录输入的密码
	// 2.密码输入
	$iptPass.focusout(function() {

		$password = null;
		var len = $(this).val().length;

		isAllReady[1] = 0;

		// /1.密码不能为空且需要至少大于8位
		if (len == 0) {
			inputError($(this), "密码不能为空");
		} else if (len < 8) {
			inputError($(this), "密码至少大于8位");
		} else {
			$password = $(this).val(); // 记录下密码
			inputSuccess($(this));
			$iptRepPass.focusout(); // 如果修改成功之后顺便激活重复密码的失去焦点事件
			isAllReady[1] = 1;
		}

	})

	// 3.重复密码输入
	$iptRepPass.focusout(function() {

		isAllReady[2] = 0;
		// /第二次输入的密码必须与之前的输入保持一致
		if ($password != null && $password == $(this).val()) {
			inputSuccess($(this));
			isAllReady[2] = 1;
		} else {
			inputError($(this), "输入的密码与上次不一致-");

		}
	})

	// 4.手机号码输入
	$iptPhoneNum.focusout(function() {

		isAllReady[3] = 0;
		// /1.手机号码必须长度为11-暂时不进行验证码测试- 使用正则表达式进行手机号的过滤
		var $phoneNum = $(this).val();
		if(!verifyPhoneNumber($phoneNum)) 
			return false;
		else {
			inputSuccess($(this));
			isAllReady[3] = 1;
			
			//手机号码填写正确才可以激活发送验证码事件
			$msgSender.removeClass("disabel");
			$msgSender.addClass("able");
			$msgSender.removeAttr("disabled");
		}

	})
	$iptRegister.click(function(event) {

		var index = isAllReady.indexOf(0);

		if (index != -1) {
			// console.log("错误");
			return false;
		} else {
			$iptRegister.disable = true;
			$("form-reg").submit();

			setTimeout(function() {
				$iptRegister.disable = false;
			}, 1000);

			// console.log("成功");
			// $iptRegister.submit();
		}
	});

	// 发送验证码按钮
	$msgSender.click(function() {
		
		if(!verifyPhoneNumber($iptPhoneNum.val())){
			return;
		}
		
		/*将发送验证码按钮设置为不可用状态*/
		$msgSender.removeClass("able");
		$msgSender.addClass("disable");
		$msgSender.attr("disabled","disabled");
		
		/*向后台发送数据*/
		
		$.ajax({
			url: "register_captcha",
			method: "get",
			data:{
				phoneNum: $iptPhoneNum.val()
			},
			//当请求回来的数据不是成功状态的时候，打印出该数据
			success: function(data){
				if(data != "Success"){
					inputError($msgSender,data);
					return;
				}
			}
			
		});
		
		/* 开启一个为一分钟的定时器*/
		var time =  60;
		var t = window.setInterval(function(){
			$msgSender.text("发送验证码(" + --time + ")");
		},1000);
		window.setTimeout(function(){
			window.clearInterval(t);
		},6000);
		
	});

	/* 立即登录按钮 */
	$('.btn-login').click(function() {
		$("#regsucc").remove(); // 删除所有元素
		// document.getElementsByClassName("to_login")[0].click();
	});

});