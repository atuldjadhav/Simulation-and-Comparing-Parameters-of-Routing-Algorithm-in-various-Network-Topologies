class nodedraw extends JPanel
 {
  Dimension d1;
  topologyreader tr=new topologyreader();
   static LinkedList n1=new LinkedList();
   static LinkedList n2=new LinkedList();
   Toolkit tk=Toolkit.getDefaultToolkit();
  public nodedraw()
  {
   tr.freader(start.topologyname);
   setSize(550,500);
   setBackground(new Color(180,180,180));
   setBorder(new EtchedBorder(4));
   d1=getSize();
   Image img=tk.getImage("MYCOMP.gif");
   boolean nb=tk.prepareImage(img,5,5,this);
   setLocation(5,5);
   ImageIcon iicon=new ImageIcon(img);
   setLayout(null);
   for(int i=0;i<tr.nodename.size();i++)
   {
    double d1=Double.parseDouble((""+tr.nodexcord.get(i)))*(640/2);
    double d2=Double.parseDouble((""+tr.nodeycord.get(i)))*(480/2);
    add(new akbutton(""+tr.nodename.get(i),(int) d1,(int) d2,iicon));
    int i1=(int) d1;
    int i2=(int) d2;
    n1.add(""+i1);
    n2.add(""+i2);
    add(new tcanvas(""+tr.nodename.get(i),(int) (d1),(int) (d2+35)));
   }
  }
 }
 