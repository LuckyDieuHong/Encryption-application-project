//Khai báo pakage hochiminh.view
package encryption.ecryption_application;
//Thêm thư viện JFrame để tạo và quản lý cửa sổ người dùng 
import encryption.business_logic_layer.Encryption_BLL;
import javax.swing.JFrame;
//Thêm thư viện BorderLayout để tạo layout Đông, Tây, Nam, Bắc, Center
import java.awt.BorderLayout;
import java.awt.Color;
//Thêm thư viện GridLayout để tạo layout chia theo số hàng và cột
import java.awt.GridLayout;
//Thêm thư viện Font để tạo font chữ
import java.awt.Font;
//Thêm 2 thư viện GridBag để tạo layout cho các nút
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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


//Lớp Encryption_GUI kế thừa lại JFrame có nghĩa mọi method trong JFrame đều có thể lấy ra vào trong hàm Encryption_GUI
public class Encryption_GUI extends JFrame{
        //Khai báo model để phục vụ lấy dữ liệu và gọi hàm từ model
	private Encryption_BLL model;
        
        //Khai báo area_PlainText và key để nhập chuỗi vào
	private JTextArea area_PlainText;
        private JTextArea area_Key;
        //Khai báo area_CypherText để hiển thị kết quả mã hóa hoặc giải mã
	private JTextArea area_CypherText;
        
        //Khai báo các nút nhấn các dạng mã hóa để bấm từng chức năng
        private JButton button_Ceasar;
        private JButton button_Vigenere;
        private JButton button_chuyen_dich_dong;
        private JButton button_Playfair;
        private JButton button_bang_chu_Don;

    //Tạo các method để getter và setter của các JButton chức năng nhằm mục đích để cho lấy màu so sánh bên Action
    public JButton getButton_Ceasar() {
        return button_Ceasar;
    }
    public void setButton_Ceasar(JButton button_Ceasar) {
        this.button_Ceasar = button_Ceasar;
    }

    public JButton getButton_Vigenere() {
        return button_Vigenere;
    }
    public void setButton_Vigenere(JButton button_Vigenere) {
        this.button_Vigenere = button_Vigenere;
    }

    public JButton getButton_chuyen_dich_dong() {
        return button_chuyen_dich_dong;
    }
    public void setButton_chuyen_dich_dong(JButton button_chuyen_dich_dong) {
        this.button_chuyen_dich_dong = button_chuyen_dich_dong;
    }

    public JButton getButton_Playfair() {
        return button_Playfair;
    }
    public void setButton_Playfair(JButton button_Playfair) {
        this.button_Playfair = button_Playfair;
    }

    public JButton getButton_bang_chu_Don() {
        return button_bang_chu_Don;
    }
    public void setButton_bang_chu_Don(JButton button_bang_chu_Don) {
        this.button_bang_chu_Don = button_bang_chu_Don;
    }
        
