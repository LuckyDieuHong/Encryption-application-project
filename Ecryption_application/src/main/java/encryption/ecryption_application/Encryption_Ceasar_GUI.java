//Khai báo pakage hochiminh.view
package encryption.ecryption_application;
//Thêm thư viện JFrame để tạo và quản lý cửa sổ người dùng 
import encryption.business_logic_layer.Encryption_Ceasar_BLL;
import javax.swing.JFrame;
//Thêm thư viện BorderLayout để tạo layout Đông, Tây, Nam, Bắc, Center
import java.awt.BorderLayout;
//Thêm thư viện GridLayout để tạo layout chia theo số hàng và cột
import java.awt.GridLayout;
//Thêm thư viện Font để tạo font chữ
import java.awt.Font;
//Thêm thư viện JButton để tạo có nút bấm
import javax.swing.JButton;
//Thêm thư viện JLabel để tạo vùng chứa tên như plainText, key, cypherText
import javax.swing.JLabel;
//Thư viện này để chứa các thành phần khác vào 1
import javax.swing.JPanel;
//Thư viện này để cso thể nhập các ký tự vào trong ô
import javax.swing.JTextArea;
//Import pakage controller để phục vụ thao tác sau khi nhấn vào nút thì sẽ tương tác gì
//Import pakage model để lấy các method, dữ liệu user nhập vào


//Lớp Encryption_Ceasar_GUI kế thừa lại JFrame có nghĩa mọi method trong JFrame đều có thể lấy ra vào trong hàm Encryption_Ceasar_GUI
public class Encryption_Ceasar_GUI extends JFrame{
        //Khai báo model để phục vụ lấy dữ liệu và gọi hàm từ model
	private Encryption_Ceasar_BLL model;
        
        //Khai báo area_PlainText và key để nhập chuỗi vào
	private JTextArea area_PlainText;
        private JTextArea area_Key;
        //Khai báo area_CypherText để hiển thị kết quả mã hóa hoặc giải mã
	private JTextArea area_CypherText;

