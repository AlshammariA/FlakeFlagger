@Test(expected=HandlebarsException.class) public void unbalancedDelim() throws IOException {
  parse("unbalancedDelim");
}
