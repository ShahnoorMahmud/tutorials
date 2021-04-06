package com.grpc.matrixmult.server;

import com.grpc.matrixmult.MatrixRequest;
import com.grpc.matrixmult.MatrixReply;
import com.grpc.matrixmult.MatrixServiceGrpc.MatrixServiceImplBase;

import io.grpc.stub.StreamObserver;
public class MatrixServiceImpl extends MatrixServiceImplBase
{

    @Override
    public void multiplyBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
    {
        int[][] A = new int[request.getBlockSize()][request.getBlockSize()]; //populates the size of the array by gettting array dimension
        int[][] B = new int[request.getBlockSize()][request.getBlockSize()]; //populates the size of the array by gettting array dimension
        int[][] C = new int[request.getBlockSize()][request.getBlockSize()];

        int bSize = request.getBlockSize(); //8
        int index =0; //this will be incremented every for loop by one to get next index in repated array all the way up to 64
        for (int i=0; i<bSize; i++)
        {
            for (int j=0; j<bSize; j++)
            {
                A[i][j]=request.getOne(index);//populate our local array by going through our repatead array
                B[i][j]=request.getTwo(index);
                index=index+1;
            }
        }

        //DISPLAYS WHAT THE INPUTS WERE 
        System.out.println("Blocks Recieved for multiplication");
        for (int i=0; i<bSize; i++)
        {
            for (int j=0; j<bSize;j++)
            {
                System.out.print(A[i][j]+" ");
            }
            System.out.println("");
        }
        for (int i=0; i<bSize; i++)
        {
            for (int j=0; j<bSize;j++)
            {
                System.out.print(B[i][j]+" ");
            }
            System.out.println("");
        }

        // Multiplaction for Array C
        for(int i=0;i<bSize;i++)
        {
            for(int j=0;j<bSize;j++)
            {
                for(int k=0;k<bSize;k++)
                {
                    C[i][j]+=(A[i][k]*B[k][j]);
                }
            }
        }

        // WE take our local C value and pass into our reapeated C Field    
        MatrixReply.Builder response = MatrixReply.newBuilder();
        for (int i = 0; i < bSize; i++) 
        { 
            for (int j = 0; j < bSize; j++)
            {
                response.addC(C[i][j]);
                // index = index + 1;
            }
        }
        reply.onNext(response.build());
        reply.onCompleted();

    }
    @Override
    public void addBlock(MatrixRequest request, StreamObserver<MatrixReply> reply)
    {
        int[][] A = new int[request.getBlockSize()][request.getBlockSize()]; //populates the size of the array by gettting array dimension
        int[][] B = new int[request.getBlockSize()][request.getBlockSize()]; //populates the size of the array by gettting array dimension
        int[][] C = new int[request.getBlockSize()][request.getBlockSize()];

        int bSize = request.getBlockSize(); //8
        int index =0; //this will be incremented every for loop by one to get next index in repated array all the way up to 64

        // store the repated array items into Array A[][] and B[][]
        for (int i=0; i<bSize; i++)
        {
            for (int j=0; j<bSize; j++)
            {
                
                A[i][j]=request.getOne(index);//populate our local array by going through our repatead array
                B[i][j]=request.getTwo(index);
                index=index+1;
            }
        }

        //DISPLAYS WHAT THE INPUTS WERE 
        System.out.println("Blocks Recieved for Addition");
        for (int i=0; i<bSize; i++)
        {
            for (int j=0; j<bSize;j++)
            {
                System.out.print(A[i][j]+" ");
            }
            System.out.println("");
        }
        for (int i=0; i<bSize; i++)
        {
            for (int j=0; j<bSize;j++)
            {
                System.out.print(B[i][j]+" ");
            }
            System.out.println("");
        }

        // ADD for Array C
        for(int i=0;i<bSize;i++)
        {
            for(int j=0;j<bSize;j++)
            {
                C[i][j]=A[i][j]+B[i][j]; 
            }
        }

        // WE take our local C value and pass into our reapeated C Array    
        MatrixReply.Builder response = MatrixReply.newBuilder();
        for (int i = 0; i < bSize; i++) 
        { 
            for (int j = 0; j < bSize; j++)
            {
                response.addC(C[i][j]);
                // index = index + 1;
            }
        }
        reply.onNext(response.build());
        reply.onCompleted();

    }
}

