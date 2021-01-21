@Test public void testGetHiddenTree(){
  Tree hidden=parent.getChild(hiddenName);
  assertNotNull(hidden);
  assertFalse(hidden.exists());
  assertEquals(0,hidden.getChildrenCount(1));
}
