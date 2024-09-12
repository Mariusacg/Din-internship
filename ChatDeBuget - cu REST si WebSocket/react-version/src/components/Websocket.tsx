import { useState } from "react";
import { connectToWs } from "./Logic";
import { useSelector } from 'react-redux'
import { useWebsocketHandlers } from "../hooks/useWebsocketHandlers";

const Websocket = () => { 
  const [websocketURL, setWebsocketURL] = useState("ws://localhost:8080/chat-websocket");
  const [nickname, setNickname] = useState("");
  const connect = useSelector((state : any) => state.connectRedux.value)
  const {onOpen, onMessage, onError, onClose} = useWebsocketHandlers();

  return (
    <>
      <div className="mb-4">
        <label className="block text-gray-700 font-bold mb-2">
          Websocket URl:
        </label>
        <input
          className="border rounded w-full py-2 px-3 mb-2"
          placeholder="WebsocketURL"
          value={websocketURL}
          onChange={(e) => setWebsocketURL(e.target.value)}
        />
      </div>
      <div>
        <label className="block text-gray-700 font-bold mb-2">
          Your nickname:
        </label>
        <input
          className="border rounded w-full py-2 px-3 mb-2"
          placeholder="Gigi"
          value={nickname}
          onChange={(e) => setNickname(e.target.value)}
        />
        <button></button>
      </div>
      <button
        className="bg-indigo-500 hover:bg-indigo-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
        onClick={() => {
          connectToWs(websocketURL, nickname, onOpen, onMessage, onError, onClose);
        }}
      >
        {connect ? "Connected" : "Connect"}
      </button>
    </>
  );
};

export default Websocket;
