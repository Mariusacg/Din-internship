import { useDispatch } from "react-redux";
import { failed, finish, successful } from "../redux/connectWs";
import { Message } from "../components/Logic";

export const useWebsocketHandlers = () => {
    const dispatch = useDispatch();

  const  onOpen = (event: any): void => {
    dispatch(successful());
    console.log("connected"); 
  }

  const onMessage = (event: any): void => {
    let incomingMessage: Message = JSON.parse(event.data);
    console.log(incomingMessage);
  }
  const onError = (event: any): void =>{
    dispatch(failed());
  }
  
  const onClose = (event: any): void =>{
    dispatch(finish());
    console.log(JSON.stringify(event.data));
  }

  return {
    onOpen, onMessage, onError, onClose
  }
}