@Test public void testNoOpMap() throws Exception {
  Map<String,String> noop=new OakFileDataStore.NoOpMap<String,String>();
  noop.put("a","b");
  noop.remove("foo");
  assertTrue(noop.isEmpty());
}
