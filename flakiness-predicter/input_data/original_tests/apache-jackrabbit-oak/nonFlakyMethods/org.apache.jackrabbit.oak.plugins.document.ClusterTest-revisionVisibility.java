@Test public void revisionVisibility() throws InterruptedException {
  DocumentMK mk1=createMK(1);
  DocumentMK mk2=createMK(2);
  String m2h;
  m2h=mk2.getNodes("/",mk2.getHeadRevision(),0,0,2,null);
  assertEquals("{\":childNodeCount\":0}",m2h);
  String oldHead=mk2.getHeadRevision();
  mk1.commit("/","+\"test\":{}",null,null);
  String m1h=mk1.getNodes("/",mk1.getHeadRevision(),0,0,2,null);
  assertEquals("{\"test\":{},\":childNodeCount\":1}",m1h);
  assertEquals("{\":childNodeCount\":0}",m2h);
  m2h=mk2.getNodes("/test",mk2.getHeadRevision(),0,0,2,null);
  for (int i=0; i < 100; i++) {
    Thread.sleep(10);
    if (mk1.getPendingWriteCount() > 0) {
      continue;
    }
    if (mk2.getHeadRevision().equals(oldHead)) {
      continue;
    }
    break;
  }
  m2h=mk2.getNodes("/",mk2.getHeadRevision(),0,0,5,null);
  assertEquals("{\"test\":{},\":childNodeCount\":1}",m2h);
  mk1.dispose();
  mk2.dispose();
}
