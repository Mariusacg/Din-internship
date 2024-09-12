import "./style.css";
interface Message {
  sender: string;
  message: string;
  receiver: string;
  group: string;
}

document.querySelector<HTMLDivElement>("#websocket")!.innerHTML = `
    <div class="form-group">
        <label for="websocketURL">Server:</label> &nbsp;
        <input type="text" id="websocketURL" placeholder="WebsocketURL" class="form-control"> &nbsp;&nbsp;
        <label for="nickname">Your nickname:</label> &nbsp;
        <input type="text" id="nickname" placeholder="Banel Nicolita" class="form-control"> &nbsp;&nbsp;
        <button id="btnConnect" type="button" class="btn btn-sm btn-primary">Connect</button>
    </div>
    
    <div class="form-group">
    <label for="messageInput">Message:</label>&nbsp;
    <input type="text" id="messageInput" placeholder="message" value="" class="form-control"> &nbsp;&nbsp;
    <label for="receiver">Receiver:</label> &nbsp;
    <input type="text" id="receiver" class="form-control" placeholder="Echipa team"> &nbsp;&nbsp;
    <label for="group">Group:</label> &nbsp;
    <input type="text" id="group" class="form-control" placeholder="Group"> &nbsp;&nbsp;
    <button id="btnSendMessage" type="button" class="btn btn-sm btn-primary">Send Message</button> &nbsp;&nbsp;
    </div>
 
    <h5>Incoming Messages:</h5>
    <div id="inMessage">
        <pre id="inMessagePre">
        </pre>
    </div>
    `;

let btnConnect: any;
let btnSendMessage: any;
let inMessagePre: any;
let ws: WebSocket;
let sender: string;

function connect(url: string, newNickname: string): void {
  console.log(url);
  ws = new WebSocket(url);
  ws.onopen = onOpen;
  ws.onmessage = onMessage;
  ws.onerror = onError;
  ws.onclose = onClose;
  sender = newNickname;
}

function onOpen(event: any): void {
  console.log("connected");
  btnConnect.innerHTML = "Connected";
}

function onMessage(event: any): void {
  let incomingMessage: Message = JSON.parse(event.data);

  console.log(incomingMessage);

  display(inMessagePre, incomingMessage.message, incomingMessage.sender);
}
function display(el: any, msg: string, messagesender: string): void {
  if (messagesender != null && messagesender != sender) {
    el.innerHTML = sender + " said:" + msg;
  } else {
    el.innerHTML = "Command used :" + msg;
  }
}
function onError(event: any): void {
  console.log(JSON.stringify(event.data));
}

function onClose(event: any): void {
  console.log(JSON.stringify(event.data));
}

window.onload = () => {
  btnConnect = document.getElementById("btnConnect");
  btnSendMessage = document.getElementById("btnSendMessage");
  inMessagePre = document.getElementById("inMessagePre");

  btnConnect.addEventListener("click", function () {
    let websocketURL: any = document.getElementById("websocketURL");
    let nicknameRead: any = document.getElementById("nickname");
    connect(websocketURL.value, nicknameRead.value);
  });
  btnSendMessage.addEventListener("click", function () {
    let messageInput: any = document.getElementById("messageInput");
    let receiver: any = document.getElementById("receiver");
    let group: any = document.getElementById("group");
    sendMessage(messageInput.value, receiver.value, group.value);
  });
};
function sendMessage(message: string, receiver: string, group: string): void {
  let jsonMessage: Message = { sender, message, receiver, group };

  console.log(JSON.stringify(jsonMessage));
  ws.send(JSON.stringify(jsonMessage));
}
