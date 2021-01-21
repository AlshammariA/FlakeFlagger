@Test public void seenAtAfterPurge() throws Exception {
  RevisionComparator comp=new RevisionComparator(1);
  Revision r1=new Revision(0x01,0,2);
  Revision r2=new Revision(0x02,0,2);
  comp.add(r1,new Revision(0x01,0,0));
  comp.add(r2,new Revision(0x02,0,0));
  comp.purge(0x01);
  assertNull(comp.getRevisionSeen(r1));
  assertEquals(new Revision(0x02,0,0),comp.getRevisionSeen(r2));
  comp.purge(0x02);
  assertNull(comp.getRevisionSeen(r2));
}
