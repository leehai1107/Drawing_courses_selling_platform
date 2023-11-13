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

function createData(data: any) {
  return {
    ReviewId: data.reviewId,
    Course: data.responseCourse.title,
    Comment: data.comment,
    Date: data.reviewDate,
  };
}

const RowTable = ({ rows, currentPage, itemsPerPage, handlePageChange }: any) => {
  const [open, setOpen]: any = useState(false);
  const [review, setReview]: any = useState();
  const handleOpen = () => setOpen(true);
  const handleClose = async () => {
    setOpen(false);
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
              <TableCell># Feedback</TableCell>
              <TableCell align="right">Course</TableCell>
              <TableCell align="right">Comment</TableCell>
              <TableCell align="right">Date</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {paginatedRows.map((row: any) => (
              <TableRow
                key={row.ReviewId}
                sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
              >
                <TableCell component="th" scope="row">
                  {row.ReviewId}
                </TableCell>
                <TableCell align="right">{row.Course}</TableCell>
                <TableCell
                  onClick={() => {
                    setReview(row);
                    handleOpen();
                  }}
                  align="right"
                  className="truncate"
                  sx={{ overflow: "hidden" }}
                >
                  {row.Comment}
                </TableCell>
                <TableCell align="right">{row.Date}</TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={modalCOurseStyle}>
          <div>{review?.Comment}</div>
        </Box>
      </Modal>

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

export const FeedbackTable = () => {
  const [rows, setRows]: any = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const itemsPerPage = 5; // Adjust as needed

  const callBack = async () => {
    const getFeedback = await API.getAllFeedBack();
    setRows(getFeedback?.map((fb: any) => createData(fb)));
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
      />
    </>
  );
};
