package helix;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
        public static int[][] helix(int[][] inMatrix) {

            if(inMatrix.length <= 0){
                return null;
            }else{
                int newArray[] = new int[inMatrix.length*inMatrix[0].length];
                for(int i = 0; i < inMatrix.length; i++) {
                    int[] row = inMatrix[i];
                    for(int j = 0; j < row.length; j++) {
                        int number = inMatrix[i][j];
                        newArray[i*row.length+j] = number;
                    }
                }
                return generateMatrix(newArray, inMatrix);
            }

        }

        private static int[][] generateMatrix(int[] values, int[][] oldMatrix){

            int top = 0;
            int bottom = oldMatrix.length -1;
            int left = 0;
            int right = oldMatrix[0].length -1;

            int[][] newMatrix = new int[oldMatrix.length][oldMatrix[0].length];

            int index = 0;

            while (true)
            {
                if (left > right)
                    break;

                for (int i = left; i <= right; i++)
                    newMatrix[top][i] = values[index++];
                top++;

                if (top > bottom)
                    break;

                for (int i = top; i <= bottom; i++)
                    newMatrix[i][right] = values[index++];
                right--;

                if (left > right)
                    break;

                for (int i = right; i >= left; i--)
                    newMatrix[bottom][i] = values[index++];
                bottom--;

                if (top > bottom)
                    break;

                for (int i = bottom; i >= top; i--)
                    newMatrix[i][left] = values[index++];
                left++;
            }

            return newMatrix;
        }

        //https://www.techiedelight.com/create-spiral-matrix-given-array/ : Idea to Convert to Spiral Array from the given Matrix
}