@Test public void clusterCompare2(){
  RevisionComparator comp=new RevisionComparator(1);
  comp.add(Revision.fromString("r3-0-1"),Revision.fromString("r1-1-0"));
  Revision r1=Revision.fromString("r1-0-2");
  Revision r2=Revision.fromString("r4-0-2");
  Revision c1sync=Revision.fromString("r5-0-1");
  comp.add(c1sync,Revision.fromString("r2-0-0"));
  Revision c2sync=Revision.fromString("r4-1-2");
  comp.add(c2sync,Revision.fromString("r2-1-0"));
  Revision c3sync=Revision.fromString("r2-0-3");
  comp.add(c3sync,Revision.fromString("r2-1-0"));
  assertTrue(comp.compare(r1,r2) < 0);
  assertTrue(comp.compare(r2,c2sync) < 0);
  assertTrue(comp.compare(c2sync,c3sync) < 0);
  assertTrue(comp.compare(r1,c3sync) < 0);
  assertTrue(comp.compare(r2,c3sync) < 0);
}
