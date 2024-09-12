import {  createSlice, PayloadAction } from "@reduxjs/toolkit";

export interface ActiveGroupWrapper {
  value: string;
}

const initialState: ActiveGroupWrapper = {
  value: "",
};

export const activeGroupSlice = createSlice({
  name: "activeGroupRedux",
  initialState,
  reducers: {
    actualizeActiveGroup: (state, action: PayloadAction<string>) => {
      state.value = action.payload;
    },
  },
});

// Action creators are generated for each case reducer function
export const { actualizeActiveGroup } = activeGroupSlice.actions;

export default activeGroupSlice.reducer;
