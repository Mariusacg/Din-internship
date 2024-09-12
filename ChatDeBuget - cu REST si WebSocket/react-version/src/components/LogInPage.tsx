import { useState } from "react";

const LogInPage = () => {
  const [username, setUsername] = useState(
    "MariusAndreiCosmin.Grigoras@lseg.com"
  );
  const [password, setPassword] = useState("internship");

  const getToken = async () => {
    try {
      const requestObject = new URLSearchParams({
        grant_type: "password",
        client_id: "chat-client",
        username: username,
        password: password,
      });
      const config = {
        headers: {
          "Content-Type": "application/x-www-form-urlencoded",
        },
      };
      const resp = await fetch(
        '/api/auth/realms/INTERNSHIP/protocol/openid-connect/token',
        {
          method: "POST",
          headers: config.headers,
          body: requestObject,
        }
      );

      return await resp.json;
    } catch (error) {
      return error;
    }
  };
  return (
    <>
      <div className="mb-4">
        <label className="block text-gray-700 font-bold mb-2">
          Username:
        </label>
        <input
          className="border rounded w-full py-2 px-3 mb-2"
          placeholder="Your name"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
        />
      </div>
      <div>
        <label className="block text-gray-700 font-bold mb-2">
          Your password:
        </label>
        <input
          className="border rounded w-full py-2 px-3 mb-2"
          placeholder="qwerty"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
        <button></button>
      </div>
      <button
        className="bg-indigo-500 hover:bg-indigo-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
        onClick={() => {
          getToken()
            .then((result) => {
              console.log(result);
            })
            .catch((error) => {
              console.log(JSON.stringify(error, null, 4));
            });
        }}
      >
        Auth
      </button>
    </>
  );
};

export default LogInPage;
