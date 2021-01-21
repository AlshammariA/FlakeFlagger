@Test public void not() throws ParseException {
  assertEquals("\"hello\" -\"world\"",convertPattern("hello -world"));
  assertTrue(test("hello -world","hello"));
  assertFalse(test("hello -world","hello world"));
}
