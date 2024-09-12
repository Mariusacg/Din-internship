export interface Message {
  sender: string;
  message: string;
  receiver: string;
  group: string;
}

let currentNickname: string;
let ws: WebSocket;

export function connectToWs(
  url: string,
  newNickname: string,
  onOpen: any,
  onMessage: any,
  onError: any,
  onClose: any
): void {
  console.log(url);
  ws = new WebSocket(url);
  ws.onopen = onOpen;
  ws.onmessage = onMessage;
  ws.onerror = onError;
  ws.onclose = onClose;
  currentNickname = newNickname;
}
export function sendMessage(
  message: string,
  receiver: string,
  group: string
): void {
  let sender = currentNickname;

  let jsonMessage: Message = { sender, message, receiver, group };

  console.log(JSON.stringify(jsonMessage));
  ws.send(JSON.stringify(jsonMessage));
}

export function closeWs(): void {
  ws.close();
}
