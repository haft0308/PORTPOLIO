package network;

public class Timer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cnt=-50, inter=-50;
		boolean isLight = false;
		while(cnt>=-100 && cnt<=200)
		{
			System.out.println(cnt+"/"+ inter);
			if( inter %52 == 0)
			{ 
				System.out.println("ºÒÄ×À½"+cnt+"/n"+inter);
				isLight = true;
				inter=cnt+2;
				
			}
			else if (isLight && cnt>=inter)
			{
				//System.out.println("ºÒ²û");
				System.out.println("ºÒ ²û"+cnt+"/n"+inter);
				isLight=false;
				inter = cnt;
			}
			inter = cnt++;			
		}
	}

}
