@Test public void testDisconnectAfterRefresh(){
  Tree x=root.getTree("/x");
  x.setProperty("p","any");
  Tree xx=x.addChild("xx");
  xx.setProperty("q","any");
  assertEquals(Status.MODIFIED,x.getStatus());
  assertEquals(Status.NEW,x.getPropertyStatus("p"));
  assertEquals(Status.NEW,xx.getStatus());
  assertEquals(Status.NEW,xx.getPropertyStatus("q"));
  root.refresh();
  assertEquals(Status.UNCHANGED,x.getStatus());
  assertNull(x.getPropertyStatus("p"));
  assertFalse(xx.exists());
}
