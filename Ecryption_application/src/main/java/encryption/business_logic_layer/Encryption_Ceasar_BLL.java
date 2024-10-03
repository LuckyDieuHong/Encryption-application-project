//Khai báo package hochiminh.model
package encryption.business_logic_layer;

public class Encryption_Ceasar_BLL {
        //Khai báo Plaintext để lưu trữ giá trị plantext muốn mã hóa hoặc giải mã
	private String plainText;
        //Khai báo key để lưu trữ giá trị key
	private int key;
        //Khai báo Cypher để lưu trữ kết quả trả về là đoạn mã đã mã hóa hoặc đoạn mã đã giải mã
	private String cypher;

	//Tạo constructor Encryption_Ceasar_model với giá trị rỗng để khởi tạo ban đầu không có giá trị
	public Encryption_Ceasar_BLL() {	
	}
        
        //Bên dưới là các hàm getter và setter để lấy giá trị và đặt giá trị từ 3 biến đã khai báo bên trên
	public String getPlainText() {
		return plainText;
	}
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public String getCypher() {
		return cypher;
	}
	public void setCypher(String cypher) {
		this.cypher = cypher;
	}
	
	//Đây là hàm mã hóa encryption
	public void encrytion(){
                //Tạo chuỗi lưu trữ các giá trị từ A->Z phục vụ cho mã hóa và giải mã
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                //Lưu giá trị chuỗi bảng chữ cái vào từng thành phần của mảng
		char[] arrayAlphabet = alphabet.toCharArray();
                //Lưu giá trị chuỗi từ đoạn plaintext vào bên trong mảng để so sánh
		char[] plainTextArray = this.plainText.toCharArray();
                //Tạo một mảng lưu trữ giá trị các ký tự đã được mã hóa
		char[] arrayResult = new char[plainTextArray.length];
                //Tạo 1 biến để lưu trữ vị trí cho mảng arrayResult
		int bientam=0;
                
        //plainTextAR dùng để đánh dấu để sau này sau khi kết thúc vòng lặp thì tiếp tục quay trở lại vòng lặp plainTextAR
                    //Vòng for này chạy từ tới cuối của mảng plainTextArray nhằm so sánh từng ký tự của plaintext nhập vào
	plainTextAR:for (int i = 0; i <plainTextArray.length; i++) 
	{               //Vòng for này để chạy từ đầu bảng chữ cái Alphabet để dò xem ký tự plaintext thuộc vị trí nào trong mảng arrayAlphabet
			for (int j = 0; j < arrayAlphabet.length; j++) 
			{       //Điều kiện này so sánh xem ký tự của mảng plainTextArray có trùng với ký tự của mảng arrayAlphabet không
				if(plainTextArray[i]==arrayAlphabet[j])
				{       //Tạo biến kết quả để lưu trữ giá trị vị trí ký tự của mảng arrayAlphabet sau khi thực hiện phép tính
                                        //Đối với mã hóa thì công thức là bằng (số tương ứng với ký tự trong plaintext + key) mod 26
					int result = (j+this.key) % 26;
                                        //Vòng for này để chạy từ đầu bảng chữ cái Alphabet để dò vị trí trong mảng arrayAlphabet
					for (int k = 0; k < arrayAlphabet.length; k++) 
					{       //So sánh để xem vị trí của biến kết quả có bằng cái vị trí vòng for này đang chạy không
						if(result==k)
						{       //Gán ký tự vị trí k trong mảng arrayAlphabet cho mảng arrayResult
							arrayResult[bientam] = arrayAlphabet[k];
                                                        //Tăng bientam lên 1 nghĩa là sắp tới ký tự tiếp theo sẽ được thêm màng vị trí bientam + 1
							bientam++;
                                                        //Kết thúc 2 vòng lặp để tiết kiệm thời gian và quay trở về vòng for ban đầu với tên vong for là plainTextAR
							continue plainTextAR;
						}
					}
				}
			}
		}
        //Gán giá trị từ mảng arrayResult thành chuỗi trong biến Cypher
	this.cypher= new String(arrayResult);
	}
        
        
        //Đây là hàm giải mã decryption
	public void decryption() {
		       //Tạo chuỗi lưu trữ các giá trị từ A->Z phục vụ cho mã hóa và giải mã
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                //Lưu giá trị chuỗi bảng chữ cái vào từng thành phần của mảng
		char[] arrayAlphabet = alphabet.toCharArray();
                //Lưu giá trị chuỗi từ đoạn plaintext vào bên trong mảng để so sánh
		char[] plainTextArray = this.plainText.toCharArray();
                //Tạo một mảng lưu trữ giá trị các ký tự đã được mã hóa
		char[] arrayResult = new char[plainTextArray.length];
                //Tạo 1 biến để lưu trữ vị trí cho mảng arrayResult
		int bientam=0;
                
        //plainTextAR dùng để đánh dấu để sau này sau khi kết thúc vòng lặp thì tiếp tục quay trở lại vòng lặp plainTextAR
                    //Vòng for này chạy từ tới cuối của mảng plainTextArray nhằm so sánh từng ký tự của plaintext nhập vào
	plainTextAR:for (int i = 0; i <plainTextArray.length; i++) 
	{               //Vòng for này để chạy từ đầu bảng chữ cái Alphabet để dò xem ký tự plaintext thuộc vị trí nào trong mảng arrayAlphabet
			for (int j = 0; j < arrayAlphabet.length; j++) 
			{       //Điều kiện này so sánh xem ký tự của mảng plainTextArray có trùng với ký tự của mảng arrayAlphabet không
				if(plainTextArray[i]==arrayAlphabet[j])
				{       //Tạo biến kết quả để lưu trữ giá trị vị trí ký tự của mảng arrayAlphabet sau khi thực hiện phép tính
                                        //Đối với giải mã thì công thức là bằng (số tương ứng với ký tự trong plaintext - key) mod 26
					int result = (j-this.key) % 26;
                                        //Vòng for này để chạy từ đầu bảng chữ cái Alphabet để dò vị trí trong mảng arrayAlphabet
					for (int k = 0; k < arrayAlphabet.length; k++) 
					{       //So sánh để xem vị trí của biến kết quả có bằng cái vị trí vòng for này đang chạy không
						if(result==k)
						{       //Gán ký tự vị trí k trong mảng arrayAlphabet cho mảng arrayResult
							arrayResult[bientam] = arrayAlphabet[k];
                                                        //Tăng bientam lên 1 nghĩa là sắp tới ký tự tiếp theo sẽ được thêm màng vị trí bientam + 1
							bientam++;
                                                        //Kết thúc 2 vòng lặp để tiết kiệm thời gian và quay trở về vòng for ban đầu với tên vong for là plainTextAR
							continue plainTextAR;
						}
					}
				}
			}
		}
        //Gán giá trị từ mảng arrayResult thành chuỗi trong biến Cypher
	this.cypher= new String(arrayResult);
	}
	
}
