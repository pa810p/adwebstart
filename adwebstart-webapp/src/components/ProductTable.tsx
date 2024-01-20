/**
 * AdWebStart - A snippet that can be used to create a web project with
 * SpringBoot, Postgresql, React
 * Author:     Paweł Prokop (pa810p@gmail.com)
 * Repository: https://github.com/pa810p/bps2
 * License:    GNU General Public License v3.0  see: LICENSE
 */
import React from 'react';

import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import { Button } from '@mui/material';

export interface DataRow {
    name: string;
    price: string;
    productId: string;
}

interface DataTableProps {
    data: DataRow[];
    onDelete: (id: string) => void;
  }

export const ProductTable : React.FC<DataTableProps> = ({ data, onDelete }) => {

    return (
    <TableContainer component={Paper}>
        <Table>
            <TableHead>
                <TableRow>
                    <TableCell>Name</TableCell>
                    <TableCell>Price</TableCell>
                    <TableCell></TableCell>
                </TableRow>
            </TableHead>
            <TableBody>
                {data.map((row, index) => (
                    <TableRow key={index}>
                        <TableCell>{row.name}</TableCell>
                        <TableCell>{row.price}</TableCell>
                        <TableCell>
                            <Button 
                                disableElevation
                                style={{ textTransform: 'none' }} onClick={() => onDelete(row.productId)}>
                                    Remove
                            </Button>
                        </TableCell>
                    </TableRow>
                ))}
            </TableBody> 
        </Table>   
    </TableContainer>
    );
}