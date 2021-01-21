@Test public void invalid() throws ParseException {
  testInvalid("","(*); expected: term");
  testInvalid("x OR ","x OR(*); expected: term");
  testInvalid("\"","(*)\"; expected: double quote");
  testInvalid("-","(*)-; expected: term");
  testInvalid("- x","- (*)x; expected: term");
  testInvalid("\\","(*)\\; expected: escaped char");
  testInvalid("\"\\","\"(*)\\; expected: escaped char");
  testInvalid("\"x\"y","\"x\"(*)y; expected: space");
}
