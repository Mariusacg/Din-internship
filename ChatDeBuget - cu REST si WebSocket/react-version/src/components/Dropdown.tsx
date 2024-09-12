import React, { useEffect, useState } from 'react';

type DropDownProps = {
  groups: string[];
  showDropDown: boolean;
  toggleDropDown: Function;
  groupSelection: Function;
};

const DropDown: React.FC<DropDownProps> = ({
  groups,
  groupSelection,
}: DropDownProps): JSX.Element => {
  const [showDropDown, setShowDropDown] = useState<boolean>(false);


  const onClickHandler = (group: string): void => {
    groupSelection(group);
  };

  useEffect(() => {
    setShowDropDown(showDropDown);
  }, [showDropDown]);

  return (
    <>
      <div className={showDropDown ? 'dropdown' : 'dropdown active'}>
        {groups.map(
          (group: string, index: number): JSX.Element => {
            return (
              <p
                key={index}
                onClick={(): void => {
                  onClickHandler(group);
                }}
              >
                {group}
              </p>
            );
          }
        )}
      </div>
    </>
  );
};

export default DropDown;
