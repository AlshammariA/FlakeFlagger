@Test public void testGetPropertyNames() throws Exception {
  Iterator it=authorizable.getPropertyNames();
  assertTrue(it.hasNext());
  assertEquals("my:property",it.next());
  assertFalse(it.hasNext());
}
