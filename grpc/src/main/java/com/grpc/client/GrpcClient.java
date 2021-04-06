package com.grpc.matrixmult.client;

import com.grpc.matrixmult.MatrixRequest;
import com.grpc.matrixmult.MatrixReply;
import com.grpc.matrixmult.MatrixServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
public class GrpcClient 
{
    public static void main(String[] args) 
    {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080).usePlaintext().build();
        MatrixServiceGrpc.MatrixServiceBlockingStub stub = MatrixServiceGrpc.newBlockingStub(channel);

        //     int[][] A = {
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},

        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     9, 10, 11, 12, 13, 14, 15, 16},


        // };
        //   int[][] B = {
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},

        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},
        //     {1, 2, 3, 4, 5, 6, 7, 8,     1, 2, 3, 4, 5, 6, 7, 8},

        // };       
        int A[][] = { 
                {1, 2, 3, 4}, 
                {5, 6, 7, 8}, 
                {9, 10, 11, 12},
                {13, 14, 15, 16}}; 

        int B[][] = { 
                {1, 2, 3, 4}, 
                {5, 6, 7, 8}, 
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int MAX = A.length; //16
        int bSize = (MAX/2); //8 is the block size
        int index = 0;

        //Request For Multiplication, we set the Blocks 
        MatrixRequest.Builder A1A2 = MatrixRequest.newBuilder();
        MatrixRequest.Builder B1C2 = MatrixRequest.newBuilder();
        MatrixRequest.Builder A1B2 = MatrixRequest.newBuilder();
        MatrixRequest.Builder B1D2 = MatrixRequest.newBuilder();
        MatrixRequest.Builder C1A2 = MatrixRequest.newBuilder();
        MatrixRequest.Builder D1C2 = MatrixRequest.newBuilder();
        MatrixRequest.Builder C1B2 = MatrixRequest.newBuilder();
        MatrixRequest.Builder D1D2 = MatrixRequest.newBuilder();

        // Each Request takes its corresponding BlockSize  
        A1A2.setBlockSize(bSize);
        B1C2.setBlockSize(bSize);
        A1B2.setBlockSize(bSize);
        B1D2.setBlockSize(bSize);
        C1A2.setBlockSize(bSize);
        D1C2.setBlockSize(bSize);
        C1B2.setBlockSize(bSize);
        D1D2.setBlockSize(bSize);


        // Explained - A reqeust takes two arrays, A1A2 means two repeated Arrays, A1 & A2
        //             So in the for loop any requests that need A1 to be their first array (One)
        //             we set it for that specific request. 
        // The for loop below initializes all A1 & A2 blocks  

        //INITIALIZE REPEATED ARRAY FOR ALL SCENARIOS
        for (int i = 0; i < bSize; i++) 
        { 
            for (int j = 0; j < bSize; j++)
            {
                //SET BLOCK A1 FOR ALL THE A1 REQUESTS 
                A1A2.addOne(A[i][j]); // A1, One means the first Block 
                A1B2.addOne(A[i][j]); // A1

                //SET BLOCK A2 FOR ALL THE A2 REQUESTS 
                A1A2.addTwo(B[i][j]); // A2
                C1A2.addTwo(B[i][j]); // A2

            }
        }


        for (int i = 0; i < bSize; i++) 
        { 
            for (int j = bSize; j < MAX; j++)
            {
                //SET BLOCK B1 FOR ALL THE B1 REQUESTS 
                B1C2.addOne(A[i][j]); // B1
                B1D2.addOne(A[i][j]); // B1

                //SET BLOCK B2 FOR ALL THE B2 REQUESTS 
                A1B2.addTwo(B[i][j]); // B2
                C1B2.addTwo(B[i][j]); // B2
            }
        }

        for (int i = bSize; i < MAX; i++) 
        { 
            for (int j = 0; j < bSize; j++)
            {
                //SET BLOCK C1 FOR ALL THE C1 REQUESTS 
                C1A2.addOne(A[i][j]); // C1
                C1B2.addOne(A[i][j]); // C1

                //SET BLOCK C2 FOR ALL THE C2 REQUESTS 
                B1C2.addTwo(B[i][j]); // C2
                D1C2.addTwo(B[i][j]); // C2
            }
        } 


        for (int i = bSize; i < MAX; i++) 
        { 
            for (int j = bSize; j < MAX; j++)
            {

                //SET BLOCK D1 FOR ALL THE FIRST BLCOK D1 REQUESTS 
                D1C2.addOne(A[i][j]); // D1
                D1D2.addOne(A[i][j]); // D1

                //SET BLOCK D2 FOR ALL THE SECOND BLOCK D2 REQUESTS 
                B1D2.addTwo(B[i][j]); // D2
                D1D2.addTwo(B[i][j]); // D2
            }
        }  


        // MULTIPLCATION OF REPEATED ARRAYS 

        MatrixReply MultiplyA1A2 = stub.multiplyBlock(A1A2.build()); // we send the values to server and wait for the reply to come into MultiplyRQ1
        MatrixReply MultiplyB1C2 = stub.multiplyBlock(B1C2.build());
        MatrixReply MultiplyA1B2 = stub.multiplyBlock(A1B2.build());
        MatrixReply MultiplyB1D2 = stub.multiplyBlock(B1D2.build());
        MatrixReply MultiplyC1A2 = stub.multiplyBlock(C1A2.build());
        MatrixReply MultiplyD1C2 = stub.multiplyBlock(D1C2.build());
        MatrixReply MultiplyC1B2 = stub.multiplyBlock(C1B2.build());
        MatrixReply MultiplyD1D2 = stub.multiplyBlock(D1D2.build());


        // ADDITION 

        // WE HAVE OUR MULTIPLCATION RESULTS ABOVE
        // NOW WE NEED TO ADD THEM IN ACCORDANCE TO MATRIX MULTIPLCATION
        // THE addBlock FROM PROTO NEEDS 2 REPATED FIELDS TO DO THE ADDITION


        MatrixRequest.Builder A3ADD = MatrixRequest.newBuilder();
        MatrixRequest.Builder B3ADD = MatrixRequest.newBuilder();
        MatrixRequest.Builder C3ADD = MatrixRequest.newBuilder();
        MatrixRequest.Builder D3ADD = MatrixRequest.newBuilder();

        A3ADD.setBlockSize(bSize);
        B3ADD.setBlockSize(bSize);
        C3ADD.setBlockSize(bSize);
        D3ADD.setBlockSize(bSize);



        // WE DO A FOR LOOP
        // THIS WAY WE BUILD THE REQUEST WE WILL SEND TO THE SERVER, 2 REPEATED FIELDS TO BE ADDED
        index=0;
        for (int i = 0; i < bSize; i++) 
        { 
            for (int j = 0; j < bSize; j++)
            {
                //ADD BLOCK MULTIPLCATION OF A1&A2 AND B1&C2
                A3ADD.addOne(MultiplyA1A2.getC(index)); //FIRST REPATED FIELD SET UP
                A3ADD.addTwo(MultiplyB1C2.getC(index)); //SECOND REPATED FIELD SET UP

                B3ADD.addOne(MultiplyA1B2.getC(index)); 
                B3ADD.addTwo(MultiplyB1D2.getC(index));

                C3ADD.addOne(MultiplyC1A2.getC(index)); 
                C3ADD.addTwo(MultiplyD1C2.getC(index));

                D3ADD.addOne(MultiplyC1B2.getC(index)); 
                D3ADD.addTwo(MultiplyD1D2.getC(index));

                index=index+1;
            }
        }

        //OUR FINAL RESULT IS THESE 4 BLOCKS 
        MatrixReply A3 = stub.addBlock(A3ADD.build()); // we send the values to server and wait for the reply to come into MultiplyRQ1
        MatrixReply B3 = stub.addBlock(B3ADD.build());
        MatrixReply C3 = stub.addBlock(C3ADD.build());
        MatrixReply D3 = stub.addBlock(D3ADD.build());


        // PUT TOGETHER THE FINAL PIECE, I.E. THE FINAL ARRAY

        int [][] res = new int [A.length][A.length];
        index =0;
        for (int i = 0; i < bSize; i++) 
        {   
            for (int j = 0; j < bSize; j++)
            {
                res[i][j]=A3.getC(index);
                index = index + 1;
            }
        }
        index =0;
        for (int i = 0; i < bSize; i++) 
        { 
            for (int j = bSize; j < MAX; j++)
            {
                res[i][j]=B3.getC(index);
                index = index + 1;
            }
        }
        index =0;
        for (int i = bSize; i < MAX; i++) 
        { 
            for (int j = 0; j < bSize; j++)
            {
                res[i][j]=C3.getC(index);
                index = index + 1;
            }
        } 
        index =0;
        for (int i = bSize; i < MAX; i++) 
        { 
            for (int j = bSize; j < MAX; j++)
            {
                res[i][j]=D3.getC(index);
                index = index + 1;
            }
        } 
        index =0;

        System.out.println("Final Answer");
        for (int i=0; i<MAX; i++)
        {
            for (int j=0; j<MAX;j++)
            {
                System.out.print(res[i][j]+" ");
            }
            System.out.println("");
        }
        channel.shutdown();
    }
}
