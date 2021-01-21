@Test public void testUUID() throws Exception {
  NodeState root=EMPTY_NODE;
  NodeBuilder builder=root.builder();
  builder.child("a").setProperty("jcr:uuid","abc");
  builder.child("b").setProperty("jcr:uuid","xyz");
  NodeState after=builder.getNodeState();
  UUIDDiffCollector collector=new UUIDDiffCollector(root,after);
  FilterImpl f=new FilterImpl();
  f.restrictProperty("jcr:uuid",Operator.EQUAL,PropertyValues.newString("abc"));
  Set<String> result=collector.getResults(f);
  Iterator<String> iterator=result.iterator();
  assertTrue(iterator.hasNext());
  assertEquals("a",iterator.next());
  assertFalse(iterator.hasNext());
}
