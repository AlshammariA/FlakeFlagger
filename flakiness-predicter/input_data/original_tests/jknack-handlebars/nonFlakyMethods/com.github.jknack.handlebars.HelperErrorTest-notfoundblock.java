@Test(expected=HandlebarsException.class) public void notfoundblock() throws IOException {
  parse("notfoundblock");
}
