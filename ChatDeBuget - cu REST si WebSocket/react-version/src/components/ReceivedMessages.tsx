import { useSelector } from "react-redux";
import { Message } from "./Logic";

const ReceivedMessages = () => {
  const activeGroup = useSelector((state: any) => state.activeGroupRedux.value);
  const mapOfMessages = useSelector((state: any) => state.messageRedux.value);
  let messagesActive = mapOfMessages.get(activeGroup);

  const messageToHTML = (messages: Message[]) => {
    if (messages == undefined){
      return;
    }
    return messages.map((message: Message) => (
      <label className="block text-gray-700 font-bold mb-2">
        {message.sender} said {message.message}{" "}
      </label>
    ));
  };
  return <>{messageToHTML(messagesActive)}</>;
};

export default ReceivedMessages;
