<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <script type="text/javascript" src="${appName}/demo/jquery-3.3.1.min.js"></script>
    <div>
        <p id="context"></p>
        <input type="text" width="100px" id="message"/>
        <input type="button" id="send" value="发送" />
    </div>

    </div>
</head>
<body>

</body>
<script>

    var username = '匿名';
    function getUrlParameter(parameter) {
        var reg = new RegExp("(^|&)" + parameter + "=([^&]*)(&|$)", "i");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }

    var socket;
    if (typeof (WebSocket) == "undefined") {
        $("#context").append("<p>您的浏览器不支持WebSocket</p>");
    } else {
        $("#context").append("<p>您的浏览器支持WebSocket</p>");
        $("#context").append("<p>连接：ws://127.0.0.1:8888/fims/websocket</p>");

        if(getUrlParameter("user") != null){
            username = getUrlParameter("user");
        }
        socket = new WebSocket("ws://127.0.0.1:8888/fims/websocket/" + username);

        //打开事件
        socket.onopen = function () {
            socket.send("快来迎接我吧...");
        };

        //获得消息事件
        socket.onmessage = function (msg) {
            $("#context").append("<p>" + msg.data + "</p>");
        };

        //关闭事件
        socket.onclose = function () {

        };

        // 发生错误触发
        socket.onerror = function () {

        }

        $("#send").on("click", function () {
            var message = $("#message").val();
            socket.send(message);
            $("#message").val("");
        });

    }
</script>

</html>
