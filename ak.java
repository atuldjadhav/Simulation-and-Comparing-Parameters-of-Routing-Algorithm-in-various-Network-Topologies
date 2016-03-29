class akbutton extends JButton implements ActionListener
{
 PopupMenu pm;
 MenuItem i1,i2,i3;
 router rou;
 String source="";
 String rstate="Up";
 topologyreader tr=new topologyreader();
 static LinkedList states=new LinkedList();
 String rname="";
 public akbutton(String name,int x,int y,ImageIcon ic)
 {
  tr.freader(start.topologyname);
  source=name;
  setSize(35,35);
  setLocation(x,y);
  setFocusPainted(false);
  setBorderPainted(false);
  setContentAreaFilled(false);
  //setBackground(new Color(120,130,180));
  addActionListener(this);
  setIcon(ic);
  setFont(new Font("Dialog",Font.BOLD,1));
  setText(name);
  pm=new PopupMenu();
  i1=new MenuItem("Router Buffer");
  i2=new MenuItem("Down");
  i3=new MenuItem("Up");
  i1.setFont(new Font("Dialog",Font.BOLD,12));
  i2.setFont(new Font("Dialog",Font.BOLD,12));
  i3.setFont(new Font("Dialog",Font.BOLD,12));
  pm.add(i1);pm.add(i2);
  rou=new router(name);
  add(pm);
  i1.addActionListener(this);
  i2.addActionListener(this);
  i3.addActionListener(this);
  addMouseListener(new mymouse());
  for(int i=0;i<tr.nodename.size();i++)
  {
   states.add(""+tr.nodename.get(i));
   states.add("Up");
  }
  if(states.size()>(2*(tr.nodename.size())))
  {
     int srt=2*(tr.nodename.size());
     for(int i=srt;i<states.size();i++)
       states.remove(i);
  }
 }
 public void setState(String state)
 {
  rstate=state;
 }
 public String getState()
 {
  return(rstate);
 }
 class mymouse extends MouseAdapter
 {
  public void mouseReleased(MouseEvent me)
  {
   rname=getText();
   if(me.isPopupTrigger())
   {
      if((getState()).equals("Down"))
      {
       pm.remove(i2);
       pm.add(i3);
      }
      if((getState()).equals("Up"))
      {
       pm.remove(i3);
       pm.add(i2);
      }
     pm.show(me.getComponent(),me.getX(),me.getY());
   }
  }
 }
 public void actionPerformed(ActionEvent ae)
 {
   String sor=ae.getActionCommand();
   if((sor.equals("Router Buffer")) ||(sor.equals("Down"))||(sor.equals("Up")))
   {
     if(sor.equals("Router Buffer"))
     {
      routerbufferview rbv=new routerbufferview();
      rbv.showBuffer(""+rname);
      rbv.show();
     }
     if(sor.equals("Down"))
     {
       i1.setEnabled(false);
       setState("Down");
       rstate=getState();
       ImageIcon icon=new ImageIcon("Mycomps.gif");
       setIcon(icon);
       for(int i=0;i<states.size();i++)
       {
        if((states.get(i)).equals(source))
        {
         states.set(i+1,"Down");
         break;
        }
       }
     }
     if(sor.equals("Up"))
     {
      i1.setEnabled(true);
      setState("Up");
      rstate=getState();
      ImageIcon icon=new ImageIcon("Mycomp.gif");
      setIcon(icon);
       for(int i=0;i<states.size();i++)
       {
        if((states.get(i)).equals(source))
        {
         states.set(i+1,"Up");
         break;
        }
       }
     }
   }
   else
   {
    if(getState().equals("Up"))
    {
    if((algosel.selalgo).equals("Source Routing"))
    {
     sourcerouting sr=new sourcerouting(sor);
     sr.show();
    }
    if((algosel.selalgo).equals("Distence Vector"))
    {
     distencevr dvr=new distencevr(sor);
     dvr.show();
    }
    if((algosel.selalgo).equals("Routing Information Protocal"))
    {
     rip ri=new rip(sor);
     ri.show();
    }
    if((algosel.selalgo).equals("Link State Routing"))
    {
     linkstaterouting lsr=new linkstaterouting(sor);
     lsr.show();
    }
    }
   }
 }
} 