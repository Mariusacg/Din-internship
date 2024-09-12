import { useDispatch } from "react-redux";
import { Message } from "../components/Logic";
import { addMessageRD } from "../redux/messagesWs";

export const useMessageHandlers = () => {
  const dispatch = useDispatch();

  const addMessage = (group: string, message: Message): void => {
    dispatch(addMessageRD({ group, message }));
  };

  return {
    addMessage,
  };
};
