//Khai báo pakage hochiminh.controller
package encryption.ecryption_application;
//Thêm thư viện ActionEvent để lấy thông từ sau khi user bấm nút thì nút đó là nút gì
import java.awt.Color;
import java.awt.event.ActionEvent;
//Thêm thư viện ActionListener để triển khai các method trong interface của ActionListener
import java.awt.event.ActionListener;
//Lớp Encryption_Action implements lại các method từ ActionListener
public class Encryption_Action implements ActionListener{
	//Khai báo biến view
	private Encryption_GUI view;
	
        //Tạo constructor để thêm các hoạt động khi bấm các nút nhấn
	public Encryption_Action(Encryption_GUI view_Button) {
                //Có nghĩa là biến view sẽ được gán biến view_Button là nút bấm
		this.view = view_Button;
	}

        //Hàm được khởi tạo sau khi bấm nút sẽ thực hiện thao tác gì
	@Override
	public void actionPerformed(ActionEvent e) {
                //Khởi tạo biến src với giá trị là tên của nút được bấm
		String src = e.getActionCommand();
                //So sánh nếu nút được bấm là nút Encryption
                
                if( src.equals("Encryption") || src.equals("Decryption") || src.equals("Random key"))
                {
                    //Xét điều kiện nếu nút nhấn là Encryption và nút vừa được nhấn có mùa LIGHT_GRAY thì bắt đầu mã hóa
                    if(src.equals("Encryption") && this.view.getButton_Ceasar().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Mã hóa 
                        this.view.encrytion_Ceasar();
                    }//Xét điều kiện nếu nút nhấn là Decryption và nút vừa được nhấn là mùa LIGHT_GRAY thì bắt đầu giải mã
                    else if(src.equals("Decryption") && this.view.getButton_Ceasar().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Giải mã 
                        this.view.decryption_Ceasar();
                    }
                    //Xét điều kiện nếu nút nhấn là Encryption và nút vừa được nhấn có mùa LIGHT_GRAY thì bắt đầu mã hóa
                    else if(src.equals("Encryption") && this.view.getButton_Vigenere().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Mã hóa 
                        this.view.encryption_Vigenere();
                    }//Xét điều kiện nếu nút nhấn là Decryption và nút vừa được nhấn là mùa LIGHT_GRAY thì bắt đầu giải mã
                    else if(src.equals("Decryption") && this.view.getButton_Vigenere().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Giải mã 
                        this.view.decryption_Vigenere();
                    }
                    //Xét điều kiện nếu nút nhấn là Encryption và nút vừa được nhấn có mùa LIGHT_GRAY thì bắt đầu mã hóa
                    else if(src.equals("Encryption") && this.view.getButton_chuyen_dich_dong().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Mã hóa 
                        this.view.encryption_ChuyenDichDong();
                    }//Xét điều kiện nếu nút nhấn là Decryption và nút vừa được nhấn là mùa LIGHT_GRAY thì bắt đầu giải mã
                    else if(src.equals("Decryption") && this.view.getButton_chuyen_dich_dong().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Giải mã 
                        this.view.decryption_ChuyenDichDong();
                    }
                    
                    //Xét điều kiện nếu nút nhấn là Encryption và nút vừa được nhấn có mùa LIGHT_GRAY thì bắt đầu mã hóa
                    else if(src.equals("Encryption") && this.view.getButton_Playfair().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Mã hóa 
                        this.view.encryption_Playfair();
                    }//Xét điều kiện nếu nút nhấn là Decryption và nút vừa được nhấn là mùa LIGHT_GRAY thì bắt đầu giải mã
                    else if(src.equals("Decryption") && this.view.getButton_Playfair().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Giải mã 
                        this.view.decryption_Playfair();
                    }
                    //Xét điều kiện nếu nút nhấn là Random key và nút vừa được nhấn là mùa LIGHT_GRAY thì gọi hàm random key
                    else if(src.equals("Random key") && this.view.getButton_bang_chu_Don().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        this.view.randomKey();
                    }
                    
                    //Xét điều kiện nếu nút nhấn là Encryption và nút vừa được nhấn có mùa LIGHT_GRAY thì bắt đầu mã hóa
                    else if(src.equals("Encryption") && this.view.getButton_bang_chu_Don().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Mã hóa 
                        this.view.encryption_BangChuDon();
                    }//Xét điều kiện nếu nút nhấn là Decryption và nút vừa được nhấn là mùa LIGHT_GRAY thì bắt đầu giải mã
                    else if(src.equals("Decryption") && this.view.getButton_bang_chu_Don().getBackground().equals(Color.LIGHT_GRAY))
                    {
                        //Giải mã 
                        this.view.decryption_BangChuDon();
                    }
                }
                //So sánh nếu nút vừa nhấn là Ceasar thì thay đổi background nút Ceasar
                else if(src.equals("Ceasar") )
                {
                    //Thay đổi background của nút Ceasar
                    this.view.changeBackGroundCeasar();
                }
                //So sánh nếu nút vừa nhấn là Vigenere thì thay đổi background nút Vigenere
                else if(src.equals("Vigenere") )
                {
                    //Thay đổi background của nút Vigenere
                    this.view.changeBackGroundVigenere();
                }
                //So sánh nếu nút vừa nhấn là Chuyen_dich_dong thì thay đổi background nút Chuyen_dich_dong
                else if(src.equals("Chuyen_dich_dong") )
                {
                    //Thay đổi background của nút Chuyen_dich_dong
                    this.view.changeBackGroundChuyenDichDong();
                }
                //So sánh nếu nút vừa nhấn là Playfair thì thay đổi background nút Playfair
                else if(src.equals("Playfair") )
                {
                    //Thay đổi background của nút Playfair
                    this.view.changeBackGroundPlayfair();
                }
                //So sánh nếu nút vừa nhấn là Bang_chu_don thì thay đổi background nút Bang_chu_don
                else if(src.equals("Bang_chu_don") )
                {
                    //Thay đổi background của nút Bang_chu_don
                    this.view.changeBackGroundBangChuDon();
                }

	}

}
