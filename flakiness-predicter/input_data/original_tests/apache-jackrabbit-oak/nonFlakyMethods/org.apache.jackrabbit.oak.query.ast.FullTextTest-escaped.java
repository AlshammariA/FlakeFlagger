@Test public void escaped() throws ParseException {
  assertEquals("\"\\\"hello world\\\"\"",convertPattern("\"\\\"hello world\\\"\""));
  assertFalse(test("\\\"hello\\\"","hello"));
  assertTrue(test("\"hello\"","\"hello\""));
  assertTrue(test("\\\"hello\\\"","\"hello\""));
  assertFalse(test("\\-1 2 3","1 2 3"));
  assertTrue(test("\\-1 2 3","-1 2 3"));
}
