class fileedit extends JFrame implements ActionListener
{
  JScrollPane jsp;
  JTextArea jta;
  JEditorPane jep;
  JButton b1,b2,b3;
  Container con;
  Dimension d1,d2;
  Toolkit tk=Toolkit.getDefaultToolkit();
  String filename="";
  JFileChooser jfc;
  static String akfilename="";
 public fileedit()
 {
  akfilename="";
  con=getContentPane();
  setSize(500,500);
  d1=tk.getScreenSize();
  d2=getSize();
  setLocation((d1.width-d2.width)/2,(d1.height-d2.height)/2);
  con.setLayout(null);
  jta=new JTextArea();
  jta.setBackground(new Color(180,180,180));
  jta.setForeground(new Color(255,255,255));
  jta.setFont(new Font("Dialog",Font.BOLD,14));
  jep=new JEditorPane();
  jsp=new JScrollPane(jta);
  b1=new JButton("Open");
  b2=new JButton("Save");
  b3=new JButton("Ok");
  jsp.setBounds(0,0,d2.width-20,d2.height-100);
  b1.setBounds(20,(d2.height-70),100,25);
  b2.setBounds(140,(d2.height-70),100,25);
  b3.setBounds(260,(d2.height-70),100,25);
  con.add(jsp);
  con.add(b1);
  con.add(b2);con.add(b3);
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
 }
 public void actionPerformed(ActionEvent ae)
 {
  if((ae.getActionCommand()).equals("Open"))
  {
   try{
     jfc=new JFileChooser();
     jfc.setCurrentDirectory(new File("C:\\Users\\MIKYAJUMBO\\Desktop\\New folder\\fresh"));
     jfc.showOpenDialog(this);
     filename=""+jfc.getSelectedFile();
     FileInputStream fin=new FileInputStream(filename);
     String str="";
     int size=fin.available();
     for(int i=0;i<size;i++)
       str=str+(char)fin.read();
     jta.setText(str.toUpperCase());
   }catch(Exception e){}
  }
  if((ae.getActionCommand()).equals("Save"))
  {
   try{
   FileOutputStream fout=new FileOutputStream(filename);
   String str=jta.getText();
   int size=str.length();
   for(int i=0;i<size;i++)
    fout.write((int) (str.charAt(i)));
   }catch(Exception e){}
  }
  if((ae.getActionCommand()).equals("Ok"))
  {
   akfilename=filename;
   setVisible(false);
  }
 }
}
