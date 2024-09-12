import { createAsyncThunk, createSlice } from "@reduxjs/toolkit";

export interface GroupsWrapper {
  value: Array<string>;
}

const initialState: GroupsWrapper = {
  value: [],
};


export const fetchGroups = createAsyncThunk("fetchGroups", async () => {
  const response = await fetch("http://localhost:8080/chat/groups");
  const jsonResponse : Array<string> = await response.json();
  return jsonResponse;
});

export const groupsSlice = createSlice({
  name: "groupsRedux",
  initialState,
  reducers: {
  },
  extraReducers: (builder) => {
    builder.addCase(fetchGroups.fulfilled, (state, action) => {
      state.value = action.payload;
    });
  },
});

// Action creators are generated for each case reducer function
export const { } = groupsSlice.actions;

export default groupsSlice.reducer;
