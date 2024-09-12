import { closeWs } from "./Logic";

const GoBackButton = () => {
  return (
    <button
      className="bg-indigo-500 hover:bg-indigo-600 text-white font-bold py-2 px-4 rounded-full  focus:outline-none focus:shadow-outline"
      onClick={() => {
        closeWs();
      }}
    >
      Back
    </button>
  );
};

export default GoBackButton;