        //Tạo constructor Encryption_Ceasar_GUI, khởi tạo biến model và gọi hàm init
	public Encryption_Ceasar_GUI()
	{
                //Khởi tạo biến model với mục đích sẽ gọi các giá trị và method từ lớp Encryption_Ceasar_model ra
		this.model = new Encryption_Ceasar_BLL();
                //Gọi hàm init để khởi tạo các thành phần có thể nhìn thấy trong giao diện
		this.init();
	}
        //Tạo hàm init
	public void init()
        {
                //Sở dĩ khai báo các kiểu dữ liệu JTextArea ở ngoài hàm init là để thành các biến toàn cục,
                //nếu khởi tạo các biến trong hàm init thì sẽ tí nữa sẽ không thể tương tác với bên ngoài hàm được
            
                //Đặt tên cửa sổ chương trình là Ceasar Cipher o((>ω< ))o
		this.setTitle("Ceasar Cipher o((>ω< ))o");
                //Đặt kích thước của chương trình với chiều rộng 600, chiều cao 600
		this.setSize(600,600);
                //Đặt vị trí đặt ban đầu của cửa sổ chương trình là ở giữa màn hình
		this.setLocationRelativeTo(null);
                //Đặt trạng thái tắt sau khi bấm nút tắt chương trình
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
                //Khai báo biến action để xem các trạng thái bấm nút của chương trình
		Encryption_Ceasar_Action action = new Encryption_Ceasar_Action(this);
                //Khai báo biến font để đặt kiểu chữ các thành phần trong chương trình
		Font font = new Font("Arial",Font.BOLD,30);
		
                //Khai báo biến panel_top để gom các thành phần vào bên trên của chương trình
		JPanel panel_top = new JPanel();
                //Đặt layout cho panel_top dạng lưới với 3 dòng 3 cột, cách nhau trên dưới và trái phải là 30
		panel_top.setLayout(new GridLayout(3,3,30,30));
		
                //Khai báo biến jLabel_PT với nội dung của biến này khi hiển thị ra ngoài màn hình là Plain text
		JLabel jLabel_PT = new JLabel("Plain text");
                //Đặt kiểu chữ cho biến jLabel_PT
		jLabel_PT.setFont(font);
                //Khởi tạo 1 vùng nhập cho plainText
		area_PlainText = new JTextArea();
                //Thêm lân lượt 2 thành phần jLabel_PT và area_PlainText vào bên trong panel_top
		panel_top.add(jLabel_PT);
		panel_top.add(area_PlainText);
			
                //Khai báo biến jLabel_Key với nội dung của biến này khi hiển thị ra ngoài màn hình là Key
		JLabel jLabel_Key = new JLabel("Key");
                //Đặt kiểu chữ cho biến jLabel_Key
		jLabel_Key.setFont(font);
                //Khởi tạo 1 vùng nhập cho area_Key
		area_Key = new JTextArea();
                //Thêm lân lượt 2 thành phần jLabel_Key và area_Key vào bên trong panel_top
		panel_top.add(jLabel_Key);
		panel_top.add(area_Key);
                
		//Khai báo biến jLabel_CT với nội dung của biến này khi hiển thị ra ngoài màn hình là Cypher text
		JLabel jLabel_CT = new JLabel("Cypher text");
                //Đặt kiểu chữ cho biến jLabel_CT
		jLabel_CT.setFont(font);
                //Khởi tạo 1 vùng hiển thị kết quả cho area_CypherText
		area_CypherText = new JTextArea();
                //Thêm lân lượt 2 thành phần jLabel_CT và area_CypherText vào bên trong panel_top
		panel_top.add(jLabel_CT);
		panel_top.add(area_CypherText);

		//Tạo và khởi tạo nút nhấn Encryption
		JButton button_encryption = new JButton("Encryption");
                //Đặt kiểu chữ cho biến button_encryption
		button_encryption.setFont(font);
                //Thêm hàm addActionListener với mục đích khi bấm vào nút Encryption thì bên lớp Encryption_Ceasar_Action sẽ làm gì
		button_encryption.addActionListener(action);
                
		//Tạo và khởi tạo nút nhấn Decryption
		JButton button_decryption = new JButton("Decryption");
                //Đặt kiểu chữ cho biến Decryption
		button_decryption.setFont(font);
                //Thêm hàm addActionListener với mục đích khi bấm vào nút Decryption thì bên lớp Encryption_Ceasar_Action sẽ làm gì
		button_decryption.addActionListener(action);
		
                //Tạo biến panel_bottom đẻ lưu trữ các nút bấm
		JPanel panel_bottom = new JPanel();
                //Đặt layout cho panel_bottom là dạng BorderLayout
		panel_bottom.setLayout(new BorderLayout());
                //Đặt nút Encryption bên phía Tây
		panel_bottom.add(button_encryption,BorderLayout.WEST);
                //Đặt nút Decryption bên phía Đông
		panel_bottom.add(button_decryption,BorderLayout.EAST);

		
		//Đặt layout cho chương trình là dạng BorderLayout với chỉ số 20,20
		this.setLayout(new BorderLayout(20,20));
                //Thêm panel_top vào chương trình chính với vị trí mặc định là CENTER
		this.add(panel_top);
                 //Thêm panel_bottom vào chương trình chính với vị trí là phía Nam
		this.add(panel_bottom, BorderLayout.SOUTH);
                //Hiển thị cửa sổ chương trình
		this.setVisible(true);
	}
	
        //Hàm mã hóa được sử dụng khi lớp Encryption_Ceasar_Action gọi
	public void encrytion(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		int key = Integer.parseInt(area_Key.getText());
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.encrytion();
                //Hiện thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp model
		this.area_CypherText.setText(this.model.getCypher());
	}
	
//Hàm mã hóa được sử dụng khi lớp Encryption_Ceasar_Action gọi
	public void decryption(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		int key = Integer.parseInt(area_Key.getText());
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn giải mã 
		this.model.decryption();
                //Hiện thị kết quả giải mã bằng cách lấy giá trị Cypher từ bên lớp model
		this.area_CypherText.setText(this.model.getCypher());
	}
}
