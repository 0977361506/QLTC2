'use strict';

var stompClient = null;
var stompClient = null;
var currentSubscription;
var topic = null;
var username;
function loadUser() {
    var data = {};
    $.ajax({
        type: "POST",
        url: "/api/current_user",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function (responesData) {
           // console.log(responesData);
            username = responesData[0];
            // console.log(username);

        }, error: function (response) {
            console.log("fail");
            console.log(response);

        }
    });
}
function loadChatLog(roomID) {
    var data = {};
    data['id'] = roomID;
    // console.log(data);
    $.ajax({
        type: "POST",
        url: "/api/chatmess",
        data: JSON.stringify(data),
        dataType: "json",
        contentType: "application/json",
        success: function (responesData) {
            responesData.forEach(function (e) {
                renderMessage(e);
            })
            setTimeout(function () {
                $('.message-modal-body').animate({
                    scrollTop: $('.message-modal-body').get(0).scrollHeight
                }, 500);
            }, 500);


        }, error: function (response) {
            console.log("fail");
            console.log(response);

        }
    });
}

function connect(id) {
    $('#room').val(id);
    Cookies.set('name', username);

    var socket = new SockJS('/sock');
    stompClient = Stomp.over(socket);
    stompClient.debug = () => {
    };
    stompClient.connect({}, onConnected, onError);


}

function onConnected() {

    enterRoom($('#room').val());

}

function onError(error) {
    console.log('uh oh! service unavailable');
}

function enterRoom(newRoomId) {
    var roomId = newRoomId;
    Cookies.set('roomId', room);
    // roomIdDisplay.textContent = roomId;
    topic = `/chat-app/chat/${newRoomId}`;
    currentSubscription = stompClient.subscribe(`/chat-room/${roomId}`,
        onMessageReceived);
//	console.log('after sub')
    var username1 = username;
    // console.log(username);
    stompClient.send(`${topic}/addUser`, {}, JSON.stringify({
        sender: username1,
        type: 'JOIN'
    }));
    loadChatLog(newRoomId);
}

function onMessageReceived(payload) {
    var message = JSON.parse(payload.body);
    renderMessage(message);
    $('.message-modal-body').animate({
        scrollTop: $('.message-modal-body').get(0).scrollHeight
    }, 0);
}

function renderMessage(message) {
    // console.log(message);
    var strChat = '';
    if (message.type == 'CHAT') {
        var strChatContainer = 'card py-2 px-3 message-container';
        if (message.sender == username) {
            strChatContainer += ' my-mess';
        }
        strChat += '<div class="' + strChatContainer + '">';
        if (message.sender != username) {
            strChat += '<div class="sender  mb-2">' + message.sender + ' :</div>';
        }

        strChat += '<div class="content">' + $('<div/>', {
            html: message.content
            // get text content from element for decoded text
        }).text() + '</div>';
        strChat += '</div>';
    }
    $('#messageArea').append(
        strChat
    );


}

function sendMessage(event) {
    var messageContent = $("#message").val().trim();
    var username1 = username;
    var newRoomId = $('#room').val().trim();

    topic = `/chat-app/chat/${newRoomId}`;
    if (messageContent && stompClient) {
        var chatMessage = {
            sender: username1,
            content: messageContent,
            type: 'CHAT'
        };
        stompClient.send(`${topic}/sendMessage`, {}, JSON
            .stringify(chatMessage));
        document.querySelector('#message').value = '';
    }
    event.preventDefault();
}

function disconnect() {

    stompClient.disconnect(onDisConnect, {});

}

function onDisConnect() {
    currentSubscription.unsubscribe();
    $('#messageArea').empty();
}

$(document).ready(function () {
    loadUser();
    $('.open-chat').on('click', function () {
        var roomId = $(this).attr('room-id');
        $('#chat-room').on('shown.bs.modal', connect(roomId));
    });
    $('#chat-room').on('hidden.bs.modal', function () {
        disconnect();
    });
    messagebox.addEventListener('submit', sendMessage, true);
})