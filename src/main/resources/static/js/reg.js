const regButton = document.querySelector('.reg-btn');
regButton.addEventListener('click', function() {
    // 取得输入框的值

    var data = {
        "userName": userName,
        "pwd": pwd,
        "mobile": mobile,
        "email": email,
        "name": name,
        "gender": gender
    };

    fetch(
        '/reg/api',
        {
            body: JSON.stringify(data),
            cache: 'no-cache',
            headers: {
                'content-type': 'application/json'
            },
            method: 'POST'
        }
    )
        .then(function(response) {
            return response.json();
        })
        .then(function(result) {
            console.log("data is :" + JSON.stringify(result))
            if (result.isSuccess == true || result.success == true) {
                alert("注册成功");
                // 这里加入跳转语句跳转到商品列表页面
            }else {
                alert("注册失败")
            }
        });

});