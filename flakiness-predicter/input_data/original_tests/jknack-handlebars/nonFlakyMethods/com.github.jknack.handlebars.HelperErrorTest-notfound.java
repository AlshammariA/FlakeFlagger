@Test(expected=HandlebarsException.class) public void notfound() throws IOException {
  parse("notfound");
}