        //Tạo constructor Encryption_GUI, khởi tạo biến model và gọi hàm init
	public Encryption_GUI()
	{
                //Khởi tạo biến model với mục đích sẽ gọi các giá trị và method từ lớp Encryption_Ceasar_model ra
		this.model = new Encryption_BLL();
                //Gọi hàm init để khởi tạo các thành phần có thể nhìn thấy trong giao diện
		this.init();
	}
        //Tạo hàm init
	public void init()
        {
                //Sở dĩ khai báo các kiểu dữ liệu JTextArea ở ngoài hàm init là để thành các biến toàn cục,
                //nếu khởi tạo các biến trong hàm init thì sẽ tí nữa sẽ không thể tương tác với bên ngoài hàm được
            
                //Đặt tên cửa sổ chương trình là Ceasar Cipher o((>ω< ))o
		this.setTitle("Encryption Application");
                //Đặt kích thước của chương trình với chiều rộng 600, chiều cao 600
		this.setSize(1015,600);
                //Đặt vị trí đặt ban đầu của cửa sổ chương trình là ở giữa màn hình
		this.setLocationRelativeTo(null);
                //Đặt trạng thái tắt sau khi bấm nút tắt chương trình
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Khai báo biến font để đặt kiểu chữ các thành phần trong chương trình
		Font font = new Font("Arial",Font.BOLD,30);
                
                //Khai báo biến action để xem các trạng thái bấm nút của chương trình
		Encryption_Action action = new Encryption_Action(this);
                
                //Khởi tạo các nút nhấn mã hóa với các tên tương ứng
                button_Ceasar = new JButton("Ceasar");
                button_Vigenere = new JButton("Vigenere");
                button_chuyen_dich_dong = new JButton("Chuyen_dich_dong");
                button_Playfair = new JButton("Playfair");
                button_bang_chu_Don = new JButton("Bang_chu_don");
                
                //Đặt Font cho các nút bấm tương ứng
                button_Ceasar.setFont(font);
                button_Vigenere.setFont(font);
                button_chuyen_dich_dong.setFont(font);
                button_Playfair.setFont(font);
                button_bang_chu_Don.setFont(font);
                
                //Thêm vào action vào các nút nhân để lắng nghe sự kiện sau khi user nhấn nút
                button_Ceasar.addActionListener(action);
                button_Vigenere.addActionListener(action);
                button_chuyen_dich_dong.addActionListener(action);
                button_Playfair.addActionListener(action);
                button_bang_chu_Don.addActionListener(action);
                     
                //Tạo một vật chứa để chứa các nút giải mã
                JPanel panel_Top = new JPanel();
                //Tạo layouy cho panel kiểu GridBagLayout là kể ô lưới nhưng gộp lại
                GridBagLayout layout_top = new GridBagLayout();
                //Đặt layout cho panel_Top
                panel_Top.setLayout(layout_top);
                //Tạo gbc để chỉ định các ràng buộc như vị trí cho các nút bấm
                GridBagConstraints gbc = new GridBagConstraints();
                //Đặt ràng buộc là các phần tử nằm trên 1 đương và vị trí trâm tâm là ở giữa panel_Top
                gbc.fill = GridBagConstraints.ABOVE_BASELINE;
               
                //Gán ràng buộc tọa độ với vị trí là x = 0 nghĩa là vị trí x đầu tiên
                //và vị trí y=0 là nằm trên tạo độ 0 từ giữa trung tâm
                gbc.gridx = 0;
                gbc.gridy = 0;
                //Đưa nút Ceasar vào trong panel_Top
                panel_Top.add(button_Ceasar,gbc);
                //Gán ràng buộc vị trí với vị trí là x = 1 nghĩa là vị trí x thứ 2, y giống như ở trên
                gbc.gridx = 1;
                gbc.gridy = 0;
                //Đưa nút Vigenere vào trong panel_Top
                panel_Top.add(button_Vigenere,gbc);
                //Gán ràng buộc vị trí với vị trí là x = 2 nghĩa là vị trí x thứ 3, y giống như ở trên
                gbc.gridx = 2;
                gbc.gridy = 0;
                //Đưa nút chuyen_dich_dong vào trong panel_Top
                panel_Top.add(button_chuyen_dich_dong,gbc);
                //Gán ràng buộc vị trí với vị trí là x = 3 nghĩa là vị trí x thứ 4, y giống như ở trên
                gbc.gridx = 3;
                gbc.gridy = 0;
                //Đưa nút Playfair vào trong panel_Top
                panel_Top.add(button_Playfair,gbc);
                //Gán ràng buộc vị trí với vị trí là x = 4 nghĩa là vị trí x thứ 5, y giống như ở trên
                gbc.gridx = 4;
                gbc.gridy = 0;
                //Đưa nút bang_chu_Don vào trong panel_Top
                panel_Top.add(button_bang_chu_Don,gbc);
                
                //Khai báo biến panel_top để gom các thành phần vào bên trên của chương trình
		JPanel panel_Center = new JPanel();
                //Đặt layout cho panel_top dạng lưới với 3 dòng 3 cột, cách nhau trên dưới và trái phải là 30
		panel_Center.setLayout(new GridLayout(3,3,30,30));
		
                //Khai báo biến jLabel_PT với nội dung của biến này khi hiển thị ra ngoài màn hình là Plain text
		JLabel jLabel_PT = new JLabel("Plain text");
                //Đặt kiểu chữ cho biến jLabel_PT
		jLabel_PT.setFont(font);
                //Khởi tạo 1 vùng nhập cho plainText
		area_PlainText = new JTextArea();
                //Thêm lân lượt 2 thành phần jLabel_PT và area_PlainText vào bên trong panel_top
		panel_Center.add(jLabel_PT);
		panel_Center.add(area_PlainText);
			
                //Khai báo biến jLabel_Key với nội dung của biến này khi hiển thị ra ngoài màn hình là Key
		JLabel jLabel_Key = new JLabel("Key");
                //Đặt kiểu chữ cho biến jLabel_Key
		jLabel_Key.setFont(font);
                //Khởi tạo 1 vùng nhập cho area_Key
		area_Key = new JTextArea();
                //Thêm lân lượt 2 thành phần jLabel_Key và area_Key vào bên trong panel_top
		panel_Center.add(jLabel_Key);
		panel_Center.add(area_Key);
                
		//Khai báo biến jLabel_CT với nội dung của biến này khi hiển thị ra ngoài màn hình là Cypher text
		JLabel jLabel_CT = new JLabel("Cypher text");
                //Đặt kiểu chữ cho biến jLabel_CT
		jLabel_CT.setFont(font);
                //Khởi tạo 1 vùng hiển thị kết quả cho area_CypherText
		area_CypherText = new JTextArea();
                //Thêm lân lượt 2 thành phần jLabel_CT và area_CypherText vào bên trong panel_top
		panel_Center.add(jLabel_CT);
		panel_Center.add(area_CypherText);

		//Tạo và khởi tạo nút nhấn Encryption
		JButton button_encryption = new JButton("Encryption");
                //Đặt kiểu chữ cho biến button_encryption
		button_encryption.setFont(font);
                //Thêm hàm addActionListener với mục đích khi bấm vào nút Encryption thì bên lớp Encryption_Action sẽ làm gì
		button_encryption.addActionListener(action);
                
		//Tạo và khởi tạo nút nhấn Decryption
		JButton button_decryption = new JButton("Decryption");
                //Đặt kiểu chữ cho biến Decryption
		button_decryption.setFont(font);
                //Thêm hàm addActionListener với mục đích khi bấm vào nút Decryption thì bên lớp Encryption_Action sẽ làm gì
		button_decryption.addActionListener(action);
                
                //Tạo và khởi tạo nút nhấn Random key
		JButton button_random_key = new JButton("Random key");
                //Đặt kiểu chữ cho biến button_random_key
		button_random_key.setFont(font);
                //Thêm hàm addActionListener với mục đích khi bấm vào nút Encryption thì bên lớp Encryption_Action sẽ làm gì
		button_random_key.addActionListener(action);
		
                //Tạo biến panel_bottom đẻ lưu trữ các nút bấm
		JPanel panel_bottom = new JPanel();
                //Đặt layout cho panel_bottom là dạng BorderLayout
		panel_bottom.setLayout(new BorderLayout());
                //Đặt nút Encryption bên phía Tây
		panel_bottom.add(button_encryption,BorderLayout.WEST);
                //Đặt nút Random key ở giữa
		panel_bottom.add(button_random_key,BorderLayout.CENTER);
                //Đặt nút Decryption bên phía Đông
		panel_bottom.add(button_decryption,BorderLayout.EAST);

		
		//Đặt layout cho chương trình là dạng BorderLayout với chỉ số 20,20
		this.setLayout(new BorderLayout(20,20));
                //Thêm panel_top vào chương trình chính với vị trí mặc định là phía Bắc
                this.add(panel_Top,BorderLayout.NORTH);
                //Thêm panel_Center vào chương trình chính với vị trí mặc định là CENTER
		this.add(panel_Center);
                 //Thêm panel_bottom vào chương trình chính với vị trí là phía Nam
		this.add(panel_bottom, BorderLayout.SOUTH);
                //Hiển thị cửa sổ chương trình
		this.setVisible(true);
	}
	
