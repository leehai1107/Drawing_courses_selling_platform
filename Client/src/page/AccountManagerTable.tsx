import { useEffect, useState } from "react";
import { API } from "../API/API";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";
import { Box, Modal } from "@mui/material";
import { modalCOurseStyle } from "../css/modalStyle";
import { CreateModalInstructor, CreateModalStaff } from "../components/Modals/CreateModal";

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

const RowTable = ({ rows, currentPage, itemsPerPage, handlePageChange, callback }: any) => {
  const banAccount = async (userid: number) => {
    await API.banAccount(userid);
    await callback();
  };

  const calculatePagination = () => {
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    return rows.slice(startIndex, endIndex);
  };

  const paginatedRows = calculatePagination();

  return (
    <>
    
      <TableContainer component={Paper}>
        <Table sx={{ minWidth: 650 }} aria-label="simple table">
          <TableHead>
            <TableRow>
              <TableCell># User</TableCell>
              <TableCell align="center">User Name</TableCell>
              <TableCell align="center">Full Name</TableCell>
              <TableCell align="center">Email</TableCell>
              <TableCell align="center">Phone</TableCell>
              <TableCell align="center">Dob</TableCell>
              <TableCell align="center">Status</TableCell>
              <TableCell align="center">Action</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {paginatedRows.map((row: any) => (
              <TableRow
                key={row.userid}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {row.userid}
                </TableCell>
                <TableCell align="center">{row.username}</TableCell>
                <TableCell align="center">{row.fullname}</TableCell>
                <TableCell align="center">{row.email}</TableCell>
                <TableCell align="center">{row.phone}</TableCell>
                <TableCell align="center">{row.dob}</TableCell>
                <TableCell align="center">{row.status}</TableCell>
                <TableCell onClick={() => banAccount(row.userid)} align="center">
                  {row.action}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      
           {/* Pagination Controls */}
      <div className="pagination-buttons">
        <button
          onClick={() => handlePageChange(currentPage - 1)}
          disabled={currentPage === 1}
          className="pagination-button"
        >
          Previous
        </button>
        <span className="pagination-info" style={{ margin: "0 50px" }}>
    Page {currentPage} of {Math.ceil(rows.length / itemsPerPage)}
  </span>
        <button
          onClick={() => handlePageChange(currentPage + 1)}
          disabled={paginatedRows.length < itemsPerPage}
          className="pagination-button"
        >
          Next
        </button>
      </div>
    </>
  );
};

export const AccountTable = () => {
  const [rows, setRows]: any = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 5; // Display 5 objects per page

  const callBack = async () => {
    const getAccounts = await API.getAllCusInfo();
    setRows(getAccounts?.map((acc: any) => createData(acc)));
  };

  const handlePageChange = (newPage: number) => {
    setCurrentPage(newPage);
  };

  useEffect(() => {
    callBack();
  }, [currentPage]);

  return (
    <>
      <RowTable
        rows={rows}
        currentPage={currentPage}
        itemsPerPage={itemsPerPage}
        handlePageChange={handlePageChange}
        callback={callBack}
      />
    </>
  );
};

export const StaffsTable = () => {
  const [open, setOpen]: any = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = async () => {
    setOpen(false);
    await callBack();
  };
  const [rows, setRows]: any = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 5; // Display 5 objects per page

  const callBack = async () => {
    const getAccounts = await API.getAllStaffInfo();
    setRows(getAccounts?.map((acc: any) => createData(acc)));
  };

  const handlePageChange = (newPage: number) => {
    setCurrentPage(newPage);
  };

  useEffect(() => {
    callBack();
  }, [currentPage]);

  return (
    <>
      <button
        onClick={handleOpen}
        className="p-2 text-white bg-blue-500 rounded-xl mb-3"
      >
        Create Staff
      </button>
      <RowTable
        rows={rows}
        currentPage={currentPage}
        itemsPerPage={itemsPerPage}
        handlePageChange={handlePageChange}
        callback={callBack}
      />
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={modalCOurseStyle}>
          <CreateModalStaff handleClose={handleClose} />
        </Box>
      </Modal>
    </>
  );
};

export const InsTable = () => {
  const [open, setOpen]: any = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = async () => {
    setOpen(false);
    await callBack();
  };
  const [rows, setRows]: any = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 5; // Display 5 objects per page

  const callBack = async () => {
    const getAccounts = await API.getAllInsInfo();
    setRows(getAccounts?.map((acc: any) => createData(acc)));
  };

  const handlePageChange = (newPage: number) => {
    setCurrentPage(newPage);
  };

  useEffect(() => {
    callBack();
  }, [currentPage]);

  return (
    <>
      <button
        onClick={handleOpen}
        className="p-2 text-white bg-blue-500 rounded-xl mb-3"
      >
        Create Instructor
      </button>
      <RowTable
        rows={rows}
        currentPage={currentPage}
        itemsPerPage={itemsPerPage}
        handlePageChange={handlePageChange}
        callback={callBack}
      />
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={modalCOurseStyle}>
          <CreateModalInstructor handleClose={handleClose} />
        </Box>
      </Modal>
    </>
  );
};
