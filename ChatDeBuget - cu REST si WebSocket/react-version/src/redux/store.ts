import { configureStore } from "@reduxjs/toolkit";
import { connectSlice } from "./connectWs";
import { groupsSlice } from "./groupsWs";
import { activeGroupSlice } from "./activeGroup";
import { messageSlice } from "./messagesWs";
import { useDispatch } from "react-redux";
import { logInSlice } from "./logIn";

const store =  configureStore({
  reducer: {
    connectRedux: connectSlice.reducer, 
    logInRedux: logInSlice.reducer, 
    groupsRedux: groupsSlice.reducer,
    activeGroupRedux: activeGroupSlice.reducer,
    messageRedux: messageSlice.reducer,
  },
});

export default store;
export type AppDispatch = typeof store.dispatch
export const useAppDispatch = useDispatch.withTypes<AppDispatch>()