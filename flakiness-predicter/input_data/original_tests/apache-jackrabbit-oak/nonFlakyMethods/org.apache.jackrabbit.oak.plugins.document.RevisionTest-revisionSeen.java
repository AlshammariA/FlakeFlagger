@Test public void revisionSeen(){
  RevisionComparator comp=new RevisionComparator(1);
  Revision r0=new Revision(0x01,0,1);
  Revision r1=new Revision(0x10,0,1);
  Revision r2=new Revision(0x20,0,1);
  Revision r21=new Revision(0x21,0,1);
  Revision r3=new Revision(0x30,0,1);
  Revision r4=new Revision(0x40,0,1);
  Revision r5=new Revision(0x50,0,1);
  comp.add(r1,new Revision(0x10,0,0));
  comp.add(r2,new Revision(0x20,0,0));
  comp.add(r3,new Revision(0x30,0,0));
  comp.add(r4,new Revision(0x40,0,0));
  assertNull(comp.getRevisionSeen(r0));
  assertEquals(new Revision(0x10,0,0),comp.getRevisionSeen(r1));
  assertEquals(new Revision(0x20,0,0),comp.getRevisionSeen(r2));
  assertEquals(new Revision(0x30,0,0),comp.getRevisionSeen(r3));
  assertEquals(new Revision(0x40,0,0),comp.getRevisionSeen(r4));
  assertEquals(RevisionComparator.NEWEST,comp.getRevisionSeen(r5));
  assertEquals(new Revision(0x30,0,0),comp.getRevisionSeen(r21));
}