        //Hàm kiểm tra dữ liệu nhập vào có phải là Integer không
        public boolean isInteger(String str)
        {
            try {
                //Nếu đúng là số nguyên thì trả về true
                Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                //Nếu không phải số nguyên thì trả về false
                return false;
            }
        }

        public void randomKey()
        {
            this.model.getRandomKey();
            this.area_Key.setText(this.model.getKey());
        }
        
        //Hàm mã hóa được sử dụng khi lớp Encryption_Action gọi
	public void encrytion_Ceasar(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                
                //Trường hợp thỏa mãn 2 điều kiện Ceasar là PlainText là String và Key là Interger
                else if(!isInteger(plainText) && isInteger(key))
                { 
                    //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
                    this.model.setPlainText(plainText);
                    //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
                    this.model.setKey(key);
                    //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
                    this.model.encrytion_Ceasar();
                    //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp Encryption_BLL
                    this.area_CypherText.setText(this.model.getCypher());
                    //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                    //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                    this.model.setCypher("");
                
                }
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 chuỗi
                else if (!isInteger(plainText) && !isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an Integer");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid");
                }
	}
	
        //Hàm giải mã được sử dụng khi lớp Encryption_Action gọi
	public void decryption_Ceasar(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                //Trường hợp thỏa mãn 2 điều kiện Ceasar là PlainText là String và Key là Interger
                else if(!isInteger(plainText) && isInteger(key))
                {
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.decryption_Ceasar();
                //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp Encryption_BLL
		this.area_CypherText.setText(this.model.getCypher());
                //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                this.model.setCypher("");
                }
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 chuỗi
                else if (!isInteger(plainText) && !isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an Integer");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid");
                }
	}
        
        //Hàm mã hóa được sử dụng khi lớp Encryption_Action gọi
	public void encryption_BangChuDon(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                //Trường hợp thỏa mãn 2 điều kiện BangChuDon là PlainText và Key là String
                if(!isInteger(plainText) && !isInteger(key))
                {
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.encryption_BangChuDon();
                //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp Encryption_BLL
		this.area_CypherText.setText(this.model.getCypher());
                //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                this.model.setCypher("");
                }
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && !isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 số nguyên
                else if (!isInteger(plainText) && isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an String");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid, must be a String");
                }
	}
	
        //Hàm giải mã được sử dụng khi lớp Encryption_Action gọi
	public void decryption_BangChuDon(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                //Trường hợp thỏa mãn 2 điều kiện BangChuDon là PlainText và Key là String
                else if(!isInteger(plainText) && !isInteger(key))
                {
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.decryption_BangChuDon();
                //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp Encryption_BLL
		this.area_CypherText.setText(this.model.getCypher());
                //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                this.model.setCypher("");
                }
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && !isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 số nguyên
                else if (!isInteger(plainText) && isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an String");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid, must be a String");
                }
	}
        
        //Hàm mã hóa được sử dụng khi lớp Encryption_Action gọi
	public void encryption_Playfair(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                //Trường hợp thỏa mãn 2 điều kiện Playfair là PlainText và Key là String
                else if(!isInteger(plainText) && !isInteger(key))
                {
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.encryption_Playfair();
                //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp Encryption_BLL
		this.area_CypherText.setText(this.model.getCypher());
                //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                this.model.setCypher("");
                }
                
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && !isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 số nguyên
                else if (!isInteger(plainText) && isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an String");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid, must be a String");
                }
	}
	
        //Hàm giải mã được sử dụng khi lớp Encryption_Action gọi
	public void decryption_Playfair(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                //Trường hợp thỏa mãn 2 điều kiện Playfair là PlainText và Key là String
                else if(!isInteger(plainText) && !isInteger(key))
                {
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.decryption_Playfair();
                //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp Encryption_BLL
		this.area_CypherText.setText(this.model.getCypher());
                //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                this.model.setCypher("");
                }
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && !isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 số nguyên
                else if (!isInteger(plainText) && isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an String");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid, must be a String");
                }
	}
        
        //Hàm mã hóa được sử dụng khi lớp Encryption_Action gọi
	public void encryption_Vigenere(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                //Trường hợp thỏa mãn 2 điều kiện Vigenre là PlainText và Key là String
                else if(!isInteger(plainText) && !isInteger(key))
                {
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.encryption_Vigenere();
                //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp Encryption_BLL
		this.area_CypherText.setText(this.model.getCypher());
                //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                this.model.setCypher("");
                }
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && !isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 số nguyên
                else if (!isInteger(plainText) && isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an String");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid, must be a String");
                }
	}
	
        //Hàm giải mã được sử dụng khi lớp Encryption_Action gọi
	public void decryption_Vigenere(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Trường hợp thỏa mãn 2 điều kiện Vigenere là PlainText và Key là String
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                else if(!isInteger(plainText) && !isInteger(key))
                {
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.decryption_Vigenere();
                //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp Encryption_BLL
		this.area_CypherText.setText(this.model.getCypher());
                //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                this.model.setCypher("");
                }
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && !isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 số nguyên
                else if (!isInteger(plainText) && isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an String");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid, must be a String");
                }
	}
        
        //Hàm mã hóa được sử dụng khi lớp Encryption_Action gọi
	public void encryption_ChuyenDichDong(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Trường hợp thỏa mãn 2 điều kiện chuyenDichDong là PlainText và Key là String
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                else if(!isInteger(plainText) && !isInteger(key))
                {
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.encryption_ChuyenDichDong();
                //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp model
		this.area_CypherText.setText(this.model.getCypher());
                //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                this.model.setCypher("");
                }
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && !isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 số nguyên
                else if (!isInteger(plainText) && isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an String");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid, must be a String");
                }
	}
	
        //Hàm giải mã được sử dụng khi lớp Encryption_Action gọi
	public void decryption_ChuyenDichDong(){
                //Tạo và khởi tạo biến plainText để lưu trữ giá trị của ô plaintext sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_PlainText.getText()
		String plainText = area_PlainText.getText();
                //Tạo và khởi tạo biến key để lưu trữ giá trị của ô key sau khi user nhập và nhấn nút Encrytion bằng cách lấy area_Key.getText()
                //Do khi nhập key từ ô bên trên thì giá trị sẽ là kiểu String nên phải đổi sang kiểu Int
		String key = area_Key.getText();
                //Trường hợp thỏa mãn 2 điều kiện chuyenDichDong là PlainText và Key là String
                //Kiểm tra trường hợp nếu plainText và key bị rỗng
                if(plainText.equals("") && key.equals(""))
                {
                   //Xuất ra màn hình thông báo Your Plain Text and your key are null
                    this.area_CypherText.setText("Your Plain Text and your key are null");
                }
                //Kiểm tra trường hợp nếu plainText bị rỗng
                else if(plainText.equals(""))
                {
                    //Xuất ra màn hình thông báo your Plain Text is null
                    this.area_CypherText.setText("Your Plain Text is null");
                }
                //Kiểm tra trường hợp nếu Key bị rỗng
                else if(key.equals(""))
                {
                    //Xuất ra màn hình thông báo your key is null
                    this.area_CypherText.setText("Your Key is null");
                }
                else if(!isInteger(plainText) && !isInteger(key))
                {
                //Đặt giá trị plainText bên trong model bằng cách lấy giá trị từ biến plainText
		this.model.setPlainText(plainText);
                //Đặt giá trị key bên trong model bằng cách lấy giá trị từ biến key
		this.model.setKey(key);
                //Gọi hàm encrytion để bắt đầu công đoạn mã hóa 
		this.model.decryption_ChuyenDichDong();
                //Hiển thị kết quả mã hóa bằng cách lấy giá trị Cypher từ bên lớp Encryption_BLL
		this.area_CypherText.setText(this.model.getCypher());
                //Sau khi hiển thị kết quả thì set lại biến Cypher "" nhầm mục đích không lưu giá trị 
                //nếu các hàm khác gọi mà hàm bị trống thì không hiển thị kết quả cũ ra màn hình
                this.model.setCypher("");
                }
                //Trường hợp nếu plainText nhập vào là số nguyên
                else if (isInteger(plainText) && !isInteger(key))
                {
                   //Xuất thông báo ra màn hình plaintext sai, phải là kiểu String
                   this.area_CypherText.setText("Your plaintext is invalid, must be a String");
                }     
                //Trường hợp nếu key nhập vào là 1 số nguyên
                else if (!isInteger(plainText) && isInteger(key))
                {
                    //Xuất thông báo ra màn hình key sai, phải là kiểu Interger
                   this.area_CypherText.setText("Your key is invalid, must be an String");
                }    
                //Trường hợp cả 2 dữ liệu không hợp lệ
                else
                {
                    //Xuất thông báo ra màn hình cả 2 không hợp lệ
                    this.area_CypherText.setText("Your plaintext/key is invalid, must be a String");
                }
	}
        
        //Hàm để thay đổi background của nút nhấn Ceasar khi được nhấn vào
        public void changeBackGroundCeasar()
        {
            button_Ceasar.setBackground(Color.LIGHT_GRAY);
            button_Playfair.setBackground(Color.white);
            button_Vigenere.setBackground(Color.white);
            button_bang_chu_Don.setBackground(Color.white);
            button_chuyen_dich_dong.setBackground(Color.white);
        }  
        //Hàm để thay đổi background của nút nhấn Playfair khi được nhấn vào
        public void changeBackGroundPlayfair()
        {
            button_Ceasar.setBackground(Color.white);
            button_Playfair.setBackground(Color.LIGHT_GRAY);
            button_Vigenere.setBackground(Color.white);
            button_bang_chu_Don.setBackground(Color.white);
            button_chuyen_dich_dong.setBackground(Color.white);
        }   
        //Hàm để thay đổi background của nút nhấn Vigenere khi được nhấn vào
        public void changeBackGroundVigenere()
        {
            button_Ceasar.setBackground(Color.white);
            button_Playfair.setBackground(Color.white);
            button_Vigenere.setBackground(Color.LIGHT_GRAY);
            button_bang_chu_Don.setBackground(Color.white);
            button_chuyen_dich_dong.setBackground(Color.white);
        }
        //Hàm để thay đổi background của nút nhấn Bang_chu_don khi được nhấn vào
        public void changeBackGroundBangChuDon()
        {
            button_Ceasar.setBackground(Color.white);
            button_Playfair.setBackground(Color.white);
            button_Vigenere.setBackground(Color.white);
            button_bang_chu_Don.setBackground(Color.LIGHT_GRAY);
            button_chuyen_dich_dong.setBackground(Color.white);
        }
        //Hàm để thay đổi background của nút nhấn Chuyen_dich_dong khi được nhấn vào
        public void changeBackGroundChuyenDichDong()
        {
            button_Ceasar.setBackground(Color.white);
            button_Playfair.setBackground(Color.white);
            button_Vigenere.setBackground(Color.white);
            button_bang_chu_Don.setBackground(Color.white);
            button_chuyen_dich_dong.setBackground(Color.LIGHT_GRAY);
        }
}
