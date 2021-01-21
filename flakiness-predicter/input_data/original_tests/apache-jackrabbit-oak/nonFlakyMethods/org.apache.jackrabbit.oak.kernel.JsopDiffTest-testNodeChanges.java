@Test public void testNodeChanges(){
  JsopDiff diff;
  NodeState before=EMPTY_NODE;
  NodeBuilder builder=before.builder();
  builder.setProperty("a",1L);
  builder.child("x");
  NodeState after=builder.getNodeState();
  diff=new JsopDiff();
  diff.childNodeAdded("test",before);
  assertEquals("+\"/test\":{}",diff.toString());
  diff=new JsopDiff();
  diff.childNodeChanged("test",before,after);
  assertEquals("^\"/test/a\":1+\"/test/x\":{}",diff.toString());
  diff=new JsopDiff();
  diff.childNodeDeleted("test",after);
  assertEquals("-\"/test\"",diff.toString());
}
