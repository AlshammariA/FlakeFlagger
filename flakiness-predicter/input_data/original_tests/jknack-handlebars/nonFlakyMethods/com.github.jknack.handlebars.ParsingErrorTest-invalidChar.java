@Test(expected=HandlebarsException.class) public void invalidChar() throws IOException {
  parse("invalidChar");
}
