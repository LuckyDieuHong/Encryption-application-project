//Khai báo package hochiminh.model
package encryption.business_logic_layer;



public class Encryption_BLL {
        //Khai báo Plaintext để lưu trữ giá trị plantext muốn mã hóa hoặc giải mã
	private String plainText;
        //Khai báo key để lưu trữ giá trị key
	private String key;
        //Khai báo Cypher để lưu trữ kết quả trả về là đoạn mã đã mã hóa hoặc đoạn mã đã giải mã
	private String cypher;

	//Tạo constructor Encryption_Ceasar_model với giá trị rỗng để khởi tạo ban đầu không có giá trị
	public Encryption_BLL() {
	}
        
        //Bên dưới là các hàm getter và setter để lấy giá trị và đặt giá trị từ 3 biến đã khai báo bên trên
	public String getPlainText() {
		return plainText;
	}
	public void setPlainText(String plainText) {
		this.plainText = plainText;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCypher() {
		return cypher;
	}
	public void setCypher(String cypher) {
		this.cypher = cypher;
	}
	
	//Đây là hàm mã hóa encryption của Ceasar
	public void encrytion_Ceasar(){
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
                                        int keyString = Integer.parseInt(key);
					int result = (j+keyString) % 26;
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
        
        
        //Đây là hàm giải mã decryption của Ceasar
	public void decryption_Ceasar() {
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
					int keyString = Integer.parseInt(key);
					int result = (j-keyString) % 26;
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
        
        //Đây là hàm mã hóa encryption của 
        public void encryption_Playfair()
        {
            
        }
        //Đây là hàm giải mã decryption của 
	public void decryption_Playfair()
        {
            
        }
        
                //Đây là hàm mã hóa encryption của BangChuDon
        public void encryption_BangChuDon()
        {
            
        }
        //Đây là hàm giải mã decryption của 
	public void decryption_BangChuDon()
        {
            
        }
        
        
        //Đây là hàm mã hóa encryption của Vigenere
        public void encryption_Vigenere()
        {   
                // Mảng để lưu kết quả mã hóa
            	char[]kq=new char[100];
                // Chuyển key và plaintext thành mảng ký tự
		char[] nkey= key.toCharArray();
		char[] plaint= plainText.toCharArray();
                // Mảng để lưu khóa lặp lại
		char[] them=new char[1000];
		int n=0;
		// Lặp qua từng ký tự trong khóa
                for (int i = 0; i < nkey.length; i++) {
                    // Sao chép ký tự khóa vào mảng them
                    them[n++] = nkey[i];
                }
                // Nếu độ dài khóa ngắn hơn độ dài văn bản gốc
                if (nkey.length < plaint.length) {
                    // Khởi tạo biến len để giữ vị trí ký tự trong khóa
                    int len = 0;
                    // Lặp để sao chép các ký tự khóa còn thiếu vào mảng them
                    for (int k = 0; k < (plaint.length - nkey.length); k++) {
                        // Nếu chưa hết các ký tự trong khóa
                        if (len < nkey.length) {
                            // Sao chép ký tự khóa tại vị trí len vào mảng them
                            them[n++] = nkey[len];
                        } else {
                            // Đặt lại len về 0 để bắt đầu lại từ đầu khóa
                            len = 0;
                        }
                        // Tăng biến len lên 1 để lấy ký tự tiếp theo trong khóa
                        len++;
                    }
                }
			int skq=0;
			for(int j=0;j<n;j++)
			{
                                // Tính ký tự mã hóa: cộng giá trị ASCII của ký tự gốc và ký tự khóa, lấy phần dư khi chia cho 26,
                                // sau đó cộng thêm 65 để chuyển về ký tự ASCII của chữ cái in hoa
				kq[skq++]=((char)((plaint[j]+them[j])%26+65));
			}
                        //Đưa vào hàm kết quả bằng cách gán mảng kết quả vào
			cypher=new String(kq);
        }
        //Đây là hàm giải mã decryption của Vigenere
	public void decryption_Vigenere()
        {
                // Mảng để lưu kết quả giải mã
                char[] kq = new char[100];
                 // Chuyển khóa và văn bản mã hóa thành mảng ký tự
                char[] nkey = key.toCharArray();
                char[] cyp = plainText.toCharArray();
                // Mảng để lưu khóa lặp lại
                char[] them = new char[1000];
                int n = 0;
                // Lặp qua từng ký tự trong khóa
                for(int i=0; i<nkey.length; i++) {
                    // Sao chép ký tự khóa vào mảng them và tăng chỉ số của mảng them
                    them[n++] = nkey[i];
                }
                // Nếu độ dài khóa ngắn hơn độ dài văn bản mã hóa
                if(nkey.length < cyp.length) {
                    // Khởi tạo biến len để theo dõi vị trí ký tự trong khóa
                    int len = 0;
                    // Lặp để sao chép các ký tự khóa còn thiếu vào mảng them
                    for(int k=0; k<(cyp.length-nkey.length); k++) {
                        // Nếu chưa hết các ký tự trong khóa
                        if(len < nkey.length) {
                            // Sao chép ký tự khóa tại vị trí len vào mảng them
                            them[n++] = nkey[len];
                        } else {
                            // Đặt lại len về 0 để bắt đầu lại từ đầu khóa
                            len = 0;
                        }
                        // Tăng biến len lên 1 để lấy ký tự tiếp theo trong khóa
                        len++;
                    }
                }
			int skq=0;
			for (int j = 0; j < n; j++) {
                        // Tính ký tự giải mã: trừ giá trị ASCII của ký tự mã hóa với ký tự khóa
                        // Nếu kết quả âm, cộng thêm 26 để tránh âm trước khi lấy phần dư
                            if ((cyp[j] - them[j]) < 0) {
                                kq[skq++] = ((char)((26 + cyp[j] - them[j]) % 26 + 65));
                            }else{
                                kq[skq++] = ((char)((cyp[j] - them[j]) % 26 + 65));
                            }
                        }
                        //Đưa vào hàm kết quả bằng cách gán mảng kết quả vào
			cypher=new String(kq);
        }
      
        public int timViTriMin(char[] nkey) {
            int luu = 0;
            int min = nkey[0];
            for (int i = 1; i < nkey.length; i++)
            {
		if (nkey[i] < min) 
                {
                    luu = i;
                    min = nkey[i];
		}
            }
            return luu;
	}
        
        //Đây là hàm mã hóa encryption của ChuyenDichDong
        public void encryption_ChuyenDichDong()
        {
           // Chuyển khóa và văn bản gốc thành mảng ký tự
           char[] nkey = key.toCharArray();
           char[] plaint = plainText.toCharArray();
           // Mảng để lưu văn bản gốc đã được thêm ký tự 'Z' nếu cần
           char[] nplaint = new char[100];
           int n = 0;

           // Sao chép văn bản gốc vào mảng nplaint và thêm ký tự 'Z' nếu cần
           for (int i = 0; i < plaint.length; i++) {
               nplaint[n++] = plaint[i];
           }
           if (n % nkey.length != 0) {
               while (n % nkey.length != 0) {
                   nplaint[n++] = 'Z';
               }
           }

           // Tạo ma trận để lưu trữ văn bản gốc
           char[][] maTran = new char[n / nkey.length][nkey.length];
           // Mảng để lưu kết quả mã hóa
           char kq[] = new char[n];
           int skq = 0;
           int k = 0;

           // Điền văn bản gốc vào ma trận theo hàng
           for (int i = 0; i < n / nkey.length; i++) {
               for (int j = 0; j < nkey.length; j++) {
                   maTran[i][j] = nplaint[k];
                   k++;
               }
           }

           // Đọc các cột theo thứ tự xác định bởi khóa
           for (int i = 0; i < nkey.length; i++) {
               // Tìm vị trí của cột có ký tự nhỏ nhất trong khóa
               int luu = timViTriMin(nkey);
               // Đọc các ký tự trong cột đó theo hàng
               for (int j = 0; j < n / nkey.length; j++) {
                   kq[skq++] = maTran[j][luu];
               }
               // Đánh dấu cột đã đọc bằng ký tự ']'
               nkey[luu] = (char) (91);
           }

           //Đưa vào hàm kết quả bằng cách gán mảng kết quả vào
           cypher = new String(kq);
    }
        //Đây là hàm giải mã decryption của ChuyenDichDong
	public void decryption_ChuyenDichDong()
        {
           // Chuyển khóa và văn bản gốc thành mảng ký tự
           char[] nkey = key.toCharArray();
           char[] plaint = plainText.toCharArray();
           char[] nplaint = new char[100];
           int n = 0;

           // Sao chép văn bản gốc vào mảng nplaint và thêm ký tự 'Z' để đảm bảo độ dài chia hết cho độ dài khóa
           for (int i = 0; i < plaint.length; i++)
               nplaint[n++] = plaint[i];
           if (n % nkey.length != 0)
               while (n % nkey.length != 0)
                   nplaint[n++] = 'Z';

           // Tạo mảng để lưu kết quả mã hóa và mảng 2D để lưu ma trận khóa
           char kq[] = new char[n];
           int skq = 0;
           char[][] maTran = new char[n / nkey.length][nkey.length];
           int k = 0;

           // Điền ma trận khóa bằng cách lấy từng ký tự từ văn bản gốc theo thứ tự tăng dần của khóa
           for (int i = 0; i < nkey.length; i++) {
               int luu = timViTriMin(nkey); // Tìm vị trí của ký tự nhỏ nhất trong khóa
               for (int j = 0; j < n / nkey.length; j++)
                   maTran[j][luu] = nplaint[k++];
               nkey[luu] = (char) (91); // Đánh dấu ký tự đã sử dụng trong khóa
           }

           // In ra ma trận khóa và lấy các ký tự từ ma trận để tạo ciphertext
           for (int i = 0; i < n / nkey.length; i++)
               for (int j = 0; j < nkey.length; j++) {
                   System.out.print(maTran[i][j] + "");
                   kq[skq++] = maTran[i][j];
               }

           // Chuyển mảng ký tự kết quả thành chuỗi
           cypher = new String(kq);
        }
}
