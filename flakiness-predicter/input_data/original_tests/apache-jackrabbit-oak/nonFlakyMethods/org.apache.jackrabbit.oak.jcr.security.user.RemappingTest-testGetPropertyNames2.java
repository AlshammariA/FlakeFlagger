@Test public void testGetPropertyNames2() throws Exception {
  Iterator it=authorizable.getPropertyNames("my:node");
  assertTrue(it.hasNext());
  assertEquals("my:property2",it.next());
  assertFalse(it.hasNext());
}
