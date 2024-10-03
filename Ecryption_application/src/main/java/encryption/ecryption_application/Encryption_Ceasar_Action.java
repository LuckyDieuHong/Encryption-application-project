//Khai báo pakage hochiminh.controller
package encryption.ecryption_application;
//Thêm thư viện ActionEvent để lấy thông từ sau khi user bấm nút thì nút đó là nút gì
import java.awt.event.ActionEvent;
//Thêm thư viện ActionListener để triển khai các method trong interface của ActionListener
import java.awt.event.ActionListener;
//Lớp Encryption_Ceasar_Action implements lại các method từ ActionListener
public class Encryption_Ceasar_Action implements ActionListener{
	//Khai báo biến view
	private Encryption_Ceasar_GUI view;
	
        //Tạo constructor để thêm các hoạt động khi bấm các nút nhấn
	public Encryption_Ceasar_Action(Encryption_Ceasar_GUI view_Button) {
                //Có nghĩa là biến view sẽ được gán biến view_Button là nút bấm
		this.view = view_Button;
	}

        //Hàm được khởi tạo sau khi bấm nút sẽ thực hiện thao tác gì
	@Override
	public void actionPerformed(ActionEvent e) {
                //Khởi tạo biến src với giá trị là tên của nút được bấm
		String src = e.getActionCommand();
                //So sánh nếu nút được bấm là nút Encryption
		if(src.equals("Encryption"))
		{       //Nếu nút được bấm là nút Encryption thì sẽ gọi hàm bên Encryption_Ceasar_GUI để thực hiện các bước mã hóa
			this.view.encrytion();
		}//So sánh nếu nút được bấm là nút Decryption
		else if(src.equals("Decryption"))
		{       //Nếu nút được bấm là nút Decryption thì sẽ gọi ham bên Encryption_Ceasar_GUI để thực hiện các bước giải mã
			this.view.decryption();	
		}
	}

}
