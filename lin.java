class linkdraw extends JPanel
 {
  Dimension d1;
  topologyreader tr=new topologyreader();
  int x1=0,y1=0,x2=0,y2=0;
  public linkdraw()
  {
   tr.freader(start.topologyname);
   setSize(550,500);
   setBackground(new Color(180,180,180));
   setBorder(new EtchedBorder(5));
   d1=getSize();
   setLocation(5,5);
   setFont(new Font("Dialog",Font.BOLD,14));
  }
 public void paint(Graphics g)
 {
   try
   {
   for(int i=0;i<nodedraw.n1.size();i++)
   {
     findlinkstart(""+tr.linkstart.get(i));
     findlinkend(""+tr.linkend.get(i));
     if(x1==x2)
     {
      if(y1<y2)
       y1=y1+45;
      if(y1>y2)
       y2=y2+45;
       x1=x1+15;
       x2=x2+15;
     }
     if(y1==y2)
     {
      if(x1<x2)
       x2=x2-15;
      if(x1>x2)
       x1=x1-15;
     }
     if(x1!=x2)
     {
      x1=x1+15;
      y1=y1+20;
      y2=y2+20;
      x2=x2+15;
     }
     g.drawLine(x1,y1,x2,y2);
     setForeground(new Color(217,255,0));
     g.drawString((""+tr.linkname.get(i)).toUpperCase(),(x1+x2)/2,(y1+y2)/2+2);
   }
   }catch(Exception e){}
 }
  void findlinkstart(String linkstart)
 {
   double d1=0,d2=0; 
  for(int i=0;i<tr.nodename.size();i++)
  {
    if((""+tr.nodename.get(i)).equals(linkstart))
    {
      d1=Double.parseDouble((""+tr.nodexcord.get(i)))*(640/2);
      d2=Double.parseDouble((""+tr.nodeycord.get(i)))*(480/2);
      x1=(int) d1;
      y1=(int) d2;
    }
   }
  }
 public void findlinkend(String linkend)
 {
   double d1=0,d2=0;
  for(int i=0;i<tr.nodename.size();i++)
  {
   if((""+tr.nodename.get(i)).equals(linkend))
   {
     d1=Double.parseDouble((""+tr.nodexcord.get(i)))*(640/2);
     d2=Double.parseDouble((""+tr.nodeycord.get(i)))*(480/2);
     x2=(int) d1;
     y2=(int) d2;
   }
  }
 }
}
 
