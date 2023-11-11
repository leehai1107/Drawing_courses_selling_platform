import { useEffect, useState } from "react";
import { API } from "../API/API";
import Table from "@mui/material/Table";
import TableBody from "@mui/material/TableBody";
import TableCell from "@mui/material/TableCell";
import TableContainer from "@mui/material/TableContainer";
import TableHead from "@mui/material/TableHead";
import TableRow from "@mui/material/TableRow";
import Paper from "@mui/material/Paper";

function createData({ data }: any) {
  return {
    ReviewId: data.reviewId,
    Course: data.responseCourse.title,
    Comment: data.comment,
    Date: data.reviewDate,
  };
}

const RowTable = ({ rows }: any) => {

    
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
              {rows.map((row: any) => (
                <TableRow
                  key={row.userid}
                  sx={{ "&:last-child td, &:last-child th": { border: 0 } }}
                >
                  <TableCell component="th" scope="row">
                    {row.userid}
                  </TableCell>
                  <TableCell align="right">{row.ReviewId}</TableCell>
                  <TableCell align="right">{row.Course}</TableCell>
                  <TableCell align="right">{row.Comment}</TableCell>
                  <TableCell align="right">{row.Date}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
      </>
    );
  };

  
export const FeedbackTable = () => {
    const [rows, setRows]: any = useState([]);

    const callBack = async () => {
      const getFeedback = await API.getAllFeedBack();
      setRows(getFeedback?.map((fb: any) => createData(fb)));
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