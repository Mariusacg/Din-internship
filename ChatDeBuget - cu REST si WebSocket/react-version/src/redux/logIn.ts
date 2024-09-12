import { createSlice } from '@reduxjs/toolkit'

export const logInSlice = createSlice({
  name: 'logInRedux',
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
export const { successful, failed, finish } = logInSlice.actions

export default logInSlice.reducer