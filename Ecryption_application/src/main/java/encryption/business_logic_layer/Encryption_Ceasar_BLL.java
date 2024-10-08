//Khai báo package hochiminh.model
package encryption.business_logic_layer;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Encryption_Ceasar_BLL {
        //Khai báo Plaintext để lưu trữ giá trị plantext muốn mã hóa hoặc giải mã
	private String plainText;
        //Khai báo key để lưu trữ giá trị key
	private String key;
        //Khai báo Cypher để lưu trữ kết quả trả về là đoạn mã đã mã hóa hoặc đoạn mã đã giải mã
	private String cypher;
        private String random_key;
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
             char[][] keyMatrix = new char[5][5] ;
        String plainText = this.plainText;
        String key = this.key;
        String cipherText = "";
        int[] indexUppercaseCharacter = new int[plainText.length()];
        Arrays.fill(indexUppercaseCharacter, -1);

        //Handle moduleKey
        key = key.toLowerCase();

        for(int i = 0 ; i < key.length() ; i++) 
        {
            //Remove all character apear 2nd time or more
            if(key.indexOf(key.charAt(i)) != i) 
                key = key.substring(0, i).concat(key.substring(i-- +1 , key.length()));
        }
        
        //Add remaining character into module key
        for(int i = 'a' ; i <= 'z' ; i++)
        {
            if(!key.contains(Character.toString(i)) &&
                i != 'j') 
                key = key.concat(Character.toString(i));
        }

        //Add key into Maxtrix
        for(int i = 0 ; i < 5 ; i++)
        {
            for(int j = 0 ; j < 5 ; j++)
                keyMatrix[i][j] = key.charAt(i*5 + j);
        }

        //Handle plaintext
        int indexX ;
        int indexY ;
        boolean flag ;

        //Check duplicate chacracter
        for(int i = 0 ; i < plainText.length() - 1 ; i++)
        {
            if(plainText.charAt(i) == plainText.charAt(i+1))
                plainText = plainText.substring(0, i+1)
                                    .concat("z")
                                    .concat(plainText.substring(i + 1, plainText.length()));

        }

        //Check length
        if(plainText.length() % 2 != 0) 
            plainText = plainText.concat("z");

        //Save Index of uppercase character
        int index = 0;
        for(int i = 0 ; i < plainText.length() ; i++)
        {
            if( Character.isLetter(plainText.charAt(i)) &&
                Character.isUpperCase(plainText.charAt(i)))
                    indexUppercaseCharacter[index++] = i;
        }

        //LowerCase String
        plainText = plainText.toLowerCase();

        //Handle encrypt
        for(int i = 0 ; i < plainText.length() - 1 ; i+=2)
        {
            indexX = -1;
            indexY = -1;
            flag = false;
            
            for(int m = 0 ; m < 5 ; m++)
            {
                for(int n = 0 ; n < 5 ; n++)
                {
                    if(plainText.charAt(i) == keyMatrix[m][n] && !flag)
                    {
                        indexX = m;
                        indexY = n;
                        flag = true;
                        m = 0;
                        n = 0;
                    }

                    else if(plainText.charAt(i+1) == keyMatrix[m][n]  && flag) 
                    {
                        //Same row
                        if(indexX == m )
                        {
                            cipherText += (indexY == 4) 
                                ? Character.toString(keyMatrix[indexX][0]) 
                                : Character.toString(keyMatrix[indexX][indexY+1]);
                            cipherText += (n == 4) 
                                ? Character.toString(keyMatrix[m][0]) 
                                : Character.toString(keyMatrix[m][n+1]);
                        }

                        //Same column
                        else if(indexY == n)
                        {
                            cipherText += (indexX == 4) 
                                ? Character.toString(keyMatrix[0][indexY]) 
                                : Character.toString(keyMatrix[indexX+1][indexY]);
                            cipherText += (m == 4) 
                                ? Character.toString(keyMatrix[0][n]) 
                                : Character.toString((keyMatrix[m+1][n]));
                        }
                        //Different rows and columns
                        else
                        {
                            cipherText += Character.toString(keyMatrix[indexX][n]);
                            cipherText += Character.toString(keyMatrix[m][indexY]);
                        }

                        //Stop loop
                        m=5;
                        n=5;     
                    }
                }
            }
        }

        //Recovery uppercase character
        for(int i = 0 ; indexUppercaseCharacter[i] != -1 ; i++)
            cipherText = cipherText.replace(cipherText.charAt(indexUppercaseCharacter[i]), Character.toUpperCase(cipherText.charAt(indexUppercaseCharacter[i])));
     
        this.cypher = cipherText;
        }
        //Đây là hàm giải mã decryption của 
	public void decryption_Playfair()
        {
            
        }
        
        //Đây là hàm mã hóa encryption của Vigenere
        public void encryption_Vigenere()
        {
            
        }
        //Đây là hàm giải mã decryption của Vigenere
	public void decryption_Vigenere()
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
        
        //Đây là hàm mã hóa encryption của ChuyenDichDong
        public void encryption_ChuyenDichDong()
        {
            
        }
        //Đây là hàm giải mã decryption của 
	public void decryption_ChuyenDichDong()
        {
            
        }
}
