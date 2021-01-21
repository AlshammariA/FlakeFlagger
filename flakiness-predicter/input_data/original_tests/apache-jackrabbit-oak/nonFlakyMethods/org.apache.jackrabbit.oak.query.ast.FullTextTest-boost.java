@Test public void boost() throws ParseException {
  assertEquals("\"hello\"^2",convertPattern("hello^2"));
  assertEquals("\"hello world\"^2",convertPattern("\"hello world\"^2"));
  assertTrue(test("hello^2","hello"));
  assertTrue(test("\"hello\"^0.2","hello"));
}
