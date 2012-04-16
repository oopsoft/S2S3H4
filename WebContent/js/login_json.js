$(document).ready(
		function() {
			$("#login").click(
					function() {
						// 把表单的数据进行序列化
						var params = $("form").serialize();
						// 使用jQuery中的$.ajax({});Ajax方法
						$.ajax({
							url : "/S2S3H4/person/login.action",
							type : "POST",
							data : params,
							dataType : "json",
							success : function(data) {
								// 清空显示层中的数据
								$("#message").html("");
								alert(data);
								if(data){
									//$("#message").html("Login OK!");
									 window.location.href="/S2S3H4/person/admin.action";
								}else{
									// 为显示层添加获取到的数据
									// 获取对象的数据用data.userInfo.属性
									$("#message").html("Login Failed!");
								}
							}
						});
					});
		});