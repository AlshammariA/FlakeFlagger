@Test(expected=HandlebarsException.class) public void block() throws IOException {
  parse("helper");
}
