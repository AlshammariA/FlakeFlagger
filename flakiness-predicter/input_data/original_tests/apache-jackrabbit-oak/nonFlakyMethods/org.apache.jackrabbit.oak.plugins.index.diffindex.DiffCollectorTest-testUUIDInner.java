@Test public void testUUIDInner() throws Exception {
  NodeState root=EMPTY_NODE;
  NodeBuilder builder=root.builder();
  builder.child("a").setProperty("jcr:uuid","abc");
  NodeState before=builder.getNodeState();
  builder=before.builder();
  builder.child("a").child("b").setProperty("jcr:uuid","xyz");
  NodeState after=builder.getNodeState();
  UUIDDiffCollector collector=new UUIDDiffCollector(before,after);
  FilterImpl f=new FilterImpl();
  f.restrictProperty("jcr:uuid",Operator.EQUAL,PropertyValues.newString("xyz"));
  Set<String> result=collector.getResults(f);
  Iterator<String> iterator=result.iterator();
  assertTrue(iterator.hasNext());
  assertEquals("a/b",iterator.next());
  assertFalse(iterator.hasNext());
}
