import { useEffect, useState } from "react";
import { API } from "../API/API";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

function createData({
  userid,
  username,
  fullname,
  email,
  status,
  phone,
  dob,
}: {
  userid: number;
  username: string;
  fullname: string;
  email: number;
  status: boolean;
  phone: number;
  dob: string;
}) {
  return {
    userid,
    username,
    fullname,
    email,
    phone,
    dob,
    status: status ? (
      <span className="text-green-500">activate</span>
    ) : (
      <span className="text-red-500">banned</span>
    ),
    action: status ? (
      <button className="bg-red-500 p-2 text-white rounded-lg">ban</button>
    ) : (
      <button className="bg-green-500 p-2 text-white rounded-lg">unban</button>
    ),
  };
}


export const AccountTable = () => {
  const [rows, setRows]: any = useState([]);

  const callBack = async () => {
    const getAccounts = await API.getAllCusInfo();
    setRows(getAccounts?.map((acc: any) => createData(acc)));
  };

  useEffect(() => {
    callBack();
  }, []);

  return (
    <>
      <RowTable rows={rows} callback={callBack}/>
    </>
  );
};

export const StaffsTable = () => {
  const [rows, setRows]: any = useState([]);

  const callBack = async () => {
    const getAccounts = await API.getAllStaffInfo();
    setRows(getAccounts?.map((acc: any) => createData(acc)));
  };

  useEffect(() => {
    callBack();
  }, []);

  return (
    <>
      <RowTable rows={rows} callback={callBack}/>
    </>
  );
};

export const InsTable = () => {
  const [rows, setRows]: any = useState([]);

  const callBack = async () => {
    const getAccounts = await API.getAllInsInfo();
    setRows(getAccounts?.map((acc: any) => createData(acc)));
  };

  useEffect(() => {
    callBack();
  }, []);

  return (
    <>
      <RowTable rows={rows} callback={callBack}/>
    </>
  );
};

const RowTable = ({ rows, callback }: any) => {

  const banAccount = async (userid:number) => {
    await API.banAccount(userid)
    await callback()
  }
  
  return (
    <>
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell># User</TableCell>
              <TableCell align="right">User Name</TableCell>
              <TableCell align="right">Full Name</TableCell>
              <TableCell align="right">Email</TableCell>
              <TableCell align="right">Phone</TableCell>
              <TableCell align="right">Dob</TableCell>
              <TableCell align="right">Status</TableCell>
              <TableCell align="right">Action</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {rows.map((row: any) => (
              <TableRow
                key={row.userid}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {row.userid}
                </TableCell>
                <TableCell align="right">{row.username}</TableCell>
                <TableCell align="right">{row.fullname}</TableCell>
                <TableCell align="right">{row.email}</TableCell>
                <TableCell align="right">{row.phone}</TableCell>
                <TableCell align="right">{row.dob}</TableCell>
                <TableCell align="right">{row.status}</TableCell>
                <TableCell onClick={() => banAccount(row.userid)} align="right">{row.action}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </>
  );
};
