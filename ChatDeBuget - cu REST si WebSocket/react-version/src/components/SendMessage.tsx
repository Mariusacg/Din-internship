import { useState } from "react";
import { sendMessage } from "./Logic";
import DropDown from "./Dropdown";
import { useSelector } from "react-redux";
import { useActiveGroupHandlers } from "../hooks/useActiveGroupHandlers";

const SendMessage = () => {
  const [message, setMessage] = useState("");
  const [receiver, setReceiver] = useState("");
  const [showDropDown, setShowDropDown] = useState<boolean>(false);
  const groups = useSelector((state: any) => state.groupsRedux.value);
  const activeGroup = useSelector((state: any) => state.activeGroupRedux.value);

  const { updateActiveGroup } = useActiveGroupHandlers();
  const toggleDropDown = () => {
    setShowDropDown(!showDropDown);
  };
  const dismissHandler = (event: React.FocusEvent<HTMLButtonElement>): void => {
    if (event.currentTarget === event.target) {
      setShowDropDown(false);
    }
  };
  const groupSelection = (group: string): void => {
    updateActiveGroup(group);
  };

  return (
    <>
      <div>
        <label className="block text-gray-700 font-bold mb-2">Message:</label>
        <input
          className="border rounded w-full py-2 px-3 mb-2"
          placeholder="Hello world"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
        />
      </div>
      <div>
        <label className="block text-gray-700 font-bold mb-2">Receiver:</label>
        <input
          className="border rounded w-full py-2 px-3 mb-2"
          placeholder="Xavier"
          value={receiver}
          onChange={(e) => setReceiver(e.target.value)}
        />
      </div>
      <div>
        <label className="block text-gray-700 font-bold mb-2">Group:</label>
        <>
          <button
            className={
              "bg-indigo-500 hover:bg-indigo-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
            }
            onClick={(): void => toggleDropDown()}
            onBlur={(e: React.FocusEvent<HTMLButtonElement>): void =>
              dismissHandler(e)
            }
          >
            <div>
              {showDropDown
                ? "Selected right now : " + activeGroup
                : "⬇️ Select a group ⬇️"}{" "}
            </div>
            {showDropDown && (
              <DropDown
                groups={groups}
                showDropDown={false}
                toggleDropDown={(): void => toggleDropDown()}
                groupSelection={groupSelection}
              />
            )}
          </button>
        </>
      </div>
      <button
        className="bg-indigo-500 hover:bg-indigo-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
        onClick={() => {
          sendMessage(message, receiver, activeGroup);
        }}
      >
        Send Message
      </button>
    </>
  );
};

export default SendMessage;
