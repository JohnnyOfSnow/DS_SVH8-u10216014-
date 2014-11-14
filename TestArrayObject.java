public class TestArrayObject{
	public static void main(String[] args) {
		int[] oi = {30,25,147,12,258,952,4,123};
		IntDLList[] ui = new IntDLList[10];
		IntDLList myNode0 = new IntDLList();
		ui[0] = myNode0;
		IntDLList myNode1 = new IntDLList();
		ui[1] = myNode1;
		IntDLList myNode2 = new IntDLList();
		ui[2] = myNode2;
		IntDLList myNode3 = new IntDLList();
		ui[3] = myNode3;
		IntDLList myNode4 = new IntDLList();
		ui[4] = myNode4;
		IntDLList myNode5 = new IntDLList();
		ui[5] = myNode5;
		IntDLList myNode6 = new IntDLList();
		ui[6] = myNode6;
		IntDLList myNode7 = new IntDLList();
		ui[7] = myNode7;
		IntDLList myNode8 = new IntDLList();
		ui[8] = myNode8;
		IntDLList myNode9 = new IntDLList();
		ui[9] = myNode9;
		

		int ret = 0;
		for(int i = 0; i < oi.length; i++){
			ret = oi[i] / 1; // devide 1 to get the digit in ones 
			ret = ret % 10;

			switch(ret){
				case 0:
					ui[0].addToDLListTail(oi[i]);
				break;
				case 1:
					ui[1].addToDLListTail(oi[i]);
				break;
				case 2:
					ui[2].addToDLListTail(oi[i]);
				break;
				case 3:
					ui[3].addToDLListTail(oi[i]);
				break;
				case 4:
					ui[4].addToDLListTail(oi[i]);
				break;
				case 5:
					ui[5].addToDLListTail(oi[i]);
				break;
				case 6:
					ui[6].addToDLListTail(oi[i]);
				break;
				case 7:
					ui[7].addToDLListTail(oi[i]);
				break;
				case 8:
					ui[8].addToDLListTail(oi[i]);
				break;
				case 9:
					ui[9].addToDLListTail(oi[i]);
				break;
				default:
					System.out.println("Error!!");
			} // end switch
		} // end for loop



		StringBuilder ip = new StringBuilder();
		StringBuilder iip = new StringBuilder();

		for(int j = 0; j < ui.length; j++){
			ip.append(ui[j].print(j) + "\n");
		}

		for(int p = 0; p < ui.length; p++){
			iip.append(ui[p].print1(p));
		}

		String h = new String(ip);
		System.out.println(h);

		String f = new String(iip);
		System.out.println(f);

		String[] reArray = f.split(",");
		int[] reArray1 = new int[reArray.length];
		for(int l = 0; l < reArray.length; l++){
			reArray1[l] = Integer.parseInt(reArray[l]);
		}

		for(int y = 0; y < oi.length; y++){
			oi[y] = reArray1[y];
		}
		//test
		for(int q = 0; q < oi.length; q++){
			System.out.println("oi[" + q + "] is: " + oi[q]);
		}
	}
}
