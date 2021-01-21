@Test public void quoted() throws ParseException {
  assertEquals("\"hello world\"",convertPattern("\"hello world\""));
  assertEquals("\"hello world\" \"world\"",convertPattern("\"hello world\" world"));
  assertTrue(test("\"hello world\"","hello world"));
  assertFalse(test("\"hello world\"","world hello"));
  assertTrue(test("\"hello-world\"","hello-world"));
  assertTrue(test("\"hello\\-world\"","hello-world"));
  assertTrue(test("\"hello \\\"world\\\"\"","hello \"world\""));
  assertTrue(test("\"hello world\" -hallo","hello world"));
  assertFalse(test("\"hello world\" -hallo","hallo hello world"));
}
