import { useState } from "react";
import { sendMessage } from "./Logic";
import { useAppDispatch } from "../redux/store";
import { fetchGroups } from "../redux/groupsWs";

const Commands = () => {
  const [group, setGroup] = useState("");
  const [inviteReceiver, setInviteReceiver] = useState("");

  const dispatch = useAppDispatch();
  return (
    <>
      {/* Create Group */}
      <div>
        <label className="block text-gray-700 font-bold mb-2">
          New group name:
        </label>
        <input
          className="border rounded w-full py-2 px-3 mb-2"
          placeholder="Creative group name"
          value={group}
          onChange={(e) => setGroup(e.target.value)}
        />
        <button></button>
      </div>
      <button
        className="bg-indigo-500 hover:bg-indigo-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
        onClick={() => {
          if (group.match("[A-Za-z0-9]+")) {
            sendMessage("!group " + group, "", "");
            dispatch(fetchGroups())
          }
        }}
      >
        Create group
      </button>
      
      {/* Hello To */}
      <div>
        <label className="block text-gray-700 font-bold mb-2">
          Receiver of hello:
        </label>
        <input
          className="border rounded w-full py-2 px-3 mb-2"
          placeholder="Giany"
          value={inviteReceiver}
          onChange={(e) => setInviteReceiver(e.target.value)}
        />
        <button></button>
      </div>
      <button
        className="bg-indigo-500 hover:bg-indigo-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
        onClick={() => {
          if (inviteReceiver.match("[A-Za-z0-9]+")) {
            sendMessage("!hello ", inviteReceiver, "");
          }
        }}
      >
        Invite to chat
      </button>
    </>
  );
};

export default Commands;
