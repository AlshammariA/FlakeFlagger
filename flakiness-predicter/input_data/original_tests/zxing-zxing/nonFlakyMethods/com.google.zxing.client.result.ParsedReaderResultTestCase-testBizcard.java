@Test public void testBizcard(){
  doTestResult("BIZCARD:N:Sean;X:Owen;C:Google;A:123 Main St;M:+12225551212;E:srowen@example.org;","Sean Owen\nGoogle\n123 Main St\n+12225551212\nsrowen@example.org",ParsedResultType.ADDRESSBOOK);
}
