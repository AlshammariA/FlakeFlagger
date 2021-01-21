@Test public void compare() throws InterruptedException {
  Revision last=Revision.newRevision(0);
  try {
    last.compareRevisionTime(null);
    fail();
  }
 catch (  NullPointerException e) {
  }
  for (int i=0; i < 1000; i++) {
    Revision r=Revision.newRevision(0);
    assertTrue(r.compareRevisionTime(r) == 0);
    assertTrue(r.compareRevisionTime(last) > 0);
    assertTrue(last.compareRevisionTime(r) < 0);
    last=r;
    if (i % 100 == 0) {
      Thread.sleep(1);
    }
  }
}
