@Test(expected=HandlebarsException.class) public void paramOutOfOrder() throws IOException {
  parse("paramOrder");
}
