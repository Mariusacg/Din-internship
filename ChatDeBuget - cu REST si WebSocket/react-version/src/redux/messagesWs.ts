import { createSlice, PayloadAction } from "@reduxjs/toolkit";
import { Message } from "../components/Logic";

export interface IncomingMessage {
  group: string;
  message: Message;
}
export interface MessageWrapper {
  value: Map<string, Message[]>;
}

const initialState: MessageWrapper = {
  value: new Map<string, Message[]>(),
};

export const messageSlice = createSlice({
  name: "messageRedux",
  initialState,
  reducers: {
    addMessageRD: (state, action: PayloadAction<IncomingMessage>) => {
      if (state.value.get(action.payload.group) == undefined) {
        state.value.set(action.payload.group, [action.payload.message]);
      } else {
        state.value.get(action.payload.group)?.push(action.payload.message);
      }
    },
  },
});

// Action creators are generated for each case reducer function
export const { addMessageRD } = messageSlice.actions;

export default messageSlice.reducer;
