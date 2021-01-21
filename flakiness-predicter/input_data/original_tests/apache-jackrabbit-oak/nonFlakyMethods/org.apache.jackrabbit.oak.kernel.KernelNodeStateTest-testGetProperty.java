@Test public void testGetProperty(){
  assertEquals("a",state.getProperty("a").getName());
  assertEquals(1,(long)state.getProperty("a").getValue(LONG));
  assertEquals("b",state.getProperty("b").getName());
  assertEquals(2,(long)state.getProperty("b").getValue(LONG));
  assertEquals("c",state.getProperty("c").getName());
  assertEquals(3,(long)state.getProperty("c").getValue(LONG));
  assertNull(state.getProperty("x"));
  assertFalse(state.hasProperty("x"));
}
