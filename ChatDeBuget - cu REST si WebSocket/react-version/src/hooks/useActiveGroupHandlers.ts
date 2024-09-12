import { useDispatch } from "react-redux";
import { actualizeActiveGroup } from "../redux/activeGroup";

export const useActiveGroupHandlers = () => {
  const dispatch = useDispatch();

  const updateActiveGroup = (newGroup: string): void => {
    dispatch(actualizeActiveGroup(newGroup));
  };

  return {
    updateActiveGroup,
  };
};
