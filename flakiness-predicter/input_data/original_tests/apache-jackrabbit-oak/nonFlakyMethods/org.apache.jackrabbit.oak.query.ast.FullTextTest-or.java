@Test public void or() throws ParseException {
  assertEquals("\"hello\" OR \"world\"",convertPattern("hello OR world"));
  assertTrue(test("hello OR world","hello"));
  assertTrue(test("hello OR world","world"));
  assertFalse(test("hello OR world","hi"));
}
