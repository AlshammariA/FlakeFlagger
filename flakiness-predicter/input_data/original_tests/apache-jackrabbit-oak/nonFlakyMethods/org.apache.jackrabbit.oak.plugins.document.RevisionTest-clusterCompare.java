@Test public void clusterCompare(){
  RevisionComparator comp=new RevisionComparator(1);
  Revision r1c1=new Revision(0x10,0,1);
  Revision r1c2=new Revision(0x20,0,2);
  Revision r2c1=new Revision(0x30,0,1);
  Revision r2c2=new Revision(0x40,0,2);
  comp.add(r1c1,new Revision(0x10,0,0));
  comp.add(r2c1,new Revision(0x20,0,0));
  assertTrue(comp.compare(r1c2,r2c1) > 0);
  comp.add(r2c2,new Revision(0x30,0,0));
  assertTrue(comp.compare(r1c2,r2c1) < 0);
}
