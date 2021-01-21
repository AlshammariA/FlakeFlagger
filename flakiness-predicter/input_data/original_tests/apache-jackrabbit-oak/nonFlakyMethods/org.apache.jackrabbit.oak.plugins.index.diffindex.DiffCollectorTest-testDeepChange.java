@Test public void testDeepChange() throws Exception {
  NodeState root=EMPTY_NODE;
  NodeBuilder builder=root.builder();
  NodeBuilder b1=builder.child("rep:security").child("rep:authorizables");
  b1.child("rep:groups").child("t").child("te").child("testGroup_1c22a39f");
  NodeBuilder b2=b1.child("rep:users");
  b2.child("t").child("te").child("testUser_008e00d9");
  NodeBuilder b3=b2.child("a");
  b3.child("an").child("anonymous");
  b3.child("ad").child("admin");
  NodeState before=builder.getNodeState();
  builder=before.builder();
  NodeBuilder a1=builder.child("rep:security").child("rep:authorizables").child("rep:groups").child("t").child("te");
  a1.child("testGroup_1c22a39f").setProperty("jcr:uuid","c6195630-e956-3d4b-8912-479c303bf15a");
  a1.child("testPrincipal_4e6b704e").setProperty("jcr:uuid","ee59b554-76b7-3e27-9fc6-15bda1388894");
  NodeState after=builder.getNodeState();
  UUIDDiffCollector collector=new UUIDDiffCollector(before,after);
  FilterImpl f=new FilterImpl();
  f.restrictProperty("jcr:uuid",Operator.EQUAL,PropertyValues.newString("ee59b554-76b7-3e27-9fc6-15bda1388894"));
  Set<String> result=collector.getResults(f);
  Iterator<String> iterator=result.iterator();
  assertTrue(iterator.hasNext());
  assertEquals("rep:security/rep:authorizables/rep:groups/t/te/testPrincipal_4e6b704e",iterator.next());
  assertFalse(iterator.hasNext());
}
