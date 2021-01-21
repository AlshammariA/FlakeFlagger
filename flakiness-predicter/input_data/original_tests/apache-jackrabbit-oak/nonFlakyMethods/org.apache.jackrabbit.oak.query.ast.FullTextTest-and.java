@Test public void and() throws ParseException {
  assertEquals("\"hello\" \"world\"",convertPattern("hello world"));
  assertEquals("\"hello\" \"or\" \"world\"",convertPattern("hello or world"));
  assertFalse(test("hello world","hello"));
  assertFalse(test("hello world","world"));
  assertTrue(test("hello world","world hello"));
  assertTrue(test("hello world ","hello world"));
}
