import { useEffect } from "react";
import Commands from "./Commands";
import GoBackButton from "./GoBackButton";
import ReceivedMessages from "./ReceivedMessages";
import SendMessage from "./SendMessage";
import Websocket from "./Websocket";
import { useSelector } from "react-redux";
import { fetchGroups } from "../redux/groupsWs";
import { useAppDispatch } from "../redux/store";
import { useMessageHandlers } from "../hooks/useMessageHandlers";
import { Message } from "./Logic";
import LogInPage from "./LogInPage";

const App = () => {
  const connect = useSelector((state: any) => state.connectRedux.value);
  const logIn = useSelector((state: any) => state.logInRedux.value);
  const dispatch = useAppDispatch();

  const {addMessage} = useMessageHandlers();


  useEffect(() => {
    dispatch(fetchGroups())
    // let message : Message = {group : "ceva",message: "ceva",receiver: "ceva",sender: "ceva"};
    // addMessage("Ceva", message);
    // addMessage("Ceva", message);
    // addMessage("Ceva", message);
    // addMessage("Ceva", message);
    // addMessage("Ceva", message);
    // addMessage("Ceva", message);
  }, []);

  return !logIn ?
     <>
      <LogInPage />
     </>
  :
  !connect ? (
    <>
      <Websocket />
    </>
  ) : (
    <>
      <GoBackButton />
      <Commands />
      <SendMessage />
      <ReceivedMessages />
    </>
  );
};

export default App;
