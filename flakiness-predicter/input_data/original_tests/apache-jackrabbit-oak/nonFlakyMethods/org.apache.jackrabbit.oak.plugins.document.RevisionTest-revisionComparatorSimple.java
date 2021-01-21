@Test public void revisionComparatorSimple(){
  RevisionComparator comp=new RevisionComparator(0);
  Revision r1=Revision.newRevision(0);
  Revision r2=Revision.newRevision(0);
  assertEquals(r1.compareRevisionTime(r2),comp.compare(r1,r2));
  assertEquals(r2.compareRevisionTime(r1),comp.compare(r2,r1));
  assertEquals(r1.compareRevisionTime(r1),comp.compare(r1,r1));
}
