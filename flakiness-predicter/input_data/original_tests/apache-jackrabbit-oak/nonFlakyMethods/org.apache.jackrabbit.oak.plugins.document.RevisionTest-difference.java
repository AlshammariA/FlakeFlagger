@Test public void difference() throws InterruptedException {
  long t0=Revision.getCurrentTimestamp();
  Revision r0=Revision.newRevision(0);
  Revision r1=Revision.newRevision(0);
  long t1=Revision.getCurrentTimestamp();
  assertTrue(Revision.getTimestampDifference(r1,r0) <= (t1 - t0));
  long t2;
  do {
    t2=Revision.getCurrentTimestamp();
  }
 while (t1 == t2);
  Revision r2=Revision.newRevision(0);
  assertTrue(Revision.getTimestampDifference(r2,r1) > 0);
}
