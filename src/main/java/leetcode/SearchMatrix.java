package leetcode;

/**
 * @author kongweichang
 */
public class SearchMatrix {

    /**
     *
     * int maximalSquare(vector<string>& matrix) {
     *         int i,j,m,n,k,ans=0;
     *         m=matrix.size();
     *         if(m==0)
     *             return 0;
     *         n=matrix[0].size();
     *         if(n==0)
     *             return 0;
     *         vector<vector<int>> f(m, vector<int>(n,0));
     *         for(i=0;i<m;i++)
     *         {
     *             if(matrix[i][0]=='1')
     *             {
     *                 f[i][0]=1;
     *                 ans=1;
     *             }
     *         }
     *         for(j=0;j<n;j++)
     *         {
     *             if(matrix[0][j]=='1')
     *             {
     *                 f[0][j]=1;
     *                 ans=1;
     *             }
     *         }
     *         for(i=1;i<m;i++)
     *         {
     *             for(j=1;j<n;j++)
     *             {
     *                 if(matrix[i][j]=='0')
     *                     continue;
     *                 k=min(min(f[i-1][j],f[i][j-1]), f[i-1][j-1]);
     *                 f[i][j]=k+1;
     *                 if(f[i][j]>ans)
     *                     ans=f[i][j];
     *             }
     *         }
     *         return ans*ans;
     *     }
     *
     */

    int maximalSquare(int[][] matrix) {




        return 0;
    }



}
