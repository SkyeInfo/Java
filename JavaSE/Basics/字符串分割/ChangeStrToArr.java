import java.util.StringTokenizer;
class ChangeStrToArr{
	public static void main(String[] args){
		//存储到一维数组的情况下
		String str = "ysk;nihao;woshiLiMing";
		//1.直接分割
		String[] result = str.split(";");
		for(int i = 0;i < result.length;i++){
			System.out.println(result[i]);
		}
		System.out.println("*************************");
		//2.用StingTokenizer
		StringTokenizer tokener = new StringTokenizer(str,";");
		String[] result1 = new String [tokener.countTokens()];
		int j = 0;
		while(tokener.hasMoreTokens()){
			result1[j++] = tokener.nextToken();
		}
		for (int m = 0;m < result.length ; m++ )
		{
			System.out.println(result[m]);
		}
		System.out.println("*************************");
		//存储到二维数组的情况下
		String str1 = "A=1=1;B=2=2;C=3=3";
		String[] res = str1.split(";");
		String[][] res1 = new String[res.length][];
		for (int n = 0;n < res.length ;n++ )
		{
			res1[n] = res[n].split("=");
		}

		for (int p = 0;p < res.length ;p++ )
		{
			System.out.print(res[p]+"  ");
			for (int q = 0;q < 3 ;q++ )
			{
				System.out.print(res1[p][q]+" ");
			}
		}
	}
}