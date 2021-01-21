@Test public void testGetChildNodeEntries(){
  long count=0;
  for (  ChildNodeEntry entry : state.getChildNodeEntries()) {
    count++;
  }
  assertEquals(N + 1,count);
}
