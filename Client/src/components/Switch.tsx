import { alpha, styled } from '@mui/material/styles';
import { common } from '@mui/material/colors';
import Switch from '@mui/material/Switch';

export const BlackSwitch = styled(Switch)(({ theme }) => ({
    '& .MuiSwitch-switchBase.Mui-checked': {
      color: common.black,
      '&:hover': {
        backgroundColor: alpha(common.black, theme.palette.action.hoverOpacity),
      },
    },
    '& .MuiSwitch-switchBase.Mui-checked + .MuiSwitch-track': {
      backgroundColor: common.black,
    },
  }));
  
  const label = { inputProps: { 'aria-label': 'Color switch demo' } };
  
  export function BlackSwitchs() {
    return (
      <div>
        <BlackSwitch {...label} defaultChecked />
      </div>
    );
  }