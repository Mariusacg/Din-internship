import { createSlice } from '@reduxjs/toolkit'

export const connectSlice = createSlice({
  name: 'connectRedux',
  initialState: {
    value: false,
  },
  reducers: {
    successful: (state) => {
      state.value = true
    },
    failed: (state) => {
      state.value = false
    },
    finish: (state) => {
      state.value = false
    },
  },
})

// Action creators are generated for each case reducer function
export const { successful, failed, finish } = connectSlice.actions

export default connectSlice.reducer